package com.example.maxxl.drawcircle;

/**
 * Created by maxxl on 22.10.2015.
 */
public class ScreenMetr {
    private static ScreenMetr ourInstance = new ScreenMetr();
    int Sdpi, Sweight, Sheight;
    int Cweight, Cheight;

    private ScreenMetr() {
    }

    public static ScreenMetr getInstance() {
        return ourInstance;
    }

    public void initDisplay(int dpi, int w, int h) {
        this.Sdpi = dpi;
        this.Sweight = w;
        this.Sheight = h;

    }

    public void initCanvas(int w, int h) {

        this.Cweight = w;
        this.Cheight = h;

    }

    public int getScreenDpi() {
        return Sdpi;
    }

    public int getScreenWeight() {
        return Sweight;
    }

    public int getScreenHeight() {
        return Sheight;
    }

    public int getConvasWeight() {
        return Cweight;
    }

    public int getConvasHeight() {
        return Cheight;
    }
}
