package br.com.necroterio.dto;

public class MortosPorDiaDTO {

    private String defunto;
    private Long quantidade;

    public MortosPorDiaDTO(String defunto, Long quantidade) {
        this.defunto = defunto;
        this.quantidade = quantidade;
    }

    public String getDefunto() {
        return defunto;
    }

    public void setDefunto(String defunto) {
        this.defunto = defunto;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
