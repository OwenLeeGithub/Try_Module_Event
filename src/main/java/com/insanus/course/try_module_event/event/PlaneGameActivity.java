package com.insanus.course.try_module_event.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.insanus.course.try_module_event.R;
import com.insanus.course.try_module_event.view.PlaneView;

public class PlaneGameActivity extends AppCompatActivity {
    //飞机速度
    private int speed = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去掉状态,AppCompatActivity无效
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final PlaneView planeView = new PlaneView(this);
        setContentView(planeView);

        //设置背景
        planeView.setBackgroundResource(R.drawable.back);

        //窗口管理器
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        planeView.currenX = metrics.widthPixels >> 1;
        planeView.currenY = metrics.heightPixels >> 1;

        planeView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (event.getKeyCode()) {
                    case KeyEvent.KEYCODE_S:
                        planeView.currenY += speed;
                        break;
                    case KeyEvent.KEYCODE_W:
                        planeView.currenY -= speed;
                        break;
                    case KeyEvent.KEYCODE_A:
                        planeView.currenX -= speed;
                        break;
                    case KeyEvent.KEYCODE_D:
                        planeView.currenX += speed;
                        break;
                }
                //重绘
                planeView.invalidate();
                return true;
            }
        });

    }
}
