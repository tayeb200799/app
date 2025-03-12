package com.djezzy.internet.ui.controls;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\controls\PrefixEditText.smali */
public class PrefixEditText extends AppCompatEditText {

    /* renamed from: g, reason: collision with root package name */
    public float f9713g;

    public PrefixEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9713g = -1.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getPaint().setColor(getCurrentTextColor());
        canvas.drawText((String) getTag(), this.f9713g, getLineBounds(0, null), getPaint());
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f9713g == -1.0f) {
            String str = (String) getTag();
            int length = str.length();
            float[] fArr = new float[length];
            getPaint().getTextWidths(str, fArr);
            float f2 = 0.0f;
            for (int i4 = 0; i4 < length; i4++) {
                f2 += fArr[i4];
            }
            float compoundPaddingLeft = getCompoundPaddingLeft();
            this.f9713g = compoundPaddingLeft;
            setPadding((int) (f2 + compoundPaddingLeft), getPaddingRight(), getPaddingTop(), getPaddingBottom());
        }
    }
}