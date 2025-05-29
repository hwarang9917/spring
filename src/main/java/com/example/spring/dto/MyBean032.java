package com.example.spring.dto;

// java bean
public class MyBean032 {

    //    private fields
    private String name;
    private String company;
    private String home;
    private Integer age;

//    파라미터 없는 생성자(기본 생성자)

//    public MyBean031() {}

//    toString

    @Override
    public String toString() {
        return "MyBean032{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", home='" + home + '\'' +
                ", age=" + age +
                '}';
    }

    //    getters, setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

