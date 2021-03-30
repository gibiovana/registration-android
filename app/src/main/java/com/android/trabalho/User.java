package com.android.trabalho;

import android.content.Context;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String name;
    private String email;
    private String phone;
    private Date birthDate;
    private boolean twilightFan;
    private boolean hpFan;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isTwilightFan() {
        return twilightFan;
    }

    public void setTwilightFan(boolean twilightFan) {
        this.twilightFan = twilightFan;
    }

    public boolean isHpFan() {
        return hpFan;
    }

    public void setHpFan(boolean hpFan) {
        this.hpFan = hpFan;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public void showToast(Context context) {
        Toast.makeText(context,this.toString(), Toast.LENGTH_LONG).show();
    }
}
