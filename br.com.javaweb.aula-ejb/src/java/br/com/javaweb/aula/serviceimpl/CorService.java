
package br.com.javaweb.aula.serviceimpl;
import br.com.javaweb.aula.entidade.Cor;
import br.com.javaweb.aula.service.ICorService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CorService implements ICorService{
    
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Cor> listar() {
        TypedQuery<Cor> modeloQuery
                = em.createQuery("select c from Cor as c",
                Cor.class);
        
        return modeloQuery.getResultList();
    }
    
}
