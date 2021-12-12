package com.ecrseer.scraptiss.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_demonstracoes")
public class DemonstracaoContabil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDemonstracao;

    private String data;
    private long cd_conta_contabil;
    private String descricao;
    private long vl_saldo_final;

    @ManyToOne
    @JoinColumn(name = "reg_ans")
    private Operadora operadora;

    public DemonstracaoContabil(long idDemonstracao, String data,
                                long cd_conta_contabil, String descricao,
                                long vl_saldo_final, Operadora operadora) {
        this.idDemonstracao = idDemonstracao;
        this.data = data;
        this.cd_conta_contabil = cd_conta_contabil;
        this.descricao = descricao;
        this.vl_saldo_final = vl_saldo_final;
        this.operadora = operadora;
    }

    public long getIdDemonstracao() {
        return idDemonstracao;
    }

    public void setIdDemonstracao(long idDemonstracao) {
        this.idDemonstracao = idDemonstracao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }
}
