package br.com.necroterio.model;


import br.com.necroterio.model.enums.Regiao;

import javax.persistence.*;
import java.util.Objects;


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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreasAfetadas that = (AreasAfetadas) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
