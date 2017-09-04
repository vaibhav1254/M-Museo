package com.example.pd_pc.myapplication;

/**
 * Created by _vaibbhavv_ on 8/30/2017.
 */

public class Traveller {

    private final String name;
    private final String number;
    private final String email;
    private final String password;
    private final String confirmpassword;

    public Traveller(String name, String number, String email, String password, String confirmpassword) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }
}
