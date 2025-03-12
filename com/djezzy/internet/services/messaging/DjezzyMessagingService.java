package com.djezzy.internet.services.messaging;

import android.content.Intent;
import android.os.Bundle;
import b.n.a;
import c.c.b.e.t;
import c.c.b.g.e.b;
import c.c.b.k.d;
import c.d.c.u.g0;
import com.djezzy.internet.services.messaging.DjezzyMessagingService;
import com.google.firebase.messaging.FirebaseMessagingService;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\services\messaging\DjezzyMessagingService.smali */
public class DjezzyMessagingService extends FirebaseMessagingService {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f9684j = 0;

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void f() {
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void g(g0 g0Var) {
        String L = a.L(getApplicationContext());
        if ("enabled".equals(L) || "enabled_not_send".equals(L)) {
            b bVar = new b();
            if (g0Var.f9536e == null) {
                Bundle bundle = g0Var.f9535d;
                b.e.a aVar = new b.e.a();
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                            aVar.put(str, str2);
                        }
                    }
                }
                g0Var.f9536e = aVar;
            }
            Map<String, String> map = g0Var.f9536e;
            if (map == null || map.size() == 0) {
                return;
            }
            String str3 = map.get("id");
            if (str3 != null) {
                bVar.f3911a = Integer.parseInt(str3);
            }
            bVar.f3914d = map.get("icon");
            bVar.f3915e = map.get("image");
            bVar.f3916f = map.get("color");
            try {
                bVar.f3913c = t.a(new JSONObject(map.get("title")));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                bVar.f3917g = t.a(new JSONObject(map.get("body")));
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            try {
                bVar.f3918h = t.a(new JSONObject(map.get("subtitle")));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            bVar.g(map.get("tag"));
            bVar.f(map.get("data"));
            Intent intent = new Intent("djezzy_event");
            intent.putExtra("notification", bVar.toString());
            getApplicationContext().sendOrderedBroadcast(intent, null, new BackgroundReceiver(), null, -1, null, null);
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void h(String str) {
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void i(final String str) {
        String L = a.L(getApplicationContext());
        if ("enabled".equals(L) || "enabled_not_send".equals(L)) {
            new Thread(new Runnable() { // from class: c.c.b.g.e.a
                @Override // java.lang.Runnable
                public final void run() {
                    String str2 = str;
                    int i2 = DjezzyMessagingService.f9684j;
                    d.a().b(str2, 10000);
                }
            }).start();
        }
    }
}