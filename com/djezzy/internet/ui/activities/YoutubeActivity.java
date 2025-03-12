package com.djezzy.internet.ui.activities;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import c.c.b.h.a.a0;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\YoutubeActivity.smali */
public class YoutubeActivity extends a0 {
    public ProgressBar y;
    public final WebChromeClient z = new a();
    public final WebViewClient A = new b();

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\YoutubeActivity$a.smali */
    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            YoutubeActivity.this.y.setProgress(i2);
            if (i2 < 100 && YoutubeActivity.this.y.getVisibility() == 8) {
                YoutubeActivity.this.y.setVisibility(0);
            } else if (i2 == 100) {
                YoutubeActivity.this.y.setVisibility(8);
            }
        }
    }

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\YoutubeActivity$b.smali */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            if (str == null || str.contains("player_share_panel")) {
                webView.stopLoading();
            } else {
                super.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            ProgressBar progressBar = YoutubeActivity.this.y;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return true;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return true;
        }
    }

    @Override // c.c.b.h.a.a0
    public String D() {
        return "youtube_activity";
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2131558439);
        if (getIntent() == null) {
            finish();
            return;
        }
        String string = getString(2131886505, new Object[]{getIntent().getStringExtra("web_url")});
        WebView webView = (WebView) findViewById(2131362635);
        this.y = (ProgressBar) findViewById(2131362636);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setAllowContentAccess(false);
        webView.getSettings().setAllowFileAccessFromFileURLs(false);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        webView.setWebViewClient(this.A);
        webView.setWebChromeClient(this.z);
        webView.loadData(string, "text/html", "UTF-8");
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onDestroy() {
        setRequestedOrientation(1);
        super.onDestroy();
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }
}