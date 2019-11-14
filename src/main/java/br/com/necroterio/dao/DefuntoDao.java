

package br.com.necroterio.dao;

import br.com.necroterio.dao.util.JpaUtil;
import br.com.necroterio.dto.MortosPorDiaDTO;
import br.com.necroterio.model.Defunto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DefuntoDao extends GenericDao<Defunto, Integer> {
    public DefuntoDao() {
        super(Defunto.class);
    }


    public List<MortosPorDiaDTO> listaMortosPorDia() {
        EntityManager manager = JpaUtil.getEntityManager();

        StringBuilder jpqlBuilder = new StringBuilder();
        jpqlBuilder.append("select new  br.com.necroterio.dto.MortosPorDiaDTO(");
        jpqlBuilder.append("Defunto.dataM");
        jpqlBuilder.append("count(pe)");
        jpqlBuilder.append(")");
        jpqlBuilder.append("from Defunto pe");
        jpqlBuilder.append("right join pe.dataMorte dataM");
        jpqlBuilder.append("group by pe.dataM");

        TypedQuery<MortosPorDiaDTO> query = manager.createQuery(jpqlBuilder.toString(), MortosPorDiaDTO.class);

        List<MortosPorDiaDTO> resultado = query.getResultList();

        manager.close();

        return resultado;
    }


}
