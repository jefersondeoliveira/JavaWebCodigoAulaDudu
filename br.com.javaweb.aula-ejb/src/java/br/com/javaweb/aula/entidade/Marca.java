package br.com.javaweb.aula.entidade;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "marca")
public class Marca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMarca",nullable = false)
    private Short idMarca;
    
    @Column(name = "descricao",nullable=false,length = 50)
    @NotNull(message = "Informe a descrição")
    private String descricao;

    @OneToMany(mappedBy = "marca",
            fetch = FetchType.LAZY)
    private List<Modelo> modelos;
           
    
    public Short getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Short idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }
    
    
}
