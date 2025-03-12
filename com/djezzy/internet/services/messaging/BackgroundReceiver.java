package com.djezzy.internet.services.messaging;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import b.h.c.h;
import b.h.c.i;
import b.h.c.j;
import b.h.c.k;
import c.b.a.s.j.c;
import c.b.a.u.e;
import c.c.b.e.n;
import c.c.b.e.p;
import c.c.b.e.t;
import c.c.b.e.u;
import c.c.b.e.v;
import c.c.b.e.z;
import com.djezzy.internet.ui.activities.SplashActivity;
import java.text.DecimalFormat;
import java.util.Objects;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\messaging\BackgroundReceiver.smali */
public class BackgroundReceiver extends BroadcastReceiver {

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\messaging\BackgroundReceiver$a.smali */
    public class a extends c<Bitmap> {

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Context f9676g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ c.c.b.g.e.b f9677h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f9678i;

        public a(Context context, c.c.b.g.e.b bVar, String str) {
            this.f9676g = context;
            this.f9677h = bVar;
            this.f9678i = str;
        }

        @Override // c.b.a.s.j.h
        public void c(Object obj, c.b.a.s.k.b bVar) {
            BackgroundReceiver.a(BackgroundReceiver.this, this.f9676g, this.f9677h, this.f9678i, (Bitmap) obj);
        }

        @Override // c.b.a.s.j.c, c.b.a.s.j.h
        public void d(Drawable drawable) {
            BackgroundReceiver.a(BackgroundReceiver.this, this.f9676g, this.f9677h, this.f9678i, null);
        }

        @Override // c.b.a.s.j.h
        public void g(Drawable drawable) {
        }
    }

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\messaging\BackgroundReceiver$b.smali */
    public class b extends c<Bitmap> {

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Context f9680g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ c.c.b.g.e.b f9681h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f9682i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f9683j;
        public final /* synthetic */ int k;
        public final /* synthetic */ String l;
        public final /* synthetic */ int m;

        public b(Context context, c.c.b.g.e.b bVar, String str, String str2, int i2, String str3, int i3) {
            this.f9680g = context;
            this.f9681h = bVar;
            this.f9682i = str;
            this.f9683j = str2;
            this.k = i2;
            this.l = str3;
            this.m = i3;
        }

        @Override // c.b.a.s.j.h
        public void c(Object obj, c.b.a.s.k.b bVar) {
            BackgroundReceiver.b(BackgroundReceiver.this, this.f9680g, this.f9681h, this.f9682i, this.f9683j, this.k, this.l, this.m, (Bitmap) obj);
        }

        @Override // c.b.a.s.j.c, c.b.a.s.j.h
        public void d(Drawable drawable) {
            BackgroundReceiver.b(BackgroundReceiver.this, this.f9680g, this.f9681h, this.f9682i, this.f9683j, this.k, this.l, this.m, null);
        }

        @Override // c.b.a.s.j.h
        public void g(Drawable drawable) {
        }
    }

    public static void a(BackgroundReceiver backgroundReceiver, Context context, c.c.b.g.e.b bVar, String str, Bitmap bitmap) {
        Objects.requireNonNull(backgroundReceiver);
        String K = b.n.a.K(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        j h2 = backgroundReceiver.h(context, K, notificationManager, bVar, str);
        if (notificationManager == null || h2 == null) {
            return;
        }
        if (bitmap != null) {
            h hVar = new h();
            hVar.f1544b = bitmap;
            if (h2.l != hVar) {
                h2.l = hVar;
                hVar.k(h2);
            }
        } else {
            i iVar = new i();
            iVar.l(bVar.c().c(K));
            if (h2.l != iVar) {
                h2.l = iVar;
                iVar.k(h2);
            }
        }
        notificationManager.notify(bVar.f3911a, h2.b());
    }

    public static void b(BackgroundReceiver backgroundReceiver, Context context, c.c.b.g.e.b bVar, String str, String str2, int i2, String str3, int i3, Bitmap bitmap) {
        Objects.requireNonNull(backgroundReceiver);
        String K = b.n.a.K(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        j h2 = backgroundReceiver.h(context, K, notificationManager, bVar, str);
        if (notificationManager == null || h2 == null) {
            return;
        }
        PendingIntent g2 = backgroundReceiver.g(context, bVar, str3);
        h2.a(0, context.getString(i2), backgroundReceiver.g(context, bVar, str2));
        h2.a(0, context.getString(i3), g2);
        if (bitmap != null) {
            h hVar = new h();
            hVar.f1544b = bitmap;
            if (h2.l != hVar) {
                h2.l = hVar;
                hVar.k(h2);
            }
        } else {
            i iVar = new i();
            iVar.l(bVar.c().c(K));
            if (h2.l != iVar) {
                h2.l = iVar;
                iVar.k(h2);
            }
        }
        notificationManager.notify(bVar.f3911a, h2.b());
    }

    public final void c(Context context, int i2, boolean z) {
        if (z) {
            context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(i2);
        }
    }

    public final void d(Context context, c.c.b.g.e.b bVar, String str) {
        c.b.a.i<Bitmap> m = c.b.a.c.e(context).m();
        String str2 = bVar.f3915e;
        if (str2 == null) {
            str2 = "";
        }
        c.b.a.i<Bitmap> J = m.J(str2);
        J.F(new a(context, bVar, str), null, J, e.f3454a);
    }

    public final void e(Context context, c.c.b.g.e.b bVar, String str, String str2, int i2, String str3, int i3) {
        c.b.a.i<Bitmap> m = c.b.a.c.e(context).m();
        String str4 = bVar.f3915e;
        if (str4 == null) {
            str4 = "";
        }
        c.b.a.i<Bitmap> J = m.J(str4);
        J.F(new b(context, bVar, str, str2, i2, str3, i3), null, J, e.f3454a);
    }

    public final void f(Context context, c.c.b.g.e.b bVar, u uVar, String str, int i2, String str2, int i3) {
        String K = b.n.a.K(context);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        j h2 = h(context, K, notificationManager, bVar, "offer_present");
        if (notificationManager == null || h2 == null) {
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String h3 = u.b.h(context, uVar.l);
        String c2 = uVar.f3708b.c(b.n.a.K(context));
        String format = String.format(h3, decimalFormat.format(uVar.g()));
        String c3 = uVar.f3716j.c(b.n.a.K(context));
        String string = context.getString(2131886375, decimalFormat.format(uVar.f3709c));
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), 2131558583);
        remoteViews.setTextViewText(2131362342, c3);
        remoteViews.setTextViewText(2131362350, c2);
        RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), 2131558584);
        remoteViews2.setTextViewText(2131362350, c2);
        remoteViews2.setTextViewText(2131362349, string);
        remoteViews2.setTextViewText(2131362351, format);
        int size = uVar.s.size() <= 5 ? uVar.s.size() : 3;
        for (int i4 = 0; i4 < size; i4++) {
            p pVar = uVar.s.get(i4);
            if (pVar != null && !n.a.none.equals(pVar.f3687f)) {
                RemoteViews remoteViews3 = new RemoteViews(context.getPackageName(), 2131558582);
                remoteViews2.addView(2131362346, remoteViews3);
                remoteViews3.setImageViewResource(2131362344, pVar.b());
                if (!pVar.f3685d) {
                    remoteViews3.setTextViewText(2131362345, pVar.a(context));
                } else {
                    remoteViews3.setTextViewText(2131362345, "∞");
                }
            }
        }
        PendingIntent g2 = g(context, bVar, str2);
        PendingIntent g3 = g(context, bVar, str);
        h2.s = remoteViews;
        h2.t = remoteViews2;
        k kVar = new k();
        if (h2.l != kVar) {
            h2.l = kVar;
            kVar.k(h2);
        }
        h2.a(0, context.getString(i2), g3);
        h2.a(0, context.getString(i3), g2);
        notificationManager.notify(bVar.f3911a, h2.b());
    }

    public final PendingIntent g(Context context, c.c.b.g.e.b bVar, String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("notification", bVar.toString());
        intent.setClass(context, BackgroundReceiver.class);
        return PendingIntent.getBroadcast(context, 12345, intent, 134217728);
    }

    public final j h(Context context, String str, NotificationManager notificationManager, c.c.b.g.e.b bVar, String str2) {
        if (notificationManager == null) {
            return null;
        }
        int i2 = Build.VERSION.SDK_INT;
        int i3 = i2 > 23 ? 2131689473 : 2131230947;
        j jVar = new j(context, "1");
        jVar.f1557j = 0;
        jVar.i(16, true);
        jVar.w.icon = i3;
        jVar.h(-1);
        jVar.h(2);
        jVar.f1557j = 0;
        jVar.g(bVar.e().c(str));
        t tVar = bVar.f3918h;
        if (tVar == null) {
            tVar = new t();
        }
        jVar.f(tVar.c(str));
        Intent intent = new Intent();
        intent.setAction(str2);
        intent.setClass(context, BackgroundReceiver.class);
        intent.putExtra("notification", bVar.toString());
        jVar.f1554g = PendingIntent.getBroadcast(context, -1, intent, 134217728);
        if (i2 >= 26) {
            Uri defaultUri = RingtoneManager.getDefaultUri(2);
            AudioAttributes build = new AudioAttributes.Builder().setUsage(6).setContentType(4).build();
            NotificationChannel notificationChannel = new NotificationChannel("1", context.getString(2131886225), 3);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setLightColor(-65536);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            notificationChannel.setSound(defaultUri, build);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        try {
            jVar.q = Color.parseColor(bVar.f3916f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int resultCode = getResultCode();
        String action = intent.getAction();
        c.c.b.g.e.b b2 = c.c.b.g.e.b.b(intent.getStringExtra("notification"));
        try {
            if ("djezzy_event".equals(action)) {
                if (resultCode != -1) {
                    return;
                }
                if ("app_update".equals(b2.d())) {
                    if (b.n.a.e0(context, b2.f3919i.getInt("version"), true)) {
                        e(context, b2, "play_open", "play_open", 2131886142, "no_action", 2131886114);
                    }
                } else {
                    if (!"offer_present".equals(b2.d())) {
                        if ("fragment_open".equals(b2.d())) {
                            e(context, b2, "app_open", "app_open", 2131886126, "no_action", 2131886114);
                            return;
                        } else if ("url_open".equals(b2.d())) {
                            d(context, b2, "url_open");
                            return;
                        } else {
                            if ("app_open".equals(b2.d())) {
                                d(context, b2, "app_open");
                                return;
                            }
                            return;
                        }
                    }
                    f(context, b2, u.a(b2.f3919i, z.a.other, v.a.none), "app_open", 2131886108, "no_action", 2131886114);
                }
            } else {
                if ("app_open".equals(action) || "offer_present".equals(action)) {
                    c(context, b2.f3911a, true);
                    Intent intent2 = new Intent(context.getApplicationContext(), (Class<?>) SplashActivity.class);
                    intent2.putExtra("notification", b2.toString());
                    intent2.addFlags(335577088);
                    context.startActivity(intent2);
                    return;
                }
                if (!"url_open".equals(action)) {
                    if ("play_open".equals(action)) {
                        c(context, b2.f3911a, true);
                        b.n.a.q0(context);
                        return;
                    } else {
                        if ("no_action".equals(action)) {
                            c(context, b2.f3911a, false);
                            return;
                        }
                        return;
                    }
                }
                c(context, b2.f3911a, true);
                b.n.a.w0(context, b2.f3919i.getString("url"));
            }
        } catch (Exception unused) {
        }
    }
}