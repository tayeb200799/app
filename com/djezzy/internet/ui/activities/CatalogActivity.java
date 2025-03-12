package com.djezzy.internet.ui.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.p.p;
import b.p.q;
import c.c.b.b.b;
import c.c.b.d.c;
import c.c.b.e.v;
import c.c.b.f.h;
import c.c.b.f.y;
import c.c.b.h.a.a0;
import c.c.b.h.b.h.a;
import c.c.b.j.d.e;
import com.djezzy.internet.ui.activities.CatalogActivity;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\CatalogActivity.smali */
public class CatalogActivity extends a0 implements TabLayout.d, c, SwipeRefreshLayout.h {
    public static final /* synthetic */ int F = 0;
    public SwipeRefreshLayout A;
    public e B;
    public q<c.c.b.k.c> C;
    public q<List<v>> D;
    public List<v.a> E;
    public TabLayout y;
    public RecyclerView z;

    @Override // c.c.b.h.a.a0
    public String D() {
        return "catalog_activity";
    }

    @Override // c.c.b.h.a.a0
    public void I(c.c.b.k.c cVar) {
        if (c.c.b.k.c.starting.equals(cVar)) {
            SwipeRefreshLayout swipeRefreshLayout = this.A;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(true);
                return;
            }
            return;
        }
        SwipeRefreshLayout swipeRefreshLayout2 = this.A;
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        super.I(cVar);
    }

    @SuppressLint({"InflateParams"})
    public final void L(v.a aVar) {
        this.E.add(aVar);
        TextView textView = (TextView) LayoutInflater.from(this).inflate(2131558534, (ViewGroup) null);
        TabLayout.g h2 = this.y.h();
        h2.f9924f = textView;
        h2.e();
        h2.d(v.a.h(this, aVar));
        TabLayout tabLayout = this.y;
        tabLayout.a(h2, tabLayout.f9898d.isEmpty());
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.h
    public void h() {
        SwipeRefreshLayout swipeRefreshLayout = this.A;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(true);
        }
        e eVar = this.B;
        Objects.requireNonNull(eVar);
        y d2 = y.d();
        v.a aVar = eVar.f4182h;
        Objects.requireNonNull(d2);
        new Thread(new h(d2, eVar, aVar)).start();
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void i(TabLayout.g gVar) {
    }

    @Override // c.c.b.d.c
    public void k(Object obj, Object obj2) {
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void o(TabLayout.g gVar) {
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558487);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(2131362527);
        this.A = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        TabLayout tabLayout = (TabLayout) findViewById(2131362383);
        this.y = tabLayout;
        if (!tabLayout.J.contains(this)) {
            tabLayout.J.add(this);
        }
        this.z = (RecyclerView) findViewById(2131362362);
        this.z.setLayoutManager(new LinearLayoutManager(1, false));
        this.z.setHasFixedSize(true);
        a aVar = new a(this, null);
        aVar.f3997f = this;
        this.z.setAdapter(aVar);
        this.C = new q() { // from class: c.c.b.h.a.y
            @Override // b.p.q
            public final void a(Object obj) {
                CatalogActivity.this.I((c.c.b.k.c) obj);
            }
        };
        this.D = new q() { // from class: c.c.b.h.a.f
            @Override // b.p.q
            public final void a(Object obj) {
                CatalogActivity catalogActivity = CatalogActivity.this;
                List<c.c.b.e.v> list = (List) obj;
                int i2 = CatalogActivity.F;
                Objects.requireNonNull(catalogActivity);
                if (list == null || !(catalogActivity.z.getAdapter() instanceof c.c.b.h.b.h.a)) {
                    return;
                }
                ((c.c.b.h.b.h.a) catalogActivity.z.getAdapter()).f3996e = list;
                catalogActivity.z.getAdapter().f405a.b();
            }
        };
        e eVar = (e) new b.p.y(this).a(e.class);
        this.B = eVar;
        eVar.i();
        e eVar2 = this.B;
        if (eVar2.f4183i == null) {
            eVar2.f4183i = new p<>();
        }
        eVar2.f4183i.e(this, this.D);
        this.B.f4170d.e(this, this.C);
        this.E = new ArrayList();
        this.y.j();
        L(v.a.mixed);
        L(v.a.family);
        L(v.a.data);
        L(v.a.postpaid);
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onDestroy() {
        e eVar = this.B;
        if (eVar != null) {
            eVar.f4170d.h(this.C);
            e eVar2 = this.B;
            if (eVar2.f4183i == null) {
                eVar2.f4183i = new p<>();
            }
            eVar2.f4183i.h(this.D);
        }
        TabLayout tabLayout = this.y;
        if (tabLayout != null) {
            tabLayout.J.remove(this);
        }
        super.onDestroy();
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void r(TabLayout.g gVar) {
        int i2 = gVar.f9923e;
        if (i2 >= this.E.size() || !(this.z.getAdapter() instanceof a)) {
            return;
        }
        e eVar = this.B;
        eVar.f4182h = this.E.get(i2);
        y d2 = y.d();
        v.a aVar = eVar.f4182h;
        Objects.requireNonNull(d2);
        new Thread(new h(d2, eVar, aVar)).start();
    }

    @Override // c.c.b.d.c
    public void s(int i2, int i3, b bVar) {
        if (b.DETAIL.equals(bVar)) {
            e eVar = this.B;
            boolean z = !eVar.f4183i.d().get(i2).b().get(i3).q;
            eVar.f4183i.d().get(i2).b().get(i3).q = z;
            if (this.z.getAdapter() instanceof a) {
                a aVar = (a) this.z.getAdapter();
                List<v> list = aVar.f3996e;
                int i4 = 0;
                int size = list != null ? list.size() : 0;
                int i5 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    if (i4 == i2) {
                        i5 += i3 + 1;
                        break;
                    } else {
                        i5 += aVar.f3996e.get(i4).b().size() + 1;
                        i4++;
                    }
                }
                this.z.getAdapter().e(i5, Boolean.valueOf(z));
                this.z.n0(i5);
            }
        }
    }
}