package br.com.necroterio.model;

import javax.persistence.*;

@Entity
public class Gaveta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private boolean ocupada;
    @OneToOne
    private Defunto defunto;

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
        Gaveta other = (Gaveta) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
