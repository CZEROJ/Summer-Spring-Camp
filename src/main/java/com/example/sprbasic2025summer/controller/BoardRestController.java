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

    @RequestMapping("/detail/{id}")
    public Map<String, Object> detail(@PathVariable int id) {
        Map<String, Object> map_board = getData(id);
        int resultCode = 0;
        if (map_board != null) {
            resultCode = 200;
        }
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", resultCode);
        map_result.put("board", map_board);
        return map_result;
    }

    public Map<String, Object> getData(int id) {
        Map<String, Object> map_board = null;
        for (Map<String, Object> each : list) {
            int eachId = Integer.parseInt(each.get("id").toString());
            if (eachId == id) {
                map_board = each;
            }
        }
        return map_board;
    }

    @RequestMapping("/update")
    public Map<String, Object> update(@RequestParam Map<String, Object> param) {
        int code = 0;
        int id = Integer.parseInt(param.get("id").toString());
        String title = param.get("title").toString();
        //key title에 해당하는 값을 가져오고
        //그 value가 Object 타입이니, toString 으로 문자열을 리텅하게 한다.
        String content = param.get("content").toString();
        String author = param.get("author").toString();

        Map<String, Object> map_board = getData(id);
        if (map_board != null) {
            map_board.put("title", title);
            map_board.put("content", content);
            map_board.put("author", author);
            code = 200;
        }
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code", code);
        return map_result;
    }

    @RequestMapping("/delete")
    public Map<String, Object> delete(
            @RequestParam Map<String, Object> param) {

        int code = 0;
        int id = Integer.parseInt(param.get("id").toString());

        int tempI = -1;
        for(int i=0; i<list.size(); i++){
            int eachId = Integer.parseInt(list.get(i).get("id").toString());
            if(eachId == id){
                tempI =i;
            }
        }
        if(tempI != -1){
            list.remove(tempI);
            code = 200;
        }
        Map<String, Object> map_result = new HashMap<>();
        map_result.put("code",code);
        return map_result;
    }
}
