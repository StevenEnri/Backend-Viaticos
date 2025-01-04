package com.viaticos.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Viatico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDate fechaRegistro;
    private String nombrePersona;
    private String identificacion;
    private String motivoViaje;
    private String clienteProyecto;
    private LocalDate fechaInicioViaje;
    private LocalDate fechaFinViaje;
    private LocalDate fechaInvitacion;
    private boolean aprobado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getMotivoViaje() {
        return motivoViaje;
    }

    public void setMotivoViaje(String motivoViaje) {
        this.motivoViaje = motivoViaje;
    }

    public String getClienteProyecto() {
        return clienteProyecto;
    }

    public void setClienteProyecto(String clienteProyecto) {
        this.clienteProyecto = clienteProyecto;
    }

    public LocalDate getFechaInicioViaje() {
        return fechaInicioViaje;
    }

    public void setFechaInicioViaje(LocalDate fechaInicioViaje) {
        this.fechaInicioViaje = fechaInicioViaje;
    }

    public LocalDate getFechaFinViaje() {
        return fechaFinViaje;
    }

    public void setFechaFinViaje(LocalDate fechaFinViaje) {
        this.fechaFinViaje = fechaFinViaje;
    }

    public LocalDate getFechaInvitacion() {
        return fechaInvitacion;
    }

    public void setFechaInvitacion(LocalDate fechaInvitacion) {
        this.fechaInvitacion = fechaInvitacion;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

}
