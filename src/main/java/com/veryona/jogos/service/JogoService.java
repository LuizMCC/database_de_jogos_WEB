package com.veryona.jogos.service;

import com.veryona.jogos.data.JogoEntity;
import com.veryona.jogos.data.JogoRepository;
import com.veryona.jogos.model.Jogo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogoService {
    
    @Autowired
    JogoRepository repository;
    
    //Select
    public JogoEntity selectByID(String ID){
        return repository.findById(ID).orElseThrow();
    }
    public List<JogoEntity> selectAll(){
        return repository.findAll();
    }
    
    //Insert
    public JogoEntity insert(JogoEntity jogo){
        if(jogo == null){
            repository.save(jogo);
            return jogo;
        } else {
            return null;
        }
    }
    
    //Delete
    public void delete(String ID){
        repository.deleteById(ID);
    }
}
