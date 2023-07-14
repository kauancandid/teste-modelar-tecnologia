package com.example.ModelarTecnologia.dto.processes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcessesRequestDTO {

    @NotNull(message = "Campo número não pode ser vazio")
    private int numero;

    @NotBlank(message = "Campo nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "Campo descrição não pode ser vazio")
    private String descricao;

    private String codMacro;

    private String codClassificacao;
}
