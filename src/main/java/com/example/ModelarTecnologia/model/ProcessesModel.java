package com.example.ModelarTecnologia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "processo")
public class ProcessesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod", nullable = false)
    private UUID id;

    @Column(name = "num", nullable = false)
    private int numero;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToOne(cascade = CascadeType.REMOVE)
    private MacroprocessesModel macroprocessesModel;

    @OneToOne(cascade = CascadeType.REMOVE)
    private ClassificationProcessesModel classificationProcessesModel;
}
