package com.firstSpringBoot.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author my
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String firstSpringBoot(@RequestParam(name="hello") String name, Model model){
        model.addAttribute("name",name);
        return "firstHtml";
    }
}
