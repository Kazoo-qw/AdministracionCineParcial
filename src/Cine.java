import Funcion.Funcion;
import Excepciones.CodigoDuplicadoException;
import Excepciones.ListaVaciaException;
import Excepciones.FuncionNoEncontradaException;

public class Cine {
    private NodoFuncion head;

    public Cine() {
        this.head = null;
    }

    public void registrarFuncion(Funcion nueva) throws CodigoDuplicadoException {
        if (buscarPorCodigo(nueva.getCodigo()) != null) {
            throw new CodigoDuplicadoException("Ya existe una función con el código: " + nueva.getCodigo());
        }

        NodoFuncion nuevoNodo = new NodoFuncion(nueva);
        if (head == null) {
            head = nuevoNodo;
        } else {
            NodoFuncion actual = head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(nuevoNodo);
        }
    }

    public Funcion buscarPorCodigo(String codigo) {
        NodoFuncion actual = head;
        while (actual != null) {
            if (actual.getData().getCodigo().equals(codigo)) {
                return actual.getData();
            }
            actual = actual.getNext();
        }
        return null;
    }

    public Funcion[] listarFunciones() throws ListaVaciaException {
        if (head == null) {
            throw new ListaVaciaException("No hay funciones registradas");
        }

        int count = 0;
        NodoFuncion actual = head;
        while (actual != null) {
            count++;
            actual = actual.getNext();
        }

        Funcion[] funciones = new Funcion[count];
        actual = head;
        for (int i = 0; i < count; i++) {
            funciones[i] = actual.getData();
            actual = actual.getNext();
        }

        return funciones;
    }

    public boolean estaVacia() {
        return head == null;
    }
}
