package com.veryona.jogos.controller;

import com.veryona.jogos.model.Jogo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JogoController {

    @GetMapping("/menu")
    public String mostrarMenu(Model model, String ID, String nome) {
        Jogo j = new Jogo();
        ID = "1234";
        nome = "Jogo1";
        j.setID(ID);
        j.setNome(nome);
        model.addAttribute("jogo", j);
        return "index";
        }
    @GetMapping("/jogo")
    public String returnJogo(){
        return "jogo";
    }
}
