package br.com.necroterio.model;

import br.com.necroterio.model.enums.MedicoEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Autopsia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dataAutopsia;
    @ManyToOne
    private Medico medico;
    @Enumerated(EnumType.STRING)
    private MedicoEnum medicoEnum;
    @OneToMany(mappedBy = "autopsia")
    private List<AreasAfetadas> areasAfetadas;
    private String causaMorte;
    @OneToOne
    private Defunto defunto;
    @OneToOne
    private Indigente indigente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Indigente getIndigente() {
        return indigente;
    }

    public void setIndigente(Indigente indigente) {
        this.indigente = indigente;
    }

    public MedicoEnum getMedicoEnum() {
        return medicoEnum;
    }

    public void setMedicoEnum(MedicoEnum medicoEnum) {
        this.medicoEnum = medicoEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autopsia autopsia = (Autopsia) o;
        return Objects.equals(id, autopsia.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
