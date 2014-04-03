package br.com.javaweb.aula.entidade;

import javax.persistence.*;


@Entity
@Table(name="modelo")
public class Modelo {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idModelo",nullable = false)
    private Short idModelo;
    
    @Column(name="descricao",nullable = false,length = 50)
    private String descricao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idMarca",nullable = false)
    private Marca marca;

    public Short getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Short idModelo) {
        this.idModelo = idModelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    
}
