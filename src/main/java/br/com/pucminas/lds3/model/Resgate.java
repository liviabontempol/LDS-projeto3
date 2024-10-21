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
    private short valor;
    private Date data;

    // Getters e setters
}
