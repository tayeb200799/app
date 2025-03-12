package com.djezzy.internet.services.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.djezzy.internet.services.camera.GraphicOverlay.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\camera\GraphicOverlay.smali */
public class GraphicOverlay<T extends a> extends View {

    /* renamed from: d, reason: collision with root package name */
    public final Object f9667d;

    /* renamed from: e, reason: collision with root package name */
    public int f9668e;

    /* renamed from: f, reason: collision with root package name */
    public float f9669f;

    /* renamed from: g, reason: collision with root package name */
    public int f9670g;

    /* renamed from: h, reason: collision with root package name */
    public float f9671h;

    /* renamed from: i, reason: collision with root package name */
    public int f9672i;

    /* renamed from: j, reason: collision with root package name */
    public final Set<T> f9673j;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\camera\GraphicOverlay$a.smali */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final GraphicOverlay f9674a;

        public a(GraphicOverlay graphicOverlay) {
            this.f9674a = graphicOverlay;
        }

        public abstract void a(Canvas canvas);

        public RectF b(RectF rectF) {
            RectF rectF2 = new RectF();
            rectF2.left = c(rectF.left);
            rectF2.top = d(rectF.top);
            rectF2.right = c(rectF.right);
            rectF2.bottom = d(rectF.bottom);
            return rectF2;
        }

        public float c(float f2) {
            GraphicOverlay graphicOverlay = this.f9674a;
            return graphicOverlay.f9672i == 1 ? graphicOverlay.getWidth() - (f2 * this.f9674a.f9669f) : f2 * graphicOverlay.f9669f;
        }

        public float d(float f2) {
            return f2 * this.f9674a.f9671h;
        }
    }

    public GraphicOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9667d = new Object();
        this.f9669f = 1.0f;
        this.f9671h = 1.0f;
        this.f9672i = 0;
        this.f9673j = new HashSet();
    }

    public void a(int i2, int i3, int i4) {
        synchronized (this.f9667d) {
            this.f9668e = i2;
            this.f9670g = i3;
            this.f9672i = i4;
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        synchronized (this.f9667d) {
            if (this.f9668e != 0 && this.f9670g != 0) {
                this.f9669f = getWidth() / this.f9668e;
                this.f9671h = getHeight() / this.f9670g;
            }
            Iterator<T> it = this.f9673j.iterator();
            while (it.hasNext()) {
                it.next().a(canvas);
            }
        }
    }
}