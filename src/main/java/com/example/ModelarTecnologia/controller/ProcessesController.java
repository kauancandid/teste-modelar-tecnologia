package com.example.ModelarTecnologia.controller;

import com.example.ModelarTecnologia.dto.classification.ClassificationProcessesRequestDTO;
import com.example.ModelarTecnologia.dto.macroprocesses.MacroprocessesRequestDTO;
import com.example.ModelarTecnologia.dto.processes.ProcessesRequestDTO;
import com.example.ModelarTecnologia.dto.processes.ProcessesResponseDTO;
import com.example.ModelarTecnologia.model.ProcessesModel;
import com.example.ModelarTecnologia.service.impl.ProcessesServiceImpl;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping(value = "/processos", produces="application/json")
public class ProcessesController {
    private ProcessesServiceImpl processoService;

    public ProcessesController(ProcessesServiceImpl processoService) {
        this.processoService = processoService;
    }

    @ApiOperation("Método para salvar o Processo.")
    @PostMapping()
    public ResponseEntity<ProcessesResponseDTO> saveProcesso(@RequestBody @Valid ProcessesRequestDTO processesRequestDTO,
                                                             @RequestBody @Valid MacroprocessesRequestDTO macroprocessesRequestDTO,
                                                             @RequestBody @Valid ClassificationProcessesRequestDTO classificationProcessesRequestDTO) {

        ProcessesModel processosSaved = this.processoService.saveProcesso(processesRequestDTO, macroprocessesRequestDTO, classificationProcessesRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProcessesResponseDTO.convertToDTO(processosSaved));
    }

    @ApiOperation("This method is used to update processesId data.")
    @PatchMapping("update/{processesId}")
    public ResponseEntity<ProcessesResponseDTO> updateProcessesId(@PathVariable String processesId,
                                                                      @RequestBody @Valid ProcessesRequestDTO processesRequestDTO,
                                                                      @RequestBody @Valid MacroprocessesRequestDTO macroprocessesRequestDTO,
                                                                      @RequestBody @Valid ClassificationProcessesRequestDTO classificationProcessesRequestDTO) {

        var processe = this.processoService.updateProcesses(processesId, processesRequestDTO, macroprocessesRequestDTO, classificationProcessesRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ProcessesResponseDTO.convertToDTO(processe));
    }

    @ApiOperation("This method is used to list all processes data.")
    @GetMapping("/get-all")
    public ResponseEntity<List<ProcessesResponseDTO>> listProcesses() {

        List<ProcessesModel> processesModelList = this.processoService.listAllProcesses();
        List<ProcessesResponseDTO> responseList = new ArrayList<>();
        for (ProcessesModel processesModel : processesModelList) {
            responseList.add(ProcessesResponseDTO.convertToDTO(processesModel));
        }

        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @ApiOperation("This method is used to list processesId data.")
    @GetMapping("get/{processesId}")
    public ResponseEntity<ProcessesResponseDTO> listProcessesId(@PathVariable String processesId) {
        var processe = this.processoService.listProcesses(processesId);

        return ResponseEntity.status(HttpStatus.OK).body(ProcessesResponseDTO.convertToDTO(processe));
    }

    @ApiOperation("This method is used to delete one processes registered.")
    @DeleteMapping("delete/{processesId}")
    public ResponseEntity deleteProcesses(@PathVariable String processesId) {
        this.processoService.deleteProcesses(processesId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}