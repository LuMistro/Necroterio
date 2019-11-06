package br.com.necroterio.dao;

import br.com.necroterio.model.Contato;

public class ContatoDao extends GenericDao<Contato, Integer> {
    public ContatoDao() {
        super(Contato.class);
    }
}
