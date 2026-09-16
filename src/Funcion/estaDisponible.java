package Funcion;
import Excepciones.IndiceInvalidoException;

public class estaDisponible {
    public static boolean estaDisponible(Funcion funcion, int indice) throws IndiceInvalidoException {
        if (indice < 0 || indice >= funcion.getPuestos().length) {
            throw new IndiceInvalidoException("Índice fuera de rango: " + indice + ". Debe estar entre 0 y " + (funcion.getPuestos().length - 1));
        }
        return !funcion.getPuestos()[indice];
    }
}
