import Model.CentroSalud;
import Model.CitaNueva;
import Model.Paciente;
import Model.PacienteEPS;
import Model.PacienteSISBEN;
import controller.PacienteEPSController;

public class main {

    public static void main(String[] args) throws Exception {

        PacienteEPSController test = new PacienteEPSController();
        
        test.registrarPacienteEPS();

        // centro.citas.enqueue(new CitaNueva(32, " asd", " asd"));


        test.mostrarListaEPS();
        // System.out.println(centro.mostrarUsuario(12));
        // centro.pacientesEPS.mostrarLista();
        // centro.pacientesSISBEN.mostrarLista();
        // centro.citas.showQueue();
        // centro.listaUsuariosRegistrados.inOrden();
        
    }

}
