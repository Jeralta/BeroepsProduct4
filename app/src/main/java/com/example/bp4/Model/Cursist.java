package com.example.bp4.Model;

import android.os.Parcel;
import android.os.Parcelable;


public class Cursist implements Parcelable {

    public static final Parcelable.Creator<Cursist> CREATOR = new Parcelable.Creator<Cursist>() {
        public Cursist createFromParcel(Parcel in) {
            return new Cursist(in);
        }

        public Cursist[] newArray(int size) {
            return new Cursist[size];
        }
    };
    private String IDCURSIST;               //auto increment & primary key
    private String EMAIL;
    private String VOORNAAM;
    private String TUSSENVOEGSEL;
    private String ACHTERNAAM;
    private String TELNR;
    private String LANDVHERKOMST;
    private String WOONPLAATS;

    public Cursist(Parcel in) {
        this.VOORNAAM = in.readString();
        this.ACHTERNAAM = in.readString();
        this.EMAIL = in.readString();
        this.TUSSENVOEGSEL = in.readString();
        this.TELNR = in.readString();
        this.LANDVHERKOMST = in.readString();
        this.WOONPLAATS = in.readString();
    }

    public Cursist(){

    }


    public Cursist(String IDCURSIST, String EMAIL, String VOORNAAM, String TUSSENVOEGSEL, String ACHTERNAAM, String TELNR, String LANDVHERKOMST, String WOONPLAATS) {

        this.IDCURSIST = IDCURSIST;
        this.EMAIL = EMAIL;
        this.VOORNAAM = VOORNAAM;
        this.TUSSENVOEGSEL = TUSSENVOEGSEL;
        this.ACHTERNAAM = ACHTERNAAM;
        this.TELNR = TELNR;
        this.LANDVHERKOMST = LANDVHERKOMST;
        this.WOONPLAATS = WOONPLAATS;
    }
    // getters and setters van strings
    public String getIDCURSIST() {
        return IDCURSIST;
    }

    public void setIDCURSIST(String IDCURSIST) {
        this.IDCURSIST = IDCURSIST;
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

    public String getLANDVHERKOMST() {
        return LANDVHERKOMST;
    }

    public void setLANDVHERKOMST(String LANDVHERKOMST) {
        this.LANDVHERKOMST = LANDVHERKOMST;
    }

    public String getWOONPLAATS() {
        return WOONPLAATS;
    }

    public void setWOONPLAATS(String WOONPLAATS) {
        this.WOONPLAATS = WOONPLAATS;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // Write data in any order
        dest.writeString(VOORNAAM);
        dest.writeString(EMAIL);
        dest.writeString(TELNR);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}

