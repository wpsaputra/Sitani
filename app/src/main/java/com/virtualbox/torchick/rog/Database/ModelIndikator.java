package com.virtualbox.torchick.rog.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.virtualbox.torchick.rog.Model.Indikator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo 17 on 4/27/2016.
 */
public class ModelIndikator extends Model{
    String[] col = {"_id", "indikator", "satuan", "kategori", "circle", "icon", "offline", "link"};

    public ModelIndikator(Context ctx) {
        super(ctx);
        // To do create table Publikasi in db sidewi

        this.setTableName("indikator");
    }

    public List<Indikator> getAll(){
        List<Indikator> data = new ArrayList<Indikator>();
        Cursor c = super.getAll(col);
        c.moveToFirst();
        while(!c.isAfterLast()){
            Indikator p = new Indikator();
            p.setId(c.getInt(c.getColumnIndex("_id")));
            p.setOffline(c.getInt(c.getColumnIndex("offline")));
            p.setIndikator(c.getString(c.getColumnIndex("indikator")));
            p.setSatuan(c.getString(c.getColumnIndex("satuan")));
            p.setKategori(c.getString(c.getColumnIndex("kategori")));
            p.setCircle(c.getString(c.getColumnIndex("circle")));
            p.setIcon(c.getString(c.getColumnIndex("icon")));
            p.setLink(c.getString(c.getColumnIndex("link")));


            data.add(p);
            c.moveToNext();
        }
        super.closeDB();

        return data;
    }

    public List<Indikator> getIndikatorByKategori(String kategori){
        List<Indikator> data = new ArrayList<Indikator>();
        Cursor c = super.getAll(col);
        c.moveToFirst();
        while(!c.isAfterLast()){
            Indikator p = new Indikator();
            p.setId(c.getInt(c.getColumnIndex("_id")));
            p.setOffline(c.getInt(c.getColumnIndex("offline")));
            p.setIndikator(c.getString(c.getColumnIndex("indikator")));
            p.setSatuan(c.getString(c.getColumnIndex("satuan")));
            p.setKategori(c.getString(c.getColumnIndex("kategori")));
            p.setCircle(c.getString(c.getColumnIndex("circle")));
            p.setIcon(c.getString(c.getColumnIndex("icon")));
            p.setLink(c.getString(c.getColumnIndex("link")));


            if(p.getKategori().equalsIgnoreCase(kategori)){
                data.add(p);
            }
            c.moveToNext();
        }
        super.closeDB();

        return data;
    }

    public List<Indikator> getSensusEkonomiAll(){
        List<Indikator> data = new ArrayList<Indikator>();
        Cursor c = super.getAll(col);
        c.moveToFirst();
        while(!c.isAfterLast()){
            Indikator p = new Indikator();
            p.setId(c.getInt(c.getColumnIndex("_id")));
            p.setOffline(c.getInt(c.getColumnIndex("offline")));
            p.setIndikator(c.getString(c.getColumnIndex("indikator")));
            p.setSatuan(c.getString(c.getColumnIndex("satuan")));
            p.setKategori(c.getString(c.getColumnIndex("kategori")));
            p.setCircle(c.getString(c.getColumnIndex("circle")));
            p.setIcon(c.getString(c.getColumnIndex("icon")));
            p.setLink(c.getString(c.getColumnIndex("link")));


            if(p.getKategori().equalsIgnoreCase("99")){
                data.add(p);
            }
            c.moveToNext();
        }
        super.closeDB();

        return data;
    }

    public List<Indikator> getIndikatorPropAll(){
        List<Indikator> data = new ArrayList<Indikator>();
        Cursor c = super.getAll(col);
        c.moveToFirst();
        while(!c.isAfterLast()){
            Indikator p = new Indikator();
            p.setId(c.getInt(c.getColumnIndex("_id")));
            p.setOffline(c.getInt(c.getColumnIndex("offline")));
            p.setIndikator(c.getString(c.getColumnIndex("indikator")));
            p.setSatuan(c.getString(c.getColumnIndex("satuan")));
            p.setKategori(c.getString(c.getColumnIndex("kategori")));
            p.setCircle(c.getString(c.getColumnIndex("circle")));
            p.setIcon(c.getString(c.getColumnIndex("icon")));
            p.setLink(c.getString(c.getColumnIndex("link")));


            if(p.getId()>=1 && p.getId()<=30){
                data.add(p);
            }
            c.moveToNext();
        }
        super.closeDB();

        return data;
    }

    public List<Indikator> getIndikatorKabAll(){
        List<Indikator> data = new ArrayList<Indikator>();
        Cursor c = super.getAll(col);
        c.moveToFirst();
        while(!c.isAfterLast()){
            Indikator p = new Indikator();
            p.setId(c.getInt(c.getColumnIndex("_id")));
            p.setOffline(c.getInt(c.getColumnIndex("offline")));
            p.setIndikator(c.getString(c.getColumnIndex("indikator")));
            p.setSatuan(c.getString(c.getColumnIndex("satuan")));
            p.setKategori(c.getString(c.getColumnIndex("kategori")));
            p.setCircle(c.getString(c.getColumnIndex("circle")));
            p.setIcon(c.getString(c.getColumnIndex("icon")));
            p.setLink(c.getString(c.getColumnIndex("link")));


            if(p.getId()>=61){
                data.add(p);
            }
            c.moveToNext();
        }
        super.closeDB();

        return data;
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
//    public Publikasi getById(int id_cari){
//        Publikasi p = new Publikasi();
//        Cursor c = super.getById("_id",id_cari, this.col);
//        c.moveToFirst();
//
//        p.setId_publikasi(c.getInt(c.getColumnIndex("_id")));
//        p.setJudul_ind(c.getString(c.getColumnIndex("judul_ind")));
//        p.setJudul_eng(c.getString(c.getColumnIndex("judul_eng")));
//        p.setIsbn(c.getString(c.getColumnIndex("isbn")));
//        p.setNo_katalog(c.getString(c.getColumnIndex("no_katalog")));
//        p.setNo_publikasi(c.getString(c.getColumnIndex("no_publikasi")));
//
//        p.setPeriode_ind(c.getString(c.getColumnIndex("periode_ind")));
//        p.setPeriode_eng(c.getString(c.getColumnIndex("periode_eng")));
//        p.setBahasa_publikasi_ind(c.getString(c.getColumnIndex("bahasa_publikasi_ind")));
//        p.setBahasa_publikasi_eng(c.getString(c.getColumnIndex("bahasa_publikasi_eng")));
//
//        p.setAbstrak_ind(c.getString(c.getColumnIndex("abstrak_ind")));
//        p.setAbstrak_eng(c.getString(c.getColumnIndex("abstrak_eng")));
//        p.setTgl_jadwal(c.getString(c.getColumnIndex("tgl_jadwal")));
//        p.setTgl_masuk(c.getString(c.getColumnIndex("tgl_masuk")));
//        p.setTgl_rilis(c.getString(c.getColumnIndex("tgl_rilis")));
//        p.setTgl_update(c.getString(c.getColumnIndex("tgl_update")));
//
//        p.setFile_cover(c.getString(c.getColumnIndex("file_cover")));
//        p.setFile_flipping(c.getString(c.getColumnIndex("file_flipping")));
////        p.setFlag(c.getString(c.getColumnIndex("flag")));
//        p.setHit(c.getString(c.getColumnIndex("hit")));
//        p.setFile_pdf(c.getString(c.getColumnIndex("file_pdf")));
//        p.setKeterangan_ind(c.getString(c.getColumnIndex("keterangan_ind")));
//
//        p.setKeterangan_eng(c.getString(c.getColumnIndex("keterangan_eng")));
////        p.setFlag_utama(c.getString(c.getColumnIndex("flag_utama")));
//
//        return p;
//    }
//
//    public void update(Publikasi p){
//        ContentValues cv = new ContentValues();
//
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
//        super.update("_id", p.getId_publikasi(), cv);
//    }


}
