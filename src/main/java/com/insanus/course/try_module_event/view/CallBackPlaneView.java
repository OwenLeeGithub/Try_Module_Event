package com.insanus.course.try_module_event.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.insanus.course.try_module_event.R;

/**
 * Created by insanus on 2017/9/19.
 */

public class CallBackPlaneView extends View {

    private Bitmap plane;

    private class Curren {
        public float currenX;
        public float currenY;
    }

    private Curren curren = null;
    //初始速度
    private float speed = 10;
    public CallBackPlaneView(Context context) {
        super(context);
        init();
    }

    public CallBackPlaneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CallBackPlaneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CallBackPlaneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        plane = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.plane);
        setFocusable(true);

        //设置背景
        setBackgroundResource(R.drawable.back);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔


        //设置在中心，在初始化的时候getXXXX都为0
        if(curren == null) {
            curren = new Curren();
            curren.currenX = getWidth() >> 1;
            curren.currenY = getHeight() >> 1;
        }

        Paint paint = new Paint();

        canvas.drawBitmap(plane, curren.currenX, curren.currenY, paint);
    }

    //回调按键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_S:
                curren.currenY += speed;
                break;
            case KeyEvent.KEYCODE_W:
                curren.currenY -= speed;
                break;
            case KeyEvent.KEYCODE_A:
                curren.currenX -= speed;
                break;
            case KeyEvent.KEYCODE_D:
                curren.currenX += speed;
                break;
        }
        invalidate();
        return super.onKeyDown(keyCode, event);
    }
}
