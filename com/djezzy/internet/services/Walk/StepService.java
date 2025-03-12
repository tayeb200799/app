package com.djezzy.internet.services.Walk;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import b.h.c.j;
import b.r.a.a;
import com.djezzy.internet.ui.activities.SplashActivity;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\Walk\StepService.smali */
public class StepService extends Service implements SensorEventListener {
    public static boolean l;

    /* renamed from: d, reason: collision with root package name */
    public int f9653d = 5000;

    /* renamed from: e, reason: collision with root package name */
    public int f9654e = 5000;

    /* renamed from: f, reason: collision with root package name */
    public int f9655f = 5000;

    /* renamed from: g, reason: collision with root package name */
    public int f9656g = 5000;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9657h = true;

    /* renamed from: i, reason: collision with root package name */
    public NotificationManager f9658i;

    /* renamed from: j, reason: collision with root package name */
    public PendingIntent f9659j;
    public SensorManager k;

    public final void a() {
        this.f9659j = PendingIntent.getService(getApplicationContext(), 0, new Intent(getApplicationContext(), (Class<?>) StepService.class).setAction("StopService"), 134217728);
    }

    public final PendingIntent b() {
        return PendingIntent.getActivity(getApplicationContext(), 0, new Intent(getApplicationContext(), (Class<?>) SplashActivity.class), 134217728);
    }

    public final void c(boolean z) {
        boolean z2;
        int i2;
        String str;
        ArrayList arrayList;
        ArrayList<a.c> arrayList2;
        String str2;
        Intent intent = new Intent("com.djezzy.internet.UPDATE_DISPLAY");
        intent.putExtra("ProgressCount", this.f9655f + this.f9653d);
        if (z) {
            intent.putExtra("StopService", true);
        }
        if (this.f9655f + this.f9653d >= this.f9656g) {
            intent.putExtra("levelAchieved", true);
        }
        a a2 = a.a(this);
        synchronized (a2.f2173b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(a2.f2172a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z3 = (intent.getFlags() & 8) != 0;
            if (z3) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<a.c> arrayList3 = a2.f2174c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z3) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    a.c cVar = arrayList3.get(i3);
                    if (z3) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f2180a);
                    }
                    if (cVar.f2182c) {
                        if (z3) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i2 = i3;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = cVar.f2180a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z3) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.f2182c = true;
                            i3 = i2 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z3) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i3 = i2 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                z2 = false;
                if (arrayList5 != null) {
                    for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                        ((a.c) arrayList5.get(i4)).f2182c = false;
                    }
                    a2.f2175d.add(new a.b(intent, arrayList5));
                    if (!a2.f2176e.hasMessages(1)) {
                        a2.f2176e.sendEmptyMessage(1);
                    }
                }
            } else {
                z2 = false;
            }
        }
        if (l || !this.f9657h) {
            return;
        }
        a();
        String str3 = String.valueOf(this.f9655f + this.f9653d) + " " + getApplicationContext().getResources().getString(2131886293);
        j jVar = new j(this, "walkChannel");
        jVar.i(16, z2);
        jVar.i(2, true);
        jVar.w.icon = 2131689473;
        jVar.g(getApplicationContext().getResources().getString(2131886487));
        jVar.f(str3);
        jVar.e(z2);
        jVar.q = getApplicationContext().getResources().getColor(2131099705);
        jVar.a(2131230850, getApplicationContext().getResources().getString(2131886294), this.f9659j);
        jVar.f1554g = b();
        this.f9658i.notify(1002, jVar.b());
    }

    public final void d(String str, int i2) {
        SharedPreferences.Editor edit = getSharedPreferences("StepServicePrefs", 0).edit();
        edit.putInt(str, i2);
        edit.apply();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        Toast.makeText(this, " Riss233x ", 1).show();
        super.onCreate();
        this.f9654e = getSharedPreferences("StepServicePrefs", 0).getInt("InitialCount", -1);
        this.f9655f = getSharedPreferences("StepServicePrefs", 0).getInt("ProgressCount", 0);
        this.f9656g = getSharedPreferences("StepServicePrefs", 0).getInt("minLevelSteps", -1);
        l = true;
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        this.k = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(19);
        if (defaultSensor != null) {
            this.k.registerListener(this, defaultSensor, 2);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        d("InitialCount", -1);
        d("ProgressCount", this.f9655f + this.f9653d);
        SensorManager sensorManager = this.k;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        super.onDestroy();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        int round = Math.round(sensorEvent.values[0]);
        int i2 = this.f9654e;
        if (i2 == -1 || i2 > round) {
            int i3 = round - 1;
            this.f9654e = i3;
            d("InitialCount", i3);
        }
        this.f9653d = round - this.f9654e;
        c(false);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        String action = intent.getAction();
        if (action != null && action.equals("ResetCounters")) {
            this.f9653d = 0;
            this.f9655f = 0;
            d("ProgressCount", 0);
            this.f9657h = false;
            c(true);
            stopSelf();
        } else if (action != null && action.equals("StopService")) {
            this.f9657h = false;
            stopForeground(true);
            stopSelf();
        } else if (action != null && action.equals("StopNotif")) {
            this.f9657h = false;
            stopForeground(true);
            c(false);
        } else if (action != null && action.equals("StartNoNotif")) {
            this.f9657h = false;
            if (l) {
                l = false;
            }
            c(false);
        } else if (action == null || !action.equals("StartNoNotif")) {
            this.f9657h = true;
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            this.f9658i = notificationManager;
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel("walkChannel", "WALK_CHANNEL", 2));
            }
            a();
            String str = String.valueOf(this.f9655f + this.f9653d) + " " + getApplicationContext().getResources().getString(2131886293);
            j jVar = new j(this, "walkChannel");
            jVar.i(16, false);
            jVar.i(2, true);
            jVar.w.icon = 2131689473;
            jVar.g(getApplicationContext().getResources().getString(2131886487));
            jVar.f(str);
            jVar.e(false);
            jVar.q = getApplicationContext().getResources().getColor(2131099705);
            jVar.a(2131230850, getApplicationContext().getResources().getString(2131886294), this.f9659j);
            jVar.f1554g = b();
            startForeground(1002, jVar.b());
        }
        return 1;
    }
}