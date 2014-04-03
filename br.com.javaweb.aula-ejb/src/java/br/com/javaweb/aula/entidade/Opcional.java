
package br.com.javaweb.aula.entidade;

import java.util.List;
import javax.persistence.*;

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
    
    
}
