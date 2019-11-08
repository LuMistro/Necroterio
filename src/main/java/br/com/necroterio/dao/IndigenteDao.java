package br.com.necroterio.dao;

import br.com.necroterio.model.Indigente;

public class IndigenteDao extends GenericDao<Indigente, Integer> {
    public IndigenteDao() {
        super(Indigente.class);
    }
}
