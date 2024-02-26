package com.javeriana.vacunacion.servicios;

import com.javeriana.vacunacion.modelos.Vacuna;

import java.util.ArrayList;
import java.util.List;

public class VacunaServicio {
    private List<Vacuna> vacunas = new ArrayList<>();

    // Agrega una nueva vacuna al sistema
    public void agregarVacuna(Vacuna vacuna) {
        vacunas.add(vacuna);
    }

    // Busca una vacuna por su nombre
    public Vacuna buscarPorNombre(String nombre) {
        for (Vacuna vacuna : vacunas) {
            if (vacuna.getNombre().equalsIgnoreCase(nombre)) {
                return vacuna;
            }
        }
        return null; // Considerar lanzar una excepción si se prefiere manejar así
    }

    public Vacuna buscarPorID(String ID) {
        for (Vacuna vacuna : vacunas) {
            if (vacuna.getID().equals(ID)) {
                return vacuna;
            }
        }
        return null; // Considerar lanzar una excepción si se prefiere manejar así
    }

    // Lista todas las vacunas registradas en el sistema
    public List<Vacuna> listarVacunas() {
        return new ArrayList<>(vacunas);
    }

    // Actualiza la cantidad de dosis disponibles para una vacuna específica
    public boolean actualizarDosisDisponibles(String nombre, int cantidad) {
        Vacuna vacuna = buscarPorNombre(nombre);
        if (vacuna != null) {
            vacuna.setCantidadDosisDisponibles(cantidad);
            return true;
        }
        return false; // Vacuna no encontrada
    }

    // Opcional: Eliminar una vacuna del sistema por su nombre
    public boolean eliminarVacuna(String ID) {
        return vacunas.removeIf(vacuna -> vacuna.getID().equalsIgnoreCase(ID));
    }
}
