package com.example.spring.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MyBean037 {
//    field : name, address, pw
//    property : name, address, password
//    *preperty 이름은 getter, setter에 의해 결정됨

    private String name;
    private String address;
    private String pw; // password

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return pw;
    }

    public void setPassword(String pw) {
        this.pw = pw;
    }
}
