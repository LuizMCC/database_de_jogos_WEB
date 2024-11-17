package com.veryona.jogos.controller;

import com.veryona.jogos.model.Console;
import com.veryona.jogos.model.Jogo;
import com.veryona.jogos.service.ConsoleService;
import com.veryona.jogos.service.JogoService;
import jakarta.annotation.PostConstruct;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class JogoController {

    @Autowired
    JogoService jogoService;

    @Autowired
    ConsoleService consoleService;

    List<Jogo> jogos;
    List<Console> consoles;

    @GetMapping("/menu")
    public String mostrarMenu(Model model) {

        jogos = jogoService.selectAll();
        consoles = consoleService.selectAll();

        model.addAttribute("consoles", consoles);
        model.addAttribute("jogos", jogos);
        return "index";
    }

    @GetMapping("/jogo")
    public String returnJogo(Model model, @RequestParam String ID) throws SQLException {
        Jogo jogoAchado = jogoService.selectByID(ID);
        
        Blob capaFrenteBlob = jogoAchado.getCapaFrente();
        String capaFrenteBase64 = null;
        if (capaFrenteBlob != null) {
            byte[] imagemBytes = capaFrenteBlob.getBytes(1, (int) capaFrenteBlob.length());
            capaFrenteBase64 = Base64.getEncoder().encodeToString(imagemBytes);
        }
        
        model.addAttribute("jogo", jogoAchado);
        model.addAttribute("capaFrente", capaFrenteBase64);
        return "jogo";
    }

    @GetMapping("/novoJogo")
    public String cadastroJogo(Model model) {

        consoles = consoleService.selectAll();

        model.addAttribute("consoles", consoles);
        model.addAttribute("jogo", new Jogo());
        return "novoJogo";
    }

    @PostMapping("/novoJogo")
    public String cadastrarJogo(Model model, @ModelAttribute Jogo jogo, @RequestParam String consoleID, @RequestParam MultipartFile imagemFrente) throws IOException, SQLException {
        Blob capaFrente = new SerialBlob(imagemFrente.getBytes());
        Console consoleSelecionado = consoleService.selectbyID(consoleID);
        jogo.setConsole(consoleSelecionado);
        jogo.setAdd(LocalDateTime.now());
        jogo.setCapaFrente(capaFrente);
        System.out.println(jogo.getConsole().getID());
        jogoService.insert(jogo);
        return "redirect:/menu";
    }
}
