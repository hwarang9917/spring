package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main15")
public class Controller15 {

    // paging

    @GetMapping("sub1")
    public String sub1(
            @RequestParam(defaultValue = "1")
            Integer page,
            Model model) throws SQLException {
        // 한 페이지에 10개씩
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID
                LIMIT ?, ?
                """;
        // 총 고객 수
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Customers
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        // offset : (page - 1) * 10
//        statement.setInt(1, 0); // 1page
//        statement.setInt(1, 10); // 2page
//        statement.setInt(1, 20); // 3page
        int offset = (page - 1) * 10;
        statement.setInt(1, offset);
        statement.setInt(2, 10);

        ResultSet rs2 = connection.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count"); // 총 고객수
        int lastPage = (count - 1) / 10 + 1; // 마지막 페이지 번호

        model.addAttribute("lastPage", lastPage);


        ResultSet rs = statement.executeQuery();
        List<CustomerDto> list = new ArrayList<>();
        while (rs.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs.getInt("CustomerID"));
            customerDto.setPostalCode(rs.getString("PostalCode"));
            customerDto.setCity(rs.getString("City"));
            customerDto.setCountry(rs.getString("Country"));
            customerDto.setContactName(rs.getString("ContactName"));
            customerDto.setName(rs.getString("CustomerName"));
            customerDto.setAddress(rs.getString("Address"));
            list.add(customerDto);
        }
        model.addAttribute("customerList", list);


        return "main15/sub1";
    }

    // 연습:
    // 한 페이지에 5개의 공급자가 출력되도록 코드 작성 (정렬은 공급자 번호 순)
    // request handler method, html
    @GetMapping("sub2")
    public String sub2(
            @RequestParam(defaultValue = "1")
            Integer page,
            Model model) throws SQLException {
        // 한 페이지에 5개씩
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID
                LIMIT ?, ?
                """;
        // 총 고객 수
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Customers
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        // offset : (page - 1) * 10
//        statement.setInt(1, 0); // 1page
//        statement.setInt(1, 10); // 2page
//        statement.setInt(1, 20); // 3page
        int offset = (page - 1) * 5;
        statement.setInt(1, offset);
        statement.setInt(2, 5);

        ResultSet rs2 = connection.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count"); // 총 고객수
        int lastPage = (count - 1) / 5 + 1; // 마지막 페이지 번호

        model.addAttribute("lastPage", lastPage);


        ResultSet rs = statement.executeQuery();
        List<CustomerDto> list = new ArrayList<>();
        while (rs.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs.getInt("CustomerID"));
            customerDto.setPostalCode(rs.getString("PostalCode"));
            customerDto.setCity(rs.getString("City"));
            customerDto.setCountry(rs.getString("Country"));
            customerDto.setContactName(rs.getString("ContactName"));
            customerDto.setName(rs.getString("CustomerName"));
            customerDto.setAddress(rs.getString("Address"));
            list.add(customerDto);
        }
        model.addAttribute("customerList", list);


        return "main15/sub2";
    }
}