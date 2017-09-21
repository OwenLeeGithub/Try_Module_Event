package com.insanus.course.try_module_event.event;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.insanus.course.try_module_event.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AsyncTaskActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        init();

    }

    //监听并下载
    public void download(View vier) throws MalformedURLException {
        DownTask task = new DownTask(this);
        task.execute(new URL("http://www.lua.org/pil/"));
    }

    //异步
    class DownTask extends AsyncTask<URL, Integer, String> {

        //已读行数
        private int hasRead = 0;
        private Context context;
        private ProgressDialog dialog;

        public DownTask(Context context) {
            this.context = context;
        }

        //初始化
        @Override
        protected void onPreExecute() {
            //进度条
            dialog = new ProgressDialog(context);
            dialog.setTitle("任务执行中");
            dialog.setMessage("load...");
            //不能取消关闭
            dialog.setCancelable(false);

            dialog.setMax(202);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

            //显示进度
            dialog.setIndeterminate(false);
            dialog.show();

        }

        //后台处理
        @Override
        protected String doInBackground(URL... params) {
            StringBuffer str = new StringBuffer();


            try {
                URLConnection conn = params[0].openConnection();

                //包装
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );


                String line = null;
                while((line = br.readLine()) != null) {
                    str.append(line);
                    hasRead ++;
                    publishProgress(hasRead);
                }
                return str.toString();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        //进度
        @Override
        protected void onProgressUpdate(Integer... values) {
            textView.setText("已经读取了【"+values[0]+"】行");
            dialog.setProgress(values[0]);
        }

        //结束后
        @Override
        protected void onPostExecute(String s) {
            textView.setText(s);
            dialog.dismiss();

        }
    }

    private void init() {
        textView = (TextView) findViewById(R.id.async_txt);
    }
}
