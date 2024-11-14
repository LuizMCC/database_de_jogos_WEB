package com.veryona.jogos.service;


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
    public Jogo selectByID(String ID){
        return repository.findById(ID).orElseThrow();
    }
    public List<Jogo> selectAll(){
        return repository.findAll();
    }
    
    //Insert
    public Jogo insert(Jogo jogo){
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
