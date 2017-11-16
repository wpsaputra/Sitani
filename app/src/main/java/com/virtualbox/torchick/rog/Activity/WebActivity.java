package com.virtualbox.torchick.rog.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;

import com.virtualbox.torchick.rog.Model.Indikator;
import com.virtualbox.torchick.rog.Model.LinkDataForm;
import com.virtualbox.torchick.rog.R;

public class WebActivity extends AppCompatActivity {

    FrameLayout frameLayoutNoInternet, frameLayoutLoading;
    Button buttonNoInternet;
//    LinkDataForm linkDataForm;
    Indikator indikator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        frameLayoutNoInternet = (FrameLayout) findViewById(R.id.frame_layout_no_internet);
        frameLayoutLoading = (FrameLayout) findViewById(R.id.frame_layout_loading);
        buttonNoInternet = (Button) findViewById(R.id.no_internet_button);

        indikator =  getIntent().getParcelableExtra("indikator");
        final WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("http://sultradata.com/project/SISERA_2/data/tampil-data2?id="+linkDataForm.getId_link());
        webView.loadUrl(indikator.getLink());

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                frameLayoutLoading.setVisibility(View.GONE);
//                frameLayoutNoInternet.setVisibility(View.GONE);

            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                frameLayoutNoInternet.setVisibility(View.VISIBLE);
            }


        });

        buttonNoInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                webView.loadUrl("http://sultradata.com/project/SISERA_2/data/tampil-data2?id="+linkDataForm.getId_link());
                webView.loadUrl(indikator.getLink());
                frameLayoutNoInternet.setVisibility(View.GONE);
                frameLayoutLoading.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
