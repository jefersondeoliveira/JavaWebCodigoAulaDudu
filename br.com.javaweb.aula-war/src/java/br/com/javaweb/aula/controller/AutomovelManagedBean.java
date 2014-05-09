package br.com.javaweb.aula.controller;

import br.com.javaweb.aula.entidade.Automovel;
import br.com.javaweb.aula.service.IAutomovelService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("automovelManagedBean")
@RequestScoped
public class AutomovelManagedBean {
    
    private Automovel automovel;
    private Automovel automovelSelecionado;
    
    @EJB
    private IAutomovelService automovelService;
    
    public List<Automovel> listar() {
        return automovelService.listar();
    }
    
    public AutomovelManagedBean(){
        automovel = new Automovel();
    }
    
    public void salvar() {
        String erro = automovelService.salvar(automovel);
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Automovel salvo com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        automovel = new Automovel();
    }
    
    public void excluir(){
        String erro = automovelService.remover(automovelSelecionado.getIdAutomovel());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Automovel excluido com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
    
    public void editar(){
        automovel = automovelSelecionado;
    }
    
    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Automovel getAutomovelSelecionado() {
        return automovelSelecionado;
    }

    public void setAutomovelSelecionado(Automovel automovelSelecionado) {
        this.automovelSelecionado = automovelSelecionado;
    }
    
    
    
}
