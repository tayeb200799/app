package com.djezzy.internet.services.camera;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import c.c.b.g.a.a;
import java.io.IOException;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\camera\CameraSourcePreview.smali */
public class CameraSourcePreview extends ViewGroup {

    /* renamed from: d, reason: collision with root package name */
    public final Context f9660d;

    /* renamed from: e, reason: collision with root package name */
    public final SurfaceView f9661e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9662f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9663g;

    /* renamed from: h, reason: collision with root package name */
    public c.c.b.g.a.a f9664h;

    /* renamed from: i, reason: collision with root package name */
    public GraphicOverlay f9665i;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\camera\CameraSourcePreview$b.smali */
    public class b implements SurfaceHolder.Callback {
        public b(a aVar) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            CameraSourcePreview cameraSourcePreview = CameraSourcePreview.this;
            cameraSourcePreview.f9663g = true;
            try {
                cameraSourcePreview.b();
            } catch (IOException e2) {
                Log.e("CameraSourcePreview", "Could not start camera source.", e2);
            } catch (SecurityException e3) {
                Log.e("CameraSourcePreview", "Do not have permission to start the camera", e3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CameraSourcePreview.this.f9663g = false;
        }
    }

    public CameraSourcePreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9660d = context;
        this.f9662f = false;
        this.f9663g = false;
        SurfaceView surfaceView = new SurfaceView(context);
        this.f9661e = surfaceView;
        surfaceView.getHolder().addCallback(new b(null));
        addView(surfaceView);
    }

    public final boolean a() {
        int i2 = this.f9660d.getResources().getConfiguration().orientation;
        if (i2 == 2) {
            return false;
        }
        if (i2 == 1) {
            return true;
        }
        Log.d("CameraSourcePreview", "isPortraitMode returning false by default");
        return false;
    }

    public final void b() {
        if (this.f9662f && this.f9663g) {
            c.c.b.g.a.a aVar = this.f9664h;
            SurfaceHolder holder = this.f9661e.getHolder();
            synchronized (aVar.f3867b) {
                if (aVar.f3868c == null) {
                    Camera a2 = aVar.a();
                    aVar.f3868c = a2;
                    a2.setPreviewDisplay(holder);
                    aVar.f3868c.startPreview();
                    aVar.l = new Thread(aVar.m);
                    a.c cVar = aVar.m;
                    synchronized (cVar.f3879f) {
                        cVar.f3880g = true;
                        cVar.f3879f.notifyAll();
                    }
                    aVar.l.start();
                }
            }
            if (this.f9665i != null) {
                c.d.a.c.e.l.a aVar2 = this.f9664h.f3871f;
                int min = Math.min(aVar2.f7475a, aVar2.f7476b);
                int max = Math.max(aVar2.f7475a, aVar2.f7476b);
                if (a()) {
                    this.f9665i.a(min, max, this.f9664h.f3869d);
                } else {
                    this.f9665i.a(max, min, this.f9664h.f3869d);
                }
                GraphicOverlay graphicOverlay = this.f9665i;
                synchronized (graphicOverlay.f9667d) {
                    graphicOverlay.f9673j.clear();
                }
                graphicOverlay.postInvalidate();
            }
            this.f9662f = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        c.d.a.c.e.l.a aVar;
        c.c.b.g.a.a aVar2 = this.f9664h;
        if (aVar2 == null || (aVar = aVar2.f3871f) == null) {
            i6 = 320;
            i7 = 240;
        } else {
            i6 = aVar.f7475a;
            i7 = aVar.f7476b;
        }
        if (!a()) {
            int i10 = i6;
            i6 = i7;
            i7 = i10;
        }
        int i11 = i4 - i2;
        int i12 = i5 - i3;
        float f2 = i7;
        float f3 = i11 / f2;
        float f4 = i6;
        float f5 = i12 / f4;
        if (f3 > f5) {
            int i13 = (int) (f4 * f3);
            int i14 = (i13 - i12) / 2;
            i12 = i13;
            i9 = i14;
            i8 = 0;
        } else {
            int i15 = (int) (f2 * f5);
            i8 = (i15 - i11) / 2;
            i11 = i15;
            i9 = 0;
        }
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            getChildAt(i16).layout(i8 * (-1), i9 * (-1), i11 - i8, i12 - i9);
        }
        try {
            b();
        } catch (IOException e2) {
            Log.e("CameraSourcePreview", "Could not start camera source.", e2);
        } catch (SecurityException e3) {
            Log.e("CameraSourcePreview", "Do not have permission to start the camera", e3);
        }
    }
}