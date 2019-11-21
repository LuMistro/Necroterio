package br.com.necroterio.bean;

import br.com.necroterio.dao.AreasAfetadasDao;
import br.com.necroterio.dao.AutopsiaDao;
import br.com.necroterio.dao.IndigenteDao;
import br.com.necroterio.dao.MedicoDao;
import br.com.necroterio.model.*;
import br.com.necroterio.model.enums.MedicoEnum;
import br.com.necroterio.model.enums.Regiao;

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
    private AreasAfetadasDao areasAfetadasDao;
    private List<AreasAfetadas> listaDeAreasAfetadas;
    private Indigente indigente;
    private IndigenteDao indigenteDao;
    private String idIndigente;
    private List<Medico> listaMedicos;
    private MedicoDao medicoDao;
    private MedicoEnum[] medicos;

    @PostConstruct
    public void init() {
        dao = new AutopsiaDao();
        indigenteDao = new IndigenteDao();
        listaMedicos = new ArrayList<>();
        medicoDao = new MedicoDao();
        areasAfetadasDao = new AreasAfetadasDao();
        limpar();
        buscar();
    }

    public void salvar() {
        if (autopsia.getId() == null) {
            dao.salvar(autopsia);
        } else {
            dao.editar(autopsia);
        }

        FacesMessage mensagem = new FacesMessage();
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        mensagem.setSummary("Autópsia salva com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, mensagem);

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
        autopsia.setIndigente(new Indigente());
        listaDeAreasAfetadas = new ArrayList<>();
        autopsia.setMedico(new Medico());
    }

    public void buscarCoisas() {
        indigente = indigenteDao.buscarPorId(new Integer(idIndigente));
        autopsia = indigente.getAutopsia();

    }

    public void buscar() {
        autopsias = dao.listarTodos();
    }

    public void adicionarLista() {
        AreasAfetadas novaArea = areaAfetada;
        listaDeAreasAfetadas.add(novaArea);
        novaArea.setAutopsia(autopsia);
        areasAfetadasDao.salvar(novaArea);
        areaAfetada = new AreasAfetadas();


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

    public String getIdIndigente() {
        return idIndigente;
    }

    public void setIdIndigente(String idIndigente) {
        this.idIndigente = idIndigente;
    }

    public Indigente getIndigente() {
        return indigente;
    }

    public void setIndigente(Indigente indigente) {
        this.indigente = indigente;
    }

    public List<AreasAfetadas> getListaDeAreasAfetadas() {
        return listaDeAreasAfetadas;
    }

    public void setListaDeAreasAfetadas(List<AreasAfetadas> listaDeAreasAfetadas) {
        this.listaDeAreasAfetadas = listaDeAreasAfetadas;
    }

    public List<Medico> getListaMedicos() {
        return medicoDao.listarTodos();
    }

    public void setListaMedicos(List<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }

    public MedicoEnum[] getMedicos() {
        return MedicoEnum.values();
    }

    public void setMedicos(MedicoEnum[] medicos) {
        this.medicos = medicos;
    }
}
