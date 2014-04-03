package br.com.javaweb.aula.entidade;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Cor")
public class Cor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCor", nullable = false)
    private Short idCor;
    
    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;
    
    @OneToMany(mappedBy = "cor", fetch = FetchType.LAZY)
    private List<Automovel> automovel;

    public Short getIdCor() {
        return idCor;
    }

    public void setIdCor(Short idCor) {
        this.idCor = idCor;
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

