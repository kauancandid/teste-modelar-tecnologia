package com.example.ModelarTecnologia.service;

import com.example.ModelarTecnologia.dto.classification.ClassificationProcessesRequestDTO;
import com.example.ModelarTecnologia.dto.macroprocesses.MacroprocessesRequestDTO;
import com.example.ModelarTecnologia.dto.processes.ProcessesRequestDTO;
import com.example.ModelarTecnologia.model.ProcessesModel;

import java.util.List;

public interface ProcessesService {
    ProcessesModel saveProcesso(ProcessesRequestDTO processesRequestDTO, MacroprocessesRequestDTO macroprocessesRequestDTO,
                                ClassificationProcessesRequestDTO classificationProcessesRequestDTO);

    ProcessesModel updateProcesses(String processesId, ProcessesRequestDTO processesRequestDTO,
                                   MacroprocessesRequestDTO macroprocessesRequestDTO,
                                   ClassificationProcessesRequestDTO classificationProcessesRequestDTO);

    ProcessesModel listProcesses(String processesId);

    List<ProcessesModel> listAllProcesses();

    public void deleteProcesses(String processesId);
}
