/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.javaweb.aula.service;

import br.com.javaweb.aula.entidade.Modelo;
import java.util.List;

/**
 *
 * @author Jeferson
 */
public interface IModeloService {

    String salvar(Modelo modelo);
    
    public List<Modelo> listar();
    
    public String remover(Short id);
    
}
