/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veryona.jogos.service;

import com.veryona.jogos.model.Func;
import com.veryona.jogos.model.Jogo;
import com.veryona.jogos.repository.FuncRepository;
import com.veryona.jogos.repository.JogoRepository;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncService {
    
    @Autowired
    FuncRepository funcRepository;
    
    @Autowired
    JogoRepository jogoRepository;
    
    JogoService jogoService;
    
    //Select
    public Set<Func> selectByJogo(String ID){
        Jogo jogo = jogoService.selectByID(ID);
        
        return jogo.getFuncs();
    }
    public List<Func> selectAll(){
        return funcRepository.findAll();
    }
    
    // ----- Insert -----
    //
    public Func insertInJogo(Func func, Jogo jogo){
        
        if(func != null || jogo != null){
            
            jogo.getFuncs().add(func);
            func.getJogos().add(jogo);
            
            return func;
        } else {
            return null;
        }
    }
}
