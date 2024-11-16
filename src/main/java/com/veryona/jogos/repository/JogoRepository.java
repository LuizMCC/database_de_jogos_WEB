package com.veryona.jogos.repository;

import com.veryona.jogos.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, String>{
    
}
