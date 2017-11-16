package com.virtualbox.torchick.rog.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 21/05/2017.
 */

public class Indikator implements Parcelable {
    private int id, offline;
    private String indikator, satuan, kategori, circle, icon, link;

    public Indikator() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOffline() {
        return offline;
    }

    public void setOffline(int offline) {
        this.offline = offline;
    }

    public String getIndikator() {
        return indikator;
    }

    public void setIndikator(String indikator) {
        this.indikator = indikator;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.offline);
        dest.writeString(this.indikator);
        dest.writeString(this.satuan);
        dest.writeString(this.kategori);
        dest.writeString(this.circle);
        dest.writeString(this.icon);
        dest.writeString(this.link);
    }

    protected Indikator(Parcel in) {
        this.id = in.readInt();
        this.offline = in.readInt();
        this.indikator = in.readString();
        this.satuan = in.readString();
        this.kategori = in.readString();
        this.circle = in.readString();
        this.icon = in.readString();
        this.link = in.readString();
    }

    public static final Creator<Indikator> CREATOR = new Creator<Indikator>() {
        @Override
        public Indikator createFromParcel(Parcel source) {
            return new Indikator(source);
        }

        @Override
        public Indikator[] newArray(int size) {
            return new Indikator[size];
        }
    };
}
