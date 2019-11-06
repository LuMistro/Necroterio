package br.com.necroterio.bean;

import br.com.necroterio.dao.PessoaDao;
import br.com.necroterio.model.Endereco;
import br.com.necroterio.model.Pessoa;
import br.com.necroterio.model.enums.Cidade;
import br.com.necroterio.model.enums.Estado;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@ManagedBean
public class PessoaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pessoa pessoa;
    private List<Pessoa> pessoas;
    private PessoaDao dao;
    private Estado[] estados;
    private Cidade[] cidades;

    @PostConstruct
    public void init() {
        dao = new PessoaDao();
        limpar();
        buscar();
    }

    public void salvar() {
        if (pessoa.getId() == null) {
            dao.salvar(pessoa);
        } else {
            dao.editar(pessoa);
        }

        limpar();
        buscar();
    }

    public void excluir() {
        dao.excluir(pessoa);
        limpar();
        buscar();

        FacesMessage mensagem = new FacesMessage();
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        mensagem.setSummary("Pessoa excluída com sucesso!");

        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public void limpar() {
        pessoa = new Pessoa();
        pessoa.setEndereco(new Endereco());
    }

    public void buscar() {
        pessoas = dao.listarTodos();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
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
}
