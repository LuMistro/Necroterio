package br.com.necroterio.dao.filter;

import java.util.Map;

public class PessoaFilter {
    private int primeiroRegistro;
    private int quantidadeRegistro;
    private String propriedadeOrdenacao;
    private boolean ascendente;
    private Map<String, Object> filtros;

    public int getPrimeiroRegistro() {
        return primeiroRegistro;
    }

    public void setPrimeiroRegistro(int primeiroRegistro) {
        this.primeiroRegistro = primeiroRegistro;
    }

    public int getQuantidadeRegistro() {
        return quantidadeRegistro;
    }

    public void setQuantidadeRegistro(int quantidadeRegistro) {
        this.quantidadeRegistro = quantidadeRegistro;
    }

    public String getPropriedadeOrdenacao() {
        return propriedadeOrdenacao;
    }

    public void setPropriedadeOrdenacao(String propriedadeOrdenacao) {
        this.propriedadeOrdenacao = propriedadeOrdenacao;
    }

    public boolean isAscendente() {
        return ascendente;
    }

    public void setAscendente(boolean ascendente) {
        this.ascendente = ascendente;
    }

    public Map<String, Object> getFiltros() {
        return filtros;
    }

    public void setFiltros(Map<String, Object> filtros) {
        this.filtros = filtros;
    }
}

