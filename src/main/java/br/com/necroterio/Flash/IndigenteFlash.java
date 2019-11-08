package br.com.necroterio.Flash;

import br.com.necroterio.model.Autopsia;
import br.com.necroterio.model.Indigente;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ComponentSystemEvent;

@ViewScoped
@ManagedBean
public class IndigenteFlash {

    private Indigente indigente;
    private Autopsia autopsia;

    public String goToConfirmView() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("Indigente", indigente);
        flash.put("Autopsia", autopsia);
        return "confirm?faces-redirect=true";
    }

    public String goToInputFormView() {
        return "input?faces-redirect=true";
    }

    public String insertValue() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();

        flash.setKeepMessages(true);
        pullValuesFromFlash(null);

        System.out.println("Indigente: " + indigente);
        System.out.println("Autopsia: " + autopsia);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Value inserted"));
        return "done?faces-redirect=true";
    }

    public void pullValuesFromFlash(ComponentSystemEvent e) {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        indigente = (Indigente) flash.get("Indigente");
        autopsia = (Autopsia) flash.get("Autopsia");
    }

    public Indigente getIndigente() {
        return indigente;
    }

    public void setIndigente(Indigente indigente) {
        this.indigente = indigente;
    }

    public Autopsia getAutopsia() {
        return autopsia;
    }

    public void setAutopsia(Autopsia autopsia) {
        this.autopsia = autopsia;
    }
}

