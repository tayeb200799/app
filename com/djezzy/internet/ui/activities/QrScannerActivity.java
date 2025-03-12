package com.djezzy.internet.ui.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import b.p.q;
import b.p.y;
import c.c.b.h.a.a0;
import c.c.b.h.a.d0;
import c.c.b.h.a.e0;
import c.c.b.j.d.l;
import c.c.b.k.c;
import c.d.a.c.i.j.b5;
import c.d.a.c.i.j.i3;
import c.d.a.c.n.a;
import c.d.a.c.n.a.RunnableC0119a;
import c.d.a.c.n.d.b;
import com.djezzy.internet.ui.activities.QrScannerActivity;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\QrScannerActivity.smali */
public class QrScannerActivity extends a0 implements View.OnClickListener {
    public AppCompatButton A;
    public b B;
    public a C;
    public String D;
    public String E;
    public String F;
    public l G;
    public q<c> H;
    public SurfaceView y;
    public AppCompatButton z;

    @Override // c.c.b.h.a.a0
    public void I(c cVar) {
        if (c.starting.equals(cVar)) {
            ProgressDialog progressDialog = this.u;
            if (progressDialog != null) {
                progressDialog.show();
                return;
            }
            return;
        }
        if (cVar == c.success_gift_scan) {
            ProgressDialog progressDialog2 = this.u;
            if (progressDialog2 != null) {
                progressDialog2.dismiss();
            }
            b.n.a.J0(z(), this, getResources().getString(2131886219), getResources().getString(2131886295), getResources().getString(2131886115), "", 2131231094);
            return;
        }
        if (cVar == c.error_gift_scan) {
            ProgressDialog progressDialog3 = this.u;
            if (progressDialog3 != null) {
                progressDialog3.dismiss();
            }
            b.n.a.J0(z(), this, getResources().getString(2131886224), getResources().getString(2131886207), getResources().getString(2131886115), "", 2131230885);
            return;
        }
        if (cVar != c.error_gift_gaming) {
            super.I(cVar);
            return;
        }
        ProgressDialog progressDialog4 = this.u;
        if (progressDialog4 != null) {
            progressDialog4.dismiss();
        }
        b.n.a.J0(z(), this, getResources().getString(2131886224), getResources().getString(2131886213), getResources().getString(2131886115), "", 2131230885);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == 2131362456) {
            String str = this.D;
            if (str == null || str.length() <= 0) {
                return;
            }
            this.A.setEnabled(false);
            this.z.setEnabled(false);
            this.z.setText("Scanning ...");
            return;
        }
        if (id == 2131362458 && this.D.length() > 0) {
            final l lVar = this.G;
            String str2 = this.E;
            String str3 = this.F;
            String str4 = this.D;
            Objects.requireNonNull(lVar);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pos-id", str4);
                jSONObject.put("id", str3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("services", jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", str2);
                jSONObject3.put("type", "products");
                jSONObject3.put("meta", jSONObject2);
                final JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("data", jSONObject3);
                Objects.requireNonNull(c.c.b.f.a0.e());
                new Thread(new Runnable() { // from class: c.c.b.f.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.c.b.k.e eVar = c.c.b.k.e.this;
                        JSONObject jSONObject5 = jSONObject4;
                        c.c.b.j.c cVar = (c.c.b.j.c) eVar;
                        try {
                            cVar.l();
                            JSONObject p = c.c.b.k.g.f().p(jSONObject5, 30000);
                            if (p == null) {
                                throw new Exception();
                            }
                            if (p.has("status") && p.getInt("status") == 200) {
                                cVar.b(c.c.b.k.c.success_gift_scan);
                            } else {
                                if (!p.has("status") || p.getInt("status") != 403) {
                                    throw new Exception();
                                }
                                cVar.f4170d.j(c.c.b.k.c.error_gift_scan);
                            }
                        } catch (c.c.b.c.c e2) {
                            e2.printStackTrace();
                            cVar.f4170d.j(e2.f3518d);
                        } catch (UnknownHostException e3) {
                            e = e3;
                            e.printStackTrace();
                            cVar.f4170d.j(c.c.b.k.c.error_network);
                        } catch (TimeoutException e4) {
                            e = e4;
                            e.printStackTrace();
                            cVar.f4170d.j(c.c.b.k.c.error_network);
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            cVar.f4170d.j(c.c.b.k.c.error_gift_gaming);
                        }
                    }
                }).start();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558435);
        if (getIntent() == null) {
            finish();
            return;
        }
        if (!getIntent().hasExtra("id") || !getIntent().hasExtra("service-id")) {
            finish();
            return;
        }
        this.E = getIntent().getStringExtra("id");
        this.F = getIntent().getStringExtra("service-id");
        this.y = (SurfaceView) findViewById(2131362457);
        this.z = (AppCompatButton) findViewById(2131362458);
        this.A = (AppCompatButton) findViewById(2131362456);
        this.z.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.H = new q() { // from class: c.c.b.h.a.e
            @Override // b.p.q
            public final void a(Object obj) {
                QrScannerActivity.this.I((c.c.b.k.c) obj);
            }
        };
        l lVar = (l) new y(this).a(l.class);
        this.G = lVar;
        lVar.i();
        this.G.f4170d.e(this, this.H);
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onPause() {
        super.onPause();
        a aVar = this.C;
        synchronized (aVar.f8394b) {
            aVar.b();
            a.RunnableC0119a runnableC0119a = aVar.k;
            c.d.a.c.n.b<?> bVar = runnableC0119a.f8403d;
            if (bVar != null) {
                bVar.d();
                runnableC0119a.f8403d = null;
            }
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onResume() {
        super.onResume();
        i3 i3Var = new i3();
        i3Var.f8137d = 256;
        b bVar = new b(new b5(this, i3Var), null);
        this.B = bVar;
        a aVar = new a(null);
        aVar.f8393a = this;
        aVar.f8398f = 1920;
        aVar.f8399g = 1080;
        aVar.f8400h = true;
        aVar.k = aVar.new RunnableC0119a(bVar);
        this.C = aVar;
        this.y.getHolder().addCallback(new d0(this));
        this.B.e(new e0(this));
    }
}