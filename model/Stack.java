package Model;

public class Stack {
    private List data;

    // Constructor
    public Stack() {
        data = new List();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // Insertar en la pila
    public void push(Paciente e) {
        data.addFirst(e);
    }

    // Sacar de la pila
    public Object pop() throws Exception {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return null;
        }
        return data.removeFirst();
    }

    // Ver la cima
    public Object top() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
            return null;
        }
        return data.first().getData();
    }

    // Mostrar pila
    public void showStack() {
        if (isEmpty()) {
            System.out.println("[ pila vacía ]");
            return;
        }

        Node current = data.first();
        System.out.println("Contenido de la pila (de cima a fondo):");

        while (current != null) {
            System.out.println("| " + current.getData() + " |");
            current = current.getNext();
        }
    }
    
    public void showStackRecursivo(Node current) {
    // Caso base
    if (current == null) {
        return;
    }

    System.out.println("| " + current.getData() + " |");
    // Llamada recursiva
    showStackRecursivo(current.getNext());
    }
    
    public String showStackRecursivo2(Node current) {
    // Caso base
    if (current == null) {
        return " ";
    }
    return current.getData() + showStackRecursivo2(current.getNext());
    }
}
