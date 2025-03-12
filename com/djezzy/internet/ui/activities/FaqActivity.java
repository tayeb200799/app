package com.djezzy.internet.ui.activities;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import b.p.q;
import c.c.b.b.b;
import c.c.b.d.c;
import c.c.b.e.c0;
import c.c.b.f.y;
import c.c.b.h.a.a0;
import c.c.b.j.d.h;
import com.djezzy.internet.ui.activities.FaqActivity;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\FaqActivity.smali */
public class FaqActivity extends a0 implements TabLayout.d, c, SwipeRefreshLayout.h {
    public static final /* synthetic */ int G = 0;
    public RecyclerView A;
    public List<String> B;
    public boolean C = false;
    public h D;
    public q<String> E;
    public q<c.c.b.k.c> F;
    public TabLayout y;
    public SwipeRefreshLayout z;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\FaqActivity$a.smali */
    public class a extends RecyclerView.q {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinearLayoutManager f9695a;

        public a(LinearLayoutManager linearLayoutManager) {
            this.f9695a = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void b(RecyclerView recyclerView, int i2, int i3) {
            int y = this.f9695a.y();
            int I = this.f9695a.I();
            int i1 = this.f9695a.i1();
            FaqActivity faqActivity = FaqActivity.this;
            if (faqActivity.C) {
                return;
            }
            h hVar = faqActivity.D;
            if (hVar.f4189i || y + i1 < I || i1 < 0 || I < 20) {
                return;
            }
            hVar.f4189i = true;
            hVar.f4188h = hVar.p() + 1;
            h hVar2 = FaqActivity.this.D;
            hVar2.q(hVar2.o().d(), FaqActivity.this.D.p());
        }
    }

    @Override // c.c.b.h.a.a0
    public String D() {
        return "faq_activity";
    }

    @Override // c.c.b.h.a.a0
    public void I(c.c.b.k.c cVar) {
        if (c.c.b.k.c.starting.equals(cVar)) {
            this.D.f4189i = true;
            SwipeRefreshLayout swipeRefreshLayout = this.z;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(true);
                return;
            }
            return;
        }
        SwipeRefreshLayout swipeRefreshLayout2 = this.z;
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setRefreshing(false);
        }
        if (!c.c.b.k.c.success_get_questions.equals(cVar)) {
            if (c.c.b.k.c.warning_no_questions.equals(cVar)) {
                this.D.f4189i = false;
                this.C = true;
                return;
            } else if (c.c.b.k.c.error_get_questions.equals(cVar)) {
                this.D.f4189i = false;
                return;
            } else {
                super.I(cVar);
                return;
            }
        }
        h hVar = this.D;
        hVar.f4189i = false;
        Objects.requireNonNull(hVar);
        List<c0> list = y.d().f3861g;
        if (list == null) {
            return;
        }
        if (list.size() % 20 > 0) {
            this.C = true;
        }
        if (this.A.getAdapter() instanceof c.c.b.h.b.d.a) {
            if (this.D.p() == 1) {
                c.c.b.h.b.d.a aVar = (c.c.b.h.b.d.a) this.A.getAdapter();
                aVar.f3974g = -1;
                aVar.f3973f = list;
            } else {
                ((c.c.b.h.b.d.a) this.A.getAdapter()).f3973f.addAll(list);
            }
            this.A.getAdapter().f405a.b();
        }
    }

    public final void L(String str, int i2) {
        int i3;
        this.B.add(str);
        TabLayout.g h2 = this.y.h();
        Resources resources = getResources();
        switch (str) {
            case "line":
                i3 = 2131886316;
                break;
            case "internet":
                i3 = 2131886315;
                break;
            case "contact":
                i3 = 2131886318;
                break;
            case "service":
                i3 = 2131886319;
                break;
            default:
                i3 = 2131886317;
                break;
        }
        h2.d(resources.getString(i3));
        h2.b(i2);
        TabLayout tabLayout = this.y;
        tabLayout.a(h2, tabLayout.f9898d.isEmpty());
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.h
    public void h() {
        SwipeRefreshLayout swipeRefreshLayout = this.z;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(true);
        }
        h hVar = this.D;
        hVar.f4189i = false;
        this.C = false;
        hVar.f4188h = 1;
        hVar.q(hVar.o().d(), this.D.p());
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void i(TabLayout.g gVar) {
    }

    @Override // c.c.b.d.c
    public void k(Object obj, Object obj2) {
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    @SuppressLint({"ResourceType"})
    public void o(TabLayout.g gVar) {
        Drawable drawable = gVar.f9920b;
        if (drawable != null) {
            drawable.setTint(getResources().getColor(2131099703));
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558481);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(2131362527);
        this.z = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        TabLayout tabLayout = (TabLayout) findViewById(2131362383);
        this.y = tabLayout;
        if (!tabLayout.J.contains(this)) {
            tabLayout.J.add(this);
        }
        this.A = (RecyclerView) findViewById(2131362091);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1, false);
        this.A.setLayoutManager(linearLayoutManager);
        this.A.setHasFixedSize(true);
        this.A.h(new a(linearLayoutManager));
        c.c.b.h.b.d.a aVar = new c.c.b.h.b.d.a(this, null);
        aVar.f3972e = this;
        this.A.setAdapter(aVar);
        this.F = new q() { // from class: c.c.b.h.a.d
            @Override // b.p.q
            public final void a(Object obj) {
                FaqActivity.this.I((c.c.b.k.c) obj);
            }
        };
        this.E = new q() { // from class: c.c.b.h.a.h
            @Override // b.p.q
            public final void a(Object obj) {
                FaqActivity faqActivity = FaqActivity.this;
                String str = (String) obj;
                int i2 = FaqActivity.G;
                Objects.requireNonNull(faqActivity);
                if (str == null || "none".equals(str)) {
                    return;
                }
                c.c.b.j.d.h hVar = faqActivity.D;
                hVar.f4189i = false;
                faqActivity.C = false;
                hVar.f4188h = 1;
                hVar.q(str, hVar.p());
            }
        };
        h hVar = (h) new b.p.y(this).a(h.class);
        this.D = hVar;
        hVar.i();
        this.D.f4170d.e(this, this.F);
        this.D.o().e(this, this.E);
        this.B = new ArrayList();
        this.y.j();
        L("line", 2131230934);
        L("service", 2131230974);
        L("internet", 2131230927);
        L("contact", 2131230948);
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onDestroy() {
        h hVar = this.D;
        if (hVar != null) {
            hVar.f4170d.h(this.F);
            this.D.o().h(this.E);
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
        if (i2 < this.B.size() && (this.A.getAdapter() instanceof c.c.b.h.b.d.a)) {
            h hVar = this.D;
            hVar.f4190j.j(this.B.get(i2));
        }
        Drawable drawable = gVar.f9920b;
        if (drawable != null) {
            drawable.setTint(getResources().getColor(2131099711));
        }
    }

    @Override // c.c.b.d.c
    public void s(int i2, int i3, b bVar) {
        int i4;
        if (b.DETAIL.equals(bVar) && (this.A.getAdapter() instanceof c.c.b.h.b.d.a)) {
            c.c.b.h.b.d.a aVar = (c.c.b.h.b.d.a) this.A.getAdapter();
            Objects.requireNonNull(aVar);
            try {
                if (i3 == aVar.f3974g) {
                    i4 = -1;
                } else {
                    aVar.f405a.c(i3, 1, Boolean.TRUE);
                    i4 = i3;
                }
                aVar.e(aVar.f3974g, Boolean.FALSE);
                aVar.f3974g = i4;
            } catch (Exception unused) {
            }
            this.A.n0(i3);
        }
    }
}