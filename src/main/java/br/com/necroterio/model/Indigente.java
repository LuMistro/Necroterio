package br.com.necroterio.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Indigente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identificador;
    private Date dataEntrada;
    private Date dataSaida;
    private Date dataMorte;
    @OneToOne(cascade = CascadeType.ALL)
    private Autopsia autopsia;
    @OneToOne
    private Gaveta gaveta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Autopsia getAutopsia() {
        return autopsia;
    }

    public void setAutopsia(Autopsia autopsia) {
        this.autopsia = autopsia;
    }

    public Date getDataMorte() {
        return dataMorte;
    }

    public void setDataMorte(Date dataMorte) {
        this.dataMorte = dataMorte;
    }

    public Gaveta getGaveta() {
        return gaveta;
    }

    public void setGaveta(Gaveta gaveta) {
        this.gaveta = gaveta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Indigente indigente = (Indigente) o;
        return id.equals(indigente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}