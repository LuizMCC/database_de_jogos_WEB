package com.veryona.jogos.controller;

import com.veryona.jogos.model.Jogo;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JogoController {
    
    List<Jogo> jogos = new ArrayList();

    @GetMapping("/menu")
    public String mostrarMenu(Model model, String ID, String nome, String plataforma, LocalDate dataLancamento) {
        //DateTimeFormatter dataForm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Jogo j = new Jogo();
        //j.setID(ID);
        //j.setNome(nome);
        //j.setPlataforma(plataforma);
        //j.setDataLancamento(dataLancamento);
        jogos.sort(Comparator.comparing(Jogo::getID).reversed());
        model.addAttribute("jogos", jogos);
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
        jogos.add(jogo);
        model.addAttribute("jogos", jogos);
        return "redirect:/menu";
    }
}
