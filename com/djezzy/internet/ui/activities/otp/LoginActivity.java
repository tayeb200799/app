package com.djezzy.internet.ui.activities.otp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import b.p.q;
import b.p.y;
import c.c.a.d;
import c.c.b.h.a.a0;
import c.c.b.i.b;
import c.c.b.j.d.j;
import c.c.b.k.c;
import com.djezzy.internet.ui.activities.otp.LoginActivity;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\otp\LoginActivity.smali */
public class LoginActivity extends a0 implements TextView.OnEditorActionListener, View.OnClickListener {
    public TextView A;
    public ProgressBar B;
    public String C;
    public CountDownTimer D;
    public j E;
    public q<c> F;
    public Button y;
    public TextView z;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\otp\LoginActivity$a.smali */
    public class a extends CountDownTimer {
        public a(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            LoginActivity.this.D.cancel();
            LoginActivity.this.y.setEnabled(true);
            LoginActivity.this.z.setEnabled(true);
            LoginActivity.this.A.setVisibility(4);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            DecimalFormat decimalFormat = new DecimalFormat("00");
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            LoginActivity.this.A.setText(String.format("%s:%s", decimalFormat.format(timeUnit.toMinutes(j2)), decimalFormat.format(timeUnit.toSeconds(j2))));
            if (LoginActivity.this.y.isEnabled()) {
                LoginActivity.this.y.setEnabled(false);
                LoginActivity.this.z.setEnabled(false);
                LoginActivity.this.A.setVisibility(0);
            }
        }
    }

    @Override // c.c.b.h.a.a0
    public String D() {
        return "login_activity";
    }

    @Override // c.c.b.h.a.a0
    public void I(c cVar) {
        if (cVar == c.starting) {
            this.y.setEnabled(false);
            this.z.setEnabled(false);
            this.B.setVisibility(0);
            return;
        }
        this.B.setVisibility(4);
        if (cVar == c.success) {
            M("success", null);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("mobileNumber", this.C);
            H(CheckActivity.class, true, hashMap);
            return;
        }
        this.y.setEnabled(true);
        this.z.setEnabled(true);
        if (cVar == c.error_not_exist) {
            M("error", cVar.toString());
            b.n.a.I0(z(), this, 2131886224, 2131886204, 2131230885, 2131886138);
            return;
        }
        if (cVar == c.error_unauthorized) {
            b.n.a.C0(this, "last_login_date", b.a(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
            N();
            M("error", cVar.toString());
            b.n.a.I0(z(), this, 2131886224, 2131886190, 2131230885, 2131886138);
            return;
        }
        if (cVar.toString().contains("error")) {
            M("error", cVar.toString());
        }
        if (c.error_unknown.equals(cVar)) {
            b.n.a.C0(this, "last_login_date", b.a(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
            N();
        }
        super.I(cVar);
    }

    public final void L() {
        if (!b.n.a.Z(this.z.getText().toString())) {
            Toast.makeText(this, 2131886198, 1).show();
            return;
        }
        M("send_request", null);
        final String format = String.format("2137%s", this.z.getText().toString().substring(this.z.getText().toString().length() - 8));
        this.C = format;
        final j jVar = this.E;
        Objects.requireNonNull(jVar);
        new Thread(new Runnable() { // from class: c.c.b.j.d.c
            @Override // java.lang.Runnable
            public final void run() {
                j jVar2 = j.this;
                String str = format;
                Objects.requireNonNull(jVar2);
                try {
                    jVar2.l();
                    if (!c.c.b.k.g.f().l(str)) {
                        throw new Exception("Error");
                    }
                    jVar2.f4170d.j(c.c.b.k.c.success);
                } catch (c.c.b.c.a e2) {
                    e = e2;
                    e.printStackTrace();
                    jVar2.f4170d.j(c.c.b.k.c.error_not_exist);
                } catch (c.c.b.c.b e3) {
                    e = e3;
                    e.printStackTrace();
                    jVar2.f4170d.j(c.c.b.k.c.error_not_exist);
                } catch (c.c.b.c.c e4) {
                    e4.printStackTrace();
                    jVar2.f4170d.j(e4.f3518d);
                } catch (UnknownHostException e5) {
                    e5.printStackTrace();
                    jVar2.f4170d.j(c.c.b.k.c.error_network);
                } catch (Exception e6) {
                    e6.printStackTrace();
                    jVar2.f4170d.j(c.c.b.k.c.error_unknown);
                }
            }
        }).start();
    }

    public final void M(String str, String str2) {
        HashMap p = c.a.a.a.a.p("event", "otp");
        if (str2 == null) {
            d.a(this).d(str, p);
        } else {
            d.a(this).c(str, str2, p);
        }
    }

    public final void N() {
        Object B = b.n.a.B(this, "last_login_date");
        Date c2 = (!(B instanceof String) || ((String) B).isEmpty()) ? null : b.c(String.valueOf(B), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", "GMT+1");
        if (c2 == null) {
            return;
        }
        long d2 = b.d(new Date(), c2);
        if (d2 <= 60000) {
            a aVar = new a(60000 - d2, 1000L);
            this.D = aVar;
            aVar.start();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == 2131362334) {
            L();
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558433);
        this.y = (Button) findViewById(2131362334);
        this.B = (ProgressBar) findViewById(2131362428);
        this.A = (TextView) findViewById(2131361990);
        TextView textView = (TextView) findViewById(2131362354);
        this.z = textView;
        textView.setOnEditorActionListener(this);
        this.y.setOnClickListener(this);
        this.F = new q() { // from class: c.c.b.h.a.f0.e
            @Override // b.p.q
            public final void a(Object obj) {
                LoginActivity.this.I((c.c.b.k.c) obj);
            }
        };
        j jVar = (j) new y(this).a(j.class);
        this.E = jVar;
        jVar.i();
        this.E.f4170d.e(this, this.F);
        N();
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        j jVar = this.E;
        if (jVar != null) {
            jVar.f4170d.h(this.F);
        }
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        if (textView.getId() != 2131362354 || i2 != 6) {
            return false;
        }
        F();
        L();
        return true;
    }

    @Override // c.c.b.h.a.a0, c.c.b.d.b
    public void t(c.c.b.b.a aVar, String str) {
        if (aVar == c.c.b.b.a.NEUTRAL && c.error_not_exist.equals(this.E.f4170d.d())) {
            this.z.setText("");
            showKeyboard(this.z);
        }
    }
}