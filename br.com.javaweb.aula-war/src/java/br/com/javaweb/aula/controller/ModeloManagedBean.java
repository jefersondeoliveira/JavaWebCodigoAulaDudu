package br.com.javaweb.aula.controller;

import br.com.javaweb.aula.entidade.Modelo;
import br.com.javaweb.aula.service.IModeloService;
import br.com.javaweb.aula.serviceimpl.ModeloService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Jeferson
 */

@Named("modeloManagedBean")
@RequestScoped
public class ModeloManagedBean {
    
    private Modelo modelo;
    private Modelo modeloSelecionado;
    
    @EJB
    private IModeloService modeloService;
    
    public ModeloManagedBean(){
        this.modelo = new Modelo();
        
    }
    
    public List<Modelo> listar() {
        return modeloService.listar();
    }
    
    public void salvar(){
        String erro = modeloService.salvar(modelo);
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Modelo salvo com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        modelo = new Modelo();
    }
    
    public void excluir(){
        String erro = modeloService.remover(modeloSelecionado.getIdModelo());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Modelo excluido com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }
    
    public void editar(){
        modelo = modeloSelecionado;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Modelo getModeloSelecionado() {
        return modeloSelecionado;
    }

    public void setModeloSelecionado(Modelo modeloSelecionado) {
        this.modeloSelecionado = modeloSelecionado;
    }

    
}
