package com.virtualbox.torchick.sitani.Activity;

import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.virtualbox.torchick.sitani.Adapter.LinkDataFormAdapter;
import com.virtualbox.torchick.sitani.Model.LinkDataForm;
import com.virtualbox.torchick.sitani.Network.ApiClientLink;
import com.virtualbox.torchick.sitani.Network.ApiInterface;
import com.virtualbox.torchick.sitani.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LinkDataFormSearchActivity extends AppCompatActivity {

    // Custom
    private List<LinkDataForm> linkDataFormList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LinkDataFormAdapter linkDataFormAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String link;

    private Bitmap icon;
    private Bitmap circle;

    private FrameLayout frameLayout, frameLayoutNotFound;
    private Button noInternetButton, backButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_data_form_search);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        link = getIntent().getStringExtra("link");
        icon = null;
        circle = null;

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        noInternetButton = (Button) findViewById(R.id.no_internet_button);
        frameLayoutNotFound = (FrameLayout) findViewById(R.id.frame_layout_not_found);
        backButton = (Button) findViewById(R.id.back_button);


        linkDataFormAdapter = new LinkDataFormAdapter(linkDataFormList, this, icon, circle);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(linkDataFormAdapter);

        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                getLinkDataForm();
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getLinkDataForm();
            }
        });
        noInternetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLinkDataForm();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void getLinkDataForm() {
        swipeRefreshLayout.setRefreshing(true);

        ApiInterface apiService =
                ApiClientLink.getClient().create(ApiInterface.class);

        Call<List<LinkDataForm>> call = apiService.getLinkDataFormSearch(link);
        call.enqueue(new Callback<List<LinkDataForm>>() {
            @Override
            public void onResponse(Call<List<LinkDataForm>> call, Response<List<LinkDataForm>> response) {
                // clear the inbox
                linkDataFormList.clear();

                // add all the messages
                linkDataFormList.addAll(response.body());

                // if search found no result
                if(linkDataFormList.size()==0){
                    frameLayoutNotFound.setVisibility(View.VISIBLE);
                }

                linkDataFormAdapter.notifyDataSetChanged();
                frameLayout.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<LinkDataForm>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Unable to fetch json: " + t.getMessage(), Toast.LENGTH_LONG).show();
                frameLayout.setVisibility(View.VISIBLE);
                swipeRefreshLayout.setRefreshing(false);
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
