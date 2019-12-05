package br.com.necroterio.model;

import br.com.necroterio.model.enums.GavetaEnum;

import javax.persistence.*;
import javax.validation.metadata.CascadableDescriptor;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
public class Defunto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    @Temporal(TemporalType.DATE)
    private Date dataSaida;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMorte;
    @OneToOne
    private Gaveta gaveta;
    @Enumerated(EnumType.STRING)
    private GavetaEnum gavetaEnum;
    @OneToOne(cascade = CascadeType.ALL)
    private Autopsia autopsia;
    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;
    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Autopsia getAutopsia() {
        return autopsia;
    }

    public void setAutopsia(Autopsia autopsia) {
        this.autopsia = autopsia;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public GavetaEnum getGavetaEnum() {
        return gavetaEnum;
    }

    public void setGavetaEnum(GavetaEnum gavetaEnum) {
        this.gavetaEnum = gavetaEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defunto defunto = (Defunto) o;
        return Objects.equals(id, defunto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
