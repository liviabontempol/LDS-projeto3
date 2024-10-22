package br.com.pucminas.lds3.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("empresa")
public class Empresa extends User{

   

    @Column(nullable = false, length = 255)
    private String descricao;

    @OneToMany(mappedBy = "empresa")
    private List<Vantagem> vantagens;


    public Empresa(String nome, String email, String password, Long idEmpresa, String nome2, String descricao,
            List<Vantagem> vantagens) {
        super(nome, email, password);
        //this.idEmpresa = idEmpresa;
        this.descricao = descricao;
        this.vantagens = vantagens;
    }

   

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Vantagem> getVantagens() {
        return vantagens;
    }

    public void setVantagens(List<Vantagem> vantagens) {
        this.vantagens = vantagens;
    }
}
