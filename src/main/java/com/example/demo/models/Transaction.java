package com.example.demo.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nom;

    @Enumerated(EnumType.STRING)
    private TypeTransaction type;

    @Column
    private String categorie;

    @Column(precision = 10, scale = 2)
    private BigDecimal montant;

    @Column
    private LocalDate date;
}