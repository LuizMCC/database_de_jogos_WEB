package com.veryona.jogos.controller;

import com.veryona.jogos.model.Console;
import com.veryona.jogos.model.Jogo;
import com.veryona.jogos.service.ConsoleService;
import com.veryona.jogos.service.JogoService;
import jakarta.annotation.PostConstruct;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JogoController {

    @Autowired
    JogoService jogoService;
    
    @Autowired
    ConsoleService consoleService;

    List<Jogo> jogos;
    List<Console> consoles;
    DateTimeFormatter dataForm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    @PostConstruct
    public void init(){
        jogos = jogoService.selectAll();
        consoles = consoleService.selectAll();
    }

    @GetMapping("/menu")
    public String mostrarMenu(Model model) {

        model.addAttribute("consoles", consoles);
        model.addAttribute("jogos", jogos);
        return "index";
    }

    @GetMapping("/jogo")
    public String returnJogo(Model model, @RequestParam String ID) {
        Jogo jogoAchado = jogoService.selectByID(ID);
        model.addAttribute("jogo", jogoAchado);
        return "jogo";
    }

    @GetMapping("/novoJogo")
    public String cadastroJogo(Model model) {

        model.addAttribute("consoles", consoles);
        model.addAttribute("jogo", new Jogo());
        return "novoJogo";
    }

    @PostMapping("/novoJogo")
    public String cadastrarJogo(Model model, @ModelAttribute Jogo jogo, @RequestParam String consoleID) {
        Console consoleSelecionado = consoleService.selectbyID(consoleID);
        jogo.setConsole(consoleSelecionado);
        System.out.println(jogo.getConsole().getID());
        jogoService.insert(jogo);
        return "redirect:/menu";
    }
}
