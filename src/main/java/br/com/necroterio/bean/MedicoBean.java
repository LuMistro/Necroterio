package br.com.necroterio.bean;

import br.com.necroterio.dao.MedicoDao;
import br.com.necroterio.model.Endereco;
import br.com.necroterio.model.Medico;
import br.com.necroterio.model.Telefone;
import br.com.necroterio.model.enums.Cidade;
import br.com.necroterio.model.enums.Estado;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class MedicoBean implements Serializable {

    private Medico medico;
    private List<Medico> medicos;
    private MedicoDao dao;
    private Estado[] estados;
    private Cidade[] cidades;
    private Telefone telefone;

    @PostConstruct
    public void init() {
        dao = new MedicoDao();
        limpar();
        buscar();
    }

    public void salvar() {
        if (medico.getId() == null) {
            dao.salvar(medico);
        } else {
            dao.editar(medico);
        }

        limpar();
        buscar();
    }

    public void excluir() {
        dao.excluir(medico);
        limpar();
        buscar();

        FacesMessage mensagem = new FacesMessage();
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        mensagem.setSummary("Pessoa excluída com sucesso!");

        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public void limpar() {
        medico = new Medico();
        medico.setEndereco(new Endereco());
        medico.setTelefone(new Telefone());
    }

    public void buscar() {
        medicos = dao.listarTodos();
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public MedicoDao getDao() {
        return dao;
    }

    public void setDao(MedicoDao dao) {
        this.dao = dao;
    }

    public Estado[] getEstados() {
        return Estado.values();
    }

    public Cidade[] getCidades() {
        return Cidade.values();
    }

    public void setEstados(Estado[] estados) {
        this.estados = estados;
    }

    public void setCidades(Cidade[] cidades) {
        this.cidades = cidades;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
