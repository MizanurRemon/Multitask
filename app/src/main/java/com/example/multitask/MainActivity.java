package com.example.multitask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView1, webView2,webView3,webView4;
    String url = "https://www.google.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init_view();
        
        load_webview(webView1);

        load_webview(webView2);

        load_webview(webView3);

        load_webview(webView4);

    }

    private void load_webview(WebView webshow) {
        webshow.getSettings().setLoadsImagesAutomatically(true);
        webshow.getSettings().setJavaScriptEnabled(true);
        // webshow.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webshow.getSettings().setPluginState(WebSettings.PluginState.ON);
        webshow.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webshow.getSettings().setBuiltInZoomControls(true);
        webshow.getSettings().setDisplayZoomControls(false);
        webshow.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        // webview.getSettings().setAppCacheEnabled(true);
        //this.jsBridge.a(new JsListener(), "sdk_js_if");
        webshow.clearView();
        webshow.setWebViewClient(new WebViewClient());
        webshow.setInitialScale(1);
        webshow.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        webshow.getSettings().setLoadWithOverviewMode(true);
        webshow.getSettings().setUseWideViewPort(true);
        webshow.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webshow.getSettings().setDomStorageEnabled(true);
        webshow.getSettings().setLoadWithOverviewMode(true);
        webshow.setWebChromeClient(new WebChromeClient());
        webshow.setWebViewClient(new WebMercuryDroidConfig(webshow));
        webshow.loadUrl(url);
    }

    private void init_view() {
        webView1= findViewById(R.id.webView1);
        webView2 = findViewById(R.id.webView2);
        webView3= findViewById(R.id.webView3);
        webView4 = findViewById(R.id.webView4);
    }
}