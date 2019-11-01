package br.com.necroterio.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Autopsia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dataAutopsia;
    @ManyToOne
    private Medico medico;
    @OneToMany(mappedBy = "autopsia")
    private List<AreasAfetadas> areasAfetadas;
    private String causaMorte;
    @OneToOne
    private Defunto defunto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataAutopsia() {
        return dataAutopsia;
    }

    public void setDataAutopsia(Date dataAutopsia) {
        this.dataAutopsia = dataAutopsia;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<AreasAfetadas> getAreasAfetadas() {
        return areasAfetadas;
    }

    public void setAreasAfetadas(List<AreasAfetadas> areasAfetadas) {
        this.areasAfetadas = areasAfetadas;
    }

    public String getCausaMorte() {
        return causaMorte;
    }

    public void setCausaMorte(String causaMorte) {
        this.causaMorte = causaMorte;
    }

    public Defunto getDefunto() {
        return defunto;
    }

    public void setDefunto(Defunto defunto) {
        this.defunto = defunto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Autopsia other = (Autopsia) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
