package br.com.necroterio.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

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
    @OneToOne
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
        Defunto other = (Defunto) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
