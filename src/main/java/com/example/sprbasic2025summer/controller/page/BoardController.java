package com.example.sprbasic2025summer.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardController {

    //어떤 파라미터가와도 page에 오는것은 변수로 간주하겠다
    //PathVariable은 resorces밑에 template 밑에 board 밑에 모든 페이지를 들어갈 수 있게 한다.(경로 개념)
    @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return "board/" + page;
    }

}
