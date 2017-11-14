package com.virtualbox.torchick.rog.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Torchick on 23/05/2017.
 */

public class Istilah implements Parcelable {
    private int id, flag;
    private String nama, keterangan;

    public Istilah() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.flag);
        dest.writeString(this.nama);
        dest.writeString(this.keterangan);
    }

    protected Istilah(Parcel in) {
        this.id = in.readInt();
        this.flag = in.readInt();
        this.nama = in.readString();
        this.keterangan = in.readString();
    }

    public static final Parcelable.Creator<Istilah> CREATOR = new Parcelable.Creator<Istilah>() {
        @Override
        public Istilah createFromParcel(Parcel source) {
            return new Istilah(source);
        }

        @Override
        public Istilah[] newArray(int size) {
            return new Istilah[size];
        }
    };
}
