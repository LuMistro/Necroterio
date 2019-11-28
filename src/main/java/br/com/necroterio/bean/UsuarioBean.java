package br.com.necroterio.bean;

import br.com.necroterio.dao.UsuarioDao;
import br.com.necroterio.model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean
public class UsuarioBean implements Serializable {

    private UsuarioDao dao;
    private Usuario usuario;
    private List<Usuario> usuarios;

    @PostConstruct
    public void init() {
        dao = new UsuarioDao();
        usuarios = new ArrayList<>();
        limpar();
        buscar();
    }

    public void salvar() {
        try {
            if (usuario.getId() == null) {
                dao.salvar(usuario);
            } else {
                dao.editar(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage mensagem = new FacesMessage();
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            mensagem.setSummary("Dois usuários não podem ter o mesmo e-mail!");

            FacesContext.getCurrentInstance().addMessage(null, mensagem);
            return;
        }


        limpar();
        buscar();
    }

    public void excluir() {
        dao.excluir(usuario);
        limpar();
        buscar();

        FacesMessage mensagem = new FacesMessage();
        mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        mensagem.setSummary("Usuário excluída com sucesso!");

        FacesContext.getCurrentInstance().addMessage(null, mensagem);
    }

    public void limpar() {
        usuario = new Usuario();
    }

    public void buscar() {
        usuarios = dao.listarTodos();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
