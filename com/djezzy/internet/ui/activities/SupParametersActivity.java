package com.djezzy.internet.ui.activities;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.n.a;
import b.p.q;
import b.p.y;
import c.c.b.b.b;
import c.c.b.d.c;
import c.c.b.e.c0;
import c.c.b.h.a.a0;
import c.c.b.j.d.g;
import com.djezzy.internet.ui.activities.SupParametersActivity;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\SupParametersActivity.smali */
public class SupParametersActivity extends a0 implements c {
    public static final /* synthetic */ int D = 0;
    public g A;
    public q<c.c.b.k.c> B;
    public q<List<c0>> C;
    public RecyclerView y;
    public c0 z;

    @Override // c.c.b.h.a.a0
    public String D() {
        return "parameters_activity";
    }

    @Override // c.c.b.h.a.a0
    public c.c.b.j.c E() {
        return this.A;
    }

    @Override // c.c.b.d.c
    public void k(Object obj, Object obj2) {
        this.z = null;
        if (obj2 instanceof c0) {
            c0 c0Var = (c0) obj2;
            this.z = c0Var;
            a.h0(this, this.A, c0Var);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558430);
        if (getIntent() == null || !getIntent().hasExtra("requested_category") || !getIntent().hasExtra("requested_type") || !getIntent().hasExtra("page_title")) {
            finish();
            return;
        }
        String stringExtra = getIntent().getStringExtra("requested_code");
        String stringExtra2 = getIntent().getStringExtra("requested_type");
        Objects.requireNonNull(stringExtra2);
        c0.b bVar = (c0.b) Enum.valueOf(c0.b.class, stringExtra2);
        String stringExtra3 = getIntent().getStringExtra("requested_category");
        Objects.requireNonNull(stringExtra3);
        c0.a aVar = (c0.a) Enum.valueOf(c0.a.class, stringExtra3);
        this.t = false;
        J(true);
        setTitle(getIntent().getStringExtra("page_title"));
        RecyclerView recyclerView = (RecyclerView) findViewById(2131362059);
        this.y = recyclerView;
        recyclerView.setHasFixedSize(false);
        this.y.setNestedScrollingEnabled(false);
        this.y.setLayoutManager(new GridLayoutManager(this, getIntent().getIntExtra("nb_columns", 1)));
        c.c.b.h.b.j.c cVar = new c.c.b.h.b.j.c(this, (List<c0>) null, aVar);
        cVar.f4013j = this;
        this.y.setAdapter(cVar);
        this.B = new q() { // from class: c.c.b.h.a.z
            @Override // b.p.q
            public final void a(Object obj) {
                SupParametersActivity.this.I((c.c.b.k.c) obj);
            }
        };
        this.C = new q() { // from class: c.c.b.h.a.v
            @Override // b.p.q
            public final void a(Object obj) {
                SupParametersActivity supParametersActivity = SupParametersActivity.this;
                List<c.c.b.e.c0> list = (List) obj;
                int i2 = SupParametersActivity.D;
                Objects.requireNonNull(supParametersActivity);
                if (list != null && (supParametersActivity.y.getAdapter() instanceof c.c.b.h.b.j.c)) {
                    ((c.c.b.h.b.j.c) supParametersActivity.y.getAdapter()).f4011h = list;
                    supParametersActivity.y.getAdapter().f405a.b();
                }
            }
        };
        g gVar = (g) new y(this).a(g.class);
        this.A = gVar;
        gVar.i();
        gVar.f4186i = bVar;
        gVar.f4185h = stringExtra;
        gVar.f4187j = aVar;
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onPause() {
        super.onPause();
        g gVar = this.A;
        if (gVar != null) {
            gVar.f4170d.h(this.B);
            this.A.o().h(this.C);
        }
    }

    @Override // b.n.c.e, android.app.Activity, b.h.c.a.b
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        a.h0(this, this.A, this.z);
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onResume() {
        super.onResume();
        g gVar = this.A;
        if (gVar != null) {
            gVar.f4170d.e(this, this.B);
            this.A.o().e(this, this.C);
        }
    }

    @Override // c.c.b.d.c
    public void s(int i2, int i3, b bVar) {
    }
}