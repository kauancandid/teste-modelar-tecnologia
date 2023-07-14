package com.example.ModelarTecnologia.service;

import com.example.ModelarTecnologia.dto.macroprocesses.MacroprocessesRequestDTO;
import com.example.ModelarTecnologia.model.MacroprocessesModel;

import java.util.List;

public interface MacroprocessesService {
    MacroprocessesModel saveMacrorocesso(MacroprocessesRequestDTO macroprocessesRequestDTO);

    MacroprocessesModel updateMacroprocesses(String macroprocessesId, MacroprocessesRequestDTO macroprocessesRequestDTO);

    MacroprocessesModel listMacroprocesses(String macroprocessesId);

    public List<MacroprocessesModel> listAllMacroprocesses();

    public void deleteMacroprocesses(String macroprocessesId);

}
