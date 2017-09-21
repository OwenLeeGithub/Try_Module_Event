package com.insanus.course.try_module_event;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.insanus.course.try_module_event.event.AsyncTaskActivity;
import com.insanus.course.try_module_event.event.ButtonEventActivity;
import com.insanus.course.try_module_event.event.CallBackActivity;
import com.insanus.course.try_module_event.event.CallBackPlaneActivity;
import com.insanus.course.try_module_event.event.ListenerConfigurationActivity;
import com.insanus.course.try_module_event.event.MessageOperationActivity;
import com.insanus.course.try_module_event.event.PlaneGameActivity;
import com.insanus.course.try_module_event.event.TryConfigurationActivity;
import com.insanus.course.try_module_event.event.TryHandlerActivity;

public class MainActivity extends AppCompatActivity {

    //跳转列表
    private final Class[] otherActicity ={
            ButtonEventActivity.class,
            PlaneGameActivity.class,
            CallBackActivity.class,
            CallBackPlaneActivity.class,
            TryConfigurationActivity.class,
            ListenerConfigurationActivity.class,
            TryHandlerActivity.class,
            MessageOperationActivity.class,
            AsyncTaskActivity.class,
    };

    private final String[] otherName = {
            "按钮点击事件",
            "飞机游戏",
            "回调事件的传播",
            "回调实现的飞机游戏",
            "响应系统设置的事件",
            "监听屏幕变化",
            "Handler的基本操作",
            "Message的处理",
            "异步任务",
    };

    //控件区

    /*主页ListView*/
    ListView gotoListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        gotoListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,otherName));
        gotoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(view.getContext(), otherActicity[position]));
            }
        });
    }

    private void init() {
        gotoListView = (ListView) findViewById(R.id.list_activity);
    }

}
