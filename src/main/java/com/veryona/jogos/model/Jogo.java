/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veryona.jogos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Jogo")
public class Jogo {
    
    @ManyToOne
    Console console;
    @Id
    String ID;
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

    public Jogo(){
        
    }

    public Jogo(Console console, String ID, String nome, String regiao, String versao, double mb, String dev, String pub, String classificacao, String dataLancamento, String arquivo, Blob capaFrente, Blob capaLateral, Blob capaCostas, Blob capaMidia, String linguagens, String genero, String midia, String fontes, String descricao) {
        this.console = console;
        this.ID = ID;
        this.nome = nome;
        this.regiao = regiao;
        this.versao = versao;
        this.mb = mb;
        this.dev = dev;
        this.pub = pub;
        this.classificacao = classificacao;
        this.dataLancamento = dataLancamento;
        this.arquivo = arquivo;
        this.capaFrente = capaFrente;
        this.capaLateral = capaLateral;
        this.capaCostas = capaCostas;
        this.capaMidia = capaMidia;
        this.linguagens = linguagens;
        this.genero = genero;
        this.midia = midia;
        this.fontes = fontes;
        this.descricao = descricao;
    }
    
    

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public double getMb() {
        return mb;
    }

    public void setMb(double mb) {
        this.mb = mb;
    }

    public String getDev() {
        return dev;
    }

    public void setDev(String dev) {
        this.dev = dev;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
    
    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public LocalDateTime getAdd() {
        return add;
    }

    public void setAdd(LocalDateTime add) {
        this.add = add;
    }

    public Blob getCapaFrente() {
        return capaFrente;
    }

    public void setCapaFrente(Blob capaFrente) {
        this.capaFrente = capaFrente;
    }

    public Blob getCapaLateral() {
        return capaLateral;
    }

    public void setCapaLateral(Blob capaLateral) {
        this.capaLateral = capaLateral;
    }

    public Blob getCapaCostas() {
        return capaCostas;
    }

    public void setCapaCostas(Blob capaCostas) {
        this.capaCostas = capaCostas;
    }

    public Blob getCapaMidia() {
        return capaMidia;
    }

    public void setCapaMidia(Blob capaMidia) {
        this.capaMidia = capaMidia;
    }

    public String getLinguagens() {
        return linguagens;
    }

    public void setLinguagens(String linguagens) {
        this.linguagens = linguagens;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }

    public String getFontes() {
        return fontes;
    }

    public void setFontes(String fontes) {
        this.fontes = fontes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
