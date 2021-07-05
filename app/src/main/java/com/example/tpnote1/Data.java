package com.example.tpnote1;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    protected String activity;
    protected Integer revenue;

    Data(String activity, Integer revenue){
        this.activity = activity;
        this.revenue = revenue;
    }
    Data(Parcel in){
        this.activity = in.readString();
        this.revenue = in.readInt();
    }
    public String getActivity() {
        return this.activity;
    }

    public Integer getRevenue() {
        return this.revenue;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.activity);
        dest.writeInt(this.revenue);
    }
    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel source){
            return new Data(source);
        }
        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
