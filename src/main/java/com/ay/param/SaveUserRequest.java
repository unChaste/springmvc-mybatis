package com.ay.param;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class SaveUserRequest implements Serializable {
    @NotNull
    private String name;

    @Range(min = 0, max = 2, message = "参数错误")
    private Integer gender;

    @Range(min = 0, max = 300, message = "身高不小于0不大大于300")
    private Integer height;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "SaveUserRequest{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", height=" + height +
                ", birthday=" + birthday +
                '}';
    }
}
