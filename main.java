import Model.CentroSalud;
import Model.Paciente;
import Model.PacienteEPS;
import Model.PacienteSISBEN;

public class main {

    public static void main(String[] args) throws Exception {

        CentroSalud centro = new CentroSalud();
        
        centro.registrarPacienteEps(new PacienteEPS(123, "emmanuel", "arenas", 20, 12345566, "Sura"));
        centro.registrarPacienteEps(new PacienteEPS(32, "emmanuel", "arenas", 20, 12345566, "Sura"));
        centro.registrarPacienteEps(new PacienteEPS(76, "emmanuel", "arenas", 20, 12345566, "Sura"));
        centro.registrarPacienteEps(new PacienteEPS(12, "emmdwqdqwdanuel", "arewdwdnas", 20, 12345566, "asdasd"));
        
        centro.eliminar(76);
        
        centro.registrarPacienteSisben(new PacienteSISBEN(76, "emmanuel", "arenas", 20, 12345566, 10));
        
        centro.eliminar(76);
        centro.eliminar(76);


        System.out.println(centro.mostrarUsuario(76));
        System.out.println(centro.mostrarUsuario(12));
        centro.listaUsuariosRegistrados.inOrden();
        
    }

}
