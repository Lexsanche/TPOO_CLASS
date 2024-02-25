package com.javeriana.vacunacion.modelos;

import java.util.ArrayList;
import java.util.List;

public class Ciudadano {
    private String nombre;
    private String ID;
    private int edad;
    private String datosContacto;
    private List<RegistroVacunacion> registrosVacunacion = new ArrayList<>();

    public Ciudadano(String nombre, String ID, int edad, String datosContacto) {
        this.nombre = nombre;
        this.ID = ID;
        this.edad = edad;
        this.datosContacto = datosContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDatosContacto() {
        return datosContacto;
    }

    public void setDatosContacto(String datosContacto) {
        this.datosContacto = datosContacto;
    }

    public List<RegistroVacunacion> getRegistrosVacunacion() {
        return registrosVacunacion;
    }

    public void setRegistrosVacunacion(List<RegistroVacunacion> registrosVacunacion) {
        this.registrosVacunacion = registrosVacunacion;
    }
}
