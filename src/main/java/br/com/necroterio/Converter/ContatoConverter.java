package br.com.necroterio.Converter;

import br.com.necroterio.dao.ContatoDao;
import br.com.necroterio.model.Contato;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Contato.class)
public class ContatoConverter implements Converter {

    private ContatoDao dao;

    public ContatoConverter() {
        dao = new ContatoDao();
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        if (dao.buscarPorId(Integer.valueOf(s)) == null) {
            return null;
        } else {
            Contato contato = (Contato) dao.buscarPorId(Integer.valueOf(s));
            return contato;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Contato contato = (Contato) o;
        contato = dao.buscarPorId(contato.getId());

        if (contato == null) {
            return null;
        } else {
            return contato.getId().toString();
        }
    }
}
