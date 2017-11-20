package com.virtualbox.torchick.rog.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.virtualbox.torchick.rog.Model.Indikator;
import com.virtualbox.torchick.rog.Model.Login;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo 17 on 4/27/2016.
 */
public class ModelLogin extends Model{
    String[] col = {"_id", "status", "flag"};

    public ModelLogin(Context ctx) {
        super(ctx);
        // To do create table Publikasi in db sidewi

        this.setTableName("login");
    }


//    public void insert(Publikasi p){
//        ContentValues cv = new ContentValues();
//        cv.put("_id", p.getId_publikasi());
//        cv.put("judul_ind", p.getJudul_ind());
//        cv.put("judul_eng", p.getJudul_eng());
//        cv.put("isbn", p.getIsbn());
//        cv.put("no_katalog", p.getNo_katalog());
//        cv.put("no_publikasi", p.getNo_publikasi());
//
//        cv.put("periode_ind", p.getPeriode_ind());
//        cv.put("periode_eng", p.getPeriode_eng());
//        cv.put("bahasa_publikasi_ind", p.getBahasa_publikasi_ind());
//        cv.put("bahasa_publikasi_eng", p.getBahasa_publikasi_eng());
//
//        cv.put("abstrak_ind", p.getAbstrak_ind());
//        cv.put("abstrak_eng", p.getAbstrak_eng());
//        cv.put("tgl_jadwal", p.getTgl_jadwal());
//        cv.put("tgl_masuk", p.getTgl_masuk());
//        cv.put("tgl_rilis", p.getTgl_rilis());
//        cv.put("tgl_update", p.getTgl_update());
//
//        cv.put("file_cover", p.getFile_cover());
//        cv.put("file_flipping", p.getFile_flipping());
//        cv.put("flag", p.isFlag());
//        cv.put("hit", p.getHit());
//        cv.put("file_pdf", p.getFile_pdf());
//        cv.put("keterangan_ind", p.getKeterangan_ind());
//
//        cv.put("keterangan_eng", p.getKeterangan_eng());
//        cv.put("flag_utama", p.isFlag_utama());
//
//        super.insert(cv, "");
//    }
//
//    public void delete(int id){
//        super.delete("_id", id);
//    }
//
    public Login getById(int id_cari){
        Login p = new Login();
        Cursor c = super.getById("_id",id_cari, this.col);
        c.moveToFirst();

        p.setId(c.getInt(c.getColumnIndex("_id")));
        p.setStatus(c.getString(c.getColumnIndex("status")));
        p.setFlag(c.getInt(c.getColumnIndex("flag")));

        return p;
    }

    public void update(Login p){
        ContentValues cv = new ContentValues();

        cv.put("_id", p.getId());
        cv.put("status", p.getStatus());
        cv.put("flag", p.getFlag());

        super.update("_id", p.getId(), cv);
    }


}
