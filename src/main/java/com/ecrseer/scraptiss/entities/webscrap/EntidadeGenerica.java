package com.ecrseer.scraptiss.entities.webscrap;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;

@Getter
@Setter
public class EntidadeGenerica {
    private int codigo;
    private String descricao;
    public EntidadeGenerica(int codig,String descrica){
        this.codigo=codig;
        this.descricao=descrica;
    }
    public String emCsv(){
        return codigo+";"+"\""+descricao+"\"\n";
    }
    public String nomeCamposEmCsv(){
        String csv="";
        Class<? extends EntidadeGenerica> thiz =  EntidadeGenerica.class;
        Field[] d = thiz.getDeclaredFields();
        for(Field field : d){
            String nomecampo=field.getName();
            csv+="\""+nomecampo+"\";";
        }
        csv=csv.substring(0,csv.length()-1);
        csv=csv+"\n";
        return csv;
    }
}
