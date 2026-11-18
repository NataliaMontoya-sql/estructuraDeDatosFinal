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

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int getEdad() {
        return edad;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

}