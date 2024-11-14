package com.veryona.jogos.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="Console")
public class ConsoleEntity {
    
    @Id
    String ID;
    String empresa;
    String nome;
}
