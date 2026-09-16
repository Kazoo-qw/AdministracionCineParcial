package Funcion;

public class contarVendidos {
    public static int contarVendidos(Funcion funcion){
        int vendidos = 0;
        for (int i = 0; i < funcion.getPuestos().length; i++) {
            if (funcion.getPuestos()[i]) {
                vendidos++;
            }
        }
        return vendidos;
    }
}
