package com.firstSpringBoot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author my
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String firstSpringBoot(){
        return "index";
    }
}
