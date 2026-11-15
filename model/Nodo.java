package Model;

public class Nodo { // Esta clase es implementada por los arboles y no por las demás

    private int dato;
    private Nodo izquierdoPtr;
    private Nodo derechoPtr;

    public Nodo(int dato) {
        this.dato = dato;
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