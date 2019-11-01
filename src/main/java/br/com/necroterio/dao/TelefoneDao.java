package br.com.necroterio.dao;

import br.com.necroterio.model.Telefone;

public class TelefoneDao extends GenericDao<Telefone, Integer> {
    public TelefoneDao() {
        super(Telefone.class);
    }

}
