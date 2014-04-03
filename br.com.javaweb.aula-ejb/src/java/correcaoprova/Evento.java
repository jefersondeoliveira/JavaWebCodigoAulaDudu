
package correcaoprova;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="evento")
public class Evento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEvento",nullable = false)
    private Integer idEvento;
    
    @Column(name="nome",nullable = false)
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data",nullable = false)
    private Date data;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "evento")
    private List<Ingresso> ingressos;
}
