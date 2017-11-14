package com.virtualbox.torchick.rog.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.virtualbox.torchick.rog.Activity.PublikasiActivity;
import com.virtualbox.torchick.rog.Model.Istilah;
import com.virtualbox.torchick.rog.Model.Publikasi;
import com.virtualbox.torchick.rog.R;

import java.util.List;

/**
 * Created by Torchick on 27/03/2017.
 */

public class IstilahAdapter extends RecyclerView.Adapter<IstilahAdapter.MyViewHolder> {
    private List<Istilah> istilahList;
    private Context mContext;
    private int[] bg_id = {R.drawable.bg_circle__dark_blue, R.drawable.bg_circle_black, R.drawable.bg_circle_blue, R.drawable.bg_circle_magenta,
    R.drawable.bg_circle_orange_2, R.drawable.bg_circle_pink, R.drawable.bg_circle_red, R.drawable.bg_circle_tosca};

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView judul, tanggal_rilis, first_letter;
        public RelativeLayout relative_layout_row;
        public ImageView cover_img;


        public MyViewHolder(View view) {
            super(view);
            first_letter = (TextView) view.findViewById(R.id.first_letter);
            judul = (TextView) view.findViewById(R.id.judul);
            tanggal_rilis = (TextView) view.findViewById(R.id.tanggal_rilis);
            relative_layout_row = (RelativeLayout) view.findViewById(R.id.relative_layout_row);
            cover_img = (ImageView) view.findViewById(R.id.cover_img);
        }
    }

    public IstilahAdapter(List<Istilah> istilahList, Context mContext) {
        this.istilahList = istilahList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.indikator_list_row_ensiklopedia, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Istilah istilah = istilahList.get(position);
        holder.judul.setText(istilah.getNama());
        holder.tanggal_rilis.setText("20-05-2017");
        holder.first_letter.setText(istilah.getNama().substring(0,1));

        applyCoverPicture(holder, istilah);
        // apply click events
        applyClickEvents(holder, position);

    }

    private void applyClickEvents(MyViewHolder holder, final int position) {
        holder.relative_layout_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i =  new Intent(mContext, PublikasiActivity.class);
//                Istilah p = istilahList.get(position);
//                i.putExtra("istilah", p);
//                mContext.startActivity(i);

                Istilah p = istilahList.get(position);
                new AlertDialog.Builder(mContext)
                        .setTitle(p.getNama())
                        .setMessage(stripHtml(p.getKeterangan()))
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setIcon(R.drawable.ic_idea)
                        .show();


            }
        });

    }

    private String stripHtml(String html) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            if(html==null){
                return "";
            }else{
                return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY).toString();
            }
        } else {
            if(html==null){
                return "";
            }else{
                return Html.fromHtml(html).toString();
            }
        }
    }

    @Override
    public int getItemCount() {
        return istilahList.size();
    }

    private void applyCoverPicture(MyViewHolder holder, Istilah istilah) {
        int first_character = Character.getNumericValue(istilah.getNama().charAt(0));
        int modulo = Math.abs(first_character%bg_id.length);


        holder.cover_img.setImageResource(bg_id[modulo]);

//        if (!TextUtils.isEmpty(publikasi.getFile_cover())) {
//            Glide.with(mContext).load("https://sultra.bps.go.id/website/cover_publikasi/"+publikasi.getFile_cover())
//                    .placeholder(R.drawable.not_available)
//                    .centerCrop()
//                    .crossFade()
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .into(holder.cover_img);
//            holder.cover_img.setColorFilter(null);
//        }

    }

}
