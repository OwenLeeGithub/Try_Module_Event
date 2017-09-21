package com.insanus.course.try_module_event.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.insanus.course.try_module_event.R;

import java.util.ArrayList;
import java.util.List;

public class MessageOperationActivity extends AppCompatActivity {

    static final String UPPER_NUM="upper";

    private CalThread calThread;
    private EditText editText;
    private Button button;

    class CalThread extends Thread {
        Handler mHandler;
        @Override
        public void run() {
            //创建Looper
            Looper.prepare();
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    //判断数据来源
                    if(msg.what == 0x12345) {
                        int upper = msg.getData().getInt(UPPER_NUM);
                        List<Integer> nums = new ArrayList<>();

                        other:
                        for(int i = 2; i < upper; i ++) {
                            for(int j = 2; j <= Math.sqrt(i); j ++) {
                                if(i != 2 && i % j == 0) {
                                    continue other;
                                }
                            }
                            nums.add(i);
                        }

                        Toast.makeText(MessageOperationActivity.this, nums.toString(), Toast.LENGTH_LONG).show();
                    }

                }
            };

            Looper.loop();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_operation);
        init();

        calThread = new CalThread();
        calThread.start();
        //启动一个新线程


    }

    //监听
    public void onClick(View view) {
        Message message = new Message();
        message.what = 0x12345;
        Bundle bundle = new Bundle();
        bundle.putInt(UPPER_NUM, Integer.parseInt(editText.getText().toString()));
        message.setData(bundle);

        calThread.mHandler.sendMessage(message);


    }

    private void init() {
        editText = (EditText) findViewById(R.id.nums_txt);
        button = (Button) findViewById(R.id.nums_btn);
    }
}
