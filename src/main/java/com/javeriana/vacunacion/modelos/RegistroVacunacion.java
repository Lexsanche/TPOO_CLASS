package com.javeriana.vacunacion.modelos;

import java.util.Date;

public class RegistroVacunacion {
    private Ciudadano ciudadano;
    private Vacuna vacuna;
    private Date fechaAplicacion;
    private Date proximaDosis;
    private String efectosSecundarios;

    public RegistroVacunacion(Ciudadano ciudadano, Vacuna vacuna, Date fechaAplicacion) {
        this.ciudadano = ciudadano;
        this.vacuna = vacuna;
        this.fechaAplicacion = fechaAplicacion;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public Date getProximaDosis() {
        return proximaDosis;
    }

    public void setProximaDosis(Date proximaDosis) {
        this.proximaDosis = proximaDosis;
    }

    public String getEfectosSecundarios() {
        return efectosSecundarios;
    }

    public void setEfectosSecundarios(String efectosSecundarios) {
        this.efectosSecundarios = efectosSecundarios;
    }
}
