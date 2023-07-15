package com.example.ModelarTecnologia.dto.macroprocesses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MacroprocessesRequestDTO {
    @NotNull(message = "Campo número não pode ser vazio")
    private int numero;

    @NotBlank(message = "Campo nome não pode ser vazio")
    private String nome;

    @NotBlank(message = "Campo descrição não pode ser vazio")
    private String descricao;

    private Date dataInicio;

    private Date dataTermino;

    @NotNull(message = "Campo status não pode ser vazio")
    private int status;

    @NotNull(message = "Campo classificação não pode ser vazio")
    private int classificacao;

    @NotNull(message = "Campo ano não pode ser vazio")
    private int ano;
}
