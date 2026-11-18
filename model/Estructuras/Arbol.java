package Model.Estructuras;

import Model.Paciente;

public class Arbol {

    private Nodo raizPtr;

    public Arbol() {
        raizPtr = null;
    }

    public boolean esVacio() {
        return raizPtr == null;
    }

    public Nodo regresaRaiz() {
        return raizPtr;
    }


    public void insertarNodo(Paciente paciente) {
        raizPtr = insertarNodo(paciente, raizPtr);
    }

    private Nodo insertarNodo(Paciente paciente, Nodo nodoPtr) {

        if (nodoPtr == null) {
            nodoPtr = new Nodo(paciente);
        } else if (paciente.getId() < nodoPtr.getDato()) {
            nodoPtr.setIzquierdoPtr(
                    insertarNodo(paciente, nodoPtr.getIzquierdoPtr())
            );
        } else if (paciente.getId() > nodoPtr.getDato()) {
            nodoPtr.setDerechoPtr(
                    insertarNodo(paciente, nodoPtr.getDerechoPtr())
            );
        } else {
            System.out.println("El valor " + paciente.getId() + " ya existe en el árbol.");
        }

        return nodoPtr;
    }

    public void muestraAcostado() {
        muestraAcostado(0, raizPtr);
    }

    private void muestraAcostado(int nivel, Nodo nodoPtr) {

        if (nodoPtr == null) {
            return;
        }

        muestraAcostado(nivel + 1, nodoPtr.getDerechoPtr());

        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }

        System.out.println(nodoPtr.getDato());

        muestraAcostado(nivel + 1, nodoPtr.getIzquierdoPtr());
    }

    public void inOrden() {
        inOrden(raizPtr);
        System.out.println();
    }

    private void inOrden(Nodo nodoPtr) {

        if (nodoPtr == null) {
            return;
        }

        inOrden(nodoPtr.getIzquierdoPtr());
        System.out.print(nodoPtr.getDato() + " - ");
        inOrden(nodoPtr.getDerechoPtr());
    }


    public void preOrden() {
        preOrden(raizPtr);
        System.out.println();
    }

    private void preOrden(Nodo nodoPtr) {

        if (nodoPtr == null) {
            return;
        }

        System.out.print(nodoPtr.getDato() + " - ");
        preOrden(nodoPtr.getIzquierdoPtr());
        preOrden(nodoPtr.getDerechoPtr());
    }

    public void postOrden() {
        postOrden(raizPtr);
        System.out.println();
    }

    private void postOrden(Nodo nodoPtr) {

        if (nodoPtr == null) {
            return;
        }

        postOrden(nodoPtr.getIzquierdoPtr());
        postOrden(nodoPtr.getDerechoPtr());
        System.out.print(nodoPtr.getDato() + " - ");
    }

    public boolean busqueda(int x) {
        return busqueda(x, raizPtr);
    }

    private boolean busqueda(int x, Nodo nodoPtr) {

        if (nodoPtr == null) {
            return false;
        } else if (x < nodoPtr.getDato()) {
            return busqueda(x, nodoPtr.getIzquierdoPtr());
        } else if (x > nodoPtr.getDato()) {
            return busqueda(x, nodoPtr.getDerechoPtr());
        } else {
            return true;
        }
    }

    private Paciente busquedaParaMostrar(int x, Nodo nodoPtr) {

        if (nodoPtr == null) {
            return null;
        } else if (x < nodoPtr.getDato()) {
            return busquedaParaMostrar(x, nodoPtr.getIzquierdoPtr());
        } else if (x > nodoPtr.getDato()) {
            return busquedaParaMostrar(x, nodoPtr.getDerechoPtr());
        } else {
            return nodoPtr.getInformacion();
        }
    }

    public Paciente busquedaParaMostrar(int x) {
        return busquedaParaMostrar(x, raizPtr);
    }

    public Nodo buscaMenor() {
        return buscaMenor(raizPtr);
    }

    private Nodo buscaMenor(Nodo nodoPtr) {

        if (nodoPtr == null) {
            return null;
        } else if (nodoPtr.getIzquierdoPtr() == null) {
            return nodoPtr;
        } else {
            return buscaMenor(nodoPtr.getIzquierdoPtr());
        }
    }

    public Nodo buscaMayor() {
        return buscaMayor(raizPtr);
    }

    private Nodo buscaMayor(Nodo nodoPtr) {

        if (nodoPtr == null) {
            return null;
        } else if (nodoPtr.getDerechoPtr() == null) {
            return nodoPtr;
        } else {
            return buscaMayor(nodoPtr.getDerechoPtr());
        }
    }

    public void eliminarPredecesor(int x) {
        raizPtr = eliminarPredecesor(x, raizPtr);
    }

    private Nodo eliminarPredecesor(int x, Nodo nodoPtr) {

        if (nodoPtr == null) {
            System.out.println("El valor " + x + " no existe en el árbol.");
            return null;
        }

        if (x < nodoPtr.getDato()) {
            nodoPtr.setIzquierdoPtr(
                    eliminarPredecesor(x, nodoPtr.getIzquierdoPtr())
            );
        } else if (x > nodoPtr.getDato()) {
            nodoPtr.setDerechoPtr(
                    eliminarPredecesor(x, nodoPtr.getDerechoPtr())
            );
        } else {

            // Caso 1: nodo hoja
            if (nodoPtr.getIzquierdoPtr() == null && nodoPtr.getDerechoPtr() == null) {
                return null;
            }

            // Caso 2: solo tiene hijo derecho
            if (nodoPtr.getIzquierdoPtr() == null) {
                return nodoPtr.getDerechoPtr();
            }

            // Caso 2: solo tiene hijo izquierdo
            if (nodoPtr.getDerechoPtr() == null) {
                return nodoPtr.getIzquierdoPtr();
            }

            // Caso 3: tiene dos hijos
            // Se busca el predecesor: mayor del subárbol izquierdo
            Nodo predecesor = buscaMayor(nodoPtr.getIzquierdoPtr());

            nodoPtr.setDato(predecesor.getDato());

            nodoPtr.setIzquierdoPtr(
                    eliminarPredecesor(predecesor.getDato(), nodoPtr.getIzquierdoPtr())
            );
        }

        return nodoPtr;
    }

    public void eliminarSucesor(int x) {
        raizPtr = eliminarSucesor(x, raizPtr);
    }

    private Nodo eliminarSucesor(int x, Nodo nodoPtr) {

        if (nodoPtr == null) {
            System.out.println("El valor " + x + " no existe en el árbol.");
            return null;
        }

        if (x < nodoPtr.getDato()) {
            nodoPtr.setIzquierdoPtr(
                    eliminarSucesor(x, nodoPtr.getIzquierdoPtr())
            );
        } else if (x > nodoPtr.getDato()) {
            nodoPtr.setDerechoPtr(
                    eliminarSucesor(x, nodoPtr.getDerechoPtr())
            );
        } else {

            // Caso 1: nodo hoja
            if (nodoPtr.getIzquierdoPtr() == null && nodoPtr.getDerechoPtr() == null) {
                return null;
            }

            // Caso 2: solo tiene hijo derecho
            if (nodoPtr.getIzquierdoPtr() == null) {
                return nodoPtr.getDerechoPtr();
            }

            // Caso 2: solo tiene hijo izquierdo
            if (nodoPtr.getDerechoPtr() == null) {
                return nodoPtr.getIzquierdoPtr();
            }

            // Caso 3: tiene dos hijos
            // Se busca el sucesor: menor del subárbol derecho
            Nodo sucesor = buscaMenor(nodoPtr.getDerechoPtr());

            nodoPtr.setDato(sucesor.getDato());

            nodoPtr.setDerechoPtr(
                    eliminarSucesor(sucesor.getDato(), nodoPtr.getDerechoPtr())
            );
        }

        return nodoPtr;
    }

    public void podarArbol() {
        raizPtr = podarArbol(raizPtr);
    }

    private Nodo podarArbol(Nodo nodoPtr) {

        if (nodoPtr == null) {
            return null;
        }

        nodoPtr.setIzquierdoPtr(
                podarArbol(nodoPtr.getIzquierdoPtr())
        );

        nodoPtr.setDerechoPtr(
                podarArbol(nodoPtr.getDerechoPtr())
        );

        return null;
    }
}
