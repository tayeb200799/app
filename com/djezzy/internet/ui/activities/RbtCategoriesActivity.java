package com.djezzy.internet.ui.activities;

import android.os.Bundle;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.p.p;
import b.p.q;
import b.p.y;
import c.c.a.d;
import c.c.b.b.b;
import c.c.b.d.c;
import c.c.b.d.f;
import c.c.b.e.h0.e;
import c.c.b.g.d.g;
import c.c.b.g.d.h;
import c.c.b.h.a.a0;
import c.c.b.h.d.t;
import c.c.b.j.d.m;
import c.d.a.b.o2.g0;
import c.d.a.b.x1;
import com.djezzy.internet.AppDelegate;
import com.djezzy.internet.ui.activities.RbtCategoriesActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\RbtCategoriesActivity.smali */
public class RbtCategoriesActivity extends a0 implements c, f, SwipeRefreshLayout.h, CompoundButton.OnCheckedChangeListener {
    public static final /* synthetic */ int J = 0;
    public q<String> A;
    public q<c.c.b.k.c> B;
    public q<List<e>> C;
    public RecyclerView D;
    public SwipeRefreshLayout E;
    public h F;
    public c.c.b.h.d.a0 G;
    public t H;
    public final RecyclerView.q I = new a();
    public q<c.c.b.e.t> y;
    public m z;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\RbtCategoriesActivity$a.smali */
    public class a extends RecyclerView.q {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void a(RecyclerView recyclerView, int i2) {
            RbtCategoriesActivity.this.E.setEnabled(i2 != 1);
        }
    }

    @Override // c.c.b.h.a.a0
    public String D() {
        return "rbt_categories_activity";
    }

    @Override // c.c.b.h.a.a0
    public c.c.b.j.c E() {
        return this.z;
    }

    @Override // c.c.b.h.a.a0
    public void I(c.c.b.k.c cVar) {
        if (cVar == c.c.b.k.c.loading || cVar == c.c.b.k.c.starting) {
            K(this.G, "loading_fragment", null);
            return;
        }
        c.c.b.h.d.a0 a0Var = this.G;
        if (a0Var != null && a0Var.S()) {
            this.G.G0();
        }
        SwipeRefreshLayout swipeRefreshLayout = this.E;
        if (swipeRefreshLayout != null && swipeRefreshLayout.f528f) {
            swipeRefreshLayout.setRefreshing(false);
        }
        if (c.c.b.k.c.success_download.equals(cVar)) {
            e p = this.z.p();
            if (p == null) {
                return;
            }
            M("download", p.f3607b, 2131886176);
            return;
        }
        if (c.c.b.k.c.success_delete.equals(cVar)) {
            e p2 = this.z.p();
            if (p2 == null) {
                return;
            }
            M("delete", p2.f3607b, 2131886171);
            return;
        }
        if (c.c.b.k.c.success_gift.equals(cVar)) {
            e p3 = this.z.p();
            if (p3 == null) {
                return;
            }
            M("gift", p3.f3607b, 2131886183);
            return;
        }
        if (c.c.b.k.c.success_activate.equals(cVar)) {
            M("activate", "", 2131886150);
            return;
        }
        if (c.c.b.k.c.success_deactivate.equals(cVar)) {
            M("deactivate", "", 2131886164);
            return;
        }
        if (c.c.b.k.c.error_not_exist.equals(cVar)) {
            L("activate", "", 2131886205, 2131886108, 2131230960);
            return;
        }
        if (c.c.b.k.c.error_unknown.equals(cVar)) {
            b.n.a.J0(z(), this, getString(2131886224), getString(2131886213), getString(2131886132), "error", 2131230963);
        } else if (c.c.b.k.c.error_not_allowed.equals(cVar)) {
            b.n.a.J0(z(), this, getString(2131886224), getString(2131886212), getString(2131886132), "error", 2131230963);
        } else {
            super.I(cVar);
        }
    }

    public final void L(String str, String str2, int i2, int i3, int i4) {
        d.a(this).c("rbt", str2, c.a.a.a.a.p("action", str));
        b.n.a.K0(z(), this, getString(2131886114), getString(i3), getString(2131886218), getString(i2), str, i4);
    }

    public final void M(String str, String str2, int i2) {
        d.a(this).c("success", str2, c.a.a.a.a.q("action", str, "event", "rbt"));
        b.n.a.J0(z(), this, getString(2131886218), getString(i2), getString(2131886132), "success", 2131230964);
    }

    @Override // c.c.b.d.f
    public void e(Object obj, long j2) {
        if (this.D.getAdapter() != null) {
            this.D.getAdapter().e(this.z.f4193h, new g(Long.valueOf(j2), "duration"));
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.h
    public void h() {
        SwipeRefreshLayout swipeRefreshLayout = this.E;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(true);
        }
        this.z.s(false);
    }

    @Override // c.c.b.d.c
    public void k(Object obj, Object obj2) {
    }

    @Override // c.c.b.d.f
    public void m(Object obj, String str) {
        if (this.D.getAdapter() != null) {
            this.D.getAdapter().e(this.z.f4193h, new g(str, "state"));
        }
    }

    @Override // c.c.b.d.f
    public void n(Object obj, long j2) {
        if (this.D.getAdapter() != null) {
            this.D.getAdapter().e(this.z.f4193h, new g(Long.valueOf(j2), "progress"));
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        m mVar = this.z;
        if (mVar == null || !mVar.o(z)) {
            return;
        }
        if (z) {
            L("activate", "", 2131886149, 2131886108, 2131230960);
        } else {
            L("deactivate", "", 2131886163, 2131886120, 2131230960);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558436);
        if (getIntent() == null) {
            finish();
            return;
        }
        String stringExtra = getIntent().getStringExtra("tone_index");
        int intExtra = getIntent().getIntExtra("category_index", 0);
        this.t = false;
        J(true);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(2131362527);
        this.E = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(2131362583);
        this.D = recyclerView;
        recyclerView.setHasFixedSize(false);
        this.D.setNestedScrollingEnabled(false);
        this.D.setLayoutManager(new LinearLayoutManager(1, false));
        c.c.b.h.b.l.g gVar = new c.c.b.h.b.l.g(this, null, 20002);
        gVar.f4040h = this;
        gVar.f4037e = intExtra;
        this.D.setAdapter(gVar);
        this.F = new h(this, this);
        this.y = new q() { // from class: c.c.b.h.a.p
            @Override // b.p.q
            public final void a(Object obj) {
                RbtCategoriesActivity rbtCategoriesActivity = RbtCategoriesActivity.this;
                c.c.b.e.t tVar = (c.c.b.e.t) obj;
                int i2 = RbtCategoriesActivity.J;
                if (tVar == null) {
                    rbtCategoriesActivity.setTitle(2131886500);
                } else {
                    rbtCategoriesActivity.setTitle(tVar.c(b.n.a.K(rbtCategoriesActivity)));
                }
            }
        };
        this.C = new q() { // from class: c.c.b.h.a.o
            @Override // b.p.q
            public final void a(Object obj) {
                RbtCategoriesActivity rbtCategoriesActivity = RbtCategoriesActivity.this;
                List<c.c.b.e.h0.e> list = (List) obj;
                int i2 = RbtCategoriesActivity.J;
                Objects.requireNonNull(rbtCategoriesActivity);
                if (list == null || !(rbtCategoriesActivity.D.getAdapter() instanceof c.c.b.h.b.l.g)) {
                    return;
                }
                ((c.c.b.h.b.l.g) rbtCategoriesActivity.D.getAdapter()).f4038f = list;
                rbtCategoriesActivity.D.getAdapter().f405a.b();
                int i3 = rbtCategoriesActivity.z.f4193h;
                if (i3 >= 0) {
                    rbtCategoriesActivity.D.n0(i3);
                }
            }
        };
        this.B = new q() { // from class: c.c.b.h.a.a
            @Override // b.p.q
            public final void a(Object obj) {
                RbtCategoriesActivity.this.I((c.c.b.k.c) obj);
            }
        };
        this.A = new q() { // from class: c.c.b.h.a.q
            @Override // b.p.q
            public final void a(Object obj) {
                String str = (String) obj;
                c.c.b.g.d.h hVar = RbtCategoriesActivity.this.F;
                if (hVar == null) {
                    return;
                }
                hVar.h(str);
            }
        };
        m mVar = (m) new y(this).a(m.class);
        this.z = mVar;
        mVar.i();
        mVar.f4193h = -1;
        mVar.k = stringExtra;
        mVar.f4194i = intExtra;
        this.z.q().e(this, this.y);
        m mVar2 = this.z;
        if (mVar2.o == null) {
            mVar2.o = new p<>();
            mVar2.r();
        }
        mVar2.o.e(this, this.C);
        this.z.f4170d.e(this, this.B);
        c.c.b.h.d.a0 a0Var = new c.c.b.h.d.a0();
        this.G = a0Var;
        a0Var.J0(0);
        this.G.K0(2131886370);
        this.G.l0 = this;
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m mVar = this.z;
        if (mVar != null) {
            mVar.q().h(this.y);
            m mVar2 = this.z;
            if (mVar2.o == null) {
                mVar2.o = new p<>();
                mVar2.r();
            }
            mVar2.o.h(this.C);
            this.z.f4170d.h(this.B);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onPause() {
        super.onPause();
        if (g0.f6900a < 24) {
            this.F.d();
        }
        m mVar = this.z;
        if (mVar != null) {
            if (mVar.n == null) {
                mVar.n = new p<>();
            }
            mVar.n.h(this.A);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onResume() {
        super.onResume();
        m mVar = this.z;
        if (mVar != null) {
            c.c.b.e.h0.c cVar = mVar.l;
            if ((cVar == null || cVar.f3602d) ? false : true) {
                mVar.s(false);
                SwipeRefreshLayout swipeRefreshLayout = this.E;
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(true);
                }
            }
        }
        if (g0.f6900a < 24) {
            this.F.a();
        }
        m mVar2 = this.z;
        if (mVar2 != null) {
            if (mVar2.n == null) {
                mVar2.n = new p<>();
            }
            mVar2.n.e(this, this.A);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onStart() {
        super.onStart();
        if (g0.f6900a >= 24) {
            this.F.a();
        }
        RecyclerView recyclerView = this.D;
        if (recyclerView != null) {
            recyclerView.h(this.I);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if ((r2.F.f3908i == null) != false) goto L9;
     */
    @Override // b.n.c.e, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onStop() {
        /*
            r2 = this;
            super.onStop()
            int r0 = c.d.a.b.o2.g0.f6900a
            r1 = 24
            if (r0 >= r1) goto L14
            c.c.b.g.d.h r0 = r2.F
            c.d.a.b.x1 r0 = r0.f3908i
            if (r0 != 0) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L19
        L14:
            c.c.b.g.d.h r0 = r2.F
            r0.d()
        L19:
            androidx.recyclerview.widget.RecyclerView r0 = r2.D
            if (r0 == 0) goto L22
            androidx.recyclerview.widget.RecyclerView$q r1 = r2.I
            r0.f0(r1)
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.djezzy.internet.ui.activities.RbtCategoriesActivity.onStop():void");
    }

    @Override // c.c.b.d.c
    public void s(int i2, int i3, b bVar) {
        e p;
        x1 x1Var;
        int i4 = this.z.f4193h;
        if (b.DETAIL.equals(bVar)) {
            if (i4 == i3 || this.D.getAdapter() == null) {
                return;
            }
            m mVar = this.z;
            mVar.f4193h = i3;
            c.c.b.e.h0.d dVar = c.c.b.f.y.d().f3859e;
            if (dVar != null && dVar.a(mVar.f4194i) != null) {
                String a2 = dVar.a(mVar.f4194i).a(i3);
                if (mVar.n == null) {
                    mVar.n = new p<>();
                }
                mVar.n.j(a2);
            }
            this.D.getAdapter().e(i4, new g(0, "duration"));
            this.D.getAdapter().e(i4, new g("stopped", "state"));
            this.D.getAdapter().e(i4, new g("collapse", "state"));
            h hVar = this.F;
            if (hVar != null && (x1Var = hVar.f3908i) != null) {
                x1Var.x(false);
            }
            this.D.getAdapter().f405a.c(i3, 1, new g("reset", "state"));
            this.D.n0(i3);
            return;
        }
        if (b.PLAY.equals(bVar)) {
            this.F.c();
            return;
        }
        if (b.DOWNLOAD.equals(bVar)) {
            e p2 = this.z.p();
            if (p2 == null) {
                return;
            }
            L("download", p2.f3606a, 2131886175, 2131886123, 2131230962);
            return;
        }
        if (b.DELETE.equals(bVar)) {
            e p3 = this.z.p();
            if (p3 == null) {
                return;
            }
            L("delete", p3.f3606a, 2131886170, 2131886122, 2131230961);
            return;
        }
        if (!b.GIFT.equals(bVar) || (p = this.z.p()) == null) {
            return;
        }
        d.a(this).c("rbt", p.f3607b, c.a.a.a.a.p("action", "gift"));
        t tVar = new t();
        this.H = tVar;
        tVar.l0 = this;
        tVar.o0 = "gift";
        tVar.L0(2131886277);
        this.H.F0(z(), "contact_fragment_dialog");
    }

    @Override // c.c.b.h.a.a0, c.c.b.d.b
    public void t(c.c.b.b.a aVar, String str) {
        c.c.b.b.a aVar2 = c.c.b.b.a.POSITIVE;
        if (this.z == null) {
            super.t(aVar, str);
        }
        if ("success".equals(str)) {
            SwipeRefreshLayout swipeRefreshLayout = this.E;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(true);
            }
            this.z.s(true);
            return;
        }
        String str2 = "send_request";
        if (!"download".equals(str) && !"delete".equals(str) && !"gift".equals(str)) {
            if (!"activate".equals(str) && !"deactivate".equals(str)) {
                super.t(aVar, str);
                return;
            }
            HashMap q = c.a.a.a.a.q("action", str, "event", "rbt");
            if (aVar2.equals(aVar)) {
                m mVar = this.z;
                boolean z = !"deactivate".equals(str);
                if (mVar.o(z)) {
                    c.c.b.f.y d2 = c.c.b.f.y.d();
                    c.c.b.k.c cVar = z ? c.c.b.k.c.success_activate : c.c.b.k.c.success_deactivate;
                    String str3 = z ? "POST" : "DELETE";
                    Objects.requireNonNull(d2);
                    new Thread(new c.c.b.f.g(mVar, str3, cVar)).start();
                }
            } else {
                str2 = "close_item";
            }
            d.a(this).c(str2, "", q);
            return;
        }
        HashMap q2 = c.a.a.a.a.q("action", str, "event", "rbt");
        e p = this.z.p();
        if (p == null || !aVar2.equals(aVar)) {
            str2 = "close_item";
        } else if ("download".equals(str)) {
            m mVar2 = this.z;
            Objects.requireNonNull(mVar2);
            c.c.b.f.y.d().g(p.f3606a, "POST", c.c.b.k.c.success_download, mVar2);
        } else if ("delete".equals(str)) {
            m mVar3 = this.z;
            Objects.requireNonNull(mVar3);
            c.c.b.f.y.d().g(p.f3606a, "DELETE", c.c.b.k.c.success_delete, mVar3);
        } else {
            t tVar = this.H;
            if (tVar != null) {
                m mVar4 = this.z;
                String J0 = tVar.J0();
                Objects.requireNonNull(mVar4);
                c.c.b.f.y.d().f(p.f3606a, (String) b.n.a.B(AppDelegate.f9647f.getApplicationContext(), "mobileNumber"), J0, null, false, c.c.b.k.c.success_gift, mVar4);
            }
        }
        d.a(this).c(str2, p != null ? p.f3607b : "", q2);
    }
}