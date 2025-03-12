package com.djezzy.internet;

import android.app.Activity;
import android.app.Application;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import c.c.a.d;
import c.e.a.b;
import com.djezzy.internet.services.logging.DjezzySenderService;
import j.a.a.w.h;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\AppDelegate.smali */
public class AppDelegate extends Application {

    /* renamed from: f, reason: collision with root package name */
    public static AppDelegate f9647f;

    /* renamed from: d, reason: collision with root package name */
    public CountDownTimer f9648d;

    /* renamed from: e, reason: collision with root package name */
    public List<Activity> f9649e;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\AppDelegate$a.smali */
    public class a extends CountDownTimer {
        public a(long j2, long j3) {
            super(j2, j3);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            List<Activity> list = AppDelegate.this.f9649e;
            if (list != null) {
                Iterator<Activity> it = list.iterator();
                while (it.hasNext()) {
                    Activity next = it.next();
                    it.remove();
                    if (next != null) {
                        next.finish();
                    }
                }
            }
            System.exit(0);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("ITEM_ID", str2);
        bundle.putString("ITEM_TYPE", str);
        bundle.putString("ITEM_NAME", str3);
        bundle.putString("ITEM_CATEGORY", str4);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c.c.b.g.b.a.a(this, b.n.a.K(this), true);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f9647f = this;
        if (Build.VERSION.SDK_INT < 26 && !c.e.a.a.f9639a.getAndSet(true)) {
            b bVar = new b(this, "org/threeten/bp/TZDB.dat");
            if (h.f10854a.get()) {
                throw new IllegalStateException("Already initialized");
            }
            if (!h.f10855b.compareAndSet(null, bVar)) {
                throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
            }
        }
        ((JobScheduler) getSystemService("jobscheduler")).schedule(new JobInfo.Builder(1895, new ComponentName(this, (Class<?>) DjezzySenderService.class)).setRequiredNetworkType(1).setRequiresCharging(false).build());
        d.a(getApplicationContext()).b("App_launch");
        this.f9648d = new a(300000L, 300000L);
    }

    @Override // android.app.Application
    public void onTerminate() {
        d.a(getApplicationContext()).b("app_closed");
        super.onTerminate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        CountDownTimer countDownTimer;
        super.onTrimMemory(i2);
        if (i2 == 20 && (countDownTimer = this.f9648d) != null) {
            countDownTimer.start();
        }
    }
}