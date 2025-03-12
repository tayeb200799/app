package com.djezzy.internet.ui.activities.otp;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Parcel;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.p.p;
import b.p.q;
import b.p.y;
import c.c.a.d;
import c.c.b.e.b0;
import c.c.b.g.h.a;
import c.c.b.h.a.a0;
import c.c.b.j.d.f;
import c.c.b.k.c;
import c.d.a.c.e.j.k.l;
import c.d.a.c.e.j.k.n;
import c.d.a.c.m.e;
import c.d.a.c.m.e0;
import c.d.a.c.m.j;
import c.d.a.c.m.k;
import com.djezzy.internet.ui.activities.NavigationActivity;
import com.djezzy.internet.ui.activities.otp.CheckActivity;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\otp\CheckActivity.smali */
public class CheckActivity extends a0 implements TextView.OnEditorActionListener, View.OnClickListener, a.InterfaceC0087a {
    public static final /* synthetic */ int J = 0;
    public ProgressBar A;
    public c.c.b.g.h.a B;
    public EditText C;
    public final TextWatcher D = new a();
    public String E;
    public CountDownTimer F;
    public f G;
    public q<c> H;
    public q<b0> I;
    public Button y;
    public Button z;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\otp\CheckActivity$a.smali */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (i3 == i4) {
                return;
            }
            StringBuilder sb = new StringBuilder(CheckActivity.this.C.getText().toString().replaceAll(" ", ""));
            for (int i5 = 2; i5 < sb.length(); i5 += 3) {
                sb.insert(i5, " ");
            }
            CheckActivity.this.C.setText(sb);
            EditText editText = CheckActivity.this.C;
            editText.setSelection(editText.getText().length());
        }
    }

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\otp\CheckActivity$b.smali */
    public class b extends CountDownTimer {
        public b(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            CheckActivity.this.F.cancel();
            CheckActivity.this.z.setVisibility(0);
            ((TextView) CheckActivity.this.findViewById(2131361990)).setText("");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            DecimalFormat decimalFormat = new DecimalFormat("00");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            ((TextView) CheckActivity.this.findViewById(2131361990)).setText(String.format("%s:%s", decimalFormat.format(timeUnit.toMinutes(j2)), decimalFormat.format(timeUnit.toSeconds(j2))));
        }
    }

    @Override // c.c.b.h.a.a0
    public String D() {
        return "otp_activity";
    }

    @Override // c.c.b.h.a.a0
    public void I(c cVar) {
        if (cVar == c.starting || cVar == c.loading) {
            this.y.setEnabled(false);
            this.C.setEnabled(false);
            this.A.setVisibility(0);
            return;
        }
        this.y.setEnabled(true);
        this.C.setEnabled(true);
        this.A.setVisibility(4);
        if (cVar == c.success) {
            M("success", null, null);
            G(NavigationActivity.class, true);
        } else if (cVar == c.error_not_exist) {
            M("error", cVar.toString(), null);
            b.n.a.I0(z(), this, 2131886224, 2131886185, 2131230885, 2131886138);
        } else {
            if (cVar.toString().contains("error")) {
                M("error", cVar.toString(), null);
            }
            super.I(cVar);
        }
    }

    public final void L(String str) {
        F();
        final String replace = this.C.getText().toString().replace(" ", "");
        if (replace.length() != 6) {
            b.n.a.H0(z(), this, true, 2131886224, 2131886186, 2131230885, new String[0]);
            return;
        }
        if (!TextUtils.isDigitsOnly(replace)) {
            b.n.a.H0(z(), this, true, 2131886224, 2131886186, 2131230885, new String[0]);
            return;
        }
        M("send_request", null, str);
        final f fVar = this.G;
        final String str2 = this.E;
        Objects.requireNonNull(fVar);
        new Thread(new Runnable() { // from class: c.c.b.j.d.b
            @Override // java.lang.Runnable
            public final void run() {
                f fVar2 = f.this;
                String str3 = str2;
                String str4 = replace;
                Objects.requireNonNull(fVar2);
                try {
                    fVar2.l();
                    if (!c.c.b.k.g.f().b(str3, str4)) {
                        throw new Exception("Error: -1");
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("surprise-products");
                    arrayList.add("subscription-type-illegibility");
                    arrayList.add("connected-products");
                    arrayList.add("subscription-history");
                    arrayList.add("flash-products");
                    arrayList.add("supplementary-informations");
                    arrayList.add("available-services");
                    c.c.b.f.a0.e().g(arrayList, 30000, false, true, true, c.c.b.k.c.success, fVar2);
                } catch (c.c.b.c.a e2) {
                    e2.printStackTrace();
                    fVar2.f4170d.j(c.c.b.k.c.error_not_exist);
                } catch (UnknownHostException e3) {
                    e3.printStackTrace();
                    fVar2.f4170d.j(c.c.b.k.c.error_network);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    fVar2.f4170d.j(c.c.b.k.c.error_unknown);
                }
            }
        }).start();
    }

    public final void M(String str, String str2, String str3) {
        HashMap p = c.a.a.a.a.p("event", "login");
        if (str3 != null) {
            p.put("category", str3);
        }
        if (str2 == null) {
            d.a(this).d(str, p);
        } else {
            d.a(this).c(str, str2, p);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 2131361949) {
            L("manual");
            return;
        }
        if (view.getId() == 2131362441) {
            this.F.start();
            this.z.setVisibility(4);
            final f fVar = this.G;
            final String str = this.E;
            Objects.requireNonNull(fVar);
            new Thread(new Runnable() { // from class: c.c.b.j.d.a
                @Override // java.lang.Runnable
                public final void run() {
                    f fVar2 = f.this;
                    String str2 = str;
                    Objects.requireNonNull(fVar2);
                    try {
                        fVar2.f4170d.j(c.c.b.k.c.loading);
                        if (!c.c.b.k.g.f().l(str2)) {
                            throw new Exception("Error");
                        }
                        fVar2.a();
                    } catch (c.c.b.c.a e2) {
                        e = e2;
                        e.printStackTrace();
                        fVar2.f4170d.j(c.c.b.k.c.error_not_exist);
                    } catch (c.c.b.c.b e3) {
                        e = e3;
                        e.printStackTrace();
                        fVar2.f4170d.j(c.c.b.k.c.error_not_exist);
                    } catch (UnknownHostException e4) {
                        e4.printStackTrace();
                        fVar2.f4170d.j(c.c.b.k.c.error_network);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        fVar2.f4170d.j(c.c.b.k.c.error_unknown);
                    }
                }
            }).start();
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558429);
        if (getIntent() == null || !getIntent().hasExtra("mobileNumber")) {
            G(LoginActivity.class, true);
        } else {
            this.E = getIntent().getStringExtra("mobileNumber");
        }
        ((TextView) findViewById(2131362356)).setText(String.format(getString(2131886291), b.n.a.z(this.E)));
        this.A = (ProgressBar) findViewById(2131362428);
        this.y = (Button) findViewById(2131361949);
        this.z = (Button) findViewById(2131362441);
        this.C = (EditText) findViewById(2131362401);
        this.y.setOnClickListener(this);
        this.z.setOnClickListener(this);
        this.C.setOnEditorActionListener(this);
        final c.d.a.c.i.a.a aVar = new c.d.a.c.i.a.a(this);
        n.a aVar2 = new n.a();
        aVar2.f7430a = new l() { // from class: c.d.a.c.i.a.h
            /* JADX WARN: Multi-variable type inference failed */
            @Override // c.d.a.c.e.j.k.l
            public final void a(Object obj, Object obj2) {
                e eVar = (e) ((g) obj).u();
                i iVar = new i((j) obj2);
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(eVar.f7658b);
                int i2 = d.f7656a;
                obtain.writeStrongBinder(iVar);
                Parcel obtain2 = Parcel.obtain();
                try {
                    eVar.f7657a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain.recycle();
                    obtain2.recycle();
                }
            }
        };
        aVar2.f7432c = new c.d.a.c.e.c[]{c.d.a.c.i.a.b.f7653c};
        aVar2.f7433d = 1567;
        Object b2 = aVar.b(1, aVar2.a());
        c.c.b.h.a.f0.c cVar = new c.d.a.c.m.f() { // from class: c.c.b.h.a.f0.c
            @Override // c.d.a.c.m.f
            public final void c(Object obj) {
                int i2 = CheckActivity.J;
                Log.d("SMS", "Successfully started retriever");
            }
        };
        e0 e0Var = (e0) b2;
        Objects.requireNonNull(e0Var);
        Executor executor = k.f8356a;
        e0Var.d(executor, cVar);
        e0Var.b(executor, new e() { // from class: c.c.b.h.a.f0.b
            @Override // c.d.a.c.m.e
            public final void d(Exception exc) {
                int i2 = CheckActivity.J;
                Log.e("SMS", "Failed to start retriever");
            }
        });
        c.c.b.g.h.a aVar3 = new c.c.b.g.h.a();
        this.B = aVar3;
        aVar3.f3925a = this;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.google.android.gms.auth.api.phone.SMS_RETRIEVED");
        registerReceiver(this.B, intentFilter);
        this.H = new q() { // from class: c.c.b.h.a.f0.a
            @Override // b.p.q
            public final void a(Object obj) {
                CheckActivity.this.I((c.c.b.k.c) obj);
            }
        };
        this.I = new q() { // from class: c.c.b.h.a.f0.d
            @Override // b.p.q
            public final void a(Object obj) {
                CheckActivity checkActivity = CheckActivity.this;
                b0 b0Var = (b0) obj;
                int i2 = CheckActivity.J;
                String J2 = b.n.a.J(checkActivity);
                if (b0Var != null && "OffreJeune".equals(b0Var.f3527a)) {
                    b.n.a.C0(checkActivity, "night_mode", "izzy");
                } else if ("izzy".equals(J2)) {
                    b.n.a.C0(checkActivity, "night_mode", "normal");
                }
            }
        };
        f fVar = (f) new y(this).a(f.class);
        this.G = fVar;
        fVar.i();
        b bVar = new b(60000L, 1000L);
        this.F = bVar;
        bVar.start();
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.F;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.F = null;
        }
        unregisterReceiver(this.B);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        if (textView.getId() != 2131362401 || i2 != 6) {
            return false;
        }
        L("manual");
        return true;
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onPause() {
        super.onPause();
        f fVar = this.G;
        if (fVar != null) {
            fVar.f4170d.h(this.H);
            f fVar2 = this.G;
            if (fVar2.f4184h == null) {
                fVar2.f4184h = new p<>();
            }
            fVar2.f4184h.h(this.I);
        }
        EditText editText = this.C;
        if (editText != null) {
            editText.removeTextChangedListener(this.D);
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onResume() {
        super.onResume();
        f fVar = this.G;
        if (fVar != null) {
            fVar.f4170d.e(this, this.H);
            f fVar2 = this.G;
            if (fVar2.f4184h == null) {
                fVar2.f4184h = new p<>();
            }
            fVar2.f4184h.e(this, this.I);
        }
        EditText editText = this.C;
        if (editText != null) {
            editText.addTextChangedListener(this.D);
        }
    }

    @Override // c.c.b.h.a.a0, c.c.b.d.b
    public void t(c.c.b.b.a aVar, String str) {
        if (aVar == c.c.b.b.a.NEUTRAL && c.error_not_exist.equals(this.G.f4170d.d())) {
            this.C.setText("");
            showKeyboard(this.C);
        }
    }
}