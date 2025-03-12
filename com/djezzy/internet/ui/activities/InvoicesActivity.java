package com.djezzy.internet.ui.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.n.a;
import b.p.q;
import b.p.y;
import c.c.b.b.b;
import c.c.b.d.c;
import c.c.b.e.c0;
import c.c.b.e.r;
import c.c.b.e.s;
import c.c.b.e.t;
import c.c.b.h.a.a0;
import c.c.b.h.b.f.e;
import c.c.b.h.d.v;
import c.c.b.j.d.d;
import com.djezzy.internet.ui.activities.InvoicesActivity;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\InvoicesActivity.smali */
public class InvoicesActivity extends a0 implements SwipeRefreshLayout.h, c {
    public static final /* synthetic */ int G = 0;
    public q<List<s>> A;
    public RecyclerView B;
    public SwipeRefreshLayout C;
    public v D;
    public r E;
    public c0 F;
    public d y;
    public q<c.c.b.k.c> z;

    @Override // c.c.b.h.a.a0
    public String D() {
        return "invoices_activity";
    }

    @Override // c.c.b.h.a.a0
    public c.c.b.j.c E() {
        return this.y;
    }

    @Override // c.c.b.h.a.a0
    public void I(c.c.b.k.c cVar) {
        if (cVar == c.c.b.k.c.loading) {
            SwipeRefreshLayout swipeRefreshLayout = this.C;
            if (swipeRefreshLayout != null && !swipeRefreshLayout.f528f) {
                swipeRefreshLayout.setRefreshing(true);
            }
        } else if (cVar == c.c.b.k.c.success_set_epayment) {
            ProgressDialog progressDialog = this.u;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            if (!this.y.o().isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject2.put("fr", "Epayment Invoice");
                    jSONObject.put("text", jSONObject2);
                    jSONObject4.put("fr", this.y.o());
                    jSONObject4.put("ar", this.y.o());
                    jSONObject4.put("en", this.y.o());
                    jSONObject3.put("text", jSONObject4);
                    c0 c0Var = new c0();
                    this.F = c0Var;
                    c0Var.f3532b = c0.b.url_service;
                    c0Var.f3533c = t.a(jSONObject);
                    this.F.f3534d = t.a(jSONObject3);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                c0 c0Var2 = this.F;
                if (c0Var2.f3532b != null && c0Var2.f3534d != null && c0Var2.f3533c != null) {
                    a.h0(this, null, c0Var2);
                }
            }
        } else {
            SwipeRefreshLayout swipeRefreshLayout2 = this.C;
            if (swipeRefreshLayout2 != null && swipeRefreshLayout2.f528f) {
                swipeRefreshLayout2.setRefreshing(false);
            }
        }
        super.I(cVar);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.h
    public void h() {
        d dVar;
        if (this.C == null || (dVar = this.y) == null) {
            return;
        }
        dVar.q();
    }

    @Override // c.c.b.d.c
    public void k(Object obj, Object obj2) {
        String str;
        int i2;
        if (obj2 == null || !(obj2 instanceof s)) {
            str = "";
            i2 = 0;
        } else {
            s sVar = (s) obj2;
            i2 = (int) (sVar.f3697c - sVar.f3698d);
            str = sVar.f3695a;
        }
        if (obj2 != null && (obj2 instanceof String)) {
            try {
                i2 = Integer.parseInt((String) obj2);
            } catch (Exception unused) {
                i2 = 0;
            }
        }
        if (i2 == 0) {
            Toast.makeText(this, 2131886217, 0).show();
            return;
        }
        double d2 = i2;
        if (d2 > 9999.0d) {
            a.I0(z(), this, 2131886224, 2131886189, 2131230885, 2131886132);
            return;
        }
        if (this.E == null) {
            this.E = new r();
        }
        Objects.requireNonNull(this.E);
        Objects.requireNonNull(this.E);
        r rVar = this.E;
        rVar.f3691b = "INVOICE";
        rVar.f3694e = d2;
        rVar.f3693d = str;
        v vVar = new v();
        this.D = vVar;
        vVar.l0 = this;
        vVar.s0 = this.E;
        vVar.F0(z(), "invoices_payment_fragment");
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558428);
        this.t = false;
        J(true);
        setTitle(2131886422);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(2131362527);
        this.C = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(2131362166);
        this.B = recyclerView;
        recyclerView.setHasFixedSize(false);
        this.B.setNestedScrollingEnabled(false);
        this.B.setLayoutManager(new LinearLayoutManager(1, false));
        e eVar = new e(this, null);
        eVar.f3985f = this;
        this.B.setAdapter(eVar);
        this.z = new q() { // from class: c.c.b.h.a.g
            @Override // b.p.q
            public final void a(Object obj) {
                InvoicesActivity.this.I((c.c.b.k.c) obj);
            }
        };
        this.A = new q() { // from class: c.c.b.h.a.j
            @Override // b.p.q
            public final void a(Object obj) {
                InvoicesActivity invoicesActivity = InvoicesActivity.this;
                List<c.c.b.e.s> list = (List) obj;
                int i2 = InvoicesActivity.G;
                Objects.requireNonNull(invoicesActivity);
                if (list != null && (invoicesActivity.B.getAdapter() instanceof c.c.b.h.b.f.e)) {
                    ((c.c.b.h.b.f.e) invoicesActivity.B.getAdapter()).f3984e = list;
                    invoicesActivity.B.getAdapter().f405a.b();
                }
            }
        };
        d dVar = (d) new y(this).a(d.class);
        this.y = dVar;
        dVar.i();
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onPause() {
        super.onPause();
        d dVar = this.y;
        if (dVar != null) {
            dVar.f4170d.h(this.z);
            this.y.p().h(this.A);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onResume() {
        super.onResume();
        d dVar = this.y;
        if (dVar != null) {
            dVar.f4170d.e(this, this.z);
            this.y.p().e(this, this.A);
            this.y.q();
        }
    }

    @Override // c.c.b.d.c
    public void s(int i2, int i3, b bVar) {
    }

    @Override // c.c.b.h.a.a0, c.c.b.d.b
    public void t(c.c.b.b.a aVar, String str) {
        if (aVar == c.c.b.b.a.NEUTRAL) {
            e eVar = (e) this.B.getAdapter();
            eVar.f3986g = String.valueOf(9999.0d);
            eVar.d(0);
        } else if ("invoices_payment_fragment".equals(str) && c.c.b.b.a.EPAYMENT_CONFIRMATION.equals(aVar)) {
            d dVar = this.y;
            r rVar = this.D.s0;
            Objects.requireNonNull(dVar);
            c.c.b.f.a0 e2 = c.c.b.f.a0.e();
            Objects.requireNonNull(e2);
            new Thread(new c.c.b.f.t(e2, dVar, rVar)).start();
        }
        super.t(aVar, str);
    }
}