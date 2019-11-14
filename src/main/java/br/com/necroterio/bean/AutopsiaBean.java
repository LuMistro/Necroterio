package br.com.necroterio.bean;

import br.com.necroterio.dao.AutopsiaDao;
import br.com.necroterio.model.*;
import br.com.necroterio.model.enums.Regiao;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

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

    private Autopsia autopsia;
    private List<Autopsia> autopsias;
    private AutopsiaDao dao;
    private Regiao[] regiaos;
    private AreasAfetadas areaAfetada;
    private List<AreasAfetadas> listaDeAreasAfetadas;


    @PostConstruct
    public void init() {
        dao = new AutopsiaDao();

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
        areaAfetada = new AreasAfetadas();
        autopsia = new Autopsia();
        autopsia.setMedico(new Medico());
        autopsia.setDefunto(new Defunto());
        autopsia.getDefunto().setPessoa(new Pessoa());
        listaDeAreasAfetadas = new ArrayList<>();

    }


    public void buscar() {
        autopsias = dao.listarTodos();
    }

    public void adicionarLista() {
        listaDeAreasAfetadas.add(areaAfetada);
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

    public AutopsiaDao getDao() {
        return dao;
    }

    public void setDao(AutopsiaDao dao) {
        this.dao = dao;
    }

    public Regiao[] getRegiaos() {
        return Regiao.values();
    }

    public void setRegiaos(Regiao[] regiaos) {
        this.regiaos = regiaos;
    }

    public AreasAfetadas getAreaAfetada() {
        return areaAfetada;
    }

    public void setAreaAfetada(AreasAfetadas areaAfetada) {
        this.areaAfetada = areaAfetada;
    }
}
