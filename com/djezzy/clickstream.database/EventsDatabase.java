package com.djezzy.clickstream.database;

import android.content.Context;
import b.u.i;
import c.c.a.e.b;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\clickstream\database\EventsDatabase.smali */
public abstract class EventsDatabase extends i {
    public static EventsDatabase l;

    public static synchronized EventsDatabase m(Context context) {
        EventsDatabase eventsDatabase;
        synchronized (EventsDatabase.class) {
            if (l == null) {
                l = (EventsDatabase) new i.a(context, EventsDatabase.class, "clickstream.db").a();
            }
            eventsDatabase = l;
        }
        return eventsDatabase;
    }

    public abstract b l();
}