package com.example.demo.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    @Column(precision = 4, scale = 2)
    private BigDecimal valeur;

    @Column
    private int coefficient;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;
}