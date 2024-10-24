/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veryona.jogos.model;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jogo {
    
    Console console;
    String ID;
    String nome;
    String regiao;
    String versao;
    double mb;
    String dev;
    String pub;
    String classificacao;
    LocalDate dataLancamento;
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
