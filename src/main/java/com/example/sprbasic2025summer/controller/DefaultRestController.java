package com.example.sprbasic2025summer.controller;

import jakarta.websocket.OnClose;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//controller 와 responsebody를 모두 가지고 있는 restcontroller 이다.(편리한 기능)
@RestController
@RequestMapping("/api")
public class DefaultRestController {

    @RequestMapping("/calculate")
    public Map<String, Object> calculate(int a, int b) {
        Map<String, Object> map = new HashMap<>();
        map.put("sum", a + b);
        return map;
    }

    @RequestMapping("/homework")
    public Map<String, Object> homework(int num1, int num2) {
        Map<String, Object> map = new HashMap<>();
        map.put("homework_multiple", num1 * num2);
        return map;
    }
}
