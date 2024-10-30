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
    DateTimeFormatter dataForm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    @GetMapping("/menu")
    public String mostrarMenu(Model model) {
        
        LocalDate lanc = LocalDate.parse("18/04/2004", dataForm);
        
        consoles.add(new Console(
                "PS3",
                "Sony",
                "PlayStation 3"
        ));
        jogos.add(new Jogo(
                consoles.get(0), //Console
                "SLUS-00001", //ID
                "Jogo1", //Nome
                "US", //Região
                "1.00", //Versão
                999.9, //Mb
                "EA", //Desenvolvedor
                "Eletronic Arts", //Publicador
                "T", //Classificação
                lanc.format(dataForm), //Lançamento
                "ISO", //Arquivo
                null, //Capa Frontal
                null, //Capa Lateral
                null, //Capa Traseira
                null, //Capa Midia
                "Inglês, Português", //Linguegens
                "Ação", //Gênero
                "BluRay", //Midia
                "Teste", //Fontes
                "Teste12345" //Descrição
        ));
        model.addAttribute("consoles", consoles);
        model.addAttribute("jogos", jogos);
        return "index";
        }
    
    @GetMapping("/jogo")
    public String returnJogo(Model model, @RequestParam String ID){
        Jogo jogoAchado = new Jogo();
        for(Jogo j : jogos){
            if(j.getID().equals(ID)){
                jogoAchado = j;
                break;
            }
        }
        System.out.println(jogoAchado.getID());
        model.addAttribute("jogo", jogoAchado);
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
