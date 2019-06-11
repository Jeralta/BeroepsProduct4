package com.example.bp4.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bp4.R;

public class Les implements Parcelable {

    public static final Parcelable.Creator<Les> CREATOR = new Parcelable.Creator<Les>() {
        public Les createFromParcel(Parcel in) {
            return new Les(in);
        }

        public Les[] newArray(int size) {
            return new Les[size];
        }
    };
    private String IDLES;
    private String WEEK;
    private String DAG;
    private String UUR;
    private String BUURTHUIS_TELNR;
    private String VRIJWILLIGER_EMAIL;

    public Les (Parcel in){
        this.IDLES = in.readString();
        this.WEEK = in.readString();
        this.DAG = in.readString();
        this.UUR = in.readString();
        this.BUURTHUIS_TELNR = in.readString();
        this.VRIJWILLIGER_EMAIL = in.readString();
    }

public Les(){}
    public Les(String IDLES, String WEEK, String DAG, String UUR, String BUURTHUIS_TELNR, String VRIJWILLIGER_EMAIL) {

        this.IDLES = IDLES;
        this.WEEK = WEEK;
        this.DAG = DAG;
        this.UUR = UUR;
        this.BUURTHUIS_TELNR = BUURTHUIS_TELNR;
        this.VRIJWILLIGER_EMAIL = VRIJWILLIGER_EMAIL;
    }
    // getters and setters van strings
    public String getIDLES() {
        return IDLES;
    }

    public void setIDLES(String IDLES) {
        this.IDLES = IDLES;
    }

    public String getWEEK() {
        return WEEK;
    }

    public void setWEEK(String WEEK) {
        this.WEEK = WEEK;
    }

    public String getDAG() {
        return DAG;
    }

    public void setDAG(String DAG) {
        this.DAG = DAG;
    }

    public String getUUR() {
        return UUR;
    }

    public void setUUR(String UUR) {
        this.UUR = UUR;
    }

    public String getBUURTHUIS_TELNR() {
        return BUURTHUIS_TELNR;
    }

    public void setBUURTHUIS_TELNR(String BUURTHUIS_TELNR) {
        this.BUURTHUIS_TELNR = BUURTHUIS_TELNR;
    }

    public String getVRIJWILLIGER_EMAIL() {
        return VRIJWILLIGER_EMAIL;
    }

    public void setVRIJWILLIGER_EMAIL(String VRIJWILLIGER_EMAIL) {
        this.VRIJWILLIGER_EMAIL = VRIJWILLIGER_EMAIL;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // Write data in any order
        dest.writeString(IDLES);
        dest.writeString(WEEK);
        dest.writeString(DAG);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
