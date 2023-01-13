package br.edu.ifpe.recife.converter;

import br.edu.ifpe.recife.model.dao.ManagerDao;
import br.edu.ifpe.recife.model.negocio.Modelo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "modeloConverter")
public class SelectOneItemModeloConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null) {
            return null;
        }

        String query = String.format("SELECT m FROM Modelo m WHERE m.id = %s", string);

        return ManagerDao.getInstance().read(query, Modelo.class).get(0);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }

        return ((Modelo) o).getId().toString();
    }
}
