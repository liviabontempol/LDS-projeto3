package br.com.pucminas.lds3.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 255)
    private String descricao;

    @OneToMany
    private List<?> vantagens;
    //coloquei o ? no tipo pq ainda n temos a classe vantagem

    public Empresa(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;

    }

    
    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<?> getVantagens() {
        return vantagens;
    }

    public void setVantagens(List<?> vantagens) {
        this.vantagens = vantagens;
    }
}
