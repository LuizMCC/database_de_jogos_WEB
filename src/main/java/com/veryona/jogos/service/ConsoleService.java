package com.veryona.jogos.service;

import com.veryona.jogos.data.ConsoleEntity;
import com.veryona.jogos.data.ConsoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService {
    
    @Autowired
    ConsoleRepository repository;
    
    public ConsoleEntity selectbyID(String ID){
        return repository.findById(ID).orElseThrow();
    }
    public List<ConsoleEntity> selectAll(){
        return repository.findAll();
    }
}
