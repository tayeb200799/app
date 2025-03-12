package com.djezzy.internet.ui.controls.PinEditText;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.appcompat.widget.AppCompatEditText;
import c.c.b.h.d.r;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\controls\PinEditText\PinEditText.smali */
public class PinEditText extends AppCompatEditText {

    /* renamed from: g, reason: collision with root package name */
    public c.c.b.d.a f9711g;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\controls\PinEditText\PinEditText$a.smali */
    public class a extends InputConnectionWrapper {
        public a(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i2, int i3) {
            return (i2 == 1 && i3 == 0) ? sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67)) : super.deleteSurroundingText(i2, i3);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            PinEditText pinEditText;
            c.c.b.d.a aVar;
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 67 && (aVar = (pinEditText = PinEditText.this).f9711g) != null) {
                r rVar = (r) aVar;
                if ((pinEditText.getText() != null ? pinEditText.getText().toString() : "").isEmpty() && pinEditText.getId() != 2131362073) {
                    pinEditText.clearFocus();
                    switch (pinEditText.getId()) {
                        case 2131362074:
                            rVar.u0.requestFocus();
                            break;
                        case 2131362075:
                            rVar.v0.requestFocus();
                            break;
                        case 2131362076:
                            rVar.w0.requestFocus();
                            break;
                        case 2131362077:
                            rVar.x0.requestFocus();
                            break;
                        case 2131362078:
                            rVar.y0.requestFocus();
                            break;
                        case 2131362079:
                            rVar.m0.requestFocus();
                            break;
                        case 2131362080:
                            rVar.n0.requestFocus();
                            break;
                        case 2131362081:
                            rVar.o0.requestFocus();
                            break;
                        case 2131362082:
                            rVar.p0.requestFocus();
                            break;
                        case 2131362083:
                            rVar.q0.requestFocus();
                            break;
                        case 2131362084:
                            rVar.r0.requestFocus();
                            break;
                        case 2131362085:
                            rVar.s0.requestFocus();
                            break;
                        case 2131362086:
                            rVar.t0.requestFocus();
                            break;
                    }
                }
            }
            return super.sendKeyEvent(keyEvent);
        }
    }

    public PinEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new a(super.onCreateInputConnection(editorInfo), true);
    }

    public void setOnEditBackListener(c.c.b.d.a aVar) {
        this.f9711g = aVar;
    }
}