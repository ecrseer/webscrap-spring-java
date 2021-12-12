package com.ecrseer.scraptiss.entities.webscrap;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
@Setter
public class TabelaQuadro {

    private String nome;
    private List<EntidadeGenerica> entidades;

    public TabelaQuadro(String text){
        String[] linhas = text.split("\n");
        this.nome=linhas[0].split("Tabela de ")[1].trim();

        this.entidades = new ArrayList<EntidadeGenerica>();
        IntStream.range(3, linhas.length).forEach(
                index-> {
                    int divisor = linhas[index].indexOf(" ");

                    int codigo = Integer.parseInt(linhas[index].substring(0, divisor));
                    String descricao = linhas[index].substring(divisor).trim();
                    entidades.add( new EntidadeGenerica(codigo, descricao) );
                }

        ); 


    }

}
