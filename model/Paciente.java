package Model;

public abstract class Paciente {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private long telefono;

    protected Paciente(int id, String nombre, String apellido, int edad, long telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
    }

    protected String getNombre() {
        return nombre;
    }

    protected int getId() {
        return id;
    }

    protected String getApellido() {
        return apellido;
    }

    protected String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    protected int getEdad() {
        return edad;
    }

    protected long getTelefono() {
        return telefono;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }

    protected void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    protected void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    protected abstract String mostrarInformacion();

}