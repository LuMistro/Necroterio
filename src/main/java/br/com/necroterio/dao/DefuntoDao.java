package br.com.necroterio.dao;

import br.com.necroterio.model.Defunto;

public class DefuntoDao extends GenericDao<Defunto, Integer> {
    public DefuntoDao() {
        super(Defunto.class);
    }
}
