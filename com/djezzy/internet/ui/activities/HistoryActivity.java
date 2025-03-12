package com.djezzy.internet.ui.activities;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.h.d.a;
import b.p.q;
import b.p.y;
import b.t.b.l;
import c.c.b.b.b;
import c.c.b.d.c;
import c.c.b.e.u;
import c.c.b.e.v;
import c.c.b.h.a.a0;
import c.c.b.h.d.c0;
import c.c.b.j.d.i;
import com.djezzy.internet.ui.activities.HistoryActivity;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\HistoryActivity.smali */
public class HistoryActivity extends a0 implements c, SwipeRefreshLayout.h {
    public static final /* synthetic */ int D = 0;
    public q<c.c.b.k.c> A;
    public q<List<c.c.b.e.a0>> B;
    public SwipeRefreshLayout C;
    public RecyclerView y;
    public i z;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\HistoryActivity$a.smali */
    public class a extends l {
        public a(HistoryActivity historyActivity, Context context, int i2) {
            super(context, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            RecyclerView.a0 K = RecyclerView.K(view);
            int e2 = K != null ? K.e() : -1;
            if (recyclerView.getAdapter() != null && e2 == recyclerView.getAdapter().a() - 1) {
                rect.setEmpty();
                return;
            }
            Drawable drawable = this.f2265a;
            if (drawable == null) {
                rect.set(0, 0, 0, 0);
            } else if (this.f2266b == 1) {
                rect.set(0, 0, 0, drawable.getIntrinsicHeight());
            } else {
                rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
            }
        }
    }

    @Override // c.c.b.h.a.a0
    public String D() {
        return "history_activity";
    }

    @Override // c.c.b.h.a.a0
    public c.c.b.j.c E() {
        return this.z;
    }

    @Override // c.c.b.h.a.a0
    public void I(c.c.b.k.c cVar) {
        SwipeRefreshLayout swipeRefreshLayout;
        if (!c.c.b.k.c.starting.equals(cVar) && (swipeRefreshLayout = this.C) != null && swipeRefreshLayout.f528f) {
            swipeRefreshLayout.setRefreshing(false);
        }
        super.I(cVar);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.h
    public void h() {
        SwipeRefreshLayout swipeRefreshLayout = this.C;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(true);
        }
        this.z.n(v.a.none);
    }

    @Override // c.c.b.d.c
    public void k(Object obj, Object obj2) {
        u e2;
        if ((obj2 instanceof c.c.b.e.a0) && (e2 = c.c.b.f.a0.e().d().e(((c.c.b.e.a0) obj2).f3521b)) != null) {
            this.z.f4173g = e2;
            c0 c0Var = new c0();
            c0Var.l0 = this;
            c0Var.m0 = e2;
            c0Var.F0(z(), "offer_confirmation_fragment");
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558431);
        this.t = false;
        J(true);
        setTitle(2131886496);
        RecyclerView recyclerView = (RecyclerView) findViewById(2131362140);
        this.y = recyclerView;
        recyclerView.setHasFixedSize(false);
        this.y.setNestedScrollingEnabled(false);
        this.y.setLayoutManager(new LinearLayoutManager(1, false));
        c.c.b.h.b.e.a aVar = new c.c.b.h.b.e.a(this, null, -1);
        aVar.f3977f = this;
        this.y.setAdapter(aVar);
        a aVar2 = new a(this, this, 1);
        Object obj = b.h.d.a.f1567a;
        Drawable b2 = a.b.b(this, 2131230833);
        Objects.requireNonNull(b2);
        aVar2.f2265a = b2;
        this.y.g(aVar2);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(2131362527);
        this.C = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        this.A = new q() { // from class: c.c.b.h.a.w
            @Override // b.p.q
            public final void a(Object obj2) {
                HistoryActivity.this.I((c.c.b.k.c) obj2);
            }
        };
        this.B = new q() { // from class: c.c.b.h.a.i
            @Override // b.p.q
            public final void a(Object obj2) {
                HistoryActivity historyActivity = HistoryActivity.this;
                List<c.c.b.e.a0> list = (List) obj2;
                int i2 = HistoryActivity.D;
                Objects.requireNonNull(historyActivity);
                if (list != null && (historyActivity.y.getAdapter() instanceof c.c.b.h.b.e.a)) {
                    ((c.c.b.h.b.e.a) historyActivity.y.getAdapter()).f3978g = list;
                    historyActivity.y.getAdapter().f405a.b();
                }
            }
        };
        i iVar = (i) new y(this).a(i.class);
        this.z = iVar;
        iVar.i();
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onPause() {
        super.onPause();
        i iVar = this.z;
        if (iVar != null) {
            iVar.f4170d.h(this.A);
            this.z.o().h(this.B);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onResume() {
        super.onResume();
        i iVar = this.z;
        if (iVar != null) {
            iVar.o().e(this, this.B);
            this.z.f4170d.e(this, this.A);
        }
    }

    @Override // c.c.b.d.c
    public void s(int i2, int i3, b bVar) {
    }

    @Override // c.c.b.h.a.a0, c.c.b.d.b
    public void t(c.c.b.b.a aVar, String str) {
        if (!c.c.b.b.a.OFFER_SUCCESS.equals(aVar)) {
            super.t(aVar, str);
            return;
        }
        if (this.z != null) {
            SwipeRefreshLayout swipeRefreshLayout = this.C;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(true);
            }
            i iVar = this.z;
            u uVar = iVar.f4173g;
            iVar.n(uVar != null ? uVar.f3712f : v.a.none);
            this.z.f4173g = null;
        }
    }
}