package br.com.javaweb.aula.converter;

import br.com.javaweb.aula.entidade.Modelo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jeferson
 */
@FacesConverter(value = "modeloConverter", forClass = Modelo.class)
public class ModeloConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if(value == null || value.isEmpty()){
                return null;
            }
            
            Short id = Short.parseShort(value);
            Modelo modelo = new Modelo();
            modelo.setIdModelo(id);
            return modelo;
            
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if(value == null || value.getClass() != Modelo.class){
            return null;
        }
        
        Modelo modelo  = (Modelo) value;
        
        return modelo.getIdModelo().toString();
        
    }
    
}
