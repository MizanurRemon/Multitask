package com.example.multitask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Pop_up_activity extends AppCompatActivity {
    WebView pop_up_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up);

        init_view();
    }

    private void init_view() {
        pop_up_webview = findViewById(R.id.pop_up_webview);
    }
}