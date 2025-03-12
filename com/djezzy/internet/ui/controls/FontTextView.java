package com.djezzy.internet.ui.controls;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import b.h.d.b.h;
import c.c.b.a;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\controls\FontTextView.smali */
public class FontTextView extends AppCompatTextView {
    public FontTextView(Context context) {
        super(context, null);
    }

    public FontTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f3495a, 0, 0);
        if (obtainStyledAttributes == null || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0 || Build.VERSION.SDK_INT >= 26) {
            return;
        }
        setTypeface(h.a(getContext(), resourceId));
    }
}