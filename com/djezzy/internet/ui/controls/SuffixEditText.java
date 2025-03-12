package com.djezzy.internet.ui.controls;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\controls\SuffixEditText.smali */
public class SuffixEditText extends AppCompatEditText {

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f9720g;

    /* renamed from: h, reason: collision with root package name */
    public int f9721h;

    public SuffixEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9721h = 255;
        System.out.println("COLOR STATE CALLED");
        this.f9720g = new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}, new int[]{-16842912}, new int[]{R.attr.state_pressed}}, new int[]{getCurrentTextColor(), getCurrentTextColor(), getCurrentTextColor(), getCurrentTextColor()});
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getTag() != null) {
            TextPaint paint = getPaint();
            paint.setColor(this.f9720g.getColorForState(getDrawableState(), 0));
            paint.setAlpha(this.f9721h);
            int lineBounds = getLineBounds(0, null);
            setWidth((int) (getPaint().measureText(getTag().toString()) + getPaint().measureText(getText().toString()) + getPaddingLeft() + getPaddingRight()));
            canvas.drawText(getTag().toString(), getPaint().measureText(getText().toString()) + getPaddingLeft(), canvas.getClipBounds().top + lineBounds, paint);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
    }

    public void setSuffixTextAlpha(int i2) {
        this.f9721h = i2;
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f9720g = colorStateList;
    }
}