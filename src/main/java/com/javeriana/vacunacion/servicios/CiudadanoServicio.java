package com.javeriana.vacunacion.servicios;

import com.javeriana.vacunacion.modelos.Ciudadano;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CiudadanoServicio {
    private List<Ciudadano> ciudadanos = new ArrayList<>();

    // Agrega un nuevo ciudadano al sistema
    public void agregarCiudadano(Ciudadano ciudadano) {
        ciudadanos.add(ciudadano);
    }

    // Busca un ciudadano por su ID
    public Ciudadano buscarPorID(String ID) {
        for (Ciudadano ciudadano : ciudadanos) {
            if (ciudadano.getID().equals(ID)) {
                return ciudadano;
            }
        }
        return null; // Considerar lanzar una excepción si se prefiere manejar así
    }

    // Actualiza los datos de contacto de un ciudadano
    public void actualizarDatosContacto(String ID, String nuevosDatosContacto) {
        Ciudadano ciudadano = buscarPorID(ID);
        if (ciudadano != null) {
            ciudadano.setDatosContacto(nuevosDatosContacto);
        } else {
            System.out.println("Ciudadano no encontrado.");
            // Considerar lanzar una excepción si se prefiere manejar así
        }
    }

    // Lista todos los ciudadanos registrados
    public List<Ciudadano> listarCiudadanos() {
        return new ArrayList<>(ciudadanos);
    }

    // Elimina un ciudadano del sistema por ID
    public boolean eliminarCiudadano(String ID) {
        return ciudadanos.removeIf(ciudadano -> ciudadano.getID().equals(ID));
    }

    // Opcional: Buscar ciudadanos por nombre (puede ser útil en ciertos contextos)
    public List<Ciudadano> buscarPorNombre(String nombre) {
        return ciudadanos.stream()
                .filter(ciudadano -> ciudadano.getNombre().equalsIgnoreCase(nombre))
                .collect(Collectors.toList());
    }
}