package com.example.a1.campr;


import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Pets {//implements Parcelable {
    private String name;
    private String gender;
    private String info;
    private String petId;
    private String ownerId;
    //private Bitmap petPic;
    //public HashMap<String, String> applicantId; //applicantID, applicationMessage
    private boolean approved;
    private boolean adopted;
    //public String approvedId;

    private String species;
    private int age;
    private String fee;
    private String city;

    public Pets(String mName, String mGender, String mInfo, String mId, String mOwnerId, String mSpecies, int mAge, String mFee, String mCity) {
        name = mName;
        gender = mGender;
        info = mInfo;
        petId = mId;
        ownerId = mOwnerId;
        //petPic = mPic;
        //applicantId = new HashMap<String, String>();
        approved = false;
        adopted = false;
        //approvedId = "";

        species = mSpecies;
        age = mAge;
        fee = mFee;
        city = mCity;
    }
    public Pets() {};

    /*public Pets(Parcel in) {
        name = in.readString();
        gender = in.readString();
        info = in.readString();
        petId = in.readString();
        ownerId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(gender);
        dest.writeString(info);
        dest.writeString(petId);
        dest.writeString(ownerId);
    }

    public static final Parcelable.Creator<Pets> CREATOR = new Parcelable.Creator<Pets>() {
        public Pets createFromParcel(Parcel in) {
            return new Pets(in);
        }

        public Pets[] newArray(int size) {
            return new Pets[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }*/

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getInfo() {
        return info;
    }

    public String getPetId() {
        return petId;
    }

    public String getOwnerId() { return ownerId; }

    //public Bitmap getPetPic() { return  petPic; }


    public boolean isApproved() {
        return approved;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getFee() {
        return fee;
    }

    public String getCity() {
        return city;
    }

    public void setName(String mName) {
        name = mName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public void setCity(String city) {
        this.city = city;
    }

    /*public void setPetPic(Bitmap petPic) {
        this.petPic = petPic;
    }*/

    @Override
    public boolean equals(Object obj) {
        //return (this.petId.equals(((Pets) obj).petId));
        return (this.getPetId().equals(((Pets) obj).getPetId()));
    }

}

