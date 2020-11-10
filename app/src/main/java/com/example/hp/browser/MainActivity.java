package com.example.hp.browser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn ;
    EditText url;
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url= findViewById(R.id.url);
        wv=findViewById(R.id.wv);
       btn=findViewById(R.id.btn);

        WebSettings settings=wv.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        wv.setWebViewClient(new Callback());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wv.setWebViewClient(new Callback());
                String searchurl= "https://"+url.getText().toString();

                wv.loadUrl(searchurl);
//                wv.getSettings().setLoadsImagesAutomatically(true);


            }
        });
    }

    class Callback extends WebViewClient
    {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            return false;
        }
    }
}
