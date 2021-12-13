package com.ecrseer.scraptiss.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_operadoras")
public class Operadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOperadora;
    private long regAns;
    private String nomeFicticio;

    @OneToMany(mappedBy = "operadora")
    List<DemonstracaoContabil> demonstracoes;

    public Operadora(){

    }
    public Operadora(long idOperadora, String nomeFicticio,long regAns,
                     List<DemonstracaoContabil> demonstracoes) {
        this.idOperadora = idOperadora;
        this.nomeFicticio = nomeFicticio;
        this.regAns = regAns;
        this.demonstracoes = demonstracoes;
    }

    public long getRegAns() {
        return regAns;
    }

    public void setRegAns(long regAns) {
        this.regAns = regAns;
    }

    public long getIdOperadora() {
        return idOperadora;
    }

    public void setIdOperadora(long idOperadora) {
        this.idOperadora = idOperadora;
    }

    public String getNomeFicticio() {
        return nomeFicticio;
    }

    public void setNomeFicticio(String nomeFicticio) {
        this.nomeFicticio = nomeFicticio;
    }

    public List<DemonstracaoContabil> getDemonstracoes() {
        return demonstracoes;
    }

    public void setDemonstracoes(List<DemonstracaoContabil> demonstracoes) {
        this.demonstracoes = demonstracoes;
    }
}
