package Funcion;
import Excepciones.IndiceInvalidoException;

public class ocuparPuesto {
    public static void ocuparPuesto(Funcion funcion, int indice) throws IndiceInvalidoException {
        if (indice < 0 || indice >= funcion.getPuestos().length) {
            throw new IndiceInvalidoException("Índice fuera de rango: " + indice + ". Debe estar entre 0 y " + (funcion.getPuestos().length - 1));
        }
        funcion.getPuestos()[indice] = true;
    }
}
