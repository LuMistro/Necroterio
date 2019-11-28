package br.com.necroterio.dao;

import br.com.necroterio.dao.util.JpaUtil;
import br.com.necroterio.dto.PessoasPorEstadoDTO;
import br.com.necroterio.model.Medico;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MedicoDao extends GenericDao<Medico, Integer> {
	public MedicoDao() {
		super(Medico.class);
	}
}
