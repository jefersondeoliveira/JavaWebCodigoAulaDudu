package br.com.javaweb.aula.entidade;

import java.util.List;
import javax.persistence.*;

@Entity
public class Combustivel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCombustivel", nullable = false)
    private Short idCombustivel;
    
    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;
    
    @OneToMany(mappedBy = "combustivel", fetch = FetchType.LAZY)
    private List<Automovel> automovel;
    

    public Short getIdCombustivel() {
        return idCombustivel;
    }

    public void setIdCombustivel(Short idCombustivel) {
        this.idCombustivel = idCombustivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Automovel> getAutomovel() {
        return automovel;
    }

    public void setAutomovel(List<Automovel> automovel) {
        this.automovel = automovel;
    }
    
}
