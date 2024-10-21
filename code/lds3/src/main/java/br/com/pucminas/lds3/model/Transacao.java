package br.com.pucminas.lds3.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private String mensagem;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Professor professor;

    @Column(nullable = false)
    private Date data;
    

    public Transacao(Long id, double valor, String mensagem, Aluno aluno, Professor professor, Date data) {
        this.id = id;
        this.valor = valor;
        this.mensagem = mensagem;
        this.aluno = aluno;
        this.professor = professor;
        this.data = data;
    }
    public Long getId() {
        return id;
    }
public void setId(Long id) {
        this.id = id;
    }
public double getValor() {
        return valor;
    }
public void setValor(double valor) {
        this.valor = valor;
    }
public String getMensagem() {
        return mensagem;
    }
public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
public Aluno getAluno() {
        return aluno;
    }
public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
public Professor getProfessor() {
        return professor;
    }
public void setProfessor(Professor professor) {
        this.professor = professor;
    }
public Date getData() {
        return data;
    }
public void setData(Date data) {
        this.data = data;
    }
}