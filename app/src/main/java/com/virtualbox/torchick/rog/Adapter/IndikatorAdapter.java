package com.virtualbox.torchick.rog.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.virtualbox.torchick.rog.Activity.WebActivity;
import com.virtualbox.torchick.rog.Activity.WebOfflineActivity;
import com.virtualbox.torchick.rog.Model.Indikator;
import com.virtualbox.torchick.rog.Model.LinkDataForm;
import com.virtualbox.torchick.rog.R;

import java.util.List;

/**
 * Created by Torchick on 27/03/2017.
 */

public class IndikatorAdapter extends RecyclerView.Adapter<IndikatorAdapter.MyViewHolder> {
    private List<Indikator> indikatorList;
    private Context mContext;
    private Bitmap icon, circle;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView cover_img, icon_img;
        public TextView judul, tanggal_rilis;
        public RelativeLayout relative_layout_row;

        public MyViewHolder(View view) {
            super(view);
            cover_img = (ImageView) view.findViewById(R.id.cover_img);
            icon_img = (ImageView) view.findViewById(R.id.icon_img);
            judul = (TextView) view.findViewById(R.id.judul);
            tanggal_rilis = (TextView) view.findViewById(R.id.tanggal_rilis);
            relative_layout_row = (RelativeLayout) view.findViewById(R.id.relative_layout_row);
        }
    }

    public IndikatorAdapter(List<Indikator> indikatorList, Context mContext, Bitmap icon, Bitmap circle) {
        this.indikatorList = indikatorList;
        this.icon = icon;
        this.circle = circle;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.indikator_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Indikator indikator = indikatorList.get(position);
        holder.judul.setText(indikator.getIndikator());
        holder.tanggal_rilis.setText(indikator.getSatuan());

        applyCoverPicture(holder, indikator);
        // apply click events
        applyClickEvents(holder, position);

    }

    private void applyClickEvents(MyViewHolder holder, final int position) {
        holder.relative_layout_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i =  new Intent(mContext, WebOfflineActivity.class);
                Intent i =  new Intent(mContext, WebActivity.class);
                Indikator indikator = indikatorList.get(position);
                i.putExtra("indikator", indikator);
                mContext.startActivity(i);


//                Intent i =  new Intent(mContext, WebActivity.class);
//                Indikator indikator = indikatorList.get(position);
//                i.putExtra("linkDataForm", indikator);
//                mContext.startActivity(i);






            }
        });

    }

    @Override
    public int getItemCount() {
        return indikatorList.size();
    }

    private void applyCoverPicture(MyViewHolder holder, Indikator indikator) {
        int id_circle = mContext.getResources().getIdentifier(indikator.getCircle(), "drawable", mContext.getPackageName());
        int id_icon = mContext.getResources().getIdentifier(indikator.getIcon(), "drawable", mContext.getPackageName());
//        imageView.setImageResource(id);

        if(indikator.getKategori().equalsIgnoreCase("99")){
            if(icon!=null&&circle!=null){
                holder.icon_img.setColorFilter(Color.TRANSPARENT);

                holder.cover_img.setImageBitmap(circle);
                holder.icon_img.setImageBitmap(icon);
            }

        }else{
            holder.cover_img.setImageResource(id_circle);
            holder.icon_img.setImageResource(id_icon);

        }



//        if(icon!=null&&circle!=null){
//            holder.cover_img.setImageBitmap(circle);
//            holder.icon_img.setImageBitmap(icon);
//        }



    }

}
