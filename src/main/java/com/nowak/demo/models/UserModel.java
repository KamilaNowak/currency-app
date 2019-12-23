package com.nowak.demo.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserModel {

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String phonenumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
