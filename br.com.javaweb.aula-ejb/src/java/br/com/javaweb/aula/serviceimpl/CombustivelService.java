
package br.com.javaweb.aula.serviceimpl;

import br.com.javaweb.aula.entidade.Combustivel;
import br.com.javaweb.aula.service.ICombustivelService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CombustivelService implements ICombustivelService{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Combustivel> listar() {
           
        TypedQuery<Combustivel> modeloQuery
                = em.createQuery("select c from Combustivel as c",
                Combustivel.class);
        
        return modeloQuery.getResultList();
    
    }
   
    
    
}
