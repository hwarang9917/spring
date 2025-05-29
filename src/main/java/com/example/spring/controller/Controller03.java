package com.example.spring.controller;

import com.example.spring.dto.MyBean031;
import com.example.spring.dto.MyBean032;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/main3") // 모든 메소드의 경로 앞 부분에 적용
public class Controller03 {

//    http://localhost:8080/main3/sub1

    @RequestMapping("/sub1")
    public void sub1() {
        System.out.println("Controller03 sub1");
    }

    @RequestMapping("sub2") // 슬래시 생략 가능
    public void sub2() {
        System.out.println("Controller03 sub2");
    }

    @RequestMapping("sub3")
    public void sub3() {
        System.out.println("Controller03 sub3");
    }

    //    /main3/sub4?param1=val1&param2=val2
    @RequestMapping("sub4")
    public void sub4(@RequestParam("param1") String param1,
                     @RequestParam("param2") String param2) {
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);
    }


    //    /main3/sub5?address=seoul&age=17&email=gmail&home=dokdo
    @RequestMapping("sub5")
    public void sub5(@RequestParam Map<String, String> param) {
        for (Map.Entry<String, String> entry : param.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    //    request parameter를 java beans (DTO : Data Transaction Object)로 받기
//    /main3/sub6?name=donald&address=la
//    /main3/sub6?name=trump
//    /main3/sub6?&address=ny
    @RequestMapping("sub6")
    public void sub6(MyBean031 params) {
        System.out.println("params.getName() = " + params.getName());
        System.out.println("params.getAddress() = " + params.getAddress());
    }

    //    /main3/sub7?name=musk&company=tesla&home=texas
    //    /main3/sub7?name=musk&company=tesla&home=texas&age=55
//    MyBean032 JavaBean(dto)를 만들어서 request parameter 받아보기
    @RequestMapping("sub7")
    public void sub7(MyBean032 params) {
        System.out.println(params);
        System.out.println("params.getName() = " + params.getName());
        System.out.println("params.getCompany() = " + params.getCompany());
        System.out.println("params.getHome() = " + params.getHome());
        System.out.println("params.getAge() = " + params.getAge());
    }
}
