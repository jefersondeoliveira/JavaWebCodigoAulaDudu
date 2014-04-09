package br.com.javaweb.aula.serviceimpl;

import br.com.javaweb.aula.entidade.Marca;
import br.com.javaweb.aula.service.IMarcaService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class MarcaService implements IMarcaService {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Marca> listar() {

        TypedQuery<Marca> marcaQuery
                = em.createQuery("select m from Marca as m",
                Marca.class);

        return marcaQuery.getResultList();
    }

    @Override
    public String salvar(Marca marca) {
        try {
            
            em.merge(marca);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Short idMarca) {
        try {
            
           em.remove(em.find(Marca.class, idMarca));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
}
