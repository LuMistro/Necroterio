package br.com.necroterio.model.enums;

public enum Cidade {
    PH("Palhoça"),
    SJ("São José"),
    NY("Nova York"),
    LV("Las Vegas");

    private String descricao;

    Cidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
