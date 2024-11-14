package com.veryona.jogos.data;

import com.veryona.jogos.model.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, String>{
    
}
