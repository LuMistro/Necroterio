package br.com.necroterio.model;


import br.com.necroterio.model.enums.Regiao;

import javax.persistence.*;


@Entity
public class AreasAfetadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Regiao regiao;
    private String observacao;
    @ManyToOne
    private Autopsia autopsia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Autopsia getAutopsia() {
        return autopsia;
    }

    public void setAutopsia(Autopsia autopsia) {
        this.autopsia = autopsia;
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
