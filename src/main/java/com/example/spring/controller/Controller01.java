package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class Controller01 {
    //    RequestMapping : path에 해당하는 메소드 호출
    @RequestMapping(path = "/main1/sub1")
    public void method1() {
        System.out.println("Controller01.method1");
    }

    @RequestMapping(value = "/main1/sub2")
    public void method2() {
        System.out.println("Controller01.method2");
    }

    @RequestMapping("/main1/sub3")
    public void method3() {
        System.out.println("Controller01.method3");
    }

//    /main1/sub4 요청이 올 경우
//    실행되는 method4 작성

    @RequestMapping({"/main1/sub4", "/main1/sub5"})
//    @RequestMapping("/main1/sub5") // 여러 개는 안 됨, 중괄호 사용
    public void method4() {
        System.out.println("Controller01.method4");
    }

    //    WebRequest : 요청 정보가 담기는 객체
    @RequestMapping("/main1/sub6")
    public void method6(WebRequest request) {
        String s = request.getHeader("User-Agent");
        System.out.println(s);
        String t = request.getHeader("Accept");
        System.out.println(t);

        System.out.println("Controller01.method6");
    }
}
