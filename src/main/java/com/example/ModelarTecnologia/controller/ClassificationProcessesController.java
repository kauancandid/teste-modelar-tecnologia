package com.example.ModelarTecnologia.controller;

import com.example.ModelarTecnologia.dto.classification.ClassificationProcessesRequestDTO;
import com.example.ModelarTecnologia.dto.classification.ClassificationProcessesResponseDTO;
import com.example.ModelarTecnologia.model.ClassificationProcessesModel;
import com.example.ModelarTecnologia.service.impl.ClassificationProcessesServiceImpl;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping(value = "/classification", produces="application/json")
public class ClassificationProcessesController {
    private final ClassificationProcessesServiceImpl classificacaoProcessosModel;


    public ClassificationProcessesController(ClassificationProcessesServiceImpl classificacaoProcessosModel) {
        this.classificacaoProcessosModel = classificacaoProcessosModel;
    }

    @ApiOperation("This method is used to save a classification.")
    @PostMapping()
    public ResponseEntity<ClassificationProcessesResponseDTO> saveClassificacaoProcesso(@RequestBody @Valid ClassificationProcessesRequestDTO classificationProcessesRequestDTO) {
        ClassificationProcessesModel classificationProcessesModel = this.classificacaoProcessosModel.saveClassificacao(classificationProcessesRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ClassificationProcessesResponseDTO.convertToDTO(classificationProcessesModel));
    }

    @ApiOperation("This method is used to update classificationId data.")
    @PatchMapping("update/{classificationId}")
    public ResponseEntity<ClassificationProcessesResponseDTO> updateClassificationId(@PathVariable String classificationId,
                                                                                     @RequestBody @Valid ClassificationProcessesRequestDTO classificationProcessesRequestDTO) {

        var classification = this.classificacaoProcessosModel.updateClassificationProcesses(classificationId, classificationProcessesRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ClassificationProcessesResponseDTO.convertToDTO(classification));
    }

    @ApiOperation("This method is used to list all classification data.")
    @GetMapping("/get-all")
    public ResponseEntity<List<ClassificationProcessesResponseDTO>> listClassification() {

        List<ClassificationProcessesModel> classificationProcessesModels = this.classificacaoProcessosModel.listAllClassificationProcesses();
        List<ClassificationProcessesResponseDTO> classificationProcessesResponseDTOS = new ArrayList<>();
        for (ClassificationProcessesModel classificationModel : classificationProcessesModels) {
            classificationProcessesResponseDTOS.add(ClassificationProcessesResponseDTO.convertToDTO(classificationModel));
        }

        return ResponseEntity.status(HttpStatus.OK).body(classificationProcessesResponseDTOS);
    }

    @ApiOperation("This method is used to list classification data.")
    @GetMapping("get/{classificationId}")
    public ResponseEntity<ClassificationProcessesResponseDTO> listProcessesId(@PathVariable String classificationId) {
        var classificationProcessesModel = this.classificacaoProcessosModel.getClassificationProcessesById(classificationId);

        return ResponseEntity.status(HttpStatus.OK).body(ClassificationProcessesResponseDTO.convertToDTO(classificationProcessesModel));
    }

    @ApiOperation("This method is used to delete one classification registered.")
    @DeleteMapping("delete/{classificationId}")
    public ResponseEntity deleteClassification(@PathVariable String classificationId) {
        this.classificacaoProcessosModel.deleteClassificationProcesses(classificationId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
