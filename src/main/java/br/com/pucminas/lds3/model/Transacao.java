package br.com.pucminas.lds3.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private short valor;

    @Column(nullable = false)
    private String mensagem;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Professor professor;

    @Column(nullable = false)
    private Date data;

    // Getters e setters
}
