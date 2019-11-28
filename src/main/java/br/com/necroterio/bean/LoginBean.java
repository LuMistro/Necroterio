package br.com.necroterio.bean;

import br.com.necroterio.dao.UsuarioDao;
import br.com.necroterio.model.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String email;
    private String senha;
    private Usuario usuarioLogado;

    private UsuarioDao usuarioDao;

    public LoginBean() {
        usuarioDao = new UsuarioDao();
    }

    public String login() {
        usuarioLogado = usuarioDao.verificaLogin(email, senha);

        if (usuarioLogado.getAtivo().equals(true) && usuarioLogado != null) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

            session.setAttribute("usuarioLogado", usuarioLogado);
            return "/secured/Funcionario.xhtml?faces-redirect=true";
        }
        FacesMessage mensagem = new FacesMessage(
        FacesMessage.SEVERITY_ERROR, "E-mail e senha inválido, ou usuário inativo!", null);
        FacesContext.getCurrentInstance().addMessage(null, mensagem);
        return "/login.xhtml";
    }


    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "/login.xhtml?faces-redirect=true";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
