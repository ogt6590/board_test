package com.example.board_test.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String mainView(Model model){
        model.addAttribute("test","타임리프테스트");
        return "board/list";
    }

}
