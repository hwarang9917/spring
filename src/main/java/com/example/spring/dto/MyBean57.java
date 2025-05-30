package com.example.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class MyBean57 {
    private String name;
    private String birthDate;
    private Integer price;

    @Data
    @AllArgsConstructor
    public class Person {
        private Integer number;
        private List<String> company;
        private List<String> address;
    }
}



