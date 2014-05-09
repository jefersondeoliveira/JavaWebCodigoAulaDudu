package br.com.javaweb.aula.controller;
import br.com.javaweb.aula.entidade.Cor;
import br.com.javaweb.aula.service.ICorService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("corManagedBean")
@RequestScoped
public class CorManagedBean {
    
    private Cor cor;
    
    @EJB
    private ICorService corService;
    
    public List<Cor> listar() {
        return corService.listar();
    }
    
    public CorManagedBean(){
        cor = new Cor();
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
    
}
