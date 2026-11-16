package Model;

public class List {
    private Node head;
    private Node tail;
    private int size;

    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node first() {
        return head;
    }

    public Node last() {
        return tail;
    }

    public void addFirst(Paciente obj) {
        Node node = new Node(obj);

        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }

        size++;
    }

    public void addLast(Paciente obj) {
        Node node = new Node(obj);

        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }

        size++;
    }

    public Paciente removeFirst() throws Exception {
        if (!isEmpty()) {
            Node temp = head;
            head = temp.getNext();
            temp.setNext(null);
            size--;

            if (size == 0) {
                tail = null;
            }

            return temp.getData();
        } else {
            throw new Exception("La lista está vacía");
        }
    }

    public Paciente removeLast() throws Exception {
        if (size == 1) {
            return removeFirst();
        } else if (size > 1) {
            Node temp = tail;
            Node anterior = head;

            while (anterior.getNext() != tail) {
                anterior = anterior.getNext();
            }

            anterior.setNext(null);
            tail = anterior;
            size--;

            return temp.getData();
        } else {
            throw new Exception("La lista está vacía");
        }
    }

    //Añadir nodo en cualquier posición
    public void addAt(int posicion, Paciente obj) throws Exception {
        if (posicion < 0 || posicion > size) {
            throw new Exception("Posición inválida");
        }

        if (posicion == 0) {
            addFirst(obj);
            return;
        }

        if (posicion == size) {
            addLast(obj);
            return;
        }

        Node nuevo = new Node(obj);
        Node actual = head;

        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getNext();//Nodo anterior a la posición que quiero modificar
        }

        nuevo.setNext(actual.getNext());//Apunto el nodo nuevo al siguiente de la posicion de interes
        actual.setNext(nuevo);//Apunto el nodo anterior al nuevo 
        size++;
    }

    //Remover nodo en cualquier posición
    public Paciente removeAt(int posicion) throws Exception {
        if (isEmpty()) {
            throw new Exception("La lista está vacía");
        }

        if (posicion < 0 || posicion >= size) {
            throw new Exception("Posición inválida");
        }

        if (posicion == 0) {
            return removeFirst();
        }

        if (posicion == size - 1) {
            return removeLast();
        }

        Node actual = head;

        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getNext();//El nodo anterior al que voy a eliminar
        }

        Node eliminado = actual.getNext();//el nodo a eliminar
        actual.setNext(eliminado.getNext());//El nodo siguiente al eliminado
        eliminado.setNext(null);
        size--;

        return eliminado.getData();
    }

    public void mostrarLista() {
        Node actual = head;

        while (actual != null) {
            System.out.print("[" + actual.getData().toString() + "] -> ");
            actual = actual.getNext();
        }

        System.out.println("null");
    }

    // MÉTODO NUEVO PARA GUARDAR EN CSV <SE TIENE QUE MODIFICAR>
     
    // public void guardarEnCSV(String nombreArchivo) {
    //     try {
    //         FileWriter fw = new FileWriter(nombreArchivo);
    //         PrintWriter pw = new PrintWriter(fw);

    //         Node actual = head;

    //         // Encabezado del archivo CSV
    //         pw.println("Registro de Estudiantes y Profesores\ntipo,nombre,edad,correo,carrera_o_facultad,contacto");

    //         while (actual != null) {
    //             Persona persona = (Persona) actual.getData();

    //             pw.println(persona.toString());

    //             actual = actual.getNext();
    //         }

    //         pw.close();
    //         fw.close();

    //         System.out.println("Archivo guardado correctamente como '" + nombreArchivo + "'");
    //     } catch (IOException e) {
    //         System.out.println("Error al guardar el archivo: " + e.getMessage());
    //     }
    // }

}