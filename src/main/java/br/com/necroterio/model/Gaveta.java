package br.com.necroterio.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Gaveta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private boolean ocupada;
    @OneToOne
    private Defunto defunto;
    @OneToOne
    private Indigente indigente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gaveta gaveta = (Gaveta) o;
        return id == gaveta.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
