package com.viaticos.backend.model;

import jakarta.persistence.*;

@Entity
public class Aprobacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreAprobador;
    private String identificacionAprobador;
    private String emailAprobador;

    @OneToOne
    @JoinColumn(name = "viatico_id")
    private Viatico viatico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailAprobador() {
        return emailAprobador;
    }

    public void setEmailAprobador(String emailAprobador) {
        this.emailAprobador = emailAprobador;
    }

    public String getIdentificacionAprobador() {
        return identificacionAprobador;
    }

    public void setIdentificacionAprobador(String identificacionAprobador) {
        this.identificacionAprobador = identificacionAprobador;
    }

    public String getNombreAprobador() {
        return nombreAprobador;
    }

    public void setNombreAprobador(String nombreAprobador) {
        this.nombreAprobador = nombreAprobador;
    }

}
