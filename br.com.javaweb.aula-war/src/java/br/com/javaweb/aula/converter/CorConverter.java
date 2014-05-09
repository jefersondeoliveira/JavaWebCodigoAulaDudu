package br.com.javaweb.aula.converter;

import br.com.javaweb.aula.entidade.Cor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jeferson
 */
@FacesConverter(value = "corConverter", forClass = Cor.class)
public class CorConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if(value == null || value.isEmpty()){
                return null;
            }
            
            Short id = Short.parseShort(value);
            Cor cor = new Cor();
            cor.setIdCor(id);
            return cor;
            
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if(value == null || value.getClass() != Cor.class){
            return null;
        }
        
        Cor cor  = (Cor) value;
        
        return cor.getIdCor().toString();
        
    }
    
}
