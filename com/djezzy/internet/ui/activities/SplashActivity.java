package com.djezzy.internet.ui.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import b.p.p;
import b.p.q;
import b.p.y;
import c.a.a.a.a;
import c.b.a.i;
import c.b.a.s.j.d;
import c.b.a.u.e;
import c.c.b.e.b0;
import c.c.b.g.e.b;
import c.c.b.h.a.a0;
import c.c.b.h.e.a1;
import c.c.b.h.e.c1;
import c.c.b.h.e.e1;
import c.c.b.h.e.f1;
import c.c.b.h.e.g1;
import c.c.b.h.e.s0;
import c.c.b.h.e.t0;
import c.c.b.h.e.u0;
import c.c.b.h.e.v0;
import c.c.b.h.e.x0;
import c.c.b.j.d.o;
import c.c.b.k.c;
import com.djezzy.internet.ui.activities.SplashActivity;
import com.djezzy.internet.ui.activities.otp.LoginActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\SplashActivity.smali */
public class SplashActivity extends a0 {
    public static final /* synthetic */ int B = 0;
    public q<b0> A;
    public o y;
    public q<c> z;

    @Override // c.c.b.h.a.a0
    public String D() {
        return "splash_activity";
    }

    @Override // c.c.b.h.a.a0
    public void I(c cVar) {
        String str;
        if (!c.success.equals(cVar)) {
            if (c.error_unauthorized.equals(cVar)) {
                G(LoginActivity.class, true);
                return;
            } else {
                if (c.starting.equals(cVar)) {
                    return;
                }
                super.I(cVar);
                return;
            }
        }
        String str2 = "";
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("notification")) {
            b b2 = b.b(intent.getStringExtra("notification"));
            if ("fragment_open".equals(b2.d())) {
                JSONObject jSONObject = b2.f3919i;
                try {
                    String string = jSONObject.getString("parent_fragment");
                    try {
                        str2 = jSONObject.getString("child_fragment");
                    } catch (Exception unused) {
                    }
                    str = str2;
                    str2 = string;
                } catch (Exception unused2) {
                    str = "";
                }
                HashMap<String, Object> q = a.q("request_param", str2, "request_sub_param", str);
                q.put("notification_type", b2.d());
                H(NavigationActivity.class, true, q);
                return;
            }
            if ("offer_present".equals(b2.d())) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("notification_type", b2.d());
                hashMap.put("notification", intent.getStringExtra("notification"));
                H(NavigationActivity.class, true, hashMap);
                return;
            }
        }
        if (intent == null || !intent.hasExtra("open_radio")) {
            G(NavigationActivity.class, true);
            return;
        }
        HashMap<String, Object> q2 = a.q("request_param", "service_fragment", "request_sub_param", "radio_fragment");
        q2.put("notification_type", "fragment_open");
        H(NavigationActivity.class, true, q2);
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558437);
        u0.a().b("RANATI_FRAGMENT_UAT", new c.c.b.h.b.i.b(f1.class, "ranati_fragment", getString(2131886500)));
        u0.a().b("QUIZ_FRAGMENT_40013", new c.c.b.h.b.i.b(a1.class, "quiz_fragment", getString(2131886498)));
        u0.a().b("GAMING_FRAGMENT_40013", new c.c.b.h.b.i.b(v0.class, "gaming_fragment", getString(2131886494)));
        u0.a().b("RAMADAN_FRAGMENT", new c.c.b.h.b.i.b(e1.class, "ramadan_fragment", getString(2131886499)));
        u0.a().b("FLEXY_FRAGMENT", new c.c.b.h.b.i.b(t0.class, "flexy_fragment", getString(2131886493)));
        u0.a().b("FAMILY_FRAGMENT", new c.c.b.h.b.i.b(s0.class, "family_fragment", getString(2131886491)));
        u0.a().b("RADIO_FRAGMENT", new c.c.b.h.b.i.b(c1.class, "radio_fragment", ""));
        u0.a().b("LINKS_FRAGMENT", new c.c.b.h.b.i.b(x0.class, "links_fragment", ""));
        u0.a().b("VIDEOS_FRAGMENT", new c.c.b.h.b.i.b(g1.class, "videos_fragment", ""));
        i<Drawable> p = c.b.a.c.b(this).f2641i.c(this).p(2131230820);
        p.F(new d((ImageView) findViewById(2131362215)), null, p, e.f3454a);
        c.c.b.f.a0.e().f3780e = true;
        this.z = new q() { // from class: c.c.b.h.a.b
            @Override // b.p.q
            public final void a(Object obj) {
                SplashActivity.this.I((c.c.b.k.c) obj);
            }
        };
        this.A = new q() { // from class: c.c.b.h.a.u
            @Override // b.p.q
            public final void a(Object obj) {
                SplashActivity splashActivity = SplashActivity.this;
                c.c.b.e.b0 b0Var = (c.c.b.e.b0) obj;
                int i2 = SplashActivity.B;
                String J = b.n.a.J(splashActivity);
                if (b0Var != null && "OffreJeune".equals(b0Var.f3527a)) {
                    b.n.a.C0(splashActivity, "night_mode", "izzy");
                } else if ("izzy".equals(J)) {
                    b.n.a.C0(splashActivity, "night_mode", "normal");
                }
            }
        };
        o oVar = (o) new y(this).a(o.class);
        this.y = oVar;
        oVar.i();
        if (bundle == null) {
            o oVar2 = this.y;
            Objects.requireNonNull(oVar2);
            ArrayList arrayList = new ArrayList();
            arrayList.add("surprise-products");
            arrayList.add("subscription-type-illegibility");
            arrayList.add("connected-products");
            arrayList.add("subscription-history");
            arrayList.add("flash-products");
            arrayList.add("supplementary-informations");
            arrayList.add("available-services");
            c.c.b.f.a0.e().g(arrayList, 30000, false, true, true, c.success, oVar2);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onPause() {
        super.onPause();
        o oVar = this.y;
        if (oVar != null) {
            oVar.f4170d.h(this.z);
            o oVar2 = this.y;
            if (oVar2.f4199h == null) {
                oVar2.f4199h = new p<>();
            }
            oVar2.f4199h.h(this.A);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.y.f4170d.e(this, this.z);
        o oVar = this.y;
        if (oVar.f4199h == null) {
            oVar.f4199h = new p<>();
        }
        oVar.f4199h.e(this, this.A);
    }

    @Override // c.c.b.h.a.a0, c.c.b.d.b
    public void t(c.c.b.b.a aVar, String str) {
        if (aVar == c.c.b.b.a.NEUTRAL) {
            finish();
        }
    }
}