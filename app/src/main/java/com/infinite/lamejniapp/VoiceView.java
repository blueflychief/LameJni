package com.infinite.lamejniapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 3/24/2018.
 */

public class VoiceView extends View {

    private Paint paint;
    private int barWidth = 20;
    private float value;
    private int viewHeight = 0;

    public VoiceView(Context context) {
        super(context);
        init(context);
    }

    public VoiceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public VoiceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        viewHeight = getMeasuredHeight();
        barWidth = getMeasuredWidth();
    }

    public void setValue(float value) {
        this.value = value;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float height = viewHeight - value * 100 / viewHeight;
        Log.e("tag", "=======height:" + height + " ,viewHeight:" + viewHeight);
        canvas.drawRect(0, height, barWidth, viewHeight, paint);
    }
}
