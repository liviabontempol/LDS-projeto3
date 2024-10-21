package br.com.pucminas.lds3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Aluno extends User {

    @Column(nullable = false, length = 15)
    private String CPF;

    @Column(nullable = false, length = 15)
    private String RG;

    @Column(nullable = false, length = 200)
    private String endereco;

    @Column(nullable = false, length = 100)
    private String curso;

    @Column(nullable = false, length = 100)
    private String instituicao;

    @Column(nullable = false)
    private Double saldo;

    public Aluno(String nome, String email, String password, String nome2, String cPF, String rG, String endereco,
            String curso, String instituicao, Double saldo) {
        super(nome, email, password);
        nome = nome2;
        CPF = cPF;
        RG = rG;
        this.endereco = endereco;
        this.curso = curso;
        this.instituicao = instituicao;
        this.saldo = saldo;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
}
