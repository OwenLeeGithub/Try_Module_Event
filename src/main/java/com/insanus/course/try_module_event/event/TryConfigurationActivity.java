package com.insanus.course.try_module_event.event;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.insanus.course.try_module_event.R;

public class TryConfigurationActivity extends AppCompatActivity {

    private EditText ori;
    private EditText navigation;
    private EditText touch;
    private EditText mnc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_configuration);
        init();


    }

    public void onClick(View view) {
        //获取配置信息类
        Configuration configuration = getResources().getConfiguration();
        String screen = configuration.orientation ==
                Configuration.ORIENTATION_LANDSCAPE?
                "横向屏幕":"竖向屏幕";

        String mncCode = "" + configuration.mnc;
        String naviName = configuration.orientation ==
                Configuration.NAVIGATION_NONAV?
                "没有方向控制":
                Configuration.NAVIGATION_WHEEL == configuration.orientation?
                        "滚轮控制方向":Configuration.NAVIGATION_DPAD == configuration.orientation?
                        "方向键控制方向":"轨迹球控制方向";

        String touchName = configuration.touchscreen == Configuration.TOUCHSCREEN_NOTOUCH?
                "无屏幕触碰":"支持屏幕触碰";

        ori.setText(screen);
        navigation.setText(naviName);
        mnc.setText(mncCode);
        touch.setText(touchName);
    }

    private void init() {
        ori = (EditText) findViewById(R.id.ori);
        navigation = (EditText) findViewById(R.id.navigation);
        touch = (EditText) findViewById(R.id.touch);
        mnc = (EditText) findViewById(R.id.mnc);
    }
}
