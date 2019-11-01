package br.com.necroterio.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Medico extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String CRM;
    @OneToMany(mappedBy = "medico")
    private List<Autopsia> autopsia;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
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
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Medico other = (Medico) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
