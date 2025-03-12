package com.djezzy.internet.webservice.ImageLoader;

import android.content.Context;
import c.b.a.c;
import c.b.a.h;
import c.b.a.o.v.p;
import c.b.a.o.v.r;
import c.b.a.q.a;
import java.io.InputStream;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\webservice\ImageLoader\DjezzyGlideModule.smali */
public class DjezzyGlideModule extends a {
    @Override // c.b.a.q.d, c.b.a.q.f
    public void b(Context context, c cVar, h hVar) {
        c.c.b.k.b.c cVar2 = new c.c.b.k.b.c();
        p pVar = hVar.f2670a;
        synchronized (pVar) {
            r rVar = pVar.f3120a;
            synchronized (rVar) {
                rVar.f3135a.add(0, new r.b<>(String.class, InputStream.class, cVar2));
            }
            pVar.f3121b.f3122a.clear();
        }
    }
}