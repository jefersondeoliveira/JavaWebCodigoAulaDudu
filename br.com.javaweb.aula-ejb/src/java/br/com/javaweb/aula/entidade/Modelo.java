package br.com.javaweb.aula.entidade;

import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


@Entity
@Table(name="modelo")
public class Modelo {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idModelo",nullable = false)
    private Short idModelo;
    
    @Column(name="descricao",nullable = false,length = 50)
    @NotNull(message = "Informe a descrição")
    private String descricao;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idMarca",nullable = false)
    @NotNull(message = "Informe a marca")
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idModelo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Modelo other = (Modelo) obj;
        if (!Objects.equals(this.idModelo, other.idModelo)) {
            return false;
        }
        return true;
    }
    
    
}
