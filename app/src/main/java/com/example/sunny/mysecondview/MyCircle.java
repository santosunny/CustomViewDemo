package com.example.sunny.mysecondview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyCircle extends View implements View.OnClickListener {

    private int rad;
    private Paint mPaint;
    private int colors[] = {Color.RED, Color.BLACK, Color.BLUE, Color.CYAN, Color.DKGRAY, Color.GREEN, Color.MAGENTA};
    private int position;

    public MyCircle(Context context) {
        super(context);
    }

    public MyCircle(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCircle);
        if (typedArray != null) {
            rad = typedArray.getInteger(R.styleable.MyCircle_rad, 0);
            typedArray.recycle();
        }

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, rad, mPaint);
    }

    @Override
    public void onClick(View view) {
        position = (int) (Math.random() * 7);
        mPaint.setColor(colors[position]);
        invalidate();
    }
}
