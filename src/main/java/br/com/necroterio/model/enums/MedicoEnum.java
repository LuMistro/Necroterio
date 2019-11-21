package br.com.necroterio.model.enums;

public enum MedicoEnum {

    medico1("Luiza Mistro"),
    medico2("William Mauro"),
    medico3("Agostinho Carrara"),
    medico4("Harry Styles"),
    medico5("Maria Betânia"),
    medico6("Timmy Turner"),
    medico7("Ce Bolinha"),
    medico8("Hotel? Trivago");

    private String descricao;

    MedicoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
