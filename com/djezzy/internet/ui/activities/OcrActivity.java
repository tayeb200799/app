package com.djezzy.internet.ui.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import c.c.b.d.e;
import c.c.b.g.a.a;
import c.c.b.g.a.a.c;
import c.c.b.g.a.b;
import c.c.b.g.a.c;
import c.c.b.h.a.a0;
import c.c.b.h.a.b0;
import c.c.b.h.a.c0;
import c.d.a.c.i.j.m;
import c.d.a.c.i.j.n;
import c.d.a.c.n.f.d;
import com.djezzy.internet.services.camera.CameraSourcePreview;
import com.djezzy.internet.services.camera.GraphicOverlay;
import java.io.IOException;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\OcrActivity.smali */
public class OcrActivity extends a0 implements e {
    public GraphicOverlay<c> A;
    public a y;
    public CameraSourcePreview z;

    @Override // c.c.b.h.a.a0
    public String D() {
        return "ocr_activity";
    }

    @SuppressLint({"InlinedApi"})
    public final void L(boolean z, boolean z2) {
        d dVar = new d(new n(this, new m()), null);
        dVar.e(new b(this.A, findViewById(2131361941), this));
        if (!dVar.f8495c.c()) {
            if (registerReceiver(null, new IntentFilter("android.intent.action.DEVICE_STORAGE_LOW")) != null) {
                setResult(3);
            }
        }
        Context applicationContext = getApplicationContext();
        a aVar = new a(null);
        if (applicationContext == null) {
            throw new IllegalArgumentException("No context supplied.");
        }
        aVar.f3866a = applicationContext;
        aVar.f3869d = 0;
        aVar.f3873h = 1280;
        aVar.f3874i = 1024;
        aVar.f3872g = 2.0f;
        aVar.k = z2 ? "torch" : null;
        aVar.f3875j = z ? "continuous-video" : null;
        aVar.m = aVar.new c(dVar);
        this.y = aVar;
        View findViewById = findViewById(2131362206);
        Animation loadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), 2130772003);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getApplicationContext(), 2130772004);
        loadAnimation.setAnimationListener(new b0(this, findViewById, loadAnimation2));
        loadAnimation2.setAnimationListener(new c0(this, findViewById, loadAnimation));
        findViewById.startAnimation(loadAnimation);
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558434);
        this.z = (CameraSourcePreview) findViewById(2131362417);
        this.A = (GraphicOverlay) findViewById(2131362133);
        if (b.n.a.U(this, "android.permission.CAMERA")) {
            L(true, false);
        } else if (b.h.c.a.d(this, "android.permission.CAMERA")) {
            setResult(2);
            finish();
        } else {
            b.h.c.a.c(this, new String[]{"android.permission.CAMERA"}, 2);
        }
        setResult(4);
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onDestroy() {
        a aVar;
        super.onDestroy();
        CameraSourcePreview cameraSourcePreview = this.z;
        if (cameraSourcePreview == null || (aVar = cameraSourcePreview.f9664h) == null) {
            return;
        }
        aVar.c();
        cameraSourcePreview.f9664h = null;
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onPause() {
        a aVar;
        super.onPause();
        CameraSourcePreview cameraSourcePreview = this.z;
        if (cameraSourcePreview == null || (aVar = cameraSourcePreview.f9664h) == null) {
            return;
        }
        aVar.d();
    }

    @Override // b.n.c.e, android.app.Activity, b.h.c.a.b
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 != 2) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            return;
        }
        if (iArr.length == 0 || iArr[0] != 0) {
            setResult(2);
            finish();
        } else {
            L(getIntent().getBooleanExtra("AutoFocus", true), getIntent().getBooleanExtra("UseFlash", false));
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onResume() {
        super.onResume();
        Object obj = c.d.a.c.e.d.f7336b;
        c.d.a.c.e.d dVar = c.d.a.c.e.d.f7337c;
        int e2 = dVar.e(getApplicationContext());
        if (e2 != 0) {
            dVar.d(this, e2, 9001).show();
        }
        a aVar = this.y;
        if (aVar != null) {
            try {
                CameraSourcePreview cameraSourcePreview = this.z;
                cameraSourcePreview.f9665i = this.A;
                cameraSourcePreview.f9664h = aVar;
                cameraSourcePreview.f9662f = true;
                cameraSourcePreview.b();
            } catch (IOException unused) {
                this.y.c();
                this.y = null;
            }
        }
    }
}