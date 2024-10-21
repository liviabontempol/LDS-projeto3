package br.com.pucminas.lds3.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Resgate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vantagem vantagem;

    @ManyToOne
    private Aluno aluno;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private Date data;


    public Resgate(Long id, Vantagem vantagem, Aluno aluno, double valor, Date data) {
        this.id = id;
        this.vantagem = vantagem;
        this.aluno = aluno;
        this.valor = valor;
        this.data = data;
    }

    
    public Long getId() {
        return id;
    }
public void setId(Long id) {
        this.id = id;
    }
public Vantagem getVantagem() {
        return vantagem;
    }
public void setVantagem(Vantagem vantagem) {
        this.vantagem = vantagem;
    }
public Aluno getAluno() {
        return aluno;
    }
public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
public double getValor() {
        return valor;
    }
public void setValor(double valor) {
        this.valor = valor;
    }
public Date getData() {
        return data;
    }
public void setData(Date data) {
        this.data = data;
    }
}