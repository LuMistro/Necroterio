package br.com.necroterio.bean;

import br.com.necroterio.dao.AutopsiaDao;
import br.com.necroterio.model.AreasAfetadas;
import br.com.necroterio.model.Autopsia;
import br.com.necroterio.model.Defunto;
import br.com.necroterio.model.Medico;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean
public class AutopsiaBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Autopsia autopsia;
    private List<Autopsia> autopsias;
    private AutopsiaDao dao;
    private List<Integer> columns;


    @PostConstruct
    public void init() {
        dao = new AutopsiaDao();
        columns = new ArrayList<Integer>();
        for (int i = 1; i < 7; i++) {
            columns.add(i);
        }
        limpar();
        buscar();
    }

    public void salvar() {
        if (autopsia.getId() == null) {
            dao.salvar(autopsia);
        } else {
            dao.editar(autopsia);
        }

        limpar();
        buscar();
    }

    public void excluir() {
        dao.excluir(autopsia);
        limpar();
        buscar();

        FacesMessage mensagem = new FacesMessage();
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        mensagem.setSummary("Autópsia excluída com sucesso!");

        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public void limpar() {
        autopsia = new Autopsia();
        autopsia.setMedico(new Medico());
        autopsia.setDefunto(new Defunto());
        autopsia.setAreasAfetadas(new ArrayList<>());
        columns = new ArrayList<>();
    }

    public void increment() {
        if (columns.size() < 20) {
            columns.add(columns.size() + 1);
        }
    }

    public void decrease() {
        if (columns.size() > 1) {
            columns.remove(columns.size() - 1);
        }
    }

    public void buscar() {
        autopsias = dao.listarTodos();
    }

    public Autopsia getAutopsia() {
        return autopsia;
    }

    public void setAutopsia(Autopsia autopsia) {
        this.autopsia = autopsia;
    }

    public List<Autopsia> getAutopsias() {
        return autopsias;
    }

    public void setAutopsias(List<Autopsia> autopsias) {
        this.autopsias = autopsias;
    }

    public List<Integer> getColumns() {
        return columns;
    }

    public void setColumns(List<Integer> columns) {
        this.columns = columns;
    }
}
