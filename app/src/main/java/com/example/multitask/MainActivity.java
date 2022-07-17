package com.example.multitask;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    WebView webView1, webView2, webView3, webView4;
    String url = "https://www.google.com/";
    String url2 = "https://www.google.com/";
    String url4 = "https://google.com/";
    String url3 = "https://www.google.com/";
    FloatingActionButton maximizeButton;

    String baseUrl;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_view();

        load_webview(webView1, url);

        load_webview(webView2, url2);

        load_webview(webView3, url3);

        load_webview(webView4, url4);

        webView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
                baseUrl = webView1.getUrl();
                return false;
            }
        });

        webView2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
                baseUrl = webView2.getUrl();
                return false;
            }
        });

        webView3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
                baseUrl = webView3.getUrl();
                return false;
            }
        });

        webView4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
                baseUrl = webView4.getUrl();
                return false;
            }
        });

        maximizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*RelativeLayout.LayoutParams paramsWebView = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
                Dialog dialog = new Dialog(getApplicationContext(), android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                dialog.addContentView(webView1, paramsWebView);
                dialog.show();*/

                if (TextUtils.isEmpty(baseUrl)) {

                } else {
                    pop_up_webview(baseUrl);
                }

            }
        });

    }

    private void pop_up_webview(String url) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.pop_up_webview);
        dialog.setCancelable(false);
        dialog.show();

        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER;
        wlp.width = android.view.WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = android.view.WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(wlp);

        WebView webshow = dialog.findViewById(R.id.pop_up_webview);

        //pop_up_webview.addView(webView1);

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

        FloatingActionButton minimizeButton = dialog.findViewById(R.id.minimizeButton);
        minimizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    private void load_webview(WebView webshow, String url) {
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
        webView1 = findViewById(R.id.webView1);
        webView2 = findViewById(R.id.webView2);
        webView3 = findViewById(R.id.webView3);
        webView4 = findViewById(R.id.webView4);

        maximizeButton = findViewById(R.id.maximizeButton);
    }
}