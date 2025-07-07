package com.example.sprbasic2025summer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    // 주소값이 동일하면 컼파일 에러는 나지 않지만 런타임 에러가 발생한다.
//    @ResponseBody
//    @RequestMapping("/test")
//    public String test1() {
//        return "test1";
//    }

//    @ResponseBody
//    @RequestMapping("/javareview1")
//    public Map<String, Object> javareview1() {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("1","111");
//        map.put("2","222");
//
//        return map;
//    }

    @ResponseBody
    @RequestMapping("/javareview1")
    public Map<String, Object> javareview1() {
        //변수 선언
        int a = 0;
        double b = 0.0;
        boolean c = false;
        String stringA = "";

        //조건문
        if (a > 10) {
            c = true;
        }

        if (c) {
            stringA = "abC";
        }

        //반복문
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(i + "x" + j + "=" + i * j);
            }
        }

        //배열
        String[] array_a = {"a","b","c"};
        for(String each: array_a){
            System.out.println(each);
        }

        //Map 중복안된다. 중복되면 그냥 덮어씀
        Map<String, Object> map = new HashMap<>();
        map.put("a",a);
        map.put("b",b);
        map.remove("a");
        System.out.println(map.get("a")); //null 값 출력하게 됨. 없는값 출력하면
        System.out.println(map.get("b"));

        //list 중복된다.
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        System.out.println(list.get(2)); //c를 출력하고 싶을 떄

        return null;
    }


}
