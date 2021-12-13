package com.ecrseer.scraptiss.dto;

import com.ecrseer.scraptiss.entities.DemonstracaoContabil;
import com.ecrseer.scraptiss.entities.Operadora;

import java.time.LocalDate;

public class DemonstracaoContabilDTO {
    private long idDemonstracao;
    private LocalDate data;
    private long cd_conta_contabil;
    private String descricao;
    private long vl_saldo_final;

    private OperadoraDTO operadora;

    public DemonstracaoContabilDTO(){

    }

    public DemonstracaoContabilDTO(long idDemonstracao, LocalDate data,
                                   long cd_conta_contabil, String descricao,
                                   long vl_saldo_final, OperadoraDTO operadora) {
        this.idDemonstracao = idDemonstracao;
        this.data = data;
        this.cd_conta_contabil = cd_conta_contabil;
        this.descricao = descricao;
        this.vl_saldo_final = vl_saldo_final;
        this.operadora = operadora;
    }

    public DemonstracaoContabilDTO(DemonstracaoContabil entidade){
        this.idDemonstracao = entidade.getIdDemonstracao();
        this.data=entidade.getData();
        this.cd_conta_contabil=entidade.getCd_conta_contabil();
        this.descricao=entidade.getDescricao();
        this.operadora=new OperadoraDTO(entidade.getOperadora());
    }

    public long getIdDemonstracao() {
        return idDemonstracao;
    }

    public void setIdDemonstracao(long idDemonstracao) {
        this.idDemonstracao = idDemonstracao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public long getCd_conta_contabil() {
        return cd_conta_contabil;
    }

    public void setCd_conta_contabil(long cd_conta_contabil) {
        this.cd_conta_contabil = cd_conta_contabil;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getVl_saldo_final() {
        return vl_saldo_final;
    }

    public void setVl_saldo_final(long vl_saldo_final) {
        this.vl_saldo_final = vl_saldo_final;
    }

    public OperadoraDTO getOperadora() {
        return operadora;
    }

    public void setOperadora(OperadoraDTO operadora) {
        this.operadora = operadora;
    }
}
