package Model;

public class PacienteSISBEN extends Paciente {
    private int puntajeSISBEN;

    public PacienteSISBEN(int id, String nombre, String apellido, int edad, long telefono, int puntajeSisben) {
        super(id, nombre, apellido, edad, telefono);
        this.puntajeSISBEN = puntajeSisben;
    }

    private int getPuntajeSisben() {
        return puntajeSISBEN;
    }
    
    @Override
    public String mostrarInformacion() {
        return getNombre() + " " + getApellido() + " #ID: " + getId() + " es usuario del sisben con un puntaje de: " + getPuntajeSisben() + ", tiene " + getEdad() + " años de edad, " + "y su teléfono es: " + getTelefono();
    }

}
