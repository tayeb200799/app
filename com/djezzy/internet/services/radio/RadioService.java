package com.djezzy.internet.services.radio;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v4.media.session.MediaSessionCompat;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import b.h.c.j;
import c.c.b.d.h;
import c.c.b.h.e.c1;
import c.d.a.b.b1;
import c.d.a.b.g2.t;
import c.d.a.b.g2.y;
import c.d.a.b.j2.a;
import c.d.a.b.j2.f;
import c.d.a.b.k1;
import c.d.a.b.k2.a0;
import c.d.a.b.k2.f0;
import c.d.a.b.k2.o0;
import c.d.a.b.l1;
import c.d.a.b.m1;
import c.d.a.b.m2.l;
import c.d.a.b.n2.r;
import c.d.a.b.n2.u;
import c.d.a.b.n2.w;
import c.d.a.b.o2.d0;
import c.d.a.b.o2.g0;
import c.d.a.b.r0;
import c.d.a.b.t0;
import c.d.a.b.x1;
import c.d.a.b.z1;
import com.djezzy.internet.AppDelegate;
import com.djezzy.internet.services.radio.RadioService;
import com.djezzy.internet.services.radio.RadioService.c;
import com.djezzy.internet.ui.activities.SplashActivity;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\radio\RadioService.smali */
public class RadioService extends Service implements AudioManager.OnAudioFocusChangeListener {
    public static boolean q = false;
    public static boolean r = false;
    public static int s = -1;
    public static c.c.b.e.g0.a t;
    public static h u;
    public static boolean v;

    /* renamed from: d, reason: collision with root package name */
    public PowerManager.WakeLock f9685d;

    /* renamed from: e, reason: collision with root package name */
    public AudioManager f9686e;

    /* renamed from: f, reason: collision with root package name */
    public a0 f9687f;

    /* renamed from: g, reason: collision with root package name */
    public x1 f9688g;

    /* renamed from: h, reason: collision with root package name */
    public d f9689h;

    /* renamed from: i, reason: collision with root package name */
    public NotificationManager f9690i;

    /* renamed from: j, reason: collision with root package name */
    public MediaSessionCompat.Token f9691j;
    public PendingIntent k;
    public PendingIntent l;
    public Handler m;
    public TelephonyManager n;
    public PhoneStateListener o = new a();
    public Runnable p = new Runnable() { // from class: c.c.b.g.f.a
        @Override // java.lang.Runnable
        public final void run() {
            RadioService radioService = RadioService.this;
            Objects.requireNonNull(radioService);
            radioService.new c(null).execute(String.valueOf(RadioService.t.f3583a));
        }
    };

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\radio\RadioService$a.smali */
    public class a extends PhoneStateListener {
        public a() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i2, String str) {
            if (i2 != 2 && i2 != 1) {
                if (i2 == 0 && RadioService.v) {
                    RadioService.v = false;
                    RadioService.this.d("radio_pause_system");
                    AppDelegate.f9647f.a("radio_play_system", String.valueOf(RadioService.t.f3583a), RadioService.t.f3584b, "RADIO_CHANNEL");
                    return;
                }
                return;
            }
            RadioService radioService = RadioService.this;
            boolean z = RadioService.q;
            if (radioService.getApplicationContext().getSharedPreferences("isPlayingRadio", 0).getBoolean("isPlaying", false)) {
                RadioService.v = true;
                RadioService.this.g("radio_pause_system");
                AppDelegate.f9647f.a("radio_pause_system", String.valueOf(RadioService.t.f3583a), RadioService.t.f3584b, "RADIO_CHANNEL");
            }
        }
    }

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\radio\RadioService$b.smali */
    public class b implements f {
        public b(RadioService radioService) {
        }

        @Override // c.d.a.b.j2.f
        public void S(c.d.a.b.j2.a aVar) {
            if (aVar == null) {
                return;
            }
            int i2 = 0;
            while (true) {
                a.b[] bVarArr = aVar.f6012d;
                if (i2 >= bVarArr.length) {
                    return;
                }
                boolean z = bVarArr[i2] instanceof c.d.a.b.j2.l.c;
                i2++;
            }
        }
    }

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\radio\RadioService$c.smali */
    public class c extends AsyncTask<String, Void, c.c.b.e.g0.c> {
        public c(a aVar) {
        }

        @Override // android.os.AsyncTask
        public c.c.b.e.g0.c doInBackground(String[] strArr) {
            String b2 = new c.c.b.k.f().b("https://jow-platform-backend-qlf.tki.la/api/channels/" + strArr[0]);
            if (b2 != null) {
                return new c.c.b.e.g0.b().a(b2);
            }
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(c.c.b.e.g0.c cVar) {
            c.c.b.e.g0.c cVar2 = cVar;
            super.onPostExecute(cVar2);
            if (cVar2 == null) {
                RadioService radioService = RadioService.this;
                boolean z = RadioService.q;
                radioService.e(900000L);
                return;
            }
            c.c.b.e.g0.a aVar = RadioService.t;
            if (aVar.f3589g.f3595e == cVar2.f3595e) {
                RadioService.this.e(120000L);
                return;
            }
            aVar.f3589g = cVar2;
            RadioService.this.e(null);
            RadioService radioService2 = RadioService.this;
            radioService2.h(radioService2.getApplicationContext().getSharedPreferences("isPlayingRadio", 0).getBoolean("isPlaying", false) ? "pause" : "play");
            ((c1) RadioService.u).L0(this, "updated");
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }
    }

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\radio\RadioService$d.smali */
    public class d implements l1.c {
        public d(a aVar) {
        }

        @Override // c.d.a.b.l1.c
        public /* synthetic */ void C(z1 z1Var, int i2) {
            m1.n(this, z1Var, i2);
        }

        @Override // c.d.a.b.l1.c
        public /* synthetic */ void I(int i2) {
            m1.g(this, i2);
        }

        @Override // c.d.a.b.l1.c
        public /* synthetic */ void J(boolean z, int i2) {
            m1.e(this, z, i2);
        }

        @Override // c.d.a.b.l1.c
        public /* synthetic */ void L(o0 o0Var, l lVar) {
            m1.o(this, o0Var, lVar);
        }

        @Override // c.d.a.b.l1.c
        public /* synthetic */ void N(c.d.a.b.c1 c1Var) {
            m1.d(this, c1Var);
        }

        @Override // c.d.a.b.l1.c
        public /* synthetic */ void R(k1 k1Var) {
            m1.f(this, k1Var);
        }

        @Override // c.d.a.b.l1.c
        public /* synthetic */ void b() {
            m1.l(this);
        }

        @Override // c.d.a.b.l1.c
        public /* synthetic */ void c0(boolean z) {
            m1.b(this, z);
        }

        @Override // c.d.a.b.l1.c
        public /* synthetic */ void e(l1.e eVar, l1.e eVar2, int i2) {
            m1.k(this, eVar, eVar2, i2);
        }

        @Override // c.d.a.b.l1.c
        public /* synthetic */ void f(int i2) {
            m1.h(this, i2);
        }

        @Override // c.d.a.b.l1.c
        public void g(boolean z, int i2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    ((c1) RadioService.u).L0(this, "preparing");
                    return;
                } else if (i2 != 4) {
                    return;
                }
            }
            RadioService radioService = RadioService.this;
            boolean z2 = RadioService.q;
            radioService.g("radio_pause_background");
        }

        @Override // c.d.a.b.l1.c
        public /* synthetic */ void n(List list) {
            m1.m(this, list);
        }

        @Override // c.d.a.b.l1.c
        public void q(c.d.a.b.o0 o0Var) {
            int i2 = o0Var.f6847d;
            if (i2 == 0) {
                b.n.a.k(i2 == 0);
                Throwable th = o0Var.l;
                Objects.requireNonNull(th);
                IOException iOException = (IOException) th;
                if (iOException instanceof w.d) {
                    boolean z = ((w.d) iOException) instanceof w.f;
                }
            }
        }

        @Override // c.d.a.b.l1.c
        public /* synthetic */ void t(boolean z) {
            m1.a(this, z);
        }

        @Override // c.d.a.b.l1.c
        public /* synthetic */ void u(b1 b1Var, int i2) {
            m1.c(this, b1Var, i2);
        }
    }

    public final void a(String str) {
        this.k = PendingIntent.getService(getApplicationContext(), 0, new Intent(getApplicationContext(), (Class<?>) RadioService.class).setAction(str), 134217728);
        this.l = PendingIntent.getService(getApplicationContext(), 0, new Intent(getApplicationContext(), (Class<?>) RadioService.class).setAction("close"), 134217728);
    }

    public final String b(c.c.b.e.g0.c cVar) {
        return c.a.a.a.a.g(cVar.f3594d.substring(0, 5), " - ", cVar.f3595e.substring(0, 5));
    }

    public final PendingIntent c() {
        Intent intent = new Intent(getApplicationContext(), (Class<?>) SplashActivity.class);
        intent.putExtra("open_radio", true);
        return PendingIntent.getActivity(getApplicationContext(), 0, intent, 134217728);
    }

    public final void d(String str) {
        if (v) {
            return;
        }
        f(true);
        h("pause");
        x1 x1Var = this.f9688g;
        x1Var.B();
        r0 r0Var = x1Var.f7176e;
        if (!r0Var.w) {
            r0Var.w = true;
            t0 t0Var = r0Var.f7100h;
            synchronized (t0Var) {
                if (!t0Var.B && t0Var.k.isAlive()) {
                    d0 d0Var = (d0) t0Var.f7116j;
                    Objects.requireNonNull(d0Var);
                    d0.b d2 = d0.d();
                    d2.f6889a = d0Var.f6888a.obtainMessage(13, 1, 0);
                    d2.b();
                }
            }
        }
        this.f9688g.s(this.f9687f, true);
        this.f9688g.x(true);
        if (str == null) {
            AppDelegate.f9647f.a("radio_play_background", String.valueOf(t.f3583a), t.f3584b, "RADIO_CHANNEL");
        }
        ((c1) u).L0(this, "playing");
    }

    public final void e(Long l) {
        long longValue;
        this.m.removeCallbacks(this.p);
        if (l == null) {
            c.c.b.e.g0.c cVar = t.f3589g;
            if (cVar != null) {
                String str = cVar.f3595e;
                SimpleDateFormat simpleDateFormat = c.c.b.i.b.f4162a;
                long timeInMillis = Calendar.getInstance().getTimeInMillis();
                try {
                    SimpleDateFormat simpleDateFormat2 = c.c.b.i.b.f4162a;
                    longValue = c.c.b.i.b.f4162a.parse(str.substring(0, 5)).getTime() - simpleDateFormat2.parse(simpleDateFormat2.format(Long.valueOf(timeInMillis))).getTime();
                    if (longValue < 0) {
                        longValue += 86400000;
                    }
                } catch (ParseException e2) {
                    e2.printStackTrace();
                    longValue = -1;
                }
            } else {
                longValue = 900000;
            }
        } else {
            longValue = l.longValue();
        }
        if (longValue == -1) {
            longValue = 300000;
        }
        this.m.postDelayed(this.p, longValue);
    }

    public final void f(boolean z) {
        SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences("isPlayingRadio", 0).edit();
        edit.putBoolean("isPlaying", z);
        edit.apply();
    }

    public final void g(String str) {
        f(false);
        h("play");
        this.f9688g.x(false);
        this.f9688g.z(false);
        if (str == null) {
            AppDelegate.f9647f.a("radio_pause_background", String.valueOf(t.f3583a), t.f3584b, "RADIO_CHANNEL");
        }
    }

    public final void h(String str) {
        String str2;
        if (q) {
            return;
        }
        a(str);
        if (t.f3589g != null) {
            str2 = t.f3589g.f3591a + " " + b(t.f3589g);
        } else {
            str2 = "";
        }
        j jVar = new j(this, "radioChannel");
        jVar.i(16, false);
        jVar.i(2, true);
        jVar.w.icon = 2131689473;
        jVar.g(t.f3584b);
        jVar.f(str2);
        jVar.e(false);
        jVar.q = getApplicationContext().getResources().getColor(2131099705);
        jVar.a(str.equals("pause") ? 2131231058 : 2131231059, str.equals("pause") ? "Pause" : "Play", this.k);
        jVar.a(2131230850, "Close", this.l);
        b.s.d.b bVar = new b.s.d.b();
        bVar.f2188b = new int[]{0, 1};
        bVar.f2189c = this.f9691j;
        if (jVar.l != bVar) {
            jVar.l = bVar;
            bVar.k(jVar);
        }
        jVar.f1554g = c();
        this.f9690i.notify(1, jVar.b());
        h hVar = u;
        if (hVar != null) {
            ((c1) hVar).L0(this, str.equals("pause") ? "playing" : "paused");
        }
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i2) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f9686e = (AudioManager) getApplicationContext().getSystemService("audio");
        this.f9691j = new MediaSessionCompat(getApplicationContext(), "MEDIA_SESSION").f33a.a();
        this.f9689h = new d(null);
        q = true;
        r = false;
        this.m = new Handler();
        v = false;
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
        this.n = telephonyManager;
        telephonyManager.listen(this.o, 32);
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        stopForeground(true);
        stopSelf();
        x1 x1Var = this.f9688g;
        if (x1Var != null) {
            x1Var.u(this.f9689h);
            this.f9688g.t();
            this.f9688g = null;
        }
        PowerManager.WakeLock wakeLock = this.f9685d;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.f9685d.release();
            this.f9685d = null;
        }
        TelephonyManager telephonyManager = this.n;
        if (telephonyManager != null) {
            telephonyManager.listen(this.o, 0);
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        String str;
        y yVar;
        String action = intent.getAction();
        String stringExtra = intent.hasExtra("from") ? intent.getStringExtra("from") : null;
        if (action != null && action.equals("play")) {
            if (this.f9686e.requestAudioFocus(this, 3, 1) == 1) {
                if (q) {
                    x1.b bVar = new x1.b(getApplicationContext());
                    b.n.a.k(!bVar.q);
                    bVar.q = true;
                    x1 x1Var = new x1(bVar);
                    this.f9688g = x1Var;
                    d dVar = this.f9689h;
                    Objects.requireNonNull(dVar);
                    x1Var.f7176e.n(dVar);
                    x1 x1Var2 = this.f9688g;
                    b bVar2 = new b(this);
                    Objects.requireNonNull(x1Var2);
                    x1Var2.k.add(bVar2);
                }
                String str2 = t.f3587e;
                r rVar = new r(this, g0.u(getApplicationContext(), "exoPlayerSample"));
                c.d.a.b.k2.j jVar = new c.d.a.b.k2.j(new c.d.a.b.h2.f());
                t tVar = new t();
                u uVar = new u();
                Uri parse = Uri.parse(str2);
                b1.c cVar = new b1.c();
                cVar.f4598b = parse;
                b1 a2 = cVar.a();
                Objects.requireNonNull(a2.f4591b);
                b1.g gVar = a2.f4591b;
                Object obj = gVar.f4633h;
                b1.e eVar = gVar.f4628c;
                if (eVar == null || g0.f6900a < 18) {
                    yVar = y.f5172a;
                } else {
                    synchronized (tVar.f5155a) {
                        if (!g0.a(eVar, tVar.f5156b)) {
                            tVar.f5156b = eVar;
                            tVar.f5157c = tVar.a(eVar);
                        }
                        yVar = tVar.f5157c;
                        Objects.requireNonNull(yVar);
                    }
                }
                this.f9687f = new f0(a2, rVar, jVar, yVar, uVar, 1048576, null);
                e(null);
                PowerManager powerManager = (PowerManager) getSystemService("power");
                if (powerManager != null) {
                    PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, getClass().getSimpleName());
                    this.f9685d = newWakeLock;
                    newWakeLock.acquire();
                }
                d(stringExtra);
            }
        }
        if (action != null && action.equals("pause")) {
            g(stringExtra);
        }
        if (action != null && action.equals("close")) {
            if (getApplicationContext().getSharedPreferences("isPlayingRadio", 0).getBoolean("isPlaying", false)) {
                g(stringExtra);
            }
            AppDelegate.f9647f.a("radio_stop", String.valueOf(t.f3583a), t.f3584b, "RADIO_CHANNEL");
            onDestroy();
        }
        if (q) {
            AppDelegate.f9647f.a("radio_start", String.valueOf(t.f3583a), t.f3584b, "RADIO_CHANNEL");
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            this.f9690i = notificationManager;
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel("radioChannel", "RADIO_CHANNEL", 2));
            }
            a("pause");
            if (t.f3589g != null) {
                str = t.f3589g.f3591a + " " + b(t.f3589g);
            } else {
                str = "";
            }
            j jVar2 = new j(this, "radioChannel");
            jVar2.i(16, false);
            jVar2.i(2, true);
            jVar2.w.icon = 2131689473;
            jVar2.g(t.f3584b);
            jVar2.f(str);
            jVar2.e(false);
            jVar2.q = getApplicationContext().getResources().getColor(2131099705);
            jVar2.a(2131231058, "Pause", this.k);
            jVar2.a(2131230850, "Close", this.l);
            b.s.d.b bVar3 = new b.s.d.b();
            bVar3.f2188b = new int[]{0, 1};
            bVar3.f2189c = this.f9691j;
            if (jVar2.l != bVar3) {
                jVar2.l = bVar3;
                bVar3.k(jVar2);
            }
            jVar2.f1554g = c();
            startForeground(1, jVar2.b());
            q = false;
            r = true;
        }
        return 2;
    }
}