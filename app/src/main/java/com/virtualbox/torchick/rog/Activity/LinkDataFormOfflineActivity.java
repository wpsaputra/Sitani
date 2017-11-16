package com.virtualbox.torchick.rog.Activity;

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

import com.virtualbox.torchick.rog.Adapter.IndikatorAdapter;
import com.virtualbox.torchick.rog.Adapter.LinkDataFormAdapter;
import com.virtualbox.torchick.rog.Database.ModelIndikator;
import com.virtualbox.torchick.rog.Model.Indikator;
import com.virtualbox.torchick.rog.Model.LinkDataForm;
import com.virtualbox.torchick.rog.Network.ApiClientLink;
import com.virtualbox.torchick.rog.Network.ApiInterface;
import com.virtualbox.torchick.rog.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LinkDataFormOfflineActivity extends AppCompatActivity {

    // Custom
    private List<Indikator> indikatorList = new ArrayList<>();
    private RecyclerView recyclerView;
    private IndikatorAdapter indikatorAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    String idLink;
    private Bitmap icon;
    private Bitmap circle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_data_form_offline);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        idLink = getIntent().getStringExtra("idLink");
        if(idLink.equalsIgnoreCase("99")){
            icon = getIntent().getParcelableExtra("icon");
            circle = getIntent().getParcelableExtra("circle");
        }else{
            icon = null;
            circle = null;
        }


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);

        indikatorAdapter = new IndikatorAdapter(indikatorList, this, icon, circle);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        recyclerView.setAdapter(indikatorAdapter);

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

    }

    private void getLinkDataForm() {
        swipeRefreshLayout.setRefreshing(true);

        ModelIndikator mp = new ModelIndikator(this);
//        List<Indikator> lp = mp.getAll();
        List<Indikator> lp;

//        if(idLink.equalsIgnoreCase("99")){
//            lp = mp.getSensusEkonomiAll();
//        }else if(idLink.equalsIgnoreCase("90")) {
//            lp = mp.getIndikatorPropAll();
//        }else {
//            lp = mp.getIndikatorKabAll();
//        }
        lp = mp.getIndikatorByKategori(idLink);


        indikatorList.clear();

        for(int i=0; i<lp.size(); i++){
            System.out.println(lp.get(i));
            indikatorList.add(lp.get(i));
        }



        indikatorAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);



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
