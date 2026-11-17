
package Model;

public class Queue {
    private List data;

    public Queue() {
        data = new List();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void enqueue(Cita e) {
        data.addLast(e);
    }

    public Cita dequeue() throws Exception {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return null;
        }
        return data.removeFirst();
    }

    public Object front() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return null;
        }
        return data.first().getData();
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("[ cola vacía ]");
            return;
        }

        Node current = data.first();
        System.out.println("Contenido de la cola: ");
        while (current != null) {
            System.out.println("| " + current.getData() + " |");
            current = current.getNext();
        }
        System.out.println("-----");
    }
    public void showQueueRecursivo(Node current) {
    // Caso base
    if (current == null) {
        return;
    }
    // Mostrar el nodo actual
    System.out.println("| " + current.getData() + " |");

    // Llamada recursiva con el siguiente nodo
    showQueueRecursivo(current.getNext());
}
}

