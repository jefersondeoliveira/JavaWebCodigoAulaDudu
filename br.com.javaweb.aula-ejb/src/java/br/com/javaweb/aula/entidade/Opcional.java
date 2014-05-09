
package br.com.javaweb.aula.entidade;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "opcional")
public class Opcional {
    
    @Id
    @GeneratedValue(strategy 
            = GenerationType.IDENTITY)
    @Column(name = "idOpcional",nullable = false)
    
    private Short idOpcional;
    
    @Column(name = "descricao",
            nullable = false,length = 50)
    @NotNull(message = "Informe a descrição")
    private String descricao;
    
    @ManyToMany(fetch = FetchType.LAZY,
            mappedBy = "opcionais")
    private List<Automovel> automoveis;

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }

    
    
    public Short getIdOpcional() {
        return idOpcional;
    }

    public void setIdOpcional(Short idOpcional) {
        this.idOpcional = idOpcional;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idOpcional);
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
        final Opcional other = (Opcional) obj;
        if (!Objects.equals(this.idOpcional, other.idOpcional)) {
            return false;
        }
        return true;
    }
    
    
}
