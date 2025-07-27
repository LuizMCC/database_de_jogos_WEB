package com.veryona.jogos.repository;

import com.veryona.jogos.model.Jogo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, String>{
    
    @Query("SELECT new Jogo(j.ID, j.console, j.nome, j.regiao, j.dataLancamento) FROM Jogo j")
    List<Jogo> findAllJogosLista();
    Jogo findTopByOrderByAddDesc();
}
