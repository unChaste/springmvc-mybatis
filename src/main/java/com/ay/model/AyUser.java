package com.ay.model;

import java.io.Serializable;
import java.util.List;

public class AyUser implements Serializable {
    private Integer id;

    private String name;

    private String password;

    private List<AyUserAddress> ayUserAddressList;


//    private AyUserAddress ayUserAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AyUserAddress> getAyUserAddressList() {
        return ayUserAddressList;
    }

    public void setAyUserAddressList(List<AyUserAddress> ayUserAddressList) {
        this.ayUserAddressList = ayUserAddressList;

    }

    @Override
    public String toString() {
        return "AyUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", ayUserAddressList=" + ayUserAddressList +
                '}';
    }
}
