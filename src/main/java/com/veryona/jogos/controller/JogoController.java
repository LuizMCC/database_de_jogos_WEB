package com.veryona.jogos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JogoController {

    @GetMapping("/saudacao")
    public String mostraSaudacao() {
        return "saudacao";
    }
}
