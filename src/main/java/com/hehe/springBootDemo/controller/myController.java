package com.hehe.springBootDemo.controller;

import com.hehe.springBootDemo.mapper.studentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class myController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/select")
    @ResponseBody
    public Map<String,Object> select(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from students");
        System.out.println(maps);
        return maps.get(0);
    }

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello word!";
    }

    @RequestMapping("success")
    public String success(Map<String, Object> map) {
        map.put("user", "<h1>hehe</h1>");
        map.put("arr", Arrays.asList("1", "2", "3"));
        /*用thymeleaf模板引擎默认将连接到resources/templates/xxx.html*/
        return "success";
    }
}
