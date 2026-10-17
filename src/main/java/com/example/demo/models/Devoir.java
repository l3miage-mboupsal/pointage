package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Devoir {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String intitule;

    @Column
    private LocalDate dateRendu;

    @Column
    private boolean fait;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;
}