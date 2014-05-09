package br.com.javaweb.aula.service;

import br.com.javaweb.aula.entidade.Opcional;
import java.util.List;

public interface IOpcionalService {
     
    public List<Opcional> listar();
    
    public String salvar(Opcional opcional);
    
    public String remover(Short id);
}
