package br.com.javaweb.aula.service;

import br.com.javaweb.aula.entidade.Marca;
import br.com.javaweb.aula.model.GraficoModel;
import java.util.List;

public interface IMarcaService {
    
    public List<Marca> listar();
    
    public String salvar(Marca marca);
    
    public String remover(Short id);
    
    public List<GraficoModel> gerarGrafico();

}
