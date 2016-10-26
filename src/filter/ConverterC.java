package filter;

import dao.RelacionamentoDAO;
import model.Relacionamento;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by pdj_3 on 25/10/2016.
 */
@FacesConverter("themeConverter")
public class ConverterC implements Converter {

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                RelacionamentoDAO service = (RelacionamentoDAO) fc.getExternalContext().getApplicationMap().get("RelacionamentoDAO");

                return service.getTheme().get(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Relacionamento) object).getId());
        }
        else {
            return null;
        }
    }
}
