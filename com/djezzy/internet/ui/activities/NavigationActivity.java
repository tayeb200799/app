package com.djezzy.internet.ui.activities;

import android.app.ProgressDialog;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import b.p.q;
import c.c.b.d.j;
import c.c.b.e.c0;
import c.c.b.e.u;
import c.c.b.e.y;
import c.c.b.e.z;
import c.c.b.h.a.a0;
import c.c.b.h.b.i.b;
import c.c.b.h.d.j0;
import c.c.b.j.d.k;
import c.c.b.k.c;
import c.d.a.c.m.f;
import com.djezzy.internet.ui.activities.NavigationActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\NavigationActivity.smali */
public class NavigationActivity extends a0 implements j {
    public static final /* synthetic */ int I = 0;
    public k A;
    public q<c> B;
    public q<c0> C;
    public long D;
    public c.c.b.g.g.a E;
    public SensorManager F;
    public c.c.b.h.d.c0 G;
    public c.c.b.h.d.a0 H;
    public ViewPager y;
    public TabLayout z;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\NavigationActivity$a.smali */
    public class a implements TabLayout.d {
        public a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void i(TabLayout.g gVar) {
            Drawable drawable = gVar.f9920b;
            if (drawable != null) {
                drawable.setColorFilter(b.h.d.a.b(NavigationActivity.this, 2131099711), PorterDuff.Mode.SRC_IN);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void o(TabLayout.g gVar) {
            if (gVar.f9920b != null) {
                gVar.f9920b.setColorFilter(b.h.d.a.b(NavigationActivity.this, b.n.a.E(NavigationActivity.this, 2130969362)), PorterDuff.Mode.SRC_IN);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void r(TabLayout.g gVar) {
            Drawable drawable = gVar.f9920b;
            if (drawable != null) {
                drawable.setColorFilter(b.h.d.a.b(NavigationActivity.this, 2131099711), PorterDuff.Mode.SRC_IN);
            }
        }
    }

    @Override // c.c.b.h.a.a0
    public c.c.b.j.c E() {
        return this.A;
    }

    @Override // c.c.b.h.a.a0
    public void I(c cVar) {
        if (cVar == c.loading) {
            ProgressDialog progressDialog = this.u;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            K(this.H, "loading_fragment", this.G);
            return;
        }
        if (cVar != c.success_shake) {
            if (cVar != c.success) {
                super.I(cVar);
                return;
            }
            ProgressDialog progressDialog2 = this.u;
            if (progressDialog2 != null) {
                progressDialog2.dismiss();
            }
            if (this.A.f4173g != null) {
                j0 j0Var = new j0();
                j0Var.l0 = this;
                j0Var.m0 = this.A.f4173g;
                j0Var.F0(z(), "operation_success_fragment");
                return;
            }
            return;
        }
        ProgressDialog progressDialog3 = this.u;
        if (progressDialog3 != null) {
            progressDialog3.dismiss();
        }
        u uVar = this.A.f4173g;
        if (uVar == null) {
            K(null, "offer_confirmation_fragment", this.H);
            b.n.a.K0(z(), this, getString(2131886114), getString(2131886131), getString(2131886224), getString(2131886210), "offers_tag", 2131230884);
            return;
        }
        c.c.b.h.d.c0 c0Var = this.G;
        c0Var.m0 = uVar;
        if (!c0Var.O()) {
            K(this.G, "offer_confirmation_fragment", this.H);
            return;
        }
        c.c.b.h.d.c0 c0Var2 = this.G;
        View view = c0Var2.H;
        if (view == null) {
            return;
        }
        if (c0Var2.m0 != null) {
            c0Var2.J0(view);
        }
        c0Var2.H0(view);
    }

    public final void L() {
        try {
            FirebaseMessaging.c().f().c(new f() { // from class: c.c.b.h.a.l
                @Override // c.d.a.c.m.f
                public final void c(Object obj) {
                    NavigationActivity.this.A.j((String) obj, false, c.c.b.k.c.success_notification);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void M(int i2) {
        TabLayout.g g2;
        if ((i2 >= 0 || i2 < this.z.getTabCount()) && (g2 = this.z.g(i2)) != null) {
            g2.a();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.z.getSelectedTabPosition() != 0) {
            M(0);
        } else {
            this.f76i.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x002a, code lost:
    
        if (b.n.a.t(r10) != false) goto L10;
     */
    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.djezzy.internet.ui.activities.NavigationActivity.onCreate(android.os.Bundle):void");
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onDestroy() {
        k kVar = this.A;
        if (kVar != null) {
            kVar.f4170d.h(this.B);
            this.A.o().h(this.C);
        }
        super.onDestroy();
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onPause() {
        super.onPause();
        SensorManager sensorManager = this.F;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.E);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.F != null) {
            Objects.requireNonNull(this.A);
            y d2 = c.c.b.f.a0.e().d();
            boolean z = false;
            if ((d2 == null || d2.j() == null) ? false : z.a.postpaid.equals(d2.j().b())) {
                return;
            }
            Objects.requireNonNull(this.A);
            y d3 = c.c.b.f.a0.e().d();
            if (d3 != null && d3.j() != null) {
                z = d3.j().f3761a;
            }
            if (z) {
                return;
            }
            SensorManager sensorManager = this.F;
            sensorManager.registerListener(this.E, sensorManager.getDefaultSensor(1), 3);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onStart() {
        super.onStart();
        String L = b.n.a.L(getApplicationContext());
        if ("none".equals(L) || "enabled_not_send".equals(L)) {
            L();
        } else if ("disabled_not_send".equals(L)) {
            this.A.j(null, false, c.success_notification);
        }
    }

    @Override // c.c.b.d.j
    public String p() {
        return "NavigationActivity";
    }

    @Override // c.c.b.h.a.a0, c.c.b.d.b
    public void t(c.c.b.b.a aVar, String str) {
        if (aVar == c.c.b.b.a.UPDATE) {
            b.n.a.q0(this);
            return;
        }
        if (aVar != c.c.b.b.a.POSITIVE) {
            if (aVar != c.c.b.b.a.NEGATIVE) {
                super.t(aVar, str);
                return;
            } else {
                if ("notification_tag".equals(str)) {
                    b.n.a.C0(this, "notification_status", "disabled");
                    return;
                }
                return;
            }
        }
        if ("notification_tag".equals(str)) {
            L();
        } else if ("offers_tag".equals(str)) {
            u("offers_fragment", null);
        } else {
            super.t(aVar, str);
        }
    }

    @Override // c.c.b.d.j
    public void u(String str, String str2) {
        if (this.y.getAdapter() instanceof c.c.b.h.b.i.a) {
            int q = ((c.c.b.h.b.i.a) this.y.getAdapter()).q(str);
            M(q);
            if (str2 == null || str2.isEmpty()) {
                return;
            }
            List<Fragment> K = z().K();
            int size = K.size();
            for (int i2 = 0; i2 < size; i2++) {
                if ((K.get(i2) instanceof j) && str.equals(((j) K.get(i2)).p())) {
                    ((j) K.get(i2)).u(str2, null);
                    return;
                }
            }
            b p = ((c.c.b.h.b.i.a) this.y.getAdapter()).p(q);
            if (p != null) {
                p.f4002d = str2;
            }
        }
    }
}