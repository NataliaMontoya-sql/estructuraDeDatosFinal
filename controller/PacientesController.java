package controller;

import model.CentroSalud;
import model.PacienteEPS;
import model.PacienteSISBEN;
import model.Estructuras.Validador;

public class PacientesController {
    private final CentroSalud centro;

    public PacientesController(CentroSalud c){
        this.centro = c;
    }

    public PacienteEPS registrarPacienteEPS(){
        int id = 0;
        do {
            id = Validador.leerEnteroMayor0("Introduzca el id del paciente, recuerde que este no puede ser 0 y no debe estar registrado");

            System.out.println((centro.verificarExiste(id)) ? "El usuario ya se encuentra registrado, solo puedes registrar personas que no lo hayan hecho antes" : "");

        } while (centro.verificarExiste(id));

        String nombre = Validador
                .leerOpcionMinusculaSinEspacios("Introduzca su nombre, este campo no puede estar vacio");
        
        String apellido = Validador.leerOpcionMinusculaSinEspacios("Introduzca su apellido, este campo no puede estar vacio");
        
        int edad = Validador.leerEnteroMayor0("Introduzca su edad, este campo no puede estar vacio");

        long telefono = Validador.leerLongMayor0("Introduzca el telefono del usuario");

        String nombreEps = Validador.leerOpcionMinusculaSinEspacios("Introduzca el nombre de la EPS al que pertenece");

        PacienteEPS paciente = new PacienteEPS(id, nombre, apellido, edad, telefono, nombreEps);

        centro.registrarPacienteEps(paciente);

        return paciente;
    }

    public PacienteSISBEN registrarPacienteSISBEN(){
        int id = 0;
        do {
            id = Validador.leerEnteroMayor0("Introduzca el id del paciente, recuerde que este no puede ser 0 y no debe estar registrado");

            System.out.println((centro.verificarExiste(id)) ? "El usuario ya se encuentra registrado, solo puedes registrar personas que no lo hayan hecho antes" : "");

        } while (centro.verificarExiste(id));

        String nombre = Validador
                .leerOpcionMinusculaSinEspacios("Introduzca su nombre, este campo no puede estar vacio");
        
        String apellido = Validador.leerOpcionMinusculaSinEspacios("Introduzca su apellido, este campo no puede estar vacio");
        
        int edad = Validador.leerEnteroMayor0("Introduzca su edad, este campo no puede estar vacio");

        String puntajeSisben = Validador.leerOpcionMinusculaSinEspacios("Introduzca el puntaje del sisben");

        long telefono = Validador.leerLongMayor0("Introduzca el telefono del usuario");

        PacienteSISBEN paciente = new PacienteSISBEN(id, nombre, apellido, edad, telefono, puntajeSisben);

        centro.registrarPacienteSisben(paciente);

        return paciente;
    }

    public void mostrarListaEPS(){
        centro.mostrarListaEPS();
    }

    public void mostrarListaSISBEN(){
        centro.mostrarListaSISBEN();
    }

    public void eliminarPaciente() throws Exception {
        int id = 0;

        do {
            id = Validador.leerEnteroMayor0("Introduzca el ID del paciente que desea eliminar");

            if (!centro.verificarExiste(id)) {
                System.out.println("ID no valido");
            }

        } while (!centro.verificarExiste(id));

        centro.eliminarPaciente(id);
    }


    public void buscarPacienteId() {
        int id = Validador.leerEnteroMayor0("Introduzca el ID del paciente a buscar");

        System.out.println(centro.mostrarUsuario(id));
    }
    
    public void mostrarListaInOrder() {
        centro.mostrarListaInOrder();
    }
    
    public void mostrarListaPreOrder() {
        centro.mostrarListaPreOrder();
    }
    
    public void mostrarListaPostOrder() {
        centro.mostrarListaPostOrder();
    }

    public void guardarEpsCSV() {
        centro.pacientesEPSToCSV();
    }

    public void guardarSisbenCSV() {
        centro.pacientesSISBENToCSV();
    }

}
