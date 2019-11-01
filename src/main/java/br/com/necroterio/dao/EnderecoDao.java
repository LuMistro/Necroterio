package br.com.necroterio.dao;


import br.com.necroterio.model.Endereco;

public class EnderecoDao extends GenericDao<Endereco, Integer> {
	public EnderecoDao() {
		super(Endereco.class);
	}

}
