package com.javeriana.vacunacion.ui;

import com.javeriana.vacunacion.modelos.Ciudadano;
import com.javeriana.vacunacion.modelos.RegistroVacunacion;
import com.javeriana.vacunacion.modelos.Vacuna;
import com.javeriana.vacunacion.servicios.CiudadanoServicio;
import com.javeriana.vacunacion.servicios.RegistroVacunacionServicio;
import com.javeriana.vacunacion.servicios.VacunaServicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private final VacunaServicio vacunaServicio = new VacunaServicio();
    private final CiudadanoServicio ciudadanoServicio = new CiudadanoServicio();
    private final RegistroVacunacionServicio registroVacunacionServicio = new RegistroVacunacionServicio();
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        while (true) {
            System.out.println("\nSistema de Gestión de Vacunación");
            System.out.println("1. Registro de Vacunas");
            System.out.println("2. Gestión de Ciudadanos");
            System.out.println("3. Registro de Aplicación de Vacunas");
            System.out.println("4. Agregar Efectos Secundarios");
            System.out.println("5. Asignación de Proxima Dosis");
            System.out.println("6. Consulta de Registro de Vacunación por Ciudadano");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    registrarVacuna();
                    break;
                case 2:
                    gestionarCiudadano();
                    break;
                case 3:
                    registrarAplicacionVacuna();
                    break;
                case 4:
                    agregarEfectosSecundarios();
                    break;
                case 5:
                    asignarProximaVacuna();
                    break;
                case 6:
                    consultarRegistroVacunacion();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }

    private void registrarVacuna() {
        System.out.println("\nRegistro de Vacunas");
        System.out.print("ID: ");
        String ID = scanner.nextLine();
        System.out.print("Nombre de la vacuna: ");
        String nombre = scanner.nextLine();
        System.out.print("Fabricante: ");
        String fabricante = scanner.nextLine();
        System.out.print("Cantidad de dosis disponibles: ");
        int cantidadDosis = Integer.parseInt(scanner.nextLine());

        Vacuna vacuna = new Vacuna(nombre, fabricante, ID, cantidadDosis);
        vacunaServicio.agregarVacuna(vacuna);

        System.out.println("Vacuna registrada exitosamente.");
    }

    private void gestionarCiudadano() {
        System.out.println("\nGestión de Ciudadanos");
        System.out.print("Ingrese el ID del ciudadano: ");
        String ID = scanner.nextLine();

        Ciudadano ciudadano = ciudadanoServicio.buscarPorID(ID);

        if (ciudadano == null) {
            System.out.println("El ciudadano no existe en el sistema. Desea registrarlo? (si/no)");
            String respuesta = scanner.nextLine().toLowerCase();
            if (respuesta.equals("si")) {
                registrarCiudadano(ID);
                return;
            } else {
                return;
            }
        }

        System.out.println("Nombre: " + ciudadano.getNombre());
        System.out.println("Datos de Contacto: " + ciudadano.getDatosContacto());
        System.out.println("Edad: " + ciudadano.getEdad());
    }

    private void registrarCiudadano(String ID) {
        System.out.println("\nRegistro de Nuevo Ciudadano");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Datos de Contacto: ");
        String datosContacto = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        Ciudadano nuevoCiudadano = new Ciudadano(nombre, ID,  edad, datosContacto);
        ciudadanoServicio.agregarCiudadano(nuevoCiudadano);
        System.out.println("Nuevo ciudadano registrado exitosamente.");
    }

    private void registrarAplicacionVacuna() {
        System.out.println("\nRegistro de Aplicación de Vacunas");
        System.out.print("Ingrese el ID del ciudadano: ");
        String ID = scanner.nextLine();

        Ciudadano ciudadano = ciudadanoServicio.buscarPorID(ID);

        if (ciudadano == null) {
            System.out.println("El ciudadano no existe en el sistema. Por favor, regístrelo primero.");
            return;
        }

        System.out.print("Ingrese el nombre de la vacuna: ");
        String IDvac = scanner.nextLine();
        Vacuna vacuna = vacunaServicio.buscarPorID(IDvac);

        if (vacuna == null) {
            System.out.println("La vacuna no está registrada en el sistema. Por favor, regístrela primero.");
            return;
        }

        System.out.print("Ingrese la fecha de aplicación de la vacuna (formato: dd/MM/yyyy): ");
        String fechaStr = scanner.nextLine();
        Date fechaAplicacion;
        try {
            fechaAplicacion = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Por favor, inténtelo de nuevo.");
            return;
        }

        registroVacunacionServicio.registrarVacunacion(ciudadano, vacuna, fechaAplicacion);
        System.out.println("Registro de vacunación exitoso.");
    }

    private void consultarRegistroVacunacion() {
        System.out.println("\nConsulta de Registro de Vacunación por Ciudadano");
        System.out.print("Ingrese el ID del ciudadano: ");
        String ID = scanner.nextLine();

        List<RegistroVacunacion> registros = registroVacunacionServicio.buscarRegistrosPorCiudadano(ID);

        if (registros.isEmpty()) {
            System.out.println("No se encontraron registros de vacunación para el ciudadano con ID " + ID);
            return;
        }

        System.out.println("Registros de vacunación para el ciudadano con ID " + ID + ":");
        for (RegistroVacunacion registro : registros) {
            System.out.println("Vacuna: " + registro.getVacuna().getNombre());
            System.out.println("Fecha de Aplicación: " + registro.getFechaAplicacion());
            System.out.println("Próxima Dosis: " + (registro.getProximaDosis() != null ? registro.getProximaDosis() : "No programada"));
            System.out.println("Efectos Secundarios: " + (registro.getEfectosSecundarios() != null ? registro.getEfectosSecundarios() : "No reportados"));
            System.out.println("----------------------------------");
        }
    }

    private void agregarEfectosSecundarios() {
        System.out.println("\nAgregar Efectos Secundarios");
        System.out.print("Ingrese el ID del ciudadano: ");
        String ID = scanner.nextLine();

        Ciudadano ciudadano = ciudadanoServicio.buscarPorID(ID);

        if (ciudadano == null) {
            System.out.println("El ciudadano no existe en el sistema.");
            return;
        }

        System.out.print("Ingrese los efectos secundarios: ");
        String efectosSecundarios = scanner.nextLine();

        boolean resultado = registroVacunacionServicio.registrarEfectosSecundarios(ID, efectosSecundarios);
        if (resultado) {
            System.out.println("Efectos secundarios registrados correctamente.");
        } else {
            System.out.println("No se pudo registrar los efectos secundarios.");
        }
    }

    private void asignarProximaVacuna() {
        System.out.println("\nAsignar Próxima Vacuna");
        System.out.print("Ingrese el ID del ciudadano: ");
        String ID = scanner.nextLine();

        Ciudadano ciudadano = ciudadanoServicio.buscarPorID(ID);

        if (ciudadano == null) {
            System.out.println("El ciudadano no existe en el sistema.");
            return;
        }

        System.out.print("Ingrese la fecha de la próxima vacuna (formato: dd/MM/yyyy): ");
        String fechaStr = scanner.nextLine();
        Date fechaProximaVacuna;
        try {
            fechaProximaVacuna = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Por favor, inténtelo de nuevo.");
            return;
        }

        boolean resultado = registroVacunacionServicio.actualizarProximaDosis(ID, fechaProximaVacuna);
        if (resultado) {
            System.out.println("Próxima vacuna asignada correctamente.");
        } else {
            System.out.println("No se pudo asignar la próxima vacuna.");
        }
    }
}
