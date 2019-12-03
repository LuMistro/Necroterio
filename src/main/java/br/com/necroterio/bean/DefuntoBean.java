package br.com.necroterio.bean;

import br.com.necroterio.dao.DefuntoDao;
import br.com.necroterio.model.*;
import br.com.necroterio.model.enums.GavetaEnum;

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

    private Defunto defunto;
    private List<Defunto> defuntos;
    private DefuntoDao dao;
    private GavetaEnum[] gavetaEnum;

    @PostConstruct
    public void init() {
        dao = new DefuntoDao();
        limpar();
        buscar();
    }

    public void salvar() {
        if (validaDatas()) {
            if (defunto.getId() == null) {
                dao.salvar(defunto);
            } else {
                dao.editar(defunto);
            }
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
        defunto.setAutopsia(new Autopsia());
    }

    public boolean validaDatas() {
        FacesMessage mensagem = new FacesMessage();
        mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);

        if (defunto.getDataEntrada().after(defunto.getDataMorte())
                && defunto.getDataEntrada().after(defunto.getPessoa().getNascimento())
                && defunto.getDataMorte().after(defunto.getPessoa().getNascimento())
                && defunto.getDataMorte().before(defunto.getDataSaida())
                && defunto.getPessoa().getNascimento().before(defunto.getDataSaida())) {
            return true;
        }
        mensagem.setSummary("Datas inválidas");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
        return false;
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

    public GavetaEnum[] getGavetaEnum() {
        return GavetaEnum.values();
    }

    public void setGavetaEnum(GavetaEnum[] gavetaEnum) {
        this.gavetaEnum = gavetaEnum;
    }
}
