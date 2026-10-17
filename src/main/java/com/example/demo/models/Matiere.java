package com.example.demo.models;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Matiere {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nom;

    @Column
    private int coefficient;

    @OneToMany(mappedBy = "matiere")
    private List<Note> notes;

    @OneToMany(mappedBy = "matiere")
    private List<Devoir> devoirs;
}