package com.example.ModelarTecnologia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "classificacao_processo")
public class ClassificationProcessesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod", nullable = false)
    private UUID id;

    @Column(name = "descricao", nullable = false)
    private String descricao;
}
