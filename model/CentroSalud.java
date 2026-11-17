package Model;

public class CentroSalud {
    private List pacientesEPS;
    private List pacientesSISBEN;
    private Arbol listaUsuariosRegistrados;
    private Queue citas;
    private Stack historial;

    public CentroSalud() {
        pacientesEPS = new List();
        pacientesSISBEN = new List();
        citas = new Queue();
        listaUsuariosRegistrados = new Arbol();
        historial = new Stack();
    }

    private List getPacientesEps() {
        return pacientesEPS;
    }

    private List getPacientesSisben() {
        return pacientesSISBEN;
    }

    private Queue getCitas() {
        return citas;
    }
    
    public String mostrarUsuario(int id) {
        Paciente paciente = listaUsuariosRegistrados.busquedaParaMostrar(id);
        return (paciente == null) ? "Paciente no encontrado" : paciente.mostrarInformacion();
    }
    
    public void eliminar(int id) throws Exception {
        
        if (!listaUsuariosRegistrados.busqueda(id)) {
            System.err.println("Usuario no se encuentra registrado");
            return;
        }

        Queue temp = new Queue();
        boolean citaActiva = false;

        for (int i = 0; i < citas.size(); i++) {
            Paciente x = citas.dequeue();
            temp.enqueue(x);
            if (id == x.getId()) {
                citaActiva = true;
            }
        }

        citas = temp;

        if (citaActiva) {
            System.out.println("El usuario tiene una cita activa, no se puede eliminar");
            return;
        }

       Node actual = pacientesEPS.first();

        for ( int i = 0; i < pacientesEPS.size(); i++) {
            if (id == actual.getData().getId()) {
                pacientesEPS.removeAt(i);
                listaUsuariosRegistrados.eliminarPredecesor(id);
                System.out.println("Paciente de EPS removido correctamente");
                return;
            } else actual = actual.getNext();
        }

        actual = pacientesSISBEN.first();

        for ( int i = 0; i < pacientesSISBEN.size(); i++) {
            if (id == actual.getData().getId()) {
                System.out.println("Paciente del SISBEN removido correctamente");
                listaUsuariosRegistrados.eliminarPredecesor(id);
                pacientesSISBEN.removeAt(i);
                return;
            } else actual = actual.getNext();
        }

        System.out.println("Error al eliminar");

    }

    public boolean registrarPacienteEps(PacienteEPS paciente) {

        if (listaUsuariosRegistrados.busqueda(paciente.getId())) {
            System.err.println("Usuario ya se encuentra registrado por lo que no se puede registrar nuevamente");
            return false;
        }

        pacientesEPS.addLast(paciente);
        listaUsuariosRegistrados.insertarNodo(paciente);

        return true;
    }

    public boolean registrarPacienteSisben(PacienteSISBEN paciente) {

        if (listaUsuariosRegistrados.busqueda(paciente.getId())) {
            System.err.println("Usuario ya se encuentra registrado por lo que no se puede registrar nuevamente");
            return false;
        }

        pacientesSISBEN.addLast(paciente);
        listaUsuariosRegistrados.insertarNodo(paciente);

        return true;
    }

    // CITAS

    private boolean crearCita(int idPaciente, String especialidad, String problema) {

        Cita cita = new Cita(idPaciente, especialidad, problema);

        citas.enqueue(cita);

        return true;
    }
}