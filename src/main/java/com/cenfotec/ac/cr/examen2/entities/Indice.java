package com.cenfotec.ac.cr.examen2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Indice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long idUsuario;
    private LocalDate fechaIngreso;
    private float masaMuscular;

    public Indice() {
    }

    public Indice(long id, long idUsuario, LocalDate fechaIngreso, float masaMuscular) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.fechaIngreso = fechaIngreso;
        this.masaMuscular = masaMuscular;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public float getMasaMuscular() {
        return masaMuscular;
    }

    public void setMasaMuscular(float masaMuscular) {
        this.masaMuscular = masaMuscular;
    }
}
