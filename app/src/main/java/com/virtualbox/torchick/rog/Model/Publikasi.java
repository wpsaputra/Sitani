package com.virtualbox.torchick.rog.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Torchick on 27/03/2017.
 */

public class Publikasi implements Parcelable {
    private int id_publikasi;
    private String judul_ind;
    private String judul_eng;
    private String isbn;
    private String no_katalog;
    private String no_publikasi;
    private String periode_ind;
    private String periode_eng;
    private String bahasa_publikasi_ind;
    private String bahasa_publikasi_eng;
    private String abstrak_ind;
    private String abstrak_eng;
    private String tgl_jadwal;
    private String tgl_masuk;
    private String tgl_rilis;
    private String tgl_update;
    private String file_cover;
    private String file_flipping;
    private boolean flag;
    private String hit;
    private String file_pdf;
    private String keterangan_ind;
    private String keterangan_eng;
    private boolean flag_utama;

    public Publikasi() {
    }

    public int getId_publikasi() {
        return id_publikasi;
    }

    public void setId_publikasi(int id_publikasi) {
        this.id_publikasi = id_publikasi;
    }

    public String getJudul_ind() {
        return judul_ind;
    }

    public void setJudul_ind(String judul_ind) {
        this.judul_ind = judul_ind;
    }

    public String getJudul_eng() {
        return judul_eng;
    }

    public void setJudul_eng(String judul_eng) {
        this.judul_eng = judul_eng;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNo_katalog() {
        return no_katalog;
    }

    public void setNo_katalog(String no_katalog) {
        this.no_katalog = no_katalog;
    }

    public String getNo_publikasi() {
        return no_publikasi;
    }

    public void setNo_publikasi(String no_publikasi) {
        this.no_publikasi = no_publikasi;
    }

    public String getPeriode_ind() {
        return periode_ind;
    }

    public void setPeriode_ind(String periode_ind) {
        this.periode_ind = periode_ind;
    }

    public String getPeriode_eng() {
        return periode_eng;
    }

    public void setPeriode_eng(String periode_eng) {
        this.periode_eng = periode_eng;
    }

    public String getBahasa_publikasi_ind() {
        return bahasa_publikasi_ind;
    }

    public void setBahasa_publikasi_ind(String bahasa_publikasi_ind) {
        this.bahasa_publikasi_ind = bahasa_publikasi_ind;
    }

    public String getBahasa_publikasi_eng() {
        return bahasa_publikasi_eng;
    }

    public void setBahasa_publikasi_eng(String bahasa_publikasi_eng) {
        this.bahasa_publikasi_eng = bahasa_publikasi_eng;
    }

    public String getAbstrak_ind() {
        return abstrak_ind;
    }

    public void setAbstrak_ind(String abstrak_ind) {
        this.abstrak_ind = abstrak_ind;
    }

    public String getAbstrak_eng() {
        return abstrak_eng;
    }

    public void setAbstrak_eng(String abstrak_eng) {
        this.abstrak_eng = abstrak_eng;
    }

    public String getTgl_jadwal() {
        return tgl_jadwal;
    }

    public void setTgl_jadwal(String tgl_jadwal) {
        this.tgl_jadwal = tgl_jadwal;
    }

    public String getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    public String getTgl_rilis() {
        return tgl_rilis;
    }

    public void setTgl_rilis(String tgl_rilis) {
        this.tgl_rilis = tgl_rilis;
    }

    public String getTgl_update() {
        return tgl_update;
    }

    public void setTgl_update(String tgl_update) {
        this.tgl_update = tgl_update;
    }

    public String getFile_cover() {
        return file_cover;
    }

    public void setFile_cover(String file_cover) {
        this.file_cover = file_cover;
    }

    public String getFile_flipping() {
        return file_flipping;
    }

    public void setFile_flipping(String file_flipping) {
        this.file_flipping = file_flipping;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getHit() {
        return hit;
    }

    public void setHit(String hit) {
        this.hit = hit;
    }

    public String getFile_pdf() {
        return file_pdf;
    }

    public void setFile_pdf(String file_pdf) {
        this.file_pdf = file_pdf;
    }

    public String getKeterangan_ind() {
        return keterangan_ind;
    }

    public void setKeterangan_ind(String keterangan_ind) {
        this.keterangan_ind = keterangan_ind;
    }

    public String getKeterangan_eng() {
        return keterangan_eng;
    }

    public void setKeterangan_eng(String keterangan_eng) {
        this.keterangan_eng = keterangan_eng;
    }

    public boolean isFlag_utama() {
        return flag_utama;
    }

    public void setFlag_utama(boolean flag_utama) {
        this.flag_utama = flag_utama;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id_publikasi);
        dest.writeString(this.judul_ind);
        dest.writeString(this.judul_eng);
        dest.writeString(this.isbn);
        dest.writeString(this.no_katalog);
        dest.writeString(this.no_publikasi);
        dest.writeString(this.periode_ind);
        dest.writeString(this.periode_eng);
        dest.writeString(this.bahasa_publikasi_ind);
        dest.writeString(this.bahasa_publikasi_eng);
        dest.writeString(this.abstrak_ind);
        dest.writeString(this.abstrak_eng);
        dest.writeString(this.tgl_jadwal);
        dest.writeString(this.tgl_masuk);
        dest.writeString(this.tgl_rilis);
        dest.writeString(this.tgl_update);
        dest.writeString(this.file_cover);
        dest.writeString(this.file_flipping);
        dest.writeByte(this.flag ? (byte) 1 : (byte) 0);
        dest.writeString(this.hit);
        dest.writeString(this.file_pdf);
        dest.writeString(this.keterangan_ind);
        dest.writeString(this.keterangan_eng);
        dest.writeByte(this.flag_utama ? (byte) 1 : (byte) 0);
    }

    protected Publikasi(Parcel in) {
        this.id_publikasi = in.readInt();
        this.judul_ind = in.readString();
        this.judul_eng = in.readString();
        this.isbn = in.readString();
        this.no_katalog = in.readString();
        this.no_publikasi = in.readString();
        this.periode_ind = in.readString();
        this.periode_eng = in.readString();
        this.bahasa_publikasi_ind = in.readString();
        this.bahasa_publikasi_eng = in.readString();
        this.abstrak_ind = in.readString();
        this.abstrak_eng = in.readString();
        this.tgl_jadwal = in.readString();
        this.tgl_masuk = in.readString();
        this.tgl_rilis = in.readString();
        this.tgl_update = in.readString();
        this.file_cover = in.readString();
        this.file_flipping = in.readString();
        this.flag = in.readByte() != 0;
        this.hit = in.readString();
        this.file_pdf = in.readString();
        this.keterangan_ind = in.readString();
        this.keterangan_eng = in.readString();
        this.flag_utama = in.readByte() != 0;
    }

    public static final Creator<Publikasi> CREATOR = new Creator<Publikasi>() {
        @Override
        public Publikasi createFromParcel(Parcel source) {
            return new Publikasi(source);
        }

        @Override
        public Publikasi[] newArray(int size) {
            return new Publikasi[size];
        }
    };

    @Override
    public String toString() {
        return this.judul_ind;
    }
}
