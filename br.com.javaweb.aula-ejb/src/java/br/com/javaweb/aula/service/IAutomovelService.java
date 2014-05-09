package br.com.javaweb.aula.service;

import br.com.javaweb.aula.entidade.Automovel;
import java.util.List;

public interface IAutomovelService {
    
    public List<Automovel> listar();
    
    public String salvar(Automovel automovel);
    
    public String remover(Integer id);
}
