package com.example.multitask;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class WebMercuryDroidConfig extends WebViewClient {

    boolean timeout = true;

    WebView webshow;

    public WebMercuryDroidConfig(WebView webshow) {
        this.webshow = webshow;
    }

    public WebMercuryDroidConfig() {
        timeout = true;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        webshow.loadUrl(url);
        return true;
        //return super.shouldOverrideUrlLoading(view, url);
    }

    public void onLoadResource(WebView view, String url) {
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        //progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        //progressBar.setVisibility(View.INVISIBLE);
        timeout = false;
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        webshow.stopLoading();
            /*ConnectivityManager manager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null) {
                webshow.loadUrl(url);
            } else {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new Network_fragment()).addToBackStack(null).commit();
            }
        }*/
    }
}
