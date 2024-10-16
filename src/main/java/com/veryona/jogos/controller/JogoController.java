package com.veryona.jogos.controller;

import com.veryona.jogos.model.Jogo;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JogoController {

    @GetMapping("/menu")
    public String mostrarMenu(Model model, String ID, String nome, String plataforma, LocalDate dataLancamento) {
        //DateTimeFormatter dataForm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Jogo j = new Jogo();
        j.setID(ID);
        j.setNome(nome);
        j.setPlataforma(plataforma);
        j.setDataLancamento(dataLancamento);
        model.addAttribute("jogo", j);
        return "index";
        }
    @GetMapping("/jogo")
    public String returnJogo(){
        return "jogo";
    }
    
    @GetMapping("/novoJogo")
    public String cadastroJogo(Model model){
        model.addAttribute("jogo", new Jogo());
        return "novoJogo";
    }
    
    @PostMapping("/novoJogo")
    public String cadastrarJogo(Model model, @ModelAttribute Jogo jogo){
        model.addAttribute("jogo", jogo);
        return "index";
    }
}
