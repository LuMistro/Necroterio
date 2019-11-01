package br.com.necroterio.dao;


import br.com.necroterio.model.Gaveta;

public class GavetaDao extends GenericDao<Gaveta, Integer> {
	public GavetaDao() {
		super(Gaveta.class);
	}
}
