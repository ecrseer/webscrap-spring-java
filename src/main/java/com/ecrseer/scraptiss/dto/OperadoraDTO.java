package com.ecrseer.scraptiss.dto;

import com.ecrseer.scraptiss.entities.Operadora;

import java.io.Serializable;

public class OperadoraDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long idOperadora;
    private String nomeFicticio;

    public OperadoraDTO(){

    }
    public OperadoraDTO(long idOperadora,String nomeFicticio){
        this.idOperadora=idOperadora;
        this.nomeFicticio=nomeFicticio;

    }
    public OperadoraDTO(Operadora entity){
        this.idOperadora=entity.getIdOperadora();
        this.nomeFicticio=entity.getNomeFicticio();
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
