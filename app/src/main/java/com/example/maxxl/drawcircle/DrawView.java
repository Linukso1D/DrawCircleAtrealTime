package com.example.maxxl.drawcircle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Map;

import static com.example.maxxl.drawcircle.ElipseType.diStartDrawX;
import static com.example.maxxl.drawcircle.ElipseType.diStartDrawY;
import static com.example.maxxl.drawcircle.ScreenMetr.getBlue;
import static com.example.maxxl.drawcircle.ScreenMetr.getBlueline;
import static com.example.maxxl.drawcircle.ScreenMetr.getBrown;
import static com.example.maxxl.drawcircle.ScreenMetr.getGreen;
import static com.example.maxxl.drawcircle.ScreenMetr.getGrey;
import static com.example.maxxl.drawcircle.ScreenMetr.getInstance;
import static com.example.maxxl.drawcircle.ScreenMetr.getRed;
import static com.example.maxxl.drawcircle.ScreenMetr.getYellow;

class DrawView extends View {


    public static int dpi, Radius, PaintWidth, PaintWidthElipse;
    ScreenMetr DisplayMetrics;
    private Paint mPaintLine, Cir1, Cir2, Cir3, Cir4, Cir5, Cir6;
    private float[] mIntervals = {0f, 0f};
    private float drawSpeed = 4f;
    private int currentPath = -1;
    private PathMeasure mPathMeasure = new PathMeasure();
    private int pathCount;
    private ArrayList<Path> mListPath = new ArrayList<Path>(this.pathCount);
    private ElipseType El1, El2, El3, El4, El5, El6;
    public DrawView(Context context) {

        super(context);


        DisplayMetrics = getInstance();
        dpi = DisplayMetrics.getScreenDpi();
        if (dpi < 161) {
            Radius = 30;
            PaintWidth = 10;
            PaintWidthElipse = 8;
        } else if (dpi > 160 && dpi < 241) {
            Radius = 30;
            PaintWidth = 13;
            PaintWidthElipse = 8;
        } else if (dpi > 240 && dpi < 321) {
            Radius = 50;
            PaintWidth = 16;
            PaintWidthElipse = 13;
        } else if (dpi > 320) {
            Radius = 80;
            PaintWidth = 20;
            PaintWidthElipse = 16;
        }


        pathCount = 1;
        //настройка кисти
        mPaintLine = new Paint();
        mPaintLine.setStyle(Paint.Style.STROKE);
        mPaintLine.setAntiAlias(true);
        mPaintLine.setColor(getBlueline());
        mPaintLine.setStrokeWidth(PaintWidth);
        mPaintLine.setShadowLayer(10.0f, 0.0f, 0.0f, 0xFF0ff000);

        Cir1 = new Paint();
        Cir1.setStyle(Paint.Style.STROKE);
        Cir1.setAntiAlias(true);
        Cir1.setColor(getGrey());
        Cir1.setStrokeWidth(PaintWidthElipse);
        Cir1.setShadowLayer(10.0f, 0.0f, 0.0f, 0xFF0ff000);

        Cir2 = new Paint();
        Cir2.setStyle(Paint.Style.STROKE);
        Cir2.setAntiAlias(true);
        Cir2.setColor(getRed());
        Cir2.setStrokeWidth(PaintWidthElipse);
        Cir2.setShadowLayer(10.0f, 0.0f, 0.0f, 0xFF0ff000);

        Cir3 = new Paint();
        Cir3.setStyle(Paint.Style.STROKE);
        Cir3.setAntiAlias(true);
        Cir3.setColor(getYellow());
        Cir3.setStrokeWidth(PaintWidthElipse);
        Cir3.setShadowLayer(10.0f, 0.0f, 0.0f, 0xFF0ff000);

        Cir4 = new Paint();
        Cir4.setStyle(Paint.Style.STROKE);
        Cir4.setAntiAlias(true);
        Cir4.setColor(getBlue());
        Cir4.setStrokeWidth(PaintWidthElipse);
        Cir4.setShadowLayer(10.0f, 0.0f, 0.0f, 0xFF0ff000);

        Cir5 = new Paint();
        Cir5.setStyle(Paint.Style.STROKE);
        Cir5.setAntiAlias(true);
        Cir5.setColor(getGreen());
        Cir5.setStrokeWidth(PaintWidthElipse);
        Cir5.setShadowLayer(10.0f, 0.0f, 0.0f, 0xFF0ff000);

        Cir6 = new Paint();
        Cir6.setStyle(Paint.Style.STROKE);
        Cir6.setAntiAlias(true);
        Cir6.setColor(getBrown());
        Cir6.setStrokeWidth(PaintWidthElipse);
        Cir6.setShadowLayer(10.0f, 0.0f, 0.0f, 0xFF0ff000);


//singlton display param

    }

    public static int getPaintWidth() {
        return PaintWidth;
    }

    public static int getPaintWidthElipse() {
        return PaintWidthElipse;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        DisplayMetrics.initCanvas(canvas.getWidth(), canvas.getHeight());
        if (mIntervals[1] <= 0f && currentPath < (pathCount - 1)) {
            // Set the current path to draw
            Log.d("DrawC", "if1 ");
            // getPath(int num) a function to return a path.

            //line
            Path newPath = this.getPathLine(0, 0, 0);
            //   this.mListPath.add(newPath);
            //elipse1
            int x = DisplayMetrics.getConvasWeight() / 2;
            int y = DisplayMetrics.getConvasHeight();


            double party = ((y) / 100) * 90;
            double tmpPart = party / 6;
            float k = (float) tmpPart;


            El1 = new ElipseType();
            El2 = new ElipseType();
            El3 = new ElipseType();
            El4 = new ElipseType();
            El5 = new ElipseType();
            El6 = new ElipseType();


            newPath = this.ElipsegetPath(x, k, El1, 315);
            this.mListPath.add(newPath);

            newPath = this.getPathLine(x, k, k + (float) tmpPart);
            this.mListPath.add(newPath);

            k += tmpPart;
            newPath = this.ElipsegetPath(x, k, El2, 315);
            this.mListPath.add(newPath);

            newPath = this.getPathLine(x, k, k + (float) tmpPart);
            this.mListPath.add(newPath);

            k += tmpPart;
            newPath = this.ElipsegetPath(x, k, El3, 315);
            this.mListPath.add(newPath);

            newPath = this.getPathLine(x, k, k + (float) tmpPart);
            this.mListPath.add(newPath);

            k += tmpPart;
            newPath = this.ElipsegetPath(x, k, El4, 75);
            this.mListPath.add(newPath);

            newPath = this.getPathLine(x, k, k + (float) tmpPart);
            this.mListPath.add(newPath);

            k += tmpPart;
            newPath = this.ElipsegetPath(x, k, El5, 75);
            this.mListPath.add(newPath);

            newPath = this.getPathLine(x, k, k + (float) tmpPart);
            this.mListPath.add(newPath);

            k += tmpPart;
            newPath = this.ElipsegetPath(x, k, El6, 135);
            this.mListPath.add(newPath);


            k += tmpPart;


            Log.d("DrawC", "y= " + y + " party " + party + " tmpPart " + tmpPart);

            this.mPathMeasure.setPath(newPath, false);
            mIntervals[0] = 0;
            mIntervals[1] = this.mPathMeasure.getLength();
            pathCount--;
        }

        if (mIntervals[1] > 0) {
            // draw the previous path

            int last = this.mListPath.size() - 1;
            int kol = 0;
            for (int i = 0; i < last; i++) {

                if (i % 2 == 1) {
                    canvas.drawPath(this.mListPath.get(i), mPaintLine);
                }
                if (i % 2 == 0) {
                    switch (kol) {
                        case 0:
                            canvas.drawPath(this.mListPath.get(i), Cir1);
                            break;
                        case 1:
                            canvas.drawPath(this.mListPath.get(i), Cir2);
                            break;
                        case 2:
                            canvas.drawPath(this.mListPath.get(i), Cir3);
                            break;
                        case 3:
                            canvas.drawPath(this.mListPath.get(i), Cir4);
                            break;
                        case 4:
                            canvas.drawPath(this.mListPath.get(i), Cir5);
                            break;
                        case 5:
                            canvas.drawPath(this.mListPath.get(i), Cir6);
                            break;
                    }
                    kol++;

                }


            }
            // partially draw the last path
            Log.d("DrawC", "Size Array" + last);

            this.mPaintLine.setPathEffect(new DashPathEffect(mIntervals, 0f));
            this.Cir1.setPathEffect(new DashPathEffect(mIntervals, 0f));
            this.Cir2.setPathEffect(new DashPathEffect(mIntervals, 0f));
            this.Cir3.setPathEffect(new DashPathEffect(mIntervals, 0f));
            this.Cir4.setPathEffect(new DashPathEffect(mIntervals, 0f));
            this.Cir5.setPathEffect(new DashPathEffect(mIntervals, 0f));
            this.Cir6.setPathEffect(new DashPathEffect(mIntervals, 0f));

            canvas.drawPath(this.mListPath.get(last), Cir6);

            // Update the path effects values, to draw a little more
            // on the path.
            mIntervals[0] += drawSpeed;
            mIntervals[1] -= drawSpeed;

            super.invalidate();
        } else {
            int kol = 0;
            // The drawing have been done, draw it entirely
            for (int i = 0; i < this.mListPath.size(); i++) {


                if (i % 2 == 1) {
                    canvas.drawPath(this.mListPath.get(i), mPaintLine);
                }
                if (i % 2 == 0) {
                    switch (kol) {
                        case 0:
                            canvas.drawPath(this.mListPath.get(i), Cir1);
                            break;
                        case 1:
                            canvas.drawPath(this.mListPath.get(i), Cir2);
                            break;
                        case 2:
                            canvas.drawPath(this.mListPath.get(i), Cir3);
                            break;
                        case 3:
                            canvas.drawPath(this.mListPath.get(i), Cir4);
                            break;
                        case 4:
                            canvas.drawPath(this.mListPath.get(i), Cir5);
                            break;
                        case 5:
                            canvas.drawPath(this.mListPath.get(i), Cir6);
                            break;
                    }
                    kol++;

                }


            }
        }
    }

    private Path getPathLine(int x, float y, float z) {
        Path mPath = new Path();

        mPath.moveTo(x, y + Radius + PaintWidthElipse / 2);
        mPath.lineTo(x, z - Radius);

        return mPath;
    }

    private Path ElipsegetPath(int x, float y, ElipseType a, int dr) {


        Path mPath = new Path();
        mPath.moveTo(diStartDrawY(x, Radius, dr), diStartDrawX(y, Radius, dr));

        Map elipse = a.GetCoordEclipse(x, y, Radius, dr);
        for (Object key : elipse.keySet()) {
            mPath.lineTo(Float.parseFloat(key.toString()), Float.parseFloat(elipse.get(key).toString()));
        }

        return mPath;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float evX = event.getX();
        float evY = event.getY();


        //     LinkedHashMap lineA();
        //     LinkedHashMap lineB();
        //     LinkedHashMap LineC();


        switch (event.getAction()) {
            // касание началось
            case MotionEvent.ACTION_DOWN:
                Log.d("DrawC", "evX= " + evX + " evY " + evY);
                // если касание было начато в пределах квадрата

                //El1
                    if (evX >= El1.getCubeAx() && evX < El1.getCubeDx() && evY >= El1.getCubeDy() && evY < El1.getCubeBy()) {

                        Snackbar snackbar = Snackbar
                                .make(this, "Elipse 1", Snackbar.LENGTH_SHORT);

                        snackbar.show();
                    }

                //El2
                if (evX >= El2.getCubeAx() && evX < El2.getCubeDx() && evY >= El2.getCubeDy() && evY < El2.getCubeBy()) {

                    Snackbar snackbar = Snackbar
                            .make(this, "2222222", Snackbar.LENGTH_SHORT);

                    snackbar.show();
                }

                //El3
                if (evX >= El3.getCubeAx() && evX < El3.getCubeDx() && evY >= El3.getCubeDy() && evY < El3.getCubeBy()) {

                    Snackbar snackbar = Snackbar
                            .make(this, "33333---33333", Snackbar.LENGTH_SHORT);

                    snackbar.show();
                }

                //El4
                if (evX >= El4.getCubeAx() && evX < El4.getCubeDx() && evY >= El4.getCubeDy() && evY < El4.getCubeBy()) {

                    Snackbar snackbar = Snackbar
                            .make(this, "444__$4-4-4-4", Snackbar.LENGTH_SHORT);

                    snackbar.show();
                }

                //El5
                if (evX >= El5.getCubeAx() && evX < El5.getCubeDx() && evY >= El5.getCubeDy() && evY < El5.getCubeBy()) {

                    Snackbar snackbar = Snackbar
                            .make(this, "%5%", Snackbar.LENGTH_SHORT);

                    snackbar.show();
                }

                //El6
                if (evX >= El6.getCubeAx() && evX < El6.getCubeDx() && evY >= El6.getCubeDy() && evY < El6.getCubeBy()) {

                    Snackbar snackbar = Snackbar
                            .make(this, "6_9", Snackbar.LENGTH_SHORT);

                    snackbar.show();
                }





                break;
        }
        return true;
    }
}

