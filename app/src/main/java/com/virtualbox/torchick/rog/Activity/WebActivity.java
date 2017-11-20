package com.virtualbox.torchick.rog.Activity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.virtualbox.torchick.rog.Model.Indikator;
import com.virtualbox.torchick.rog.Model.LinkDataForm;
import com.virtualbox.torchick.rog.R;

import java.util.Calendar;

public class WebActivity extends AppCompatActivity {

    FrameLayout frameLayoutNoInternet, frameLayoutLoading;
    Button buttonNoInternet;
    FloatingActionButton fab;
    DatePickerDialog.OnDateSetListener onDateSetListener;
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
        fab = (FloatingActionButton) findViewById(R.id.fab);

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
//                webView.loadUrl(indikator.getLink());
                webView.loadUrl(webView.getUrl());
                frameLayoutNoInternet.setVisibility(View.GONE);
                frameLayoutLoading.setVisibility(View.VISIBLE);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indikator.getKategori().equalsIgnoreCase("5")||indikator.getKategori().equalsIgnoreCase("6")){
                    Toast.makeText(getApplicationContext(), "Maaf data series tahunan belum tersedia", Toast.LENGTH_LONG).show();
                }else{
                    Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH);
                    int day = calendar.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog datePickerDialog = new DatePickerDialog(WebActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, onDateSetListener, year, month, day);
                    datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    datePickerDialog.show();
                }

            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Log.d("DATEPICKER i = ", String.valueOf(i));
                Log.d("DATEPICKER i1 = ", String.valueOf(i1));
                Log.d("DATEPICKER i2 = ", String.valueOf(i2));

                webView.loadUrl(webView.getUrl()+"&tahun="+i);
                frameLayoutNoInternet.setVisibility(View.GONE);
                frameLayoutLoading.setVisibility(View.VISIBLE);


            }
        };

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
