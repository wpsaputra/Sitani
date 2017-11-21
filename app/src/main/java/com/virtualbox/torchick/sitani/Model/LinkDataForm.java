package com.virtualbox.torchick.sitani.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 17/05/2017.
 */

public class LinkDataForm implements Parcelable {
    String id_link;
    String judul;
    String wilayah;
    String variabel;
    String subjek;
    String tahun;
    String id_kec;
    String id_kab;
    String id_prop;
    String tgl_ubah;

    public LinkDataForm() {
    }

    public String getId_link() {
        return id_link;
    }

    public void setId_link(String id_link) {
        this.id_link = id_link;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }

    public String getVariabel() {
        return variabel;
    }

    public void setVariabel(String variabel) {
        this.variabel = variabel;
    }

    public String getSubjek() {
        return subjek;
    }

    public void setSubjek(String subjek) {
        this.subjek = subjek;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getId_kec() {
        return id_kec;
    }

    public void setId_kec(String id_kec) {
        this.id_kec = id_kec;
    }

    public String getId_kab() {
        return id_kab;
    }

    public void setId_kab(String id_kab) {
        this.id_kab = id_kab;
    }

    public String getId_prop() {
        return id_prop;
    }

    public void setId_prop(String id_prop) {
        this.id_prop = id_prop;
    }

    public String getTgl_ubah() {
        return tgl_ubah;
    }

    public void setTgl_ubah(String tgl_ubah) {
        this.tgl_ubah = tgl_ubah;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id_link);
        dest.writeString(this.judul);
        dest.writeString(this.wilayah);
        dest.writeString(this.variabel);
        dest.writeString(this.subjek);
        dest.writeString(this.tahun);
        dest.writeString(this.id_kec);
        dest.writeString(this.id_kab);
        dest.writeString(this.id_prop);
        dest.writeString(this.tgl_ubah);
    }

    protected LinkDataForm(Parcel in) {
        this.id_link = in.readString();
        this.judul = in.readString();
        this.wilayah = in.readString();
        this.variabel = in.readString();
        this.subjek = in.readString();
        this.tahun = in.readString();
        this.id_kec = in.readString();
        this.id_kab = in.readString();
        this.id_prop = in.readString();
        this.tgl_ubah = in.readString();
    }

    public static final Parcelable.Creator<LinkDataForm> CREATOR = new Parcelable.Creator<LinkDataForm>() {
        @Override
        public LinkDataForm createFromParcel(Parcel source) {
            return new LinkDataForm(source);
        }

        @Override
        public LinkDataForm[] newArray(int size) {
            return new LinkDataForm[size];
        }
    };
}
