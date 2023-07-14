package com.example.ModelarTecnologia.repository;



import com.example.ModelarTecnologia.model.ClassificationProcessesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClassificationProcessesRepository extends JpaRepository<ClassificationProcessesModel, UUID> {

}
