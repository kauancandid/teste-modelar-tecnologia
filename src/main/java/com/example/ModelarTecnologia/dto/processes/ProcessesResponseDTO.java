package com.example.ModelarTecnologia.dto.processes;

import com.example.ModelarTecnologia.model.ProcessesModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Data
public class ProcessesResponseDTO {

    private UUID id;
    private int numero;
    private String nome;
    private String descricao;
    private String codMacro;
    private String codClassificacao;


    public static ProcessesResponseDTO convertToDTO(ProcessesModel proce) {

        var proceResponseDTO = new ProcessesResponseDTO();
        proceResponseDTO.setId(proce.getId());
        proceResponseDTO.setNumero(proce.getNumero());
        proceResponseDTO.setNome(proce.getNome());
        proceResponseDTO.setDescricao(proce.getDescricao());
        proceResponseDTO.setCodMacro(String.valueOf(proce.getMacroprocessesModel().getId()));
        proceResponseDTO.setCodClassificacao(String.valueOf(proce.getClassificationProcessesModel().getId()));

        return proceResponseDTO;
    }



}
