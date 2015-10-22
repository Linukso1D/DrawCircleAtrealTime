package com.example.maxxl.drawcircle;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.Log;
import android.view.View;


import static com.example.maxxl.drawcircle.ScreenMetr.getInstance;

class DrawView extends View {
    private Paint mPaint;
    private float[] mIntervals = { 0f, 0f };
    private float drawSpeed = 4f;
    private int currentPath = -1;
    private PathMeasure mPathMeasure = new PathMeasure();
    private int pathCount;
    private ArrayList<Path> mListPath = new ArrayList<Path>(this.pathCount);
    ScreenMetr DisplayMetrics;
    public DrawView(Context context) {

        super(context);
        pathCount=4;
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(12);


//singlton display param
        DisplayMetrics=getInstance();
    }


    @Override
    protected void onDraw(Canvas canvas) {

        DisplayMetrics.initCanvas(canvas.getWidth(),canvas.getHeight());
        if (mIntervals[1] <= 0f && currentPath < (pathCount - 1)) {
            // Set the current path to draw
            Log.d("DrawC", "if1 " );
            // getPath(int num) a function to return a path.
            Path newPath = this.getPath(mListPath.size());
            this.mListPath.add(newPath);
            this.mPathMeasure.setPath(newPath, false);
            mIntervals[0] = 0;
            mIntervals[1] = this.mPathMeasure.getLength();
        }

        if (mIntervals[1] > 0) {
            // draw the previous path
            int last = this.mListPath.size()-1;
            for (int i = 0; i < last; i++) {
                canvas.drawPath(this.mListPath.get(i), mPaint);
            }
            // partially draw the last path
            this.mPaint.setPathEffect(new DashPathEffect(mIntervals, 0f));
            Log.d("DrawC", "Last item is " + last);
            canvas.drawPath(this.mListPath.get(last), mPaint);

            // Update the path effects values, to draw a little more
            // on the path.
            mIntervals[0] += drawSpeed;
            mIntervals[1] -= drawSpeed;

            super.invalidate();
        } else {
            // The drawing have been done, draw it entirely
            for (int i = 0; i < this.mListPath.size(); i++) {
                canvas.drawPath(this.mListPath.get(i), mPaint);
            }
        }
    }

    private Path getPath(int size) {
        Path mPath = new Path();
        mPath.reset();

        int x = DisplayMetrics.getConvasWeight()/2;
        int y = DisplayMetrics.getConvasHeight() / 2;
        int partx = (x/100)*85;
        int party = (y/100)*85;
        mPath.moveTo(x, y - party);
        mPath.lineTo(x, y+party);

        return mPath;
    }
}

