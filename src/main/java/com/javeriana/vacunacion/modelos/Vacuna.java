package com.javeriana.vacunacion.modelos;

public class Vacuna {
    private String nombre;
    private String fabricante;
    private String ID;
    private int cantidadDosisDisponibles;

    public Vacuna(String nombre, String fabricante, String ID,  int cantidadDosisDisponibles) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.ID = ID;
        this.cantidadDosisDisponibles = cantidadDosisDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCantidadDosisDisponibles() {
        return cantidadDosisDisponibles;
    }

    public void setCantidadDosisDisponibles(int cantidadDosisDisponibles) {
        this.cantidadDosisDisponibles = cantidadDosisDisponibles;
    }
}