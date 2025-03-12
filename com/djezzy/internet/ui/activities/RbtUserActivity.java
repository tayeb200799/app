package com.djezzy.internet.ui.activities;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.p.p;
import b.p.q;
import c.c.a.d;
import c.c.b.b.b;
import c.c.b.d.c;
import c.c.b.d.f;
import c.c.b.e.h0.e;
import c.c.b.f.y;
import c.c.b.g.d.g;
import c.c.b.g.d.h;
import c.c.b.h.a.a0;
import c.c.b.h.d.t;
import c.c.b.j.d.n;
import c.d.a.b.o2.g0;
import c.d.a.b.x1;
import com.djezzy.internet.AppDelegate;
import com.djezzy.internet.ui.activities.RbtUserActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\RbtUserActivity.smali */
public class RbtUserActivity extends a0 implements c, f, SwipeRefreshLayout.h {
    public q<String> A;
    public q<c.c.b.e.h0.f> B;
    public q<c.c.b.k.c> C;
    public q<List<c.c.b.e.h0.c>> D;
    public RecyclerView E;
    public SwipeRefreshLayout F;
    public h G;
    public c.c.b.h.d.a0 H;
    public t I;
    public final RecyclerView.q J = new a();
    public String y;
    public n z;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\RbtUserActivity$a.smali */
    public class a extends RecyclerView.q {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void a(RecyclerView recyclerView, int i2) {
            RbtUserActivity.this.F.setEnabled(i2 != 1);
        }
    }

    @Override // c.c.b.h.a.a0
    public String D() {
        return "rbt_user_activity";
    }

    @Override // c.c.b.h.a.a0
    public c.c.b.j.c E() {
        return this.z;
    }

    @Override // c.c.b.h.a.a0
    public void I(c.c.b.k.c cVar) {
        if (cVar == c.c.b.k.c.loading || cVar == c.c.b.k.c.starting) {
            K(this.H, "loading_fragment", null);
            return;
        }
        c.c.b.h.d.a0 a0Var = this.H;
        if (a0Var != null && a0Var.S()) {
            this.H.G0();
        }
        SwipeRefreshLayout swipeRefreshLayout = this.F;
        if (swipeRefreshLayout != null && swipeRefreshLayout.f528f) {
            swipeRefreshLayout.setRefreshing(false);
        }
        if (c.c.b.k.c.success_download.equals(cVar)) {
            e q = this.z.q();
            if (q == null) {
                return;
            }
            M("download", "success", q.f3607b, 2131886176);
            return;
        }
        if (c.c.b.k.c.success_delete.equals(cVar)) {
            e q2 = this.z.q();
            if (q2 == null) {
                return;
            }
            M("delete", "delete_success_tone", q2.f3607b, 2131886171);
            return;
        }
        if (c.c.b.k.c.success_gift.equals(cVar)) {
            e q3 = this.z.q();
            if (q3 == null) {
                return;
            }
            M("gift", "success", q3.f3607b, 2131886183);
            return;
        }
        if (c.c.b.k.c.success_accept_gift.equals(cVar)) {
            e q4 = this.z.q();
            if (q4 == null) {
                return;
            }
            M("accept", "success", q4.f3607b, 2131886176);
            return;
        }
        if (c.c.b.k.c.success_decline_gift.equals(cVar)) {
            e q5 = this.z.q();
            if (q5 == null) {
                return;
            }
            M("decline", "success", q5.f3607b, 2131886171);
            return;
        }
        if (c.c.b.k.c.success_activate.equals(cVar)) {
            M("activate", "success", "", 2131886150);
            return;
        }
        if (c.c.b.k.c.success_deactivate.equals(cVar)) {
            M("deactivate", "success", "", 2131886164);
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

    public final void M(String str, String str2, String str3, int i2) {
        d.a(this).c("success", str3, c.a.a.a.a.q("action", str, "event", "rbt"));
        b.n.a.J0(z(), this, getString(2131886218), getString(i2), getString(2131886132), str2, 2131230964);
    }

    @Override // c.c.b.d.f
    public void e(Object obj, long j2) {
        if (this.E.getAdapter() != null) {
            this.E.getAdapter().e(this.z.f4198j, new g(Long.valueOf(j2), "duration"));
        }
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.h
    public void h() {
        SwipeRefreshLayout swipeRefreshLayout = this.F;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(true);
        }
        n nVar = this.z;
        Objects.requireNonNull(nVar);
        y.d().e(nVar);
    }

    @Override // c.c.b.d.c
    public void k(Object obj, Object obj2) {
    }

    @Override // c.c.b.d.f
    public void m(Object obj, String str) {
        if (this.E.getAdapter() != null) {
            this.E.getAdapter().e(this.z.f4198j, new g(str, "state"));
        }
    }

    @Override // c.c.b.d.f
    public void n(Object obj, long j2) {
        if (this.E.getAdapter() != null) {
            this.E.getAdapter().e(this.z.f4198j, new g(Long.valueOf(j2), "progress"));
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
        this.y = getIntent().getStringExtra("tone_index");
        this.t = false;
        J(true);
        setTitle(2131886420);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(2131362527);
        this.F = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(2131362583);
        this.E = recyclerView;
        recyclerView.setHasFixedSize(false);
        this.E.setNestedScrollingEnabled(false);
        this.E.setLayoutManager(new LinearLayoutManager(1, false));
        c.c.b.h.b.l.c cVar = new c.c.b.h.b.l.c(this, null);
        cVar.f4035g = this;
        this.E.setAdapter(cVar);
        this.G = new h(this, this);
        this.B = new q() { // from class: c.c.b.h.a.t
            @Override // b.p.q
            public final void a(Object obj) {
                RbtUserActivity rbtUserActivity = RbtUserActivity.this;
                c.c.b.e.h0.f fVar = (c.c.b.e.h0.f) obj;
                RecyclerView recyclerView2 = rbtUserActivity.E;
                if (recyclerView2 == null || !(recyclerView2.getAdapter() instanceof c.c.b.h.b.l.c)) {
                    return;
                }
                ((c.c.b.h.b.l.c) rbtUserActivity.E.getAdapter()).f4032d = fVar;
                rbtUserActivity.E.getAdapter().d(0);
            }
        };
        this.C = new q() { // from class: c.c.b.h.a.k
            @Override // b.p.q
            public final void a(Object obj) {
                RbtUserActivity.this.I((c.c.b.k.c) obj);
            }
        };
        this.A = new q() { // from class: c.c.b.h.a.r
            @Override // b.p.q
            public final void a(Object obj) {
                String str = (String) obj;
                c.c.b.g.d.h hVar = RbtUserActivity.this.G;
                if (hVar == null) {
                    return;
                }
                hVar.h(str);
            }
        };
        this.D = new q() { // from class: c.c.b.h.a.s
            @Override // b.p.q
            public final void a(Object obj) {
                String str;
                RbtUserActivity rbtUserActivity = RbtUserActivity.this;
                List<c.c.b.e.h0.c> list = (List) obj;
                RecyclerView recyclerView2 = rbtUserActivity.E;
                if (recyclerView2 == null || !(recyclerView2.getAdapter() instanceof c.c.b.h.b.l.c)) {
                    return;
                }
                ((c.c.b.h.b.l.c) rbtUserActivity.E.getAdapter()).f4033e = list;
                rbtUserActivity.E.getAdapter().f405a.b();
                if (rbtUserActivity.z.f4198j < 0 && (str = rbtUserActivity.y) != null && !str.isEmpty()) {
                    c.c.b.j.d.n nVar = rbtUserActivity.z;
                    c.c.b.h.b.l.c cVar2 = (c.c.b.h.b.l.c) rbtUserActivity.E.getAdapter();
                    String str2 = rbtUserActivity.y;
                    List<c.c.b.e.h0.c> list2 = cVar2.f4033e;
                    int size = list2 != null ? list2.size() : 0;
                    int i2 = 0;
                    int i3 = 0;
                    loop0: while (true) {
                        if (i2 >= size) {
                            i3 = -1;
                            break;
                        }
                        i3++;
                        List<c.c.b.e.h0.e> d2 = cVar2.f4033e.get(i2).d();
                        int size2 = d2 != null ? d2.size() : 0;
                        for (int i4 = 0; i4 < size2; i4++) {
                            i3++;
                            if (d2.get(i4).f3606a.equals(str2)) {
                                break loop0;
                            }
                        }
                        i2++;
                    }
                    nVar.f4198j = i3;
                }
                int i5 = rbtUserActivity.z.f4198j;
                if (i5 >= 0) {
                    rbtUserActivity.E.n0(i5);
                }
            }
        };
        n nVar = (n) new b.p.y(this).a(n.class);
        this.z = nVar;
        String str = this.y;
        nVar.i();
        nVar.f4196h = -1;
        nVar.f4197i = -1;
        nVar.f4198j = -1;
        nVar.k = str;
        this.z.f4170d.e(this, this.C);
        this.z.r().e(this, this.B);
        n nVar2 = this.z;
        if (nVar2.n == null) {
            nVar2.n = new p<>();
            nVar2.s();
        }
        nVar2.n.e(this, this.D);
        c.c.b.h.d.a0 a0Var = new c.c.b.h.d.a0();
        this.H = a0Var;
        a0Var.J0(0);
        this.H.K0(2131886370);
        this.H.l0 = this;
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        n nVar = this.z;
        if (nVar != null) {
            nVar.f4170d.h(this.C);
            this.z.r().h(this.B);
            n nVar2 = this.z;
            if (nVar2.n == null) {
                nVar2.n = new p<>();
                nVar2.s();
            }
            nVar2.n.h(this.D);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onPause() {
        super.onPause();
        if (g0.f6900a < 24) {
            this.G.d();
        }
        n nVar = this.z;
        if (nVar != null) {
            if (nVar.l == null) {
                nVar.l = new p<>();
            }
            nVar.l.h(this.A);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (g0.f6900a < 24) {
            this.G.a();
        }
        n nVar = this.z;
        if (nVar != null) {
            if (nVar.l == null) {
                nVar.l = new p<>();
            }
            nVar.l.e(this, this.A);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onStart() {
        super.onStart();
        if (g0.f6900a >= 24) {
            this.G.a();
        }
        RecyclerView recyclerView = this.E;
        if (recyclerView != null) {
            recyclerView.h(this.J);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if ((r2.G.f3908i == null) != false) goto L9;
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
            c.c.b.g.d.h r0 = r2.G
            c.d.a.b.x1 r0 = r0.f3908i
            if (r0 != 0) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L19
        L14:
            c.c.b.g.d.h r0 = r2.G
            r0.d()
        L19:
            androidx.recyclerview.widget.RecyclerView r0 = r2.E
            if (r0 == 0) goto L22
            androidx.recyclerview.widget.RecyclerView$q r1 = r2.J
            r0.f0(r1)
        L22:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.djezzy.internet.ui.activities.RbtUserActivity.onStop():void");
    }

    @Override // c.c.b.d.c
    public void s(int i2, int i3, b bVar) {
        x1 x1Var;
        if (this.E.getAdapter() instanceof c.c.b.h.b.l.c) {
            int j2 = ((c.c.b.h.b.l.c) this.E.getAdapter()).j(i3);
            int i4 = this.z.f4198j;
            if (b.DETAIL.equals(bVar)) {
                if (i4 != i3) {
                    this.z.p(i2, j2, i3);
                    this.E.getAdapter().e(i4, new g(0, "duration"));
                    this.E.getAdapter().e(i4, new g("stopped", "state"));
                    this.E.getAdapter().e(i4, new g("collapse", "state"));
                    h hVar = this.G;
                    if (hVar != null && (x1Var = hVar.f3908i) != null) {
                        x1Var.x(false);
                    }
                    this.E.getAdapter().f405a.c(i3, 1, new g("reset", "state"));
                    this.E.n0(i3);
                    return;
                }
                return;
            }
            if (b.PLAY.equals(bVar)) {
                this.G.c();
                return;
            }
            if (b.DOWNLOAD.equals(bVar)) {
                e q = this.z.q();
                if (q == null) {
                    return;
                }
                L("download", q.f3606a, 2131886175, 2131886123, 2131230962);
                return;
            }
            if (b.DELETE.equals(bVar)) {
                e q2 = this.z.q();
                if (q2 == null) {
                    return;
                }
                L("delete", q2.f3606a, 2131886170, 2131886122, 2131230961);
                return;
            }
            if (b.GIFT.equals(bVar)) {
                e q3 = this.z.q();
                if (q3 == null) {
                    return;
                }
                d.a(this).c("rbt", q3.f3607b, c.a.a.a.a.p("action", "gift"));
                t tVar = new t();
                this.I = tVar;
                tVar.l0 = this;
                tVar.o0 = "gift";
                tVar.L0(2131886277);
                this.I.F0(z(), "contact_fragment_dialog");
                return;
            }
            if (b.DECLINE.equals(bVar)) {
                e q4 = this.z.q();
                if (q4 == null) {
                    return;
                }
                L("decline", q4.f3606a, 2131886167, 2131886121, 2131230961);
                return;
            }
            if (b.VALIDATE.equals(bVar)) {
                e q5 = this.z.q();
                if (q5 == null) {
                    return;
                }
                L("accept", q5.f3606a, 2131886147, 2131886107, 2131230962);
                return;
            }
            if (b.ACTIVATE.equals(bVar)) {
                if (this.z.o(true)) {
                    L("activate", "", 2131886149, 2131886108, 2131230960);
                }
            } else if (b.DEACTIVATE.equals(bVar) && this.z.o(false)) {
                L("deactivate", "", 2131886163, 2131886120, 2131230960);
            }
        }
    }

    @Override // c.c.b.h.a.a0, c.c.b.d.b
    public void t(c.c.b.b.a aVar, String str) {
        c.c.b.b.a aVar2 = c.c.b.b.a.POSITIVE;
        if (this.z == null) {
            super.t(aVar, str);
        }
        if ("success".equals(str) || "delete_success_tone".equals(str)) {
            if ("delete_success_tone".equals(str)) {
                this.z.p(-1, -1, -1);
            }
            SwipeRefreshLayout swipeRefreshLayout = this.F;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(true);
            }
            n nVar = this.z;
            Objects.requireNonNull(nVar);
            y.d().e(nVar);
            return;
        }
        String str2 = "send_request";
        if (!"download".equals(str) && !"delete".equals(str) && !"gift".equals(str) && !"decline".equals(str) && !"accept".equals(str)) {
            if (!"activate".equals(str) && !"deactivate".equals(str)) {
                super.t(aVar, str);
                return;
            }
            HashMap q = c.a.a.a.a.q("action", str, "event", "rbt");
            if (aVar2.equals(aVar)) {
                n nVar2 = this.z;
                boolean z = !"deactivate".equals(str);
                if (nVar2.o(z)) {
                    y d2 = y.d();
                    c.c.b.k.c cVar = z ? c.c.b.k.c.success_activate : c.c.b.k.c.success_deactivate;
                    String str3 = z ? "POST" : "DELETE";
                    Objects.requireNonNull(d2);
                    new Thread(new c.c.b.f.g(nVar2, str3, cVar)).start();
                }
            } else {
                if (this.E.getAdapter() != null) {
                    this.E.getAdapter().d(0);
                }
                str2 = "close_item";
            }
            d.a(this).d(str2, q);
            return;
        }
        HashMap q2 = c.a.a.a.a.q("action", str, "event", "rbt");
        e q3 = this.z.q();
        if (q3 == null || !aVar2.equals(aVar)) {
            str2 = "close_item";
        } else if ("download".equals(str)) {
            n nVar3 = this.z;
            Objects.requireNonNull(nVar3);
            y.d().g(q3.f3606a, "POST", c.c.b.k.c.success_download, nVar3);
        } else if ("delete".equals(str)) {
            n nVar4 = this.z;
            Objects.requireNonNull(nVar4);
            y.d().g(q3.f3606a, "DELETE", c.c.b.k.c.success_delete, nVar4);
        } else if ("decline".equals(str)) {
            n nVar5 = this.z;
            Objects.requireNonNull(nVar5);
            y.d().f(q3.f3606a, q3.m, q3.n, q3.p, false, c.c.b.k.c.success_decline_gift, nVar5);
        } else if ("accept".equals(str)) {
            n nVar6 = this.z;
            Objects.requireNonNull(nVar6);
            y.d().f(q3.f3606a, q3.m, q3.n, q3.p, true, c.c.b.k.c.success_accept_gift, nVar6);
        } else {
            t tVar = this.I;
            if (tVar != null) {
                n nVar7 = this.z;
                String J0 = tVar.J0();
                Objects.requireNonNull(nVar7);
                y.d().f(q3.f3606a, (String) b.n.a.B(AppDelegate.f9647f.getApplicationContext(), "mobileNumber"), J0, null, false, c.c.b.k.c.success_gift, nVar7);
            }
        }
        d.a(this).c(str2, q3 != null ? q3.f3607b : "", q2);
    }
}