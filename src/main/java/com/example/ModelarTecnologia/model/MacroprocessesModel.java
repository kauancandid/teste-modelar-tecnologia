package com.example.ModelarTecnologia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "macro_processo")
public class MacroprocessesModel {

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

    @Column(name = "inicio", nullable = false)
    private Date dataInicio;

    @Column(name = "termino", nullable = false)
    private Date dataTermino;

    @Column(name = "status", nullable = false)
    private int status;

    @OneToOne(cascade = CascadeType.REMOVE)
    private ClassificationProcessesModel classificationProcessesModel;

    @Column(name = "ano", nullable = false)
    private int ano;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "processo_id")
    private List<ProcessesModel> processoModel;


}
