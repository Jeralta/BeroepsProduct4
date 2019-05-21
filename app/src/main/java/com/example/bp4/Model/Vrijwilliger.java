package com.example.bp4.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bp4.R;

public class Vrijwilliger implements Parcelable {

    public static final Parcelable.Creator<Vrijwilliger> CREATOR = new Parcelable.Creator<Vrijwilliger>() {
        public Vrijwilliger createFromParcel(Parcel in) {
            return new Vrijwilliger(in);
        }

        public Vrijwilliger[] newArray(int size) { return new Vrijwilliger[size];}
    };
    private String EMAIL;
    private String VOORNAAM;
    private String TUSSENVOEGSEL;
    private String ACHTERNAAM;
    private String TELNR;
    private String WOONPLAATS;

    public Vrijwilliger(Parcel in) {
        this.VOORNAAM = in.readString();
        this.ACHTERNAAM = in.readString();
        this.EMAIL = in.readString();
        this.TUSSENVOEGSEL = in.readString();
        this.TELNR = in.readString();
        this.WOONPLAATS = in.readString();
    }
    public Vrijwilliger(String EMAIL, String VOORNAAM, String ACHTERNAAM, String TUSSENVOEGSEL, String TELNR, String WOONPLAATS) {
        this.EMAIL = EMAIL;
        this.VOORNAAM = VOORNAAM;
        this.TUSSENVOEGSEL = TUSSENVOEGSEL;
        this.ACHTERNAAM = ACHTERNAAM;
        this.TELNR = TELNR;
        this.WOONPLAATS = WOONPLAATS;
    }

    public Vrijwilliger (){

    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getVOORNAAM() {
        return VOORNAAM;
    }

    public void setVOORNAAM(String VOORNAAM) {
        this.VOORNAAM = VOORNAAM;
    }

    public String getTUSSENVOEGSEL() {
        return TUSSENVOEGSEL;
    }

    public void setTUSSENVOEGSEL(String TUSSENVOEGSEL) {
        this.TUSSENVOEGSEL = TUSSENVOEGSEL;
    }

    public String getACHTERNAAM() {
        return ACHTERNAAM;
    }

    public void setACHTERNAAM(String ACHTERNAAM) {
        this.ACHTERNAAM = ACHTERNAAM;
    }

    public String getTELNR() {
        return TELNR;
    }

    public void setTELNR(String TELNR) {
        this.TELNR = TELNR;
    }

    public String getWOONPLAATS() {
        return WOONPLAATS;
    }

    public void setWOONPLAATS(String WOONPLAATS) {
        this.WOONPLAATS = WOONPLAATS;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        // Write data in any order
        dest.writeString(VOORNAAM);
        dest.writeString(EMAIL);
        dest.writeString(TELNR);
    }

    @Override
    public int describeContents()  {return 0; }
}
