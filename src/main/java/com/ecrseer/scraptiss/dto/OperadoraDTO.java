package com.ecrseer.scraptiss.dto;

import com.ecrseer.scraptiss.entities.Operadora;

import java.io.Serializable;

public class OperadoraDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idOperadora;
    private String nomeFicticio;

    private long regAns;

    public OperadoraDTO(){

    }
    public OperadoraDTO(long idOperadora,String nomeFicticio,long regAns){
        this.idOperadora=idOperadora;
        this.nomeFicticio=nomeFicticio;
        this.regAns=regAns;

    }
    public OperadoraDTO(Operadora entity){
        this.idOperadora=entity.getIdOperadora();
        this.nomeFicticio=entity.getNomeFicticio();
        this.regAns=entity.getRegAns();
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
}
