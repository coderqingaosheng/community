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
  /**
   * @Author jc-qings
   * @Date 2020/2/25 11:27
   * @Description This is description of method
   * @Param
   * @Return
   * @Since version-1.0
   */
    @GetMapping("/")
    public String firstSpringBoot(){
        return "index";
    }
}
