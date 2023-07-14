package com.example.ModelarTecnologia.repository;

import com.example.ModelarTecnologia.model.ProcessesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProcessesRepository extends JpaRepository<ProcessesModel, UUID> {

}
