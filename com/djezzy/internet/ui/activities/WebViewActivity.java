package com.djezzy.internet.ui.activities;

import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import c.c.b.h.a.a0;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\WebViewActivity.smali */
public class WebViewActivity extends a0 implements SwipeRefreshLayout.h {
    public SwipeRefreshLayout A;
    public DownloadManager.Request B;
    public Map<String, String> C = new HashMap();
    public final WebChromeClient D = new a();
    public final WebViewClient E = new b();
    public final DownloadListener F = new DownloadListener() { // from class: c.c.b.h.a.x
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0054, code lost:
        
            r10 = r4.split("=")[1];
         */
        @Override // android.webkit.DownloadListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onDownloadStart(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, long r12) {
            /*
                r7 = this;
                com.djezzy.internet.ui.activities.WebViewActivity r9 = com.djezzy.internet.ui.activities.WebViewActivity.this
                java.util.Objects.requireNonNull(r9)
                android.net.Uri r8 = android.net.Uri.parse(r8)
                java.lang.String r12 = "="
                java.lang.String r13 = "filename"
                r0 = 0
                r1 = 1
                java.lang.String r2 = "filename[^;\\n]*=(UTF-\\d['\"]*)?((['\"]).*?[.]$\\2|[^;\\n]*)?"
                java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch: java.lang.Exception -> L36
                java.util.regex.Matcher r2 = r2.matcher(r10)     // Catch: java.lang.Exception -> L36
                int r3 = r2.groupCount()     // Catch: java.lang.Exception -> L36
                r4 = 0
            L1e:
                if (r4 >= r3) goto L37
                java.lang.String r5 = r2.group(r4)     // Catch: java.lang.Exception -> L36
                if (r5 == 0) goto L33
                boolean r6 = r5.contains(r13)     // Catch: java.lang.Exception -> L36
                if (r6 == 0) goto L33
                java.lang.String[] r2 = r5.split(r12)     // Catch: java.lang.Exception -> L36
                r10 = r2[r1]     // Catch: java.lang.Exception -> L36
                goto L5f
            L33:
                int r4 = r4 + 1
                goto L1e
            L36:
            L37:
                if (r10 == 0) goto L5f
                java.lang.String r2 = "attachment"
                boolean r2 = r10.contains(r2)     // Catch: java.lang.Exception -> L5e
                if (r2 == 0) goto L5f
                java.lang.String r2 = ";"
                java.lang.String[] r2 = r10.split(r2)     // Catch: java.lang.Exception -> L5e
                int r3 = r2.length     // Catch: java.lang.Exception -> L5e
            L48:
                if (r0 >= r3) goto L5f
                r4 = r2[r0]     // Catch: java.lang.Exception -> L5e
                if (r4 == 0) goto L5b
                boolean r5 = r4.contains(r13)     // Catch: java.lang.Exception -> L5e
                if (r5 == 0) goto L5b
                java.lang.String[] r12 = r4.split(r12)     // Catch: java.lang.Exception -> L5e
                r10 = r12[r1]     // Catch: java.lang.Exception -> L5e
                goto L5f
            L5b:
                int r0 = r0 + 1
                goto L48
            L5e:
            L5f:
                android.app.DownloadManager$Request r12 = new android.app.DownloadManager$Request
                r12.<init>(r8)
                r9.B = r12
                r12.setTitle(r10)
                android.app.DownloadManager$Request r10 = r9.B
                r10.setMimeType(r11)
                android.app.DownloadManager$Request r10 = r9.B
                r10.setVisibleInDownloadsUi(r1)
                android.app.DownloadManager$Request r10 = r9.B
                r10.setNotificationVisibility(r1)
                android.app.DownloadManager$Request r10 = r9.B
                java.lang.String r11 = android.os.Environment.DIRECTORY_DOWNLOADS
                java.lang.String r8 = r8.getLastPathSegment()
                r10.setDestinationInExternalPublicDir(r11, r8)
                java.lang.String r8 = "android.permission.WRITE_EXTERNAL_STORAGE"
                boolean r10 = b.n.a.U(r9, r8)
                if (r10 != 0) goto Laa
                boolean r10 = b.h.c.a.d(r9, r8)
                if (r10 != 0) goto L9b
                java.lang.String[] r8 = new java.lang.String[]{r8}
                r10 = 10011(0x271b, float:1.4028E-41)
                b.h.c.a.c(r9, r8, r10)
                goto Lb9
            L9b:
                r8 = 2131886202(0x7f12007a, float:1.9406976E38)
                java.lang.String r8 = r9.getString(r8)
                android.widget.Toast r8 = android.widget.Toast.makeText(r9, r8, r1)
                r8.show()
                goto Lb9
            Laa:
                java.lang.String r8 = "download"
                java.lang.Object r8 = r9.getSystemService(r8)
                android.app.DownloadManager r8 = (android.app.DownloadManager) r8
                if (r8 == 0) goto Lb9
                android.app.DownloadManager$Request r9 = r9.B
                r8.enqueue(r9)
            Lb9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c.c.b.h.a.x.onDownloadStart(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):void");
        }
    };
    public final ViewTreeObserver.OnScrollChangedListener G = new c();
    public WebView y;
    public ProgressBar z;

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\WebViewActivity$a.smali */
    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            WebViewActivity.this.z.setProgress(i2);
            if (i2 < 100 && WebViewActivity.this.z.getVisibility() == 8) {
                WebViewActivity.this.z.setVisibility(0);
            } else if (i2 == 100) {
                WebViewActivity.this.z.setVisibility(8);
            }
        }
    }

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\WebViewActivity$b.smali */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            SwipeRefreshLayout swipeRefreshLayout = WebViewActivity.this.A;
            if (swipeRefreshLayout != null && swipeRefreshLayout.f528f) {
                swipeRefreshLayout.setRefreshing(false);
            }
            ProgressBar progressBar = WebViewActivity.this.z;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        }

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                String uri = webResourceRequest.getUrl().toString();
                Map<String, String> map = WebViewActivity.this.C;
                if (map == null) {
                    map = new HashMap<>();
                }
                webView.loadUrl(uri, map);
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                Map<String, String> map = WebViewActivity.this.C;
                if (map == null) {
                    map = new HashMap<>();
                }
                webView.loadUrl(str, map);
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        }
    }

    /* loaded from: C:\Users\tayeb\Videos\apk-easy-tool-1-60\1-Decompiled APKs\com-mod-djezzy-mod-apk-v-v2-5-1-40019\smali\com\djezzy\internet\ui\activities\WebViewActivity$c.smali */
    public class c implements ViewTreeObserver.OnScrollChangedListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            WebViewActivity webViewActivity = WebViewActivity.this;
            webViewActivity.A.setEnabled(webViewActivity.y.getScrollY() == 0);
        }
    }

    @Override // c.c.b.h.a.a0
    public String D() {
        return "webview_activity";
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.h
    public void h() {
        WebView webView = this.y;
        if (webView != null) {
            webView.reload();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        WebView webView = this.y;
        if (webView == null || !webView.canGoBack()) {
            this.f76i.a();
        } else {
            this.y.goBack();
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, androidx.activity.ComponentActivity, b.h.c.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(2131558438);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        try {
            if (intent.getStringExtra("web_headers") != null) {
                String stringExtra = intent.getStringExtra("web_headers");
                JSONObject jSONObject = new JSONObject();
                if (stringExtra != null) {
                    try {
                        if (!stringExtra.isEmpty()) {
                            jSONObject = new JSONObject(stringExtra);
                        }
                    } catch (Exception unused) {
                    }
                }
                this.C = b.n.a.f0(jSONObject.getJSONObject("headers"));
                str = String.format("%s?%s", jSONObject.getString("url"), b.n.a.A(b.n.a.f0(jSONObject.getJSONObject("parameters"))));
            } else {
                str = String.format("%s", getIntent().getStringExtra("web_url"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            str = "";
        }
        this.y = (WebView) findViewById(2131362635);
        this.z = (ProgressBar) findViewById(2131362636);
        this.A = (SwipeRefreshLayout) findViewById(2131362527);
        this.y.getSettings().setSupportZoom(true);
        this.y.getSettings().setDomStorageEnabled(true);
        this.y.getSettings().setJavaScriptEnabled(true);
        this.y.getSettings().setAllowFileAccess(false);
        this.y.getSettings().setAllowContentAccess(false);
        this.y.getSettings().setAllowFileAccessFromFileURLs(false);
        this.y.getSettings().setAllowUniversalAccessFromFileURLs(false);
        this.y.setWebViewClient(this.E);
        this.y.setWebChromeClient(this.D);
        this.A.setOnRefreshListener(this);
        this.y.setDownloadListener(this.F);
        WebView webView = this.y;
        Map<String, String> map = this.C;
        if (map == null) {
            map = new HashMap<>();
        }
        webView.loadUrl(str, map);
    }

    @Override // b.n.c.e, android.app.Activity, b.h.c.a.b
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 10011) {
            if (!b.n.a.U(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                Toast.makeText(this, getString(2131886202), 1).show();
                return;
            }
            DownloadManager downloadManager = (DownloadManager) getSystemService("download");
            if (downloadManager != null) {
                downloadManager.enqueue(this.B);
            }
        }
    }

    @Override // c.c.b.h.a.a0, b.n.c.e, android.app.Activity
    public void onStart() {
        super.onStart();
        SwipeRefreshLayout swipeRefreshLayout = this.A;
        if (swipeRefreshLayout == null || swipeRefreshLayout.getViewTreeObserver() == null) {
            return;
        }
        this.A.getViewTreeObserver().addOnScrollChangedListener(this.G);
    }

    @Override // b.n.c.e, android.app.Activity
    public void onStop() {
        super.onStop();
        SwipeRefreshLayout swipeRefreshLayout = this.A;
        if (swipeRefreshLayout == null || swipeRefreshLayout.getViewTreeObserver() == null) {
            return;
        }
        this.A.getViewTreeObserver().removeOnScrollChangedListener(this.G);
    }
}