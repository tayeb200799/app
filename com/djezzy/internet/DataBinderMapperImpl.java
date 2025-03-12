package com.djezzy.internet;

import android.util.SparseIntArray;
import b.k.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\DataBinderMapperImpl.smali */
public class DataBinderMapperImpl extends a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f9652a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        f9652a = sparseIntArray;
        sparseIntArray.put(2131558535, 1);
        sparseIntArray.put(2131558537, 2);
    }

    @Override // b.k.a
    public List<a> a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }
}