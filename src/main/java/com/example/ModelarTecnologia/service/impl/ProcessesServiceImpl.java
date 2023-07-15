package com.example.ModelarTecnologia.service.impl;

import com.example.ModelarTecnologia.dto.classification.ClassificationProcessesRequestDTO;
import com.example.ModelarTecnologia.dto.macroprocesses.MacroprocessesRequestDTO;
import com.example.ModelarTecnologia.dto.processes.ProcessesRequestDTO;
import com.example.ModelarTecnologia.model.ProcessesModel;
import com.example.ModelarTecnologia.repository.ProcessesRepository;
import com.example.ModelarTecnologia.service.ProcessesService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProcessesServiceImpl implements ProcessesService {

    private final ProcessesRepository processesRepository;
    private final MacroprocessesServiceImpl macroprocessoService;
    private final ClassificationProcessesServiceImpl classificacaoProcessoService;


    public ProcessesServiceImpl(ProcessesRepository processesRepository, MacroprocessesServiceImpl macroprocessoService,
                                ClassificationProcessesServiceImpl classificacaoProcessoService) {
        this.processesRepository = processesRepository;
        this.macroprocessoService = macroprocessoService;
        this.classificacaoProcessoService = classificacaoProcessoService;
    }

    @Override
    @Transactional
    public ProcessesModel saveProcesso(ProcessesRequestDTO processesRequestDTO, String macroprocessesId,
                                       String classificationProcessesId) {

        ProcessesModel processesModel = new ProcessesModel();

        processesModel.setNumero(processesRequestDTO.getNumero());
        processesModel.setNome(processesRequestDTO.getNome());
        processesModel.setDescricao(processesRequestDTO.getDescricao());

        var macroProce = macroprocessoService.listMacroprocesses(macroprocessesId);
        processesModel.setMacroprocessesModel(macroProce);

        var classificacao = classificacaoProcessoService.listClassificationProcesses(classificationProcessesId);
        processesModel.setClassificationProcessesModel(classificacao);

        this.processesRepository.save(processesModel);

        return processesModel;

    }

    @Override
    public ProcessesModel updateProcesses(String processesId, ProcessesRequestDTO processesRequestDTO) {
        Optional<ProcessesModel> classificationProcessesModel = this.processesRepository.findById(UUID.fromString(processesId));
        if(classificationProcessesModel.isEmpty()) {
            throw new RuntimeException("Processo não encontrado!");
        }

        var processesModel = classificationProcessesModel.get();
        processesModel.setNumero(processesRequestDTO.getNumero());
        processesModel.setNome(processesRequestDTO.getNome());
        processesModel.setDescricao(processesRequestDTO.getDescricao());

        return this.processesRepository.save(processesModel);
    }

    @Override
    public ProcessesModel listProcesses(String processesId) {
        Optional<ProcessesModel> processesModel = this.processesRepository.findById(UUID.fromString(processesId));
        if (processesModel.isEmpty()) {
            throw new RuntimeException("Processo não encontrado!");
        }
        return processesModel.get();
    }


    @Override
    public List<ProcessesModel> listAllProcesses() {
        return processesRepository.findAll();
    }

    @Override
    public void deleteProcesses(String processesId) {
        Optional<ProcessesModel> processesModel = this.processesRepository.findById(UUID.fromString(processesId));
        if (processesModel.isEmpty()) {
            throw new RuntimeException("Processo não encontrado!");
        }
        processesRepository.delete(processesModel.get());
    }
}
