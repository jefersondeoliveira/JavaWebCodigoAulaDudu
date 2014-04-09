package br.com.javaweb.aula.service;

import br.com.javaweb.aula.entidade.Marca;
import java.util.List;


public interface IMarcaService {
    
    public List<Marca> listar();
    
    public String salvar(Marca marca);
    
    public String remover(Short id);

}
