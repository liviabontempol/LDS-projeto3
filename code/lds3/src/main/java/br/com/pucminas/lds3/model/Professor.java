package br.com.pucminas.lds3.model;

import jakarta.persistence.*;

@Entity
public class Professor extends User {

    @Column(nullable = false, length = 100)
    private String departamento;

    @Column(nullable = false, length = 100)
    private double saldo;

    public Professor(String nome, String email, String password, String departamento, double saldo) {
        super(nome, email, password);
        this.departamento = departamento;
        this.saldo = saldo;
    }

    public String getDepartamento() {
        return departamento;
    }

public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

public double getSaldo() {
        return saldo;
    }

public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
}
