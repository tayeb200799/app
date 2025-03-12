package com.djezzy.clickstream.database;

import android.content.Context;
import b.u.h;
import b.u.j;
import b.w.a.c;
import c.c.a.e.b;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\clickstream\database\EventsDatabase_Impl.smali */
public final class EventsDatabase_Impl extends EventsDatabase {
    public volatile b m;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\clickstream\database\EventsDatabase_Impl$a.smali */
    public class a extends j.a {
        public a(int i2) {
            super(i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:74:0x01e3  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0203  */
        @Override // b.u.j.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b.u.j.b a(b.w.a.b r29) {
            /*
                Method dump skipped, instructions count: 537
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.djezzy.clickstream.database.EventsDatabase_Impl.a.a(b.w.a.b):b.u.j$b");
        }
    }

    @Override // b.u.i
    public h c() {
        return new h(this, new HashMap(0), new HashMap(0), "events");
    }

    @Override // b.u.i
    public c d(b.u.c cVar) {
        j jVar = new j(cVar, new a(1), "c04654493a2cafa2b67ea3877efd961a", "708679f6d14ffb15a0b3934217646fdb");
        Context context = cVar.f2326b;
        String str = cVar.f2327c;
        if (context == null) {
            throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
        }
        return new b.w.a.g.b(context, str, jVar, false);
    }

    @Override // b.u.i
    public Map<Class<?>, List<Class<?>>> e() {
        HashMap hashMap = new HashMap();
        hashMap.put(b.class, Collections.emptyList());
        return hashMap;
    }

    @Override // com.djezzy.clickstream.database.EventsDatabase
    public b l() {
        b bVar;
        if (this.m != null) {
            return this.m;
        }
        synchronized (this) {
            if (this.m == null) {
                this.m = new c.c.a.e.c(this);
            }
            bVar = this.m;
        }
        return bVar;
    }
}