package br.com.necroterio.converter;

import br.com.necroterio.dao.MedicoDao;
import br.com.necroterio.model.Medico;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Medico.class)
public class MedicoConverter implements Converter {

    private MedicoDao dao;

    public MedicoConverter() {
        dao = new MedicoDao();
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        if (dao.buscarPorId(Integer.valueOf(s)) == null) {
            return null;
        } else {
            Medico medico = (Medico) dao.buscarPorId(Integer.valueOf(s));
            return medico;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Medico medico = (Medico) o;
        medico = dao.buscarPorId(medico.getId());

        if (medico == null) {
            return null;
        } else {
            return medico.getId().toString();
        }
    }
}
