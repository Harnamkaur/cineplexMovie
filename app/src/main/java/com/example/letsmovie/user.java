package com.example.letsmovie;

import java.util.Date;

public class user {

    private String name,refernceId,userUid;
    private String phone ,credidtcard,cvv;
    private String expiryDate;

public user(String name1, String phone, String credidtcard, String date, String cvv,String expiryDate,String refernceId,String userUid)
{

}

    public user(String name,String phone, String credidtcard, String cvv,String expiryDate,String refernceId,String userUid) {
        this.name = name;
        this.phone = phone;
        this.credidtcard = credidtcard;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.refernceId = refernceId;
        this.userUid = userUid;
    }

    public String getName() {
        return name;
    }
    public String getPhone(){
    return phone;
    }

    public String getCredidtcard() {
        return credidtcard;
    }

    public String getExpiry() {
        return expiryDate;
    }

    public String getCvv() {
        return cvv;
    }
    public String getrefernceId() {
        return refernceId;
    }
    public String getuserUid() {
        return userUid;
    }
}

