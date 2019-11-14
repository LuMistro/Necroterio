package br.com.necroterio.dao;

import br.com.necroterio.model.Pessoa;

import java.util.List;

public class PessoaDao extends GenericDao<Pessoa, Integer> {
	public PessoaDao() {
		super(Pessoa.class);
	}
}
