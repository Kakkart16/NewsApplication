package com.example.newspilot;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class webView extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_web_view);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.webView = (WebView) findViewById(R.id.webview);
        setSupportActionBar(this.toolbar);
        String url = getIntent().getStringExtra("url");
        this.webView.setWebViewClient(new WebViewClient());
        this.webView.loadUrl(url);
    }
}