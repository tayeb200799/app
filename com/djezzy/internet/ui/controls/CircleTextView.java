package com.djezzy.internet.ui.controls;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import c.c.b.a;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\controls\CircleTextView.smali */
public class CircleTextView extends AppCompatTextView {

    /* renamed from: h, reason: collision with root package name */
    public Paint f9708h;

    /* renamed from: i, reason: collision with root package name */
    public Paint f9709i;

    /* renamed from: j, reason: collision with root package name */
    public RectF f9710j;
    public RectF k;
    public int l;
    public int m;
    public float n;
    public float o;
    public float p;
    public float q;
    public int r;
    public int s;

    public CircleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f3495a, 0, 0);
        if (obtainStyledAttributes != null) {
            this.l = obtainStyledAttributes.getInt(2, 100);
            this.m = obtainStyledAttributes.getInt(3, 0);
            this.q = obtainStyledAttributes.getFloat(4, 0.0f);
            this.n = obtainStyledAttributes.getDimension(1, 5.0f);
            this.o = obtainStyledAttributes.getDimension(6, 1.0f);
            this.r = obtainStyledAttributes.getColor(0, 0);
            this.s = obtainStyledAttributes.getColor(5, 0);
        }
        this.f9710j = new RectF();
        this.k = new RectF();
        Paint paint = new Paint();
        this.f9708h = paint;
        paint.setAntiAlias(true);
        this.f9708h.setStyle(Paint.Style.STROKE);
        this.f9708h.setStrokeCap(Paint.Cap.ROUND);
        this.f9708h.setStrokeWidth(this.n);
        this.f9708h.setColor(this.r);
        Paint paint2 = new Paint();
        this.f9709i = paint2;
        paint2.setAntiAlias(true);
        this.f9709i.setStyle(Paint.Style.STROKE);
        this.f9709i.setStrokeCap(Paint.Cap.ROUND);
        this.f9709i.setStrokeWidth(this.o);
        this.f9709i.setColor(this.s);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f9710j;
        float f2 = this.n;
        rectF.set(f2, f2, getWidth() - this.n, getHeight() - this.n);
        RectF rectF2 = this.k;
        float f3 = this.n;
        rectF2.set(f3, f3, getWidth() - this.n, getHeight() - this.n);
        RectF rectF3 = this.k;
        float f4 = this.q;
        float f5 = this.p;
        canvas.drawArc(rectF3, f4 + f5, 270.0f - f5, false, this.f9709i);
        canvas.drawArc(this.f9710j, this.q, this.p, false, this.f9708h);
    }

    public void setMax(int i2) {
        this.l = i2;
    }

    public void setProgress(int i2) {
        int i3 = this.l;
        if (i2 > i3) {
            i2 = i3;
        }
        this.m = i2;
        this.p = (i2 / (i3 == 0 ? 1.0f : i3)) * 270.0f;
        invalidate();
    }
}