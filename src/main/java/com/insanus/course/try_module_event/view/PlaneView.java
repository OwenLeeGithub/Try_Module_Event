package com.insanus.course.try_module_event.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import com.insanus.course.try_module_event.R;

/**
 * Created by insanus on 2017/9/19.
 */

public class PlaneView extends View {
    private Bitmap plane;
    public float currenX;
    public float currenY;

    public PlaneView(Context context) {
        super(context);
        init();
    }

    public PlaneView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PlaneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public PlaneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        plane = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.plane);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔
        Paint paint = new Paint();
        canvas.drawBitmap(plane, currenX, currenY, paint);
    }
}
