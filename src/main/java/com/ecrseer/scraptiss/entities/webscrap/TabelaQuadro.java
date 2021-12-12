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

    private boolean isLinhaValida(int divisor,String linha){


        if(divisor==0 || linha.isBlank() || linha.length()-1<=divisor){
            return false;
        }
        char charAnterior = linha.charAt(divisor-1);
        char charProximo = linha.charAt(divisor+1);

        if(!Character.isDigit(charAnterior) || !Character.isLetter(charProximo)){
            return false;
        }

        return true;
    }
    public TabelaQuadro(String text){
        String[] linhas = text.split("\n");
        this.nome=linhas[0].split("Tabela de ")[1].trim();

        this.entidades = new ArrayList<EntidadeGenerica>();

        IntStream.range(3, linhas.length).forEach(
                index-> {
                    int divisor = linhas[index].indexOf(" ");

                    if(isLinhaValida(divisor,linhas[index])){
                        int codigo = Integer.parseInt(linhas[index].substring(0, divisor));
                        String descricao = linhas[index].substring(divisor).trim();
                        entidades.add( new EntidadeGenerica(codigo, descricao) );
                    }
                }

        ); 


    }

}
