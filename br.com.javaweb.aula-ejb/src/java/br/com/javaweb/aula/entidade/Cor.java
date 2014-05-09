package br.com.javaweb.aula.entidade;
import java.util.List;
import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.idCor);
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
        final Cor other = (Cor) obj;
        if (!Objects.equals(this.idCor, other.idCor)) {
            return false;
        }
        return true;
    }
    
    
}

