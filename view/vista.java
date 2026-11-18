package view;

import controller.CitasController;
import controller.PacientesController;
import model.CentroSalud;
import java.util.Scanner;

public class vista {

    private final CentroSalud centro;
    private final PacientesController pacientesController;
    private final CitasController citasController;
    private final Scanner scanner;

    public vista() {
        // Inicializa el modelo central compartido y los dos controladores
        this.centro = new CentroSalud();
        this.pacientesController = new PacientesController(this.centro);
        this.citasController = new CitasController(this.centro);
        this.scanner = new Scanner(System.in);
    }

    /**
     * Bucle principal de la interfaz de usuario por consola.
     */
    public void iniciar() {
        int opcion = -1;

        do {
            mostrarMenu();
            opcion = leerEntero();

            try {
                switch (opcion) {
                    case 1:
                        System.out.println("\n--- REGISTRAR PACIENTE EPS ---");
                        pacientesController.registrarPacienteEPS();
                        break;
                    case 2:
                        System.out.println("\n--- REGISTRAR PACIENTE SISBEN ---");
                        pacientesController.registrarPacienteSISBEN();
                        break;
                    case 3:
                        System.out.println("\n--- BUSCAR PACIENTE POR ID (ÁRBOL ABB) ---");
                        pacientesController.buscarPacienteId();
                        break;
                    case 4:
                        System.out.println("\n--- LISTA DE PACIENTES EPS ---");
                        pacientesController.mostrarListaEPS();
                        break;
                    case 5:
                        System.out.println("\n--- LISTA DE PACIENTES SISBEN ---");
                        pacientesController.mostrarListaSISBEN();
                        break;
                    case 6:
                        System.out.println("\n--- AGENDAR CITA MÉDICA (COLA) ---");
                        citasController.registrarNuevaCita();
                        break;
                    case 7:
                        System.out.println("\n--- ATENDER SIGUIENTE CITA ---");
                        citasController.atenderSiguienteCita();
                        break;
                    case 8:
                        System.out.println("\n--- CITAS MÉDICAS PENDIENTES ---");
                        citasController.mostrarCitasPendientes();
                        break;
                    case 9:
                        System.out.println("\n--- ÚLTIMA ATENCIÓN REALIZADA (PILA) ---");
                        citasController.mostrarUltimaAtencion();
                        break;
                    case 10:
                        System.out.println("\n--- HISTORIAL COMPLETO DE ATENCIONES ---");
                        citasController.mostrarHistorial();
                        break;
                    case 11:
                        System.out.println("\nGuardando pacientes EPS en CSV...");
                        pacientesController.guardarEpsCSV();
                        System.out.println("Archivo guardado correctamente.");
                        break;
                    case 12:
                        System.out.println("\nGuardando pacientes SISBEN en CSV...");
                        pacientesController.guardarSisbenCSV();
                        System.out.println("Archivo guardado correctamente.");
                        break;
                    case 13:
                        System.out.println("\n--- ELIMINAR PACIENTE ---");
                        pacientesController.eliminarPaciente();
                        break;
                    case 14:
                        mostrarSubmenuRecorridos();
                        break;
                    case 0:
                        System.out.println("\nCerrando el sistema del Centro de Salud. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("\n[ERROR] Opción no válida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("\n[ERROR] Ocurrió un inconveniente: " + e.getMessage());
            }

            if (opcion != 0) {
                pausar();
            }

        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n=============================================");
        System.out.println("   SISTEMA DE GESTIÓN - CENTRO DE SALUD      ");
        System.out.println("=============================================");
        System.out.println(" 1. Registrar paciente EPS");
        System.out.println(" 2. Registrar paciente SISBEN");
        System.out.println(" 3. Buscar paciente por ID (Árbol ABB)");
        System.out.println(" 4. Mostrar todos los pacientes EPS");
        System.out.println(" 5. Mostrar todos los pacientes SISBEN");
        System.out.println(" 6. Agendar cita médica (Cola)");
        System.out.println(" 7. Atender siguiente cita");
        System.out.println(" 8. Mostrar citas pendientes");
        System.out.println(" 9. Ver última atención (historial)");
        System.out.println("10. Ver historial completo");
        System.out.println("11. Guardar pacientes EPS en CSV");
        System.out.println("12. Guardar pacientes SISBEN en CSV");
        System.out.println("13. Eliminar paciente por ID");
        System.out.println("14. Visualizar recorridos del Árbol (ABB)");
        System.out.println(" 0. Salir");
        System.out.println("=============================================");
        System.out.print("Seleccione una opción: ");
    }

    private void mostrarSubmenuRecorridos() {
        System.out.println("\n--- RECORRIDOS DEL ÁRBOL BINARIO DE BÚSQUEDA ---");
        System.out.println("\n1. Recorrido Inorden (Orden ascendente por ID):");
        pacientesController.mostrarListaInOrder();

        System.out.println("\n2. Recorrido Preorden (Raíz -> Izq -> Der):");
        pacientesController.mostrarListaPreOrder();

        System.out.println("\n3. Recorrido Postorden (Izq -> Der -> Raíz):");
        pacientesController.mostrarListaPostOrder();
    }

    private int leerEntero() {
        while (true) {
            try {
                String linea = scanner.nextLine().trim();
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.print("[ERROR] Ingrese un número válido: ");
            }
        }
    }

    private void pausar() {
        System.out.print("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }
}
