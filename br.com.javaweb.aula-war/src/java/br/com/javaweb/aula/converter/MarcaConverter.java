package br.com.javaweb.aula.converter;

import br.com.javaweb.aula.entidade.Marca;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Jeferson
 */
@FacesConverter(value = "marcaConverter", forClass = Marca.class)
public class MarcaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            if(value == null || value.isEmpty()){
                return null;
            }
            
            Short id = Short.parseShort(value);
            Marca marca = new Marca();
            marca.setIdMarca(id);
            return marca;
            
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if(value == null || value.getClass() != Marca.class){
            return null;
        }
        
        Marca marca  = (Marca) value;
        
        return marca.getIdMarca().toString();
        
    }
    
}
