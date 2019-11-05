package br.com.necroterio.model.enums;

public enum Estado {

    AC("Acre"),
    AL("Alagoas"),
    AP("Amapá"),
    AM("Amazonas");

    private String descricao;

    Estado(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
