package br.com.javaweb.aula.controller;

import br.com.javaweb.aula.entidade.Marca;
import br.com.javaweb.aula.service.IMarcaService;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("marcaManagedBean")
@RequestScoped
public class MarcaManagedBean {

    private Marca marca;
    private Marca marcaSelecionada;

    @EJB
    private IMarcaService marcaService;

    public List<Marca> listar() {
        return marcaService.listar();
    }
    
    public MarcaManagedBean(){
        marca = new Marca();
    }

    public void salvar() {
        String erro = marcaService.salvar(marca);
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Marca salva com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        marca = new Marca();
    }
    
    public void excluir(){
        String erro = marcaService.remover(marcaSelecionada.getIdMarca());
        if (erro == null) {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Marca excluida com sucesso", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    erro, null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
    }

    public Marca getMarca() {
        return marca;
    }
    
    public void editar(){
        marca = marcaSelecionada;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Marca getMarcaSelecionada() {
        return marcaSelecionada;
    }

    public void setMarcaSelecionada(Marca marcaSelecionada) {
        this.marcaSelecionada = marcaSelecionada;
    }
    
    

}
