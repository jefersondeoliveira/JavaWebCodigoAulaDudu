package br.com.javaweb.aula.controller;

import br.com.javaweb.aula.entidade.Combustivel;
import br.com.javaweb.aula.service.ICombustivelService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("combustivelManagedBean")
@RequestScoped
public class CombustivelManagedBean {
    
    private Combustivel combustivel;
    
    @EJB
    private ICombustivelService combustivelService;
    
    public List<Combustivel> listar() {
        return combustivelService.listar();
    }
    
    public CombustivelManagedBean(){
        combustivel = new Combustivel();
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }
    
}
