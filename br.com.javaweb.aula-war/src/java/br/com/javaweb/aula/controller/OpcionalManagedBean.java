package br.com.javaweb.aula.controller;

import br.com.javaweb.aula.entidade.Opcional;
import br.com.javaweb.aula.service.IOpcionalService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("opcionalManagedBean")
@RequestScoped
public class OpcionalManagedBean {
    
    private Opcional opcional;
    private Opcional opcionalSelecionado;
    
    @EJB
    private IOpcionalService opcionalService;
    
    public List<Opcional> listar() {
        return opcionalService.listar();
    }
    
    public OpcionalManagedBean(){
        opcional = new Opcional();
    }
    
    public void salvar() {
        String erro = opcionalService.salvar(opcional);
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Opcional salvo com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        opcional = new Opcional();
    }
    
    public void excluir(){
        String erro = opcionalService.remover(opcionalSelecionado.getIdOpcional());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Opcional excluido com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
    
    public void editar(){
        opcional = opcionalSelecionado;
    }

    public Opcional getOpcional() {
        return opcional;
    }

    public void setOpcional(Opcional opcional) {
        this.opcional = opcional;
    }

    public Opcional getOpcionalSelecionado() {
        return opcionalSelecionado;
    }

    public void setOpcionalSelecionado(Opcional opcionalSelecionado) {
        this.opcionalSelecionado = opcionalSelecionado;
    }
    
    
    
}
