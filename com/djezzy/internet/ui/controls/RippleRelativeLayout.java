package com.djezzy.internet.ui.controls;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\controls\RippleRelativeLayout.smali */
public class RippleRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    public Paint f9714d;

    /* renamed from: e, reason: collision with root package name */
    public float f9715e;

    /* renamed from: f, reason: collision with root package name */
    public AnimatorSet f9716f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9717g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList<a> f9718h;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\controls\RippleRelativeLayout$a.smali */
    public class a extends View {
        public a(Context context) {
            super(context);
            setVisibility(4);
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            float min = Math.min(getWidth(), getHeight()) / 2;
            RippleRelativeLayout rippleRelativeLayout = RippleRelativeLayout.this;
            canvas.drawCircle(min, min, min - rippleRelativeLayout.f9715e, rippleRelativeLayout.f9714d);
        }
    }

    public RippleRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        char c2 = 0;
        this.f9717g = false;
        this.f9718h = new ArrayList<>();
        if (isInEditMode()) {
            return;
        }
        if (attributeSet == null) {
            throw new IllegalArgumentException("Attributes should be provided to this view,");
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.c.b.a.f3496b);
        int color = obtainStyledAttributes.getColor(0, getResources().getColor(2131099711));
        this.f9715e = obtainStyledAttributes.getDimension(5, getResources().getDimension(2131165569));
        int i2 = 2;
        float dimension = obtainStyledAttributes.getDimension(2, getResources().getDimension(2131165568));
        int i3 = 1;
        int i4 = obtainStyledAttributes.getInt(1, 3000);
        int i5 = obtainStyledAttributes.getInt(3, 6);
        float f2 = obtainStyledAttributes.getFloat(4, 10.0f);
        int i6 = obtainStyledAttributes.getInt(6, 0);
        obtainStyledAttributes.recycle();
        int i7 = i4 / i5;
        Paint paint = new Paint();
        this.f9714d = paint;
        paint.setAntiAlias(true);
        if (i6 == 0) {
            this.f9715e = 0.0f;
            this.f9714d.setStyle(Paint.Style.FILL);
        } else {
            this.f9714d.setStyle(Paint.Style.STROKE);
        }
        this.f9714d.setColor(color);
        int i8 = (int) ((dimension + this.f9715e) * 2.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i8, i8);
        int i9 = -1;
        layoutParams.addRule(13, -1);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f9716f = animatorSet;
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 < i5) {
            a aVar = new a(getContext());
            addView(aVar, layoutParams);
            this.f9718h.add(aVar);
            float[] fArr = new float[i2];
            fArr[c2] = 1.0f;
            fArr[i3] = f2;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar, "ScaleX", fArr);
            ofFloat.setRepeatCount(i9);
            ofFloat.setRepeatMode(i3);
            long j2 = i10 * i7;
            ofFloat.setStartDelay(j2);
            float f3 = f2;
            long j3 = i4;
            ofFloat.setDuration(j3);
            arrayList.add(ofFloat);
            float[] fArr2 = new float[i2];
            fArr2[c2] = 1.0f;
            fArr2[1] = f3;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(aVar, "ScaleY", fArr2);
            ofFloat2.setRepeatCount(-1);
            ofFloat2.setRepeatMode(1);
            ofFloat2.setStartDelay(j2);
            ofFloat2.setDuration(j3);
            arrayList.add(ofFloat2);
            float[] fArr3 = new float[i2];
            // fill-array-data instruction
            fArr3[0] = 1.0f;
            fArr3[1] = 0.0f;
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(aVar, "Alpha", fArr3);
            ofFloat3.setRepeatCount(-1);
            ofFloat3.setRepeatMode(1);
            ofFloat3.setStartDelay(j2);
            ofFloat3.setDuration(j3);
            arrayList.add(ofFloat3);
            i10++;
            i5 = i5;
            f2 = f3;
            c2 = 0;
            i2 = 2;
            i3 = 1;
            i9 = -1;
        }
        this.f9716f.playTogether(arrayList);
    }

    public void a() {
        if (this.f9717g) {
            return;
        }
        Iterator<a> it = this.f9718h.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(0);
        }
        this.f9716f.start();
        this.f9717g = true;
    }
}