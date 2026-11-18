package Model;

public class PacienteEPS extends Paciente {
    private String nombreEPS;

    public PacienteEPS(int id, String nombre, String apellido, int edad, long telefono, String nombreEps) {
        super(id, nombre, apellido, edad, telefono);
        this.nombreEPS = nombreEps;

    }

    public String getNombreEps() {
        return nombreEPS;
    }

    public void setNombreEps(String nombreEps) {
        this.nombreEPS = nombreEps;
    }
    
    @Override
    public String toString() {
        return getNombre() + " " + getApellido() + " #ID: " + getId() + " es usuario de la eps: " + getNombreEps() + ", tiene " + getEdad() + " años de edad, " + "y su teléfono es: " + getTelefono();
    }   
}
