package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;

public class MyViewTest1 extends View {
    int N = 50;
    float[] x = new float[N];
    float[] y = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    long lastTime = System.currentTimeMillis();


    public MyViewTest1(Context context) {
        super(context);
        fillRandom(x, 0, 500);
        fillRandom(y, 0, 500);
        fillRandom(vx, -3, 3);
        fillRandom(vy, 0,500);
    }

    float rand(float min , float max){
        return (float)(Math.random() * (max - min + 1)) + min;
    }

    void fillRandom(float[] array , float min, float max){
        for (int i = 0; i < array.length; i++){
            array[i] = rand (min, max);
        }
    }

    void addValues(float[] array , float[] values){
        for (int i = 0; i < array.length; i++){
            array[i] += values[i];
        }
    }

    void drawBalls(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        for (int i = 0; i < N; i++) {
            canvas.drawCircle(x[i], y[i], 20, paint);
        }
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        drawBalls(canvas);

        addValues(x, vx);
        addValues(y, vy);

        invalidate();
    }
}
