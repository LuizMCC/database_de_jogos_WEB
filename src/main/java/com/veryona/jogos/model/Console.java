package com.veryona.jogos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Console {

    public Console(String ID, String empresa, String nome) {
        this.ID = ID;
        this.empresa = empresa;
        this.nome = nome;
    }
    
    String ID;
    String empresa;
    String nome;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
