package br.com.javaweb.aula.serviceimpl;

import br.com.javaweb.aula.service.IModeloService;
import br.com.javaweb.aula.entidade.Modelo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jeferson
 */
@Stateless
public class ModeloService implements IModeloService {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public String salvar(Modelo modelo){
        try {
            em.merge(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return null;
    }

    @Override
    public List<Modelo> listar() {

        TypedQuery<Modelo> modeloQuery
                = em.createQuery("select m from Modelo as m",
                Modelo.class);
        
        return modeloQuery.getResultList();
    }

    @Override
    public String remover(Short idModelo) {
        try {
            
           em.remove(em.find(Modelo.class, idModelo));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
}
