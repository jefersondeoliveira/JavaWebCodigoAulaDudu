package br.com.javaweb.aula.converter;

import br.com.javaweb.aula.entidade.Opcional;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jeferson
 */
@FacesConverter(value = "opcionalConverter", forClass = Opcional.class)
public class OpcionalConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if(value == null || value.isEmpty()){
                return null;
            }
            
            Short id = Short.parseShort(value);
            Opcional opcional = new Opcional();
            opcional.setIdOpcional(id);
            return opcional;
            
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if(value == null || value.getClass() != Opcional.class){
            return null;
        }
        
        Opcional opcional  = (Opcional) value;
        
        return opcional.getIdOpcional().toString();
        
    }
    
}
