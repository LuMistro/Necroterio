package br.com.necroterio.bean;

import br.com.necroterio.dao.IndigenteDao;
import br.com.necroterio.model.Autopsia;
import br.com.necroterio.model.Gaveta;
import br.com.necroterio.model.Indigente;
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
public class IndigenteBean implements Serializable {

    private Indigente indigente;
    private List<Indigente> indigentes;
    private IndigenteDao dao;
    private GavetaEnum[] gavetas;

    @PostConstruct
    public void init() {
        dao = new IndigenteDao();
        limpar();
        buscar();
    }

    public void salvar() {
        if (indigente.getId() == null) {
            dao.salvar(indigente);
        } else {
            dao.editar(indigente);
        }

        limpar();
        buscar();
    }

    public void excluir() {
        dao.excluir(indigente);
        limpar();
        buscar();

        FacesMessage mensagem = new FacesMessage();
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        mensagem.setSummary("Pessoa excluída com sucesso!");

        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public void limpar() {
        indigente = new Indigente();
        indigente.setGaveta(new Gaveta());
        indigente.setAutopsia(new Autopsia());
    }

    public void buscar() {
        indigentes = dao.listarTodos();
    }

    public Indigente getIndigente() {
        return indigente;
    }

    public void setIndigente(Indigente indigente) {
        this.indigente = indigente;
    }

    public List<Indigente> getIndigentes() {
        return indigentes;
    }

    public void setIndigentes(List<Indigente> indigentes) {
        this.indigentes = indigentes;
    }

    public GavetaEnum[] getGavetas() {
        return GavetaEnum.values();
    }

    public void setGavetas(GavetaEnum[] gavetas) {
        this.gavetas = gavetas;
    }
}
