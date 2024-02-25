package com.javeriana.vacunacion.servicios;

import com.javeriana.vacunacion.modelos.Ciudadano;
import com.javeriana.vacunacion.modelos.RegistroVacunacion;
import com.javeriana.vacunacion.modelos.Vacuna;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RegistroVacunacionServicio {
    private List<RegistroVacunacion> registros = new ArrayList<>();

    // Registra una nueva vacunación
    public void registrarVacunacion(Ciudadano ciudadano, Vacuna vacuna, Date fechaAplicacion) {
        RegistroVacunacion nuevoRegistro = new RegistroVacunacion(ciudadano, vacuna, fechaAplicacion);
        registros.add(nuevoRegistro);
    }

    // Busca registros de vacunación por ID de ciudadano
    public List<RegistroVacunacion> buscarRegistrosPorCiudadano(String ID) {
        return registros.stream()
                .filter(registro -> registro.getCiudadano().getID().equals(ID))
                .collect(Collectors.toList());
    }

    // Lista todos los registros de vacunación
    public List<RegistroVacunacion> listarRegistros() {
        return new ArrayList<>(registros);
    }

    // Registra efectos secundarios para un registro de vacunación específico
    public boolean registrarEfectosSecundarios(String ID, String efectosSecundarios) {
        for (RegistroVacunacion registro : registros) {
            if (registro.getCiudadano().getID().equals(ID)) {
                registro.setEfectosSecundarios(efectosSecundarios);
                return true; // Efectos secundarios registrados correctamente
            }
        }
        return false; // Ciudadano no encontrado
    }

    // Opcional: Actualizar la fecha de la próxima dosis para un registro específico
    public boolean actualizarProximaDosis(String ID, Date proximaDosis) {
        for (RegistroVacunacion registro : registros) {
            if (registro.getCiudadano().getID().equals(ID)) {
                registro.setProximaDosis(proximaDosis);
                return true; // Fecha actualizada correctamente
            }
        }
        return false; // Ciudadano no encontrado
    }
}
