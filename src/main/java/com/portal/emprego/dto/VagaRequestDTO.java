package com.portal.emprego.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VagaRequestDTO {

    @NotBlank(message = "O título da vaga é obrigatório.")
    private String titulo;

    @NotBlank(message = "A descrição da vaga é obrigatória.")
    private String descricao;

    @NotBlank(message = "O nome da empresa é obrigatório.")
    private String empresa;

    @NotNull(message = "O salário deve ser informado.")
    @Positive(message = "O salário deve ser um valor maior que zero.")
    private Double salario;

    @NotBlank(message = "A localização da vaga é obrigatória.")
    private String localizacao;
}