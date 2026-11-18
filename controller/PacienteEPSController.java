package controller;

import Model.CentroSalud;
import Model.PacienteEPS;
import Model.Validador;

public class PacienteEPSController {
    private final CentroSalud centro;

    public PacienteEPSController(){
        this.centro = new CentroSalud();
    }

    public PacienteEPS registrarPacienteEPS(){
        int id = 0;
        do {
            id = Validador.leerEnteroMayor0("Introduzca el id del paciente, recuerde que este no puede ser 0 y no debe estar registrado");

            System.out.println((centro.verificarExiste(id)) ? "El usuario ya se encuentra registrado, solo puedes registrar personas que no lo hayan hecho antes" : "");

        } while (centro.verificarExiste(id));

        String nombre = Validador.leerOpcionMinusculaSinEspacios("Introduzca su nombre, este campo no puede estar vacio");

        long telefono = Validador.leerLongMayor0("Introduzca el telefono del usuario");

        String nombreEps = Validador.leerOpcionMinusculaSinEspacios("Introduzca el nombre de la EPS al que pertenece");

        PacienteEPS paciente = new PacienteEPS(id, nombreEps, nombre, id, telefono, nombreEps);

        centro.registrarPacienteEps(paciente);

        return paciente;
    }

    public void mostrarListaEPS(){
        centro.mostrarListaEPS();
    }

    public void eliminarPacienteEPS() throws Exception{
        int id = 0;

        do {
            id = Validador.leerEnteroMayor0("Introduzca el ID del paciente que desea eliminar");
    
            if (!centro.verificarExiste(id)) {
                System.out.println("ID no valido");
            }
            
        } while (!centro.verificarExiste(id));

        centro.eliminarPacienteEPS(id);
        System.out.println("Paciente de EPS eliminado con exito");
    }

}
