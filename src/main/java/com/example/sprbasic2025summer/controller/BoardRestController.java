package com.example.sprbasic2025summer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("api/board")
@RestController
public class BoardRestController {

    List<Map<String, Object>> list = new ArrayList<>();
    int tempId = 0;

    @RequestMapping("/create")
    public Map<String, Object> create(
//            @RequestParam String title, String content
            @RequestParam Map<String, Object> param
    ) {
        String title = param.get("title").toString();
        String content = param.get("content").toString();
        String author = param.get("author").toString();

        System.out.println(title);
        System.out.println(content);
        System.out.println(author);

        Map<String, Object> map_board = new HashMap<>();
        map_board.put("id", ++tempId);
        map_board.put("title", title);
        map_board.put("content", content);
        map_board.put("author", content);
        list.add(map_board);

        //------------------------------------------------------
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        map_result.put("totalsize", list.size());
        return map_result;
    }

    @RequestMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", 200);
        map_result.put("totalsize", list.size());
        map_result.put("list", list);
        return map_result;
    }

}
