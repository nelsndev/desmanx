package br.edu.ifpe.recife.converter;

import br.edu.ifpe.recife.model.negocio.Peca;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

@FacesConverter(value = "pecaConverter")
public class PickListPecaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        DualListModel<Peca> dlm = (DualListModel<Peca>) ((PickList) uic).getValue();

        for (Peca p : dlm.getSource()) {
            if (p.getId().toString().equals(string)) {
                return p;
            }
        }

        for (Peca p : dlm.getTarget()) {
            if (p.getId().toString().equals(string)) {
                return p;
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }
        return ((Peca) o).getId().toString();
    }
}
