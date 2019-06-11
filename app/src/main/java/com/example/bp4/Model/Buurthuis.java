package com.example.bp4.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bp4.R;

public class Buurthuis implements Parcelable {

    public static final Parcelable.Creator<Buurthuis> CREATOR = new Parcelable.Creator<Buurthuis>() {
        public Buurthuis createFromParcel(Parcel in) {
            return new Buurthuis(in);
        }

        public Buurthuis[] newArray(int size) {
            return new Buurthuis[size];
        }
    };
    private String TELNR;
    private String NAAM;
    private String ADRES;
    private String POSTCODE;
    private String CONTACTPERSOON;
    private String PLAATS;

    public  Buurthuis (Parcel in){
        this.TELNR = in.readString();
        this.NAAM = in.readString();
        this.ADRES = in.readString();
        this.POSTCODE = in.readString();
        this.CONTACTPERSOON = in.readString();
        this.PLAATS = in.readString();
    }

    public Buurthuis(){}

    public Buurthuis (String TELNR, String NAAM, String ADRES, String POSTCODE, String CONTACTPERSOON, String PLAATS){
        this.TELNR = TELNR;
        this.NAAM = NAAM;
        this.ADRES = ADRES;
        this.POSTCODE = POSTCODE;
        this.CONTACTPERSOON = CONTACTPERSOON;
        this.PLAATS = PLAATS;
    }
    // getters and setters van strings
    public String getTELNR() {
        return TELNR;
    }

    public void setTELNR(String TELNR) {
        this.TELNR = TELNR;
    }

    public String getNAAM() {
        return NAAM;
    }

    public void setNAAM(String NAAM) {
        this.NAAM = NAAM;
    }

    public String getADRES() {
        return ADRES;
    }

    public void setADRES(String ADRES) {
        this.ADRES = ADRES;
    }

    public String getPOSTCODE() {
        return POSTCODE;
    }

    public void setPOSTCODE(String POSTCODE) {
        this.POSTCODE = POSTCODE;
    }

    public String getCONTACTPERSOON() {
        return CONTACTPERSOON;
    }

    public void setCONTACTPERSOON(String CONTACTPERSOON) {
        this.CONTACTPERSOON = CONTACTPERSOON;
    }

    public String getPLAATS() {
        return PLAATS;
    }

    public void setPLAATS(String PLAATS) {
        this.PLAATS = PLAATS;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // Write data in any order
        dest.writeString(NAAM);
        dest.writeString(ADRES);
        dest.writeString(TELNR);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
