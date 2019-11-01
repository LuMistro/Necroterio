package br.com.necroterio.dao;

import br.com.necroterio.model.Medico;

public class MedicoDao extends GenericDao<Medico, Integer> {
	public MedicoDao() {
		super(Medico.class);
	}

}
