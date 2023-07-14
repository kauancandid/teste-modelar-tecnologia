package com.example.ModelarTecnologia.service;

import com.example.ModelarTecnologia.dto.classification.ClassificationProcessesRequestDTO;
import com.example.ModelarTecnologia.model.ClassificationProcessesModel;

import java.util.List;

public interface ClassificationProcessesService {
    ClassificationProcessesModel saveClassificacao(ClassificationProcessesRequestDTO classificationProcessesRequestDTO);
    ClassificationProcessesModel updateClassificationProcesses(String classificationId, ClassificationProcessesRequestDTO classificationProcessesRequestDTO);
    ClassificationProcessesModel listClassificationProcesses(String classificationId);
    List<ClassificationProcessesModel> listAllClassificationProcesses();
    void deleteClassificationProcesses(String classificationId);
}
