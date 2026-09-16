import Funcion.Funcion;

public class NodoFuncion {
    private Funcion data;
    private NodoFuncion next;

    public NodoFuncion(Funcion data) {
        this.data = data;
        this.next = null;
    }

    public Funcion getData() {
        return data;
    }

    public void setData(Funcion data) {
        this.data = data;
    }

    public NodoFuncion getNext() {
        return next;
    }

    public void setNext(NodoFuncion next) {
        this.next = next;
    }
}
