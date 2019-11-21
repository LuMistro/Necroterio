package br.com.necroterio.model.enums;

public enum GavetaEnum {
    gavetaA("1A"),
    gavetaB("2A"),
    gavetaC("3A"),
    gavetaD("4A"),
    gavetaE("5A"),
    gavetaF("6A"),
    gavetaG("7A"),
    gavetaH("8A");

    private String descricao;

    GavetaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
