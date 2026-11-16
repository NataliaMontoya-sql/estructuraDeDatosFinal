package Model;

public class Nodo { // Esta clase es implementada por los arboles y no por las demás

    private Paciente informacion;
    private int dato;
    private Nodo izquierdoPtr;
    private Nodo derechoPtr;

    public Nodo(Paciente paciente) {
        this.informacion = paciente;
        this.dato = paciente.getId();
        this.izquierdoPtr = null;
        this.derechoPtr = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getIzquierdoPtr() {
        return izquierdoPtr;
    }

    public Paciente getInformacion() {
        return informacion;
    }

    public void setIzquierdoPtr(Nodo izquierdoPtr) {
        this.izquierdoPtr = izquierdoPtr;
    }

    public Nodo getDerechoPtr() {
        return derechoPtr;
    }

    public void setDerechoPtr(Nodo derechoPtr) {
        this.derechoPtr = derechoPtr;
    }
}