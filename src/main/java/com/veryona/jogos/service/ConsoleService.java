package com.veryona.jogos.service;

import com.veryona.jogos.repository.ConsoleRepository;
import com.veryona.jogos.model.Console;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService {
    
    @Autowired
    ConsoleRepository repository;
    
    public Console selectbyID(String ID){
        return repository.findById(ID).orElseThrow();
    }
    public List<Console> selectAll(){
        return repository.findAll();
    }
}
