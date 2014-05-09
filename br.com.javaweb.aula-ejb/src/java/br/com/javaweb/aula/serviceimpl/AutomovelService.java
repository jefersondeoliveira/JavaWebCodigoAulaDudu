package br.com.javaweb.aula.serviceimpl;

import br.com.javaweb.aula.entidade.Automovel;
import br.com.javaweb.aula.service.IAutomovelService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class AutomovelService implements IAutomovelService{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Automovel> listar() {
        TypedQuery<Automovel> automovelQuery =
                em.createQuery("select a from Automovel as a",
                Automovel.class);
        return automovelQuery.getResultList();
    }

    @Override
    public String salvar(Automovel automovel) {
        try {
            
            em.merge(automovel);

        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }

    @Override
    public String remover(Integer idAutomovel) {
        try {
            
           em.remove(em.find(Automovel.class, idAutomovel));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }

        return null;
    }
    
}
