package com.veryona.jogos.controller;

import com.veryona.jogos.model.Console;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JogoController {
    
    List<Jogo> jogos = new ArrayList();
    List<Console> consoles = new ArrayList();
    
    @GetMapping("/menu")
    public String mostrarMenu(Model model) {
        
        consoles.add(new Console("PS3", "Sony", "PlayStation 3"));
        
        model.addAttribute("consoles", consoles);
        model.addAttribute("jogos", jogos);
        return "index";
        }
    
    @GetMapping("/jogo")
    public String returnJogo(Model model, @ModelAttribute Jogo jogo){
        model.addAttribute("jogo", jogo);
        return "jogo";
    }
    
    @GetMapping("/novoJogo")
    public String cadastroJogo(Model model){
        model.addAttribute("consoles", consoles);
        model.addAttribute("jogo", new Jogo());
        return "novoJogo";
    }
    
    @PostMapping("/novoJogo")
    public String cadastrarJogo(Model model, @ModelAttribute Jogo jogo, @RequestParam String consoleID){
        Console consoleSelecionado = consoles.stream().filter(console -> console.getID().equals(consoleID)).findFirst().orElse(null);
        jogo.setConsole(consoleSelecionado);    
        System.out.println(jogo.getConsole().getNome());
        jogos.add(jogo);
        model.addAttribute("jogos", jogos);
        return "redirect:/menu";
    }
}
