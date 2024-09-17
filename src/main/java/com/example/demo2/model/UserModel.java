package com.example.demo2.model;
import java.io.Serializable;
import java.util.Date;

public class UserModel implements Serializable {
     public int id;
     public String username;
     public String password;
     public String email;
     public int role;
     public String phone;
     public Date createDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getRole() {
        return role;
    }

    public String getPhone() {
        return phone;
    }

    public Date getCreateDate() {
        return createDate;
    }
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
