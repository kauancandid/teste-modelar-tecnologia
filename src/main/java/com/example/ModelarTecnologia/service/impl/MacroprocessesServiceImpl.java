package com.example.ModelarTecnologia.service.impl;

import com.example.ModelarTecnologia.dto.classification.ClassificationProcessesRequestDTO;
import com.example.ModelarTecnologia.dto.macroprocesses.MacroprocessesRequestDTO;
import com.example.ModelarTecnologia.model.ClassificationProcessesModel;
import com.example.ModelarTecnologia.model.MacroprocessesModel;
import com.example.ModelarTecnologia.repository.MacroprocessesRepository;
import com.example.ModelarTecnologia.service.MacroprocessesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MacroprocessesServiceImpl implements MacroprocessesService {

    private MacroprocessesRepository macroprocessesRepository;


    public MacroprocessesServiceImpl(MacroprocessesRepository macroprocessesRepository) {
        this.macroprocessesRepository = macroprocessesRepository;
    }

    @Override
    public MacroprocessesModel saveMacrorocesso(MacroprocessesRequestDTO macroprocessesRequestDTO) {

        MacroprocessesModel macroprocessesModel = new MacroprocessesModel();

        macroprocessesModel.setNumero(macroprocessesRequestDTO.getNumero());
        macroprocessesModel.setAno(macroprocessesRequestDTO.getAno());
        macroprocessesModel.setNome(macroprocessesRequestDTO.getNome());
        macroprocessesModel.setClassificacao(macroprocessesRequestDTO.getClassificacao());
        macroprocessesModel.setDescricao(macroprocessesRequestDTO.getDescricao());
        macroprocessesModel.setStatus(macroprocessesRequestDTO.getStatus());
        macroprocessesModel.setDataInicio(macroprocessesRequestDTO.getDataInicio());
        macroprocessesModel.setDataTermino(macroprocessesRequestDTO.getDataTermino());
        this.macroprocessesRepository.save(macroprocessesModel);

        return macroprocessesModel;

    }

    @Override
    public MacroprocessesModel updateMacroprocesses(String macroprocessesId, MacroprocessesRequestDTO macroprocessesRequestDTO) {
        Optional<MacroprocessesModel> macroprocessesModel = this.macroprocessesRepository.findById(UUID.fromString(macroprocessesId));
        if(macroprocessesModel.isEmpty()) {
            throw new RuntimeException("Macroprocesso não encontrado!");
        }

        var macroprocessesModel1 = macroprocessesModel.get();
        macroprocessesModel1.setNumero(macroprocessesRequestDTO.getNumero());
        macroprocessesModel1.setAno(macroprocessesRequestDTO.getAno());
        macroprocessesModel1.setNome(macroprocessesRequestDTO.getNome());
        macroprocessesModel1.setClassificacao(macroprocessesRequestDTO.getClassificacao());
        macroprocessesModel1.setDescricao(macroprocessesRequestDTO.getDescricao());
        macroprocessesModel1.setStatus(macroprocessesRequestDTO.getStatus());
        macroprocessesModel1.setDataInicio(macroprocessesRequestDTO.getDataInicio());
        macroprocessesModel1.setDataTermino(macroprocessesRequestDTO.getDataTermino());

        return this.macroprocessesRepository.save(macroprocessesModel1);
    }

    @Override
    public MacroprocessesModel listMacroprocesses(String macroprocessesId) {
        Optional<MacroprocessesModel> macroprocessesModel = this.macroprocessesRepository.findById(UUID.fromString(macroprocessesId));
        if (macroprocessesModel.isEmpty()) {
            throw new RuntimeException("Macroprocesso não encontrado!");
        }
        return macroprocessesModel.get();
    }


    @Override
    public List<MacroprocessesModel> listAllMacroprocesses() {
        return macroprocessesRepository.findAll();
    }

    @Override
    public void deleteMacroprocesses(String macroprocessesId) {
        Optional<MacroprocessesModel> macroprocessesModel = this.macroprocessesRepository.findById(UUID.fromString(macroprocessesId));
        if (macroprocessesModel.isEmpty()) {
            throw new RuntimeException("Macroprocesso não encontrado!");
        }
        macroprocessesRepository.delete(macroprocessesModel.get());
    }
}
