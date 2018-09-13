package com.maven.firstweb.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Wang HLiang
 * @Description: Write Elegant Code
 * @Date: Created in 15:14 2018-09-12
 * @Modofied:
 */
@RestController
public class TestControl {
    @RequestMapping("/first.html")
    public String test(){
        return "this is first html!";
    }
}
