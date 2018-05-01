package com.example.sridhar123.biodiversity;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public class SlopeDrawable extends Drawable {

    private Paint paint;
    private Path path;
    private int start_color, end_color;

    public SlopeDrawable(int start_color, int end_color) {
        paint = new Paint();
        path = new Path();
        this.start_color = start_color;
        this.end_color = end_color;
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(20);
        paint.setTypeface(Typeface.DEFAULT);
        path.moveTo(0, 120);
        path.lineTo(canvas.getWidth(), 0);
        path.lineTo(canvas.getWidth(), canvas.getHeight());
        path.lineTo(0, canvas.getHeight());
        path.lineTo(0, 120);
        paint.setShader(new LinearGradient(0, 0, 0, canvas.getHeight(), start_color, end_color, Shader.TileMode.MIRROR));
        canvas.drawPath(path, paint);
    }

    @Override
    public void setAlpha(int i) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }
}

