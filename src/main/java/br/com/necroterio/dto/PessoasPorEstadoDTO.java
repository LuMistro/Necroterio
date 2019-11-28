package br.com.necroterio.dto;

import br.com.necroterio.model.enums.Estado;

public class PessoasPorEstadoDTO {

    private Estado estado;
    private Long quantidadePessoa;

    public PessoasPorEstadoDTO() {
    }

    public PessoasPorEstadoDTO(Estado estado, Long quantidadePessoa) {
        this.estado = estado;
        this.quantidadePessoa = quantidadePessoa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getQuantidadePessoa() {
        return quantidadePessoa;
    }

    public void setQuantidadePessoa(Long quantidadePessoa) {
        this.quantidadePessoa = quantidadePessoa;
    }
}