package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Activite {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String titre;

    @Enumerated(EnumType.STRING)
    private TypeActivite type;

    @Column
    private LocalDateTime dateDebut;

    @Column
    private LocalDateTime dateFin;
}