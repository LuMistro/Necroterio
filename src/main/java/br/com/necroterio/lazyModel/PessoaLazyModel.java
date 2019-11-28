package br.com.necroterio.lazyModel;

import br.com.necroterio.dao.PessoaDao;
import br.com.necroterio.dao.filter.PessoaFilter;
import br.com.necroterio.model.Pessoa;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.List;
import java.util.Map;

public class PessoaLazyModel extends LazyDataModel<Pessoa> {

    private PessoaFilter filter;
    private PessoaDao pessoaDao;

    public PessoaLazyModel(PessoaDao pessoaDao) {
        this.pessoaDao = pessoaDao;
        filter = new PessoaFilter();
    }

    @Override
    public List<Pessoa> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        filter.setPrimeiroRegistro(first);
        filter.setQuantidadeRegistro(pageSize);
        filter.setPropriedadeOrdenacao(sortField);
        filter.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
        filter.setFiltros(filters);

        setRowCount(pessoaDao.total());
        return pessoaDao.buscar(filter);
    }
}
