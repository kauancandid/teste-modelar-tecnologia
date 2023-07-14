package com.example.ModelarTecnologia.service.impl;

import com.example.ModelarTecnologia.dto.classification.ClassificationProcessesRequestDTO;
import com.example.ModelarTecnologia.model.ClassificationProcessesModel;
import com.example.ModelarTecnologia.repository.ClassificationProcessesRepository;
import com.example.ModelarTecnologia.service.ClassificationProcessesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClassificationProcessesServiceImpl implements ClassificationProcessesService {

    private ClassificationProcessesRepository classificationProcessesRepository;

    public ClassificationProcessesServiceImpl(ClassificationProcessesRepository classificationProcessesRepository) {
        this.classificationProcessesRepository = classificationProcessesRepository;
    }

    @Override
    public ClassificationProcessesModel saveClassificacao(ClassificationProcessesRequestDTO classificationProcessesRequestDTO) {
        var classificationProcessesModel = new ClassificationProcessesModel();
        classificationProcessesModel.setDescricao(classificationProcessesRequestDTO.getDescricao());
        this.classificationProcessesRepository.save(classificationProcessesModel);

        return classificationProcessesModel;

    }

    @Override
    public ClassificationProcessesModel updateClassificationProcesses(String classificationId, ClassificationProcessesRequestDTO classificationProcessesRequestDTO) {
        Optional<ClassificationProcessesModel> classificationProcessesModel = this.classificationProcessesRepository.findById(UUID.fromString(classificationId));
        if(classificationProcessesModel.isEmpty()) {
            throw new RuntimeException("Classificação não encontrado!");
        }

        var classificationProcessesModel1 = classificationProcessesModel.get();
        classificationProcessesModel1.setDescricao(classificationProcessesRequestDTO.getDescricao());
        return this.classificationProcessesRepository.save(classificationProcessesModel1);
    }

    @Override
    public ClassificationProcessesModel listClassificationProcesses(String classificationId) {

        Optional<ClassificationProcessesModel> classicationModel = this.classificationProcessesRepository.findById(UUID.fromString(classificationId));
        if (classicationModel.isEmpty()) {
            throw new RuntimeException("Classificador não encontrado!");
        }
        return classicationModel.get();
    }


    @Override
    public List<ClassificationProcessesModel> listAllClassificationProcesses() {
        return classificationProcessesRepository.findAll();
    }

    @Override
    public void deleteClassificationProcesses(String classificationId) {

        Optional<ClassificationProcessesModel> classicationModel = this.classificationProcessesRepository.findById(UUID.fromString(classificationId));
        if (classicationModel.isEmpty()) {
            throw new RuntimeException("Classificador não encontrado!");
        }
        classificationProcessesRepository.delete(classicationModel.get());
    }

}
