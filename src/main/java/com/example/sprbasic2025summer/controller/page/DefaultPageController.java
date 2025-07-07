package com.example.sprbasic2025summer.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.lang.Integer.parseInt;

@Controller //스프링의 bin으로 등록이 된다.
public class DefaultPageController {

    //index를 그러면 하나하나 다 입력해줘야 하는가? 한번에 쓰는 방식은
    //RequestMapping 을 배열로 하면 된다. 이렇게 하면 저 셋중에 아무거나 입력해도 index 페이지로 온다.
    @RequestMapping({"","/","/index"})
    public String index(){
        return "index";
    }


    @RequestMapping("/aaa")
    public String aaa(@RequestParam String name, String phone, Model model) {
        System.out.println("name : " + name);
        System.out.println("phone : " + phone);
        model.addAttribute("key1", "value111");

        //파라미터 출력
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);

        //두개의 숫자를 파라미터로 입력받아, 더해주는 페이지 컨트롤러 만들기.
        model.addAttribute("sum", Integer.parseInt(name) + Integer.parseInt(phone));

        return "aaa";
    }

    @RequestMapping("/calculate")
    public String calculate(String num1, String num2, Model model){
        System.out.println("num1 : " + num1);
        System.out.println("num2 : " + num2);
        int int_num1 = Integer.parseInt(num1);
        int int_num2 = Integer.parseInt(num2);
        int sum = int_num1 + int_num2;

        model.addAttribute("sum", sum);
        return "calculate";
    }

    @RequestMapping("/calculate2")
    public String calculate2(int num1, int num2, Model model){
        int sum = num1 + num2;
        model.addAttribute("sum", sum);
        /*
        Map<String, Object> temp = new HashMap<String, Object>();
        temp.put("sum", sum);
        temp.put("code", "success");
        model.addAttribute("result", temp);
        */
        return "calculate2";
    }
}
