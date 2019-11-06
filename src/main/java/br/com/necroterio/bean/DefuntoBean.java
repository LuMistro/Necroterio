package br.com.necroterio.bean;

import br.com.necroterio.dao.DefuntoDao;
import br.com.necroterio.model.Contato;
import br.com.necroterio.model.Defunto;
import br.com.necroterio.model.Pessoa;
import br.com.necroterio.model.Telefone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@ManagedBean
public class DefuntoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Defunto defunto;
    private List<Defunto> defuntos;
    private DefuntoDao dao;
    private Contato contato;

    @PostConstruct
    public void init() {
        dao = new DefuntoDao();
        limpar();
        buscar();
    }

    public void salvar() {
        if (defunto.getId() == null) {
            dao.salvar(defunto);
        } else {
            dao.editar(defunto);
        }

        limpar();
        buscar();
    }

    public void excluir() {
        dao.excluir(defunto);
        limpar();
        buscar();

        FacesMessage mensagem = new FacesMessage();
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        mensagem.setSummary("Pessoa excluída com sucesso!");

        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public void limpar() {
        defunto = new Defunto();
        defunto.setContato(new Contato());
        defunto.setPessoa(new Pessoa());
    }

    public void buscar() {
        defuntos = dao.listarTodos();
    }

    public Defunto getDefunto() {
        return defunto;
    }

    public void setDefunto(Defunto defunto) {
        this.defunto = defunto;
    }

    public List<Defunto> getDefuntos() {
        return defuntos;
    }

    public void setDefuntos(List<Defunto> defuntos) {
        this.defuntos = defuntos;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}
