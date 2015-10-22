package com.example.maxxl.drawcircle;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends Activity {
    DrawView drawView;
Context MyCont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyCont= getApplicationContext();

        DisplayMetrics dm = MyCont.getResources().getDisplayMetrics();
        int densityDpi = dm.densityDpi;
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        ScreenMetr metrics=ScreenMetr.getInstance();
        metrics.initDisplay(densityDpi,width,height);
        drawView=new DrawView(MyCont);
        setContentView(drawView);



    }
}
