package com.veryona.jogos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Console {
    
    public Console(String ID, String empresa, String nome){
        ID = this.ID;
        empresa = this.empresa;
        nome = this.nome;
    }
    
    String ID;
    String empresa;
    String nome;
}
