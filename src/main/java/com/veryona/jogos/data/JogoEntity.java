package com.veryona.jogos.data;

import com.veryona.jogos.model.Console;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Blob;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name="Jogo")
public class JogoEntity {
    
    @Id
    String ID;
    @ManyToOne
    Console console;
    String nome;
    String regiao;
    String versao;
    double mb;
    String dev;
    String pub;
    String classificacao;
    String dataLancamento;
    String arquivo;
    LocalDateTime add;
    Blob capaFrente;
    Blob capaLateral;
    Blob capaCostas;
    Blob capaMidia;
    String linguagens;
    String genero;
    String midia;
    String fontes;
    String descricao;
}
