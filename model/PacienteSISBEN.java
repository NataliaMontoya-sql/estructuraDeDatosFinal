package model;

public class PacienteSISBEN extends Paciente {
    private String puntajeSISBEN;

    public PacienteSISBEN(int id, String nombre, String apellido, int edad, long telefono, String puntajeSisben) {
        super(id, nombre, apellido, edad, telefono);
        this.puntajeSISBEN = puntajeSisben;
    }

    public String getPuntajeSisben() {
        return puntajeSISBEN;
    }
    
    @Override
    public String toString() {
        return getNombre() + " " + getApellido() + " #ID: " + getId() + " es usuario del sisben con un puntaje de: "
                + getPuntajeSisben() + ", tiene " + getEdad() + " años de edad, " + "y su teléfono es: "
                + getTelefono();
    }

    @Override
    public String toCSV() {
        return getId() + "," + getNombre() + "," + getApellido() + "," + getEdad() + "," + getTelefono() + "," + getPuntajeSisben(); 
    }

}
