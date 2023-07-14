package com.example.ModelarTecnologia.dto.macroprocesses;

import com.example.ModelarTecnologia.model.MacroprocessesModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Data
public class MacroprocessesResponseDTO {

    private UUID id;
    private int numero;
    private String nome;
    private String descricao;
    private Date dataInicio;
    private Date dataTermino;
    private int status;
    private int classificacao;
    private int ano;

    public static MacroprocessesResponseDTO convertToDTO(MacroprocessesModel macro) {

        var macroResponseDTO = new MacroprocessesResponseDTO();
        macroResponseDTO.setId(macro.getId());
        macroResponseDTO.setNumero(macro.getNumero());
        macroResponseDTO.setNome(macro.getNome());
        macroResponseDTO.setDescricao(macro.getDescricao());
        macroResponseDTO.setDataInicio(macro.getDataInicio());
        macroResponseDTO.setDataTermino(macro.getDataTermino());
        macroResponseDTO.setStatus(macro.getStatus());
        macroResponseDTO.setClassificacao(macro.getClassificacao());
        macroResponseDTO.setAno(macro.getAno());

        return macroResponseDTO;
    }



}
