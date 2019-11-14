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

    public boolean validaDatas() {
        if (defunto.getDataEntrada().after(defunto.getDataMorte()) || defunto.getDataEntrada() == defunto.getDataMorte()) {
            return true;
        }
        if (defunto.getDataEntrada().after(defunto.getPessoa().getNascimento()) || defunto.getDataEntrada() == defunto.getPessoa().getNascimento()) {
            return true;
        }
        if (defunto.getDataEntrada().before(defunto.getDataSaida()) || defunto.getDataEntrada() == defunto.getDataSaida()) {
            return true;
        }
        if (defunto.getDataMorte().after(defunto.getPessoa().getNascimento()) || defunto.getDataMorte() == defunto.getPessoa().getNascimento()) {
            return true;
        }
        if (defunto.getDataMorte().after(defunto.getDataEntrada()) || defunto.getDataMorte() == defunto.getDataEntrada()){
            return true;
        }
        if (defunto.getDataMorte().before(defunto.getDataSaida()) || defunto.getDataMorte() == defunto.getDataSaida()){
            return true;
        }
        return false;
    }


//    Data de nascimento < = data de morte
//    Data de nacimento < = data de Entrada
//    Data de nascimento < = data de saída
//

//    Data de saída >= data de nascimento
//    Data de saída >= data de Entrada
//    Data de saída >= data de saída


public void buscar(){
        defuntos=dao.listarTodos();
        }

public Defunto getDefunto(){
        return defunto;
        }

public void setDefunto(Defunto defunto){
        this.defunto=defunto;
        }

public List<Defunto> getDefuntos(){
        return defuntos;
        }

public void setDefuntos(List<Defunto> defuntos){
        this.defuntos=defuntos;
        }

        }
