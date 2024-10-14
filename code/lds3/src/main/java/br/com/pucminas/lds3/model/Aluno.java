package br.com.pucminas.lds3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aluno;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;
    
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

    public Aluno(String nome, String email, String CPF, String RG, String endereco, String curso, Double saldo, String instituicao) {
        this.nome = nome;
        this.email = email;
        this.CPF = CPF;
        this.RG = RG;
        this.endereco = endereco;
        this.curso = curso;
        this.saldo = saldo;
        this.instituicao = instituicao;
    }
   
    public Long getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Long id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
