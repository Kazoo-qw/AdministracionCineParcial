package Funcion;
import Excepciones.IndiceInvalidoException;

public class obtenerPuestosTexto {
    public static String obtenerPuestosTexto(Funcion funcion) throws IndiceInvalidoException {
        String texto = "";

        for (int i = 0; i < funcion.getPuestos().length; i++) {
            int numeroPuesto = i + 1;
            String etiqueta;

            if (estaDisponible.estaDisponible(funcion, i)) {
                etiqueta = "[D]";
            } else {
                etiqueta = "[O]";
            }

            texto = texto + numeroPuesto + " " + etiqueta + " ";

            if (numeroPuesto % 5 == 0) {
                texto = texto + "\n";
            }
        }

        return texto;
    }
}
