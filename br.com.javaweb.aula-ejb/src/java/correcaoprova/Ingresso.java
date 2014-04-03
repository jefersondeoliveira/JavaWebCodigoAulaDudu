package correcaoprova;

import javax.persistence.*;

@Entity
@Table(name="ingresso")
public class Ingresso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numero",nullable = false)
    private Integer numero;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEvento")
    private Evento evento;
}
