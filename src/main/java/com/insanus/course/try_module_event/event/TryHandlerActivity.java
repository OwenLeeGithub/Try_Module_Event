package com.insanus.course.try_module_event.event;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.insanus.course.try_module_event.R;

import java.util.Timer;
import java.util.TimerTask;

public class TryHandlerActivity extends AppCompatActivity {

    private TextView textView;

    private int index = 0;
    private static final String[] strrecycle = {
        "A",
        "B",
        "C",
        "D",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_handler);
        init();

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                //判断来源
                if(msg.what == 0x2333) {
                    textView.setText(strrecycle[index]);
                    index = ++index%strrecycle.length;
                }

            }

        };

        //周期性发送
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x2333);
            }
        }, 0, 1200);


    }

    private void init() {
        textView = (TextView) findViewById(R.id.handler_txt);
    }
}
