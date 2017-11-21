package com.virtualbox.torchick.sitani.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Torchick on 11/21/2017.
 */

public class Login implements Parcelable {
    int id, flag;
    String status;

    public Login() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.flag);
        dest.writeString(this.status);
    }

    protected Login(Parcel in) {
        this.id = in.readInt();
        this.flag = in.readInt();
        this.status = in.readString();
    }

    public static final Parcelable.Creator<Login> CREATOR = new Parcelable.Creator<Login>() {
        @Override
        public Login createFromParcel(Parcel source) {
            return new Login(source);
        }

        @Override
        public Login[] newArray(int size) {
            return new Login[size];
        }
    };
}
