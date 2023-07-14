package com.example.ModelarTecnologia.repository;

import com.example.ModelarTecnologia.model.MacroprocessesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MacroprocessesRepository extends JpaRepository<MacroprocessesModel, UUID> {
}
