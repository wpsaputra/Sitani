package com.virtualbox.torchick.rog.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.virtualbox.torchick.rog.R;

import java.io.FileNotFoundException;

public class PdfReaderActivity extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener {
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);
        pdfView = (PDFView) findViewById(R.id.pdfView);
        displayFromUri();
    }

    @SuppressLint("NewApi")
    private void displayFromUri() {
        Intent intent = getIntent();
        Uri uri = intent.getData();
        Log.d("PDF", "WORKING");

        try {
            pdfView.fromStream(getContentResolver().openInputStream(uri))
                    .defaultPage(0)
                    .onPageChange(this)
                    .enableAnnotationRendering(true)
                    .onLoad(this)
                    .scrollHandle(new DefaultScrollHandle(this))
                    .load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error opening PDF file make sure file is not corrupted", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void loadComplete(int nbPages) {

    }

    @Override
    public void onPageChanged(int page, int pageCount) {

    }
}
