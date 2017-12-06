package com.techobbyist.HouseHold;

/**
 * Created by Acer on 11/27/2017.
 */
import android.graphics.Bitmap;

public class Contact {

    private String name,username,email,sexe,password;
    private boolean isAdmin;
    private int nbrOfTask ;
    private Bitmap bmp;

    public boolean isAdmin() {
        return isAdmin;
    }

    public Bitmap getBitmap() {
        return bmp;
    }


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public  int getNbrOfTask(){return nbrOfTask; }

    public String getPassword() {
        return password;
    }

    public String getSexe() {
        return sexe;
    }

    public String getUsername() {
        return username;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBmp(Bitmap bmp) {
        this.bmp = bmp;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNbrOfTask(int nbrOfTask) {
        this.nbrOfTask = nbrOfTask;
    }
}



