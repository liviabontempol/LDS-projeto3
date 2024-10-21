package br.com.pucminas.lds3.model;

import jakarta.persistence.*;

@Entity
public class Vantagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String descricao;

    @Column(nullable = false)
    private short custo;
    
    @ManyToOne
    private Empresa empresa;

    
    public Vantagem(String descricao, short custo, Empresa empresa) {
        this.descricao = descricao;
        this.custo = custo;
        this.empresa = empresa;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public short getCusto() {
        return custo;
    }

    public void setCusto(short custo) {
        this.custo = custo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
