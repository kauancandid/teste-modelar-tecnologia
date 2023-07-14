package com.example.ModelarTecnologia.dto.classification;

import com.example.ModelarTecnologia.model.ClassificationProcessesModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Data
public class ClassificationProcessesResponseDTO {

    private UUID id;
    private String descricao;


    public static ClassificationProcessesResponseDTO convertToDTO(ClassificationProcessesModel classi) {

        var classiResponseDTO = new ClassificationProcessesResponseDTO();
        classiResponseDTO.setId(classi.getId());
        classiResponseDTO.setDescricao(classi.getDescricao());

        return classiResponseDTO;
    }

}
