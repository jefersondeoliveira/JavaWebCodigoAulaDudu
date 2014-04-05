package br.com.javaweb.aula.serviceimpl;

import br.com.javaweb.aula.entidade.Opcional;
import br.com.javaweb.aula.service.IOpcionalService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class OpcionalService implements IOpcionalService {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Opcional> listar() {

        TypedQuery<Opcional> opcionalQuery
                = em.createQuery("select o from Opcional as o",
                Opcional.class);
        
        return opcionalQuery.getResultList();
    }

    @Override
    public String salvar(Opcional opcional) {
        try {
            
            em.merge(opcional);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Short idOpcional) {
        try {
            
           em.remove(em.find(Opcional.class, idOpcional));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
}
