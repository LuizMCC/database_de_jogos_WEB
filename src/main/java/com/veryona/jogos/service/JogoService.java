package com.veryona.jogos.service;

import com.veryona.jogos.repository.JogoRepository;
import com.veryona.jogos.model.Jogo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogoService {
    
    @Autowired
    JogoRepository jogoRepository;
    
    //Select
    public Jogo selectByID(String ID){
        return jogoRepository.findById(ID).orElseThrow();
    }
    public List<Jogo> selectAll(){
        return jogoRepository.findAll();
    }
    public Jogo selectLastAdd(){
        return jogoRepository.findTopByOrderByAddDesc();
    }
    
    //Insert
    public Jogo insert(Jogo jogo){
        if(jogo != null){
            jogoRepository.save(jogo);
            return jogo;
        } else {
            return null;
        }
    }
    
    //Delete
    public void delete(String ID){
        jogoRepository.deleteById(ID);
    }
}
