package br.com.necroterio.model;


import javax.persistence.*;
import java.util.List;


@Entity
public class AreasAfetadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private List<Regiao> regioes;
    private List<String> observacao;
    @ManyToOne
    private Autopsia autopsia;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Regiao> getRegioes() {
        return regioes;
    }

    public void setRegioes(List<Regiao> regioes) {
        this.regioes = regioes;
    }

    public List<String> getObservacao() {
        return observacao;
    }

    public void setObservacao(List<String> observacao) {
        this.observacao = observacao;
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
        AreasAfetadas other = (AreasAfetadas) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
