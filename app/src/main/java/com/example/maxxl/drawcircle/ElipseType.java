package com.example.maxxl.drawcircle;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by maxxl on 22.10.2015.
 */
public class ElipseType {



    public static LinkedHashMap Standart(float x,float y,int R,int st,int fin)
    {
        LinkedHashMap MyArray = new LinkedHashMap<Float,Float>();
         int h=1;



        for (int i = st; i <= fin; i += h)
        {


                double d = (x + R * sin((i - h) * 3.1415 / 180));
                double d2 = y + R * cos((i - h) * 3.1415 / 180);

                MyArray.put(d, d2);


      //    double w=  (x + R * sin(i * 3.1415 / 180), y + R * cos(i * 3.1415 / 180));             //ѕроводим пр¤мую в точку
        }
        return MyArray;
    }
}
