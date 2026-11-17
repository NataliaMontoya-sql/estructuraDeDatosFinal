package Model;

public class Node {
    private Object data;
    private Node next;

    public Node() {
        this.data = null;
        this.next = null;
    }
    
    public Node(Paciente data) {
        this.data = data;
        this.next = null;
    }
    public Node(Cita data) {
        this.data = data;
        this.next = null;
    }

    public Paciente getData() {
        return data;
    }

    public void setData(Paciente data) {
        this.data = data;
    }

    public void setData(Cita data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node n) {
        this.next = n;
    }
}

