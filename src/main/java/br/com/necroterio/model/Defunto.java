package br.com.necroterio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
    public class Defunto extends Pessoa {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private Date dataEntrada;
        private Date dataSaida;
        private Date dataMorte;
        private Gaveta gaveta;
        private Autopsia autopsia;

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public Autopsia getAutopsia() {
            return autopsia;
        }
        public void setAutopsia(Autopsia autopsia) {
            this.autopsia = autopsia;
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
