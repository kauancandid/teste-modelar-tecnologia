package com.example.ModelarTecnologia.dto.classification;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassificationProcessesRequestDTO {
    @NotBlank(message = "Campo descrição não pode ser vazio")
    private String descricao;
}
