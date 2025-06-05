package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main13")
public class Controller13 {
    @GetMapping("sub1")
    public String sub1(Model model) throws Exception {
//        1.request 분석/가공
//        @GetMapping, @PostMapping, @RequestParam

//        2.request 처리 (business logic)
//          CRUD
//        2.1연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

//        2.2쿼리(sql) 실행
        String sql = """
                SELECT CustomerName
                FROM Customers
                WHERE CustomerID = 1
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

//        2.3결과 처리
        String name = "";
        if (resultSet.next()) {
            name = resultSet.getString("CustomerName");
        }


//        3.결과를 Model(RedirectAttributes)에 담고
//          model.addAttribute(), rttr.addFlashAttribute(), rttr.addAttribute()
//          session.setAttribute()
        model.addAttribute("name", name);

//        4.view로 forwarding
//          다른 경로로 redirection

        return "main13/sub1";
    }

    //        연습 : 상품번호가 1번인 상품 조회/출력
    @GetMapping("sub2")
    public String sub2(Model model) throws Exception {
//        1.request 분석/가공
//        @GetMapping, @PostMapping, @RequestParam

//        2.request 처리 (business logic)
//          CRUD
//        2.1연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

//        2.2쿼리(sql) 실행
        String sql = """
                SELECT ProductName
                FROM Products
                WHERE ProductID = 1
                """;
//            실행 준비
        PreparedStatement statement = connection.prepareStatement(sql);
//            실행
        ResultSet resultSet = statement.executeQuery();
//            결과 처리
        String name = "";
        if (resultSet.next()) {
            name = resultSet.getString("ProductName");
        }
//            결과를 Model(RedirectAttributes)에 담고
//           view로 forwarding
        model.addAttribute("ProductName", name);
//          다른 경로로 redirection
        return "main13/sub2";
    }

    @GetMapping("sub3")
    public String sub3(Model model) throws Exception {
//        1.request 분석/가공
//        @GetMapping, @PostMapping, @RequestParam

//        2.request 처리 (business logic)
//          CRUD
//        2.1연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT LastName
                FROM Employees;
                """;

        //            실행 준비
        PreparedStatement statement = connection.prepareStatement(sql);
//            실행
        ResultSet resultSet = statement.executeQuery();
//        ResultSet :
//        table 형태의 결과
//        내부에 행(row)를 가리키는 커서가 있음
//        next() 호출하면 다음 행으로 커서를 이동

        resultSet.next(); // 1번째 행 가리킴 (true 리턴)
        String name1 = resultSet.getString("LastName");
        resultSet.next(); // 2번째 행 가리킴 (true 리턴)
        String name2 = resultSet.getString("LastName");
        resultSet.next(); // 3번째 행 가리킴 (true 리턴)
        String name3 = resultSet.getString("LastName");
        resultSet.next(); // 4번째 행 가리킴 (true 리턴)
        String name4 = resultSet.getString("LastName");
        resultSet.next(); // 5번째 행 가리킴 (true 리턴)
        String name5 = resultSet.getString("LastName");
        resultSet.next(); // 6번째 행 가리킴 (true 리턴)
        String name6 = resultSet.getString("LastName");
        resultSet.next(); // 7번째 행 가리킴 (true 리턴)
        String name7 = resultSet.getString("LastName");
        resultSet.next(); // 8번째 행 가리킴 (true 리턴)
        String name8 = resultSet.getString("LastName");
        resultSet.next(); // 9번째 행 가리킴 (true 리턴)
        String name9 = resultSet.getString("LastName");
        resultSet.next(); // 10번째 행 가리킴 (없으니까 false 리턴)

        var list = List.of(name1, name2, name3, name4, name5, name6, name7, name8, name9);

        model.addAttribute("nameList", list);
        return "main13/sub3";
    }

    @GetMapping("sub4")
    public String sub4(Model model) throws Exception {
//        1.request 분석/가공
//        @GetMapping, @PostMapping, @RequestParam

//        2.request 처리 (business logic)
//          CRUD
//        2.1연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT FirstName
                FROM Employees;
                """;

        //            실행 준비
        PreparedStatement statement = connection.prepareStatement(sql);
//            실행
        ResultSet resultSet = statement.executeQuery();
//        ResultSet :
//        table 형태의 결과
//        내부에 행(row)를 가리키는 커서가 있음
//        next() 호출하면 다음 행으로 커서를 이동

        var list = new ArrayList<String>();

        while (resultSet.next()) {
            String name = resultSet.getString("FirstName");

            list.add(name);
        }

        model.addAttribute("nameList", list);
        return "main13/sub3";
    }

    //    get /main13/sub5
//    Categories 테이블의 CategoryName 들을 조회해서
//    main13/sub5.html에서 출력하기
    @GetMapping("sub5")
    public String sub5(Model model) throws Exception {
//        2.1연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT CategoryName
                FROM Categories;
                """;

        //            실행 준비
        PreparedStatement statement = connection.prepareStatement(sql);
//            실행
        ResultSet resultSet = statement.executeQuery();
//        ResultSet :
//        table 형태의 결과
//        내부에 행(row)를 가리키는 커서가 있음
//        next() 호출하면 다음 행으로 커서를 이동

        var list = new ArrayList<String>();

        while (resultSet.next()) {
            String name = resultSet.getString("CategoryName");

            list.add(name);
        }

        model.addAttribute("categoryList", list);
        return "main13/sub5";
    }

    @GetMapping("sub6")
    public String sub6(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT Price
                FROM Products
                ORDER BY Price
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

//        var list = new ArrayList<String>();
//        while (resultSet.next()) {
//            String price = resultSet.getString("Price");
//            list.add(price);
//        }

//        모든 데이터는 String으로 얻어 오는 것이 가능하지만
//        특별한 이유가 없다면 type에 맞는 get... 메소드 사용
        var list = new ArrayList<Double>();
        while (resultSet.next()) {
            resultSet.getDouble("Price");
        }
        model.addAttribute("priceList", list);
        return "main13/sub6";
    }

    //    연습 :
//    get /main13/sub7
//    OrderDetails 에서 수량(Quantity) 상위 5개 조회해서
//    main13/sub7.html에서 출력
    @GetMapping("sub7")
    public String sub7(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT Quantity
                FROM OrderDetails
                ORDER BY Quantity DESC
                LIMIT 5
                """;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<Integer>();
        while (resultSet.next()) {
            int quantity = resultSet.getInt("Quantity");
            list.add(quantity);
        }

        model.addAttribute("quantityList", list);
        return "main13/sub7";
    }

    @GetMapping("sub8")
    public String sub8(Model model) throws Exception {
        String sql = """
                SELECT LastName, FirstName
                FROM Employees
                """;


        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<Map<String, String>>();
        while (resultSet.next()) {
            String lastName = resultSet.getString("LastName");
            String firstName = resultSet.getString("FirstName");

            var name = new HashMap<String, String>();
            name.put("lastName", lastName);
            name.put("firstName", firstName);

            list.add(name);
        }

        model.addAttribute("nameList", list);
        return "main13/sub8";
    }

    //    연습
//    get /main13/sub9
//    고객테이블에서 미국, 영국에 사는 고객이름과 국가를 조회해서
//    main13/sub9.html에서 출력
    @GetMapping("sub9")
    public String sub9(Model model) throws Exception {
        String sql = """
                SELECT CustomerName, Country, City
                FROM Customers
                WHERE Country IN ('usa', 'uk')
                ORDER BY Country
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<Map<String, String>>();
        while (resultSet.next()) {
            String customerName = resultSet.getString("CustomerName");
            String city = resultSet.getString("city");
            String country = resultSet.getString("Country");
            Map<String, String> map = new HashMap<>();
            map.put("name", customerName);
            map.put("city", city);
            map.put("country", country);
            list.add(map);
        }

        model.addAttribute("customerList", list);
        return "main13/sub9";
    }

    @GetMapping("sub10")
    public String sub10(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Products
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<Map<String, Object>>();
        while (resultSet.next()) {
            int productId = resultSet.getInt("ProductId");
            String productName = resultSet.getString("ProductName");
            int supplierID = resultSet.getInt("SupplierID");
            int categoryID = resultSet.getInt("CategoryID");
            String unit = resultSet.getString("Unit");
            double price = resultSet.getDouble("Price");

            Map<String, Object> map = new HashMap<>();
            map.put("productId", productId);
            map.put("productName", productName);
            map.put("supplierID", supplierID);
            map.put("categoryID", categoryID);
            map.put("unit", unit);
            map.put("price", price);
            list.add(map);
        }

        model.addAttribute("productList", list);
        return "main13/sub10";
    }

    //    연습
//    get /main13/sub11
//    모든 고객의 정보를 출력하는 코드 작성
//    main13/sub11.html 출력
    @GetMapping("sub11")
    public String sub11(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<Map<String, Object>>();
        while (resultSet.next()) {
            int customerId = resultSet.getInt("customerId");
            String customerName = resultSet.getString("customerName");
            String contactName = resultSet.getString("contactName");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            String postalCode = resultSet.getString("postalCode");
            String country = resultSet.getString("country");

            Map<String, Object> map = new HashMap<>();
            map.put("customerId", customerId);
            map.put("customerName", customerName);
            map.put("contactName", contactName);
            map.put("address", address);
            map.put("city", city);
            map.put("postalCode", postalCode);
            map.put("country", country);

            list.add(map);
        }

        model.addAttribute("customerList", list);
        return "main13/sub11";
    }

    @GetMapping("sub12")
    public String sub12(Model model) throws Exception {
        String sql = """
                        SELECT *
                        FROM Customers
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();


        var list = new ArrayList<CustomerDto>();
        while (resultSet.next()) {
            int customerId = resultSet.getInt("customerId");
            String customerName = resultSet.getString("customerName");
            String contactName = resultSet.getString("contactName");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            String postalCode = resultSet.getString("postalCode");
            String country = resultSet.getString("country");

            CustomerDto dto = new CustomerDto();
            dto.setId(customerId);
            dto.setName(customerName);
            dto.setContactName(contactName);
            dto.setAddress(address);
            dto.setCity(city);
            dto.setPostalCode(postalCode);
            dto.setCountry(country);

            list.add(dto);
        }

        model.addAttribute("customerList", list);

        return "main13/sub12";
    }

//    연습
//    dto, html, request handler method
//    모든 상품 조회, 출력
//    get /main13/sub13
//    ProductDto
    @GetMapping("sub13")
    public String sub13(Model model) throws Exception {
        String sql = """
                        SELECT *
                        FROM Products
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();


        var list = new ArrayList<ProductDto>();
        while (resultSet.next()) {
            int productID = resultSet.getInt("ProductID");
            String productName = resultSet.getString("ProductName");
            int supplierID = resultSet.getInt("SupplierID");
            int categoryID = resultSet.getInt("CategoryID");
            String unit = resultSet.getString("Unit");
            double price = resultSet.getDouble("Price");

            ProductDto dto = new ProductDto();
            dto.setId(productID);
            dto.setName(productName);
            dto.setSupplierId(supplierID);
            dto.setCategoryId(categoryID);
            dto.setUnit(unit);
            dto.setPrice(price);

            list.add(dto);
        }

        model.addAttribute("productList", list);

        return "main13/sub13";
    }
}
