package Model;

public class PacienteEPS extends Paciente {
    private String nombreEPS;

    public PacienteEPS(int id, String nombre, String apellido, int edad, long telefono, String nombreEps) {
        super(id, nombre, apellido, edad, telefono);
        this.nombreEPS = nombreEps;

    }

    private String getNombreEps() {
        return nombreEPS;
    }

    private void setNombreEps(String nombreEps) {
        this.nombreEPS = nombreEps;
    }
    
    @Override
    public String mostrarInformacion() {
        return getNombre() + " " + getApellido() + " #ID: " + getId() + " es usuario de la eps: " + getNombreEps() + ", tiene " + getEdad() + " años de edad, " + "y su teléfono es: " + getTelefono();
    }   
}
