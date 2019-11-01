package br.com.necroterio.dao;

import br.com.necroterio.model.Pessoa;

public class PessoaDao extends GenericDao<Pessoa, Integer> {
	public PessoaDao() {
		super(Pessoa.class);
	}
}
