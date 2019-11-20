package br.com.necroterio.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Medico extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String CRM;
    @OneToMany(mappedBy = "medico")
    private List<Autopsia> autopsia;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public List<Autopsia> getAutopsia() {
        return autopsia;
    }

    public void setAutopsia(List<Autopsia> autopsia) {
        this.autopsia = autopsia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Medico medico = (Medico) o;
        return id == medico.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
