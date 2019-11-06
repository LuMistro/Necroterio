package br.com.necroterio.dao;


import br.com.necroterio.model.Autopsia;

public class AutopsiaDao extends GenericDao<Autopsia, Integer> {
    public AutopsiaDao() {
        super(Autopsia.class);
    }

}
