package com.insanus.course.try_module_event.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.insanus.course.try_module_event.R;

public class ButtonEventActivity extends AppCompatActivity {

    //控件区
    private EditText edit;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_event);
        init();

        //按钮监听事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setText("button was click!");
            }
        });
    }

    private void init() {
        edit = (EditText) findViewById(R.id.txt);
        btn = (Button) findViewById(R.id.btn);
    }
}
