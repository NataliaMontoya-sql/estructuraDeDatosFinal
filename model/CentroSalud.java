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

    // public List getPacientesEps() {
    //     return pacientesEPS;
    // }

    // public List getPacientesSisben() {
    //     return pacientesSISBEN;
    // }

    // public Queue getCitas() {
    //     return citas;
    // }
    
    public String mostrarUsuario(int id) {
        Paciente paciente = listaUsuariosRegistrados.busquedaParaMostrar(id);
        return (paciente == null) ? "Paciente no encontrado" : paciente.toString();
    }

    public void pacientesEPSToCSV() {
        pacientesEPS.guardarEnCSV("Pacientes_eps.csv",
                "Pacientes EPS\nID/Nombre/Apellido/Edad/Telefono/Nombre de su EPS");
    }
    
    public void pacientesSISBENToCSV() {
        pacientesSISBEN.guardarEnCSV("Pacientes_sisben.csv", "Pacientes Sisben\nID/Nombre/Apellido/Edad/Telefono/Puntaje del Sisben");
    }

    public void mostrarListaEPS(){
        pacientesEPS.mostrarLista();
    }

    public void mostrarListaSISBEN() {
        pacientesSISBEN.mostrarLista();
    }
    
    public void mostrarCitasPendientes() {
        citas.showQueue();
    }

    public boolean verificarExiste(int id){
        return listaUsuariosRegistrados.busqueda(id);

    }
    
    public void eliminarPacienteEPS(int id) throws Exception {
        
        Queue temp = new Queue();
        boolean citaActiva = false;

        for (int i = 0; i < citas.size(); i++) {
            Paciente x = (Paciente) citas.dequeue();
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
            if (id == ((PacienteEPS)actual.getData()).getId()) {
                pacientesEPS.removeAt(i);
                listaUsuariosRegistrados.eliminarPredecesor(id);
                System.out.println("Paciente de EPS removido correctamente");
                return;
            } else actual = actual.getNext();
        }

        System.out.println("Error al eliminar");

    }
    
    public void eliminarPacienteSISBEN(int id) throws Exception {
        
        Queue temp = new Queue();
        boolean citaActiva = false;

        for (int i = 0; i < citas.size(); i++) {
            Paciente x = (Paciente) citas.dequeue();
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

        Node actual = pacientesSISBEN.first();

        for ( int i = 0; i < pacientesSISBEN.size(); i++) {
            if (id == ((PacienteSISBEN) actual.getData()).getId()) {
                System.out.println("Paciente del SISBEN removido correctamente");
                listaUsuariosRegistrados.eliminarPredecesor(id);
                pacientesSISBEN.removeAt(i);
                return;
            } else actual = actual.getNext();
        }

        System.out.println("Error al eliminar");

    }

    public boolean registrarPacienteEps(PacienteEPS paciente) {

        pacientesEPS.addLast(paciente);
        listaUsuariosRegistrados.insertarNodo(paciente);

        return true;
    }

    public CitaNueva procesarCita() throws Exception {
        return (CitaNueva) citas.dequeue();
    }

    public boolean registrarPacienteSisben(PacienteSISBEN paciente) {

        pacientesSISBEN.addLast(paciente);
        listaUsuariosRegistrados.insertarNodo(paciente);

        return true;
    }

    public void agregarHistorial(CitaProcesada cita) {
        historial.push(cita);
    }

    public void mostrarListaInOrder() {
        listaUsuariosRegistrados.inOrden();
    }
    
    public void mostrarListaPreOrder() {
        listaUsuariosRegistrados.preOrden();
    }

    public void mostrarListaPostOrder() {
        listaUsuariosRegistrados.postOrden();
    }
    
    // CITAS

    public void crearCita(int idPaciente, String especialidad, String problema) {

        citas.enqueue(new CitaNueva(idPaciente, especialidad, problema));

    }

    public void mostrarUltimaAtencion() {
        System.out.println(((CitaProcesada) historial.top()).toString());
    }
    
    public void mostrarHistorial() {
        historial.showStack();
    }
}