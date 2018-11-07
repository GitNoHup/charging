package com.charging.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "index")
public class IndexController {

    @RequestMapping(value = "welcome")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "view")
    public String view() {
        return "view";
    }
}
