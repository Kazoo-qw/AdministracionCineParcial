import Funcion.Funcion;
import Funcion.obtenerPuestosTexto;
import Funcion.estaDisponible;
import Funcion.ocuparPuesto;
import Funcion.contarVendidos;
import Excepciones.CodigoDuplicadoException;
import Excepciones.ListaVaciaException;
import Excepciones.IndiceInvalidoException;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Cine cine;

    public Menu(Cine cine) {
        this.scanner = new Scanner(System.in);
        this.cine = cine;
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("========== CINE ==========");
            System.out.println("1. Registrar función");
            System.out.println("2. Comprar entrada");
            System.out.println("3. Iniciar labores");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarFuncion();
                    break;
                case 2:
                    comprarEntrada();
                    break;
                case 3:
                    iniciarLabores();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    public void registrarFuncion() {
        System.out.println("========== REGISTRAR FUNCIÓN ==========");
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Película: ");
        String pelicula = scanner.nextLine();
        System.out.print("Hora de inicio: ");
        String horaInicio = scanner.nextLine();

        Funcion nueva = new Funcion(codigo, pelicula, horaInicio);
        try {
            cine.registrarFuncion(nueva);
            System.out.println("Función registrada exitosamente");
        } catch (CodigoDuplicadoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void comprarEntrada() {
        try {
            System.out.println("========== COMPRAR ENTRADA ==========");
            Funcion[] funciones = cine.listarFunciones();
            for (int i = 0; i < funciones.length; i++) {
                System.out.println((i + 1) + ". Código: " + funciones[i].getCodigo() + " - Película: " + funciones[i].getPelicula());
            }

            System.out.print("Seleccione una función: ");
            int seleccion = scanner.nextInt();
            scanner.nextLine();

            if (seleccion < 1 || seleccion > funciones.length) {
                System.out.println("Selección no válida");
                return;
            }

            Funcion funcionSeleccionada = funciones[seleccion - 1];
            System.out.println("========== PUESTOS DISPONIBLES ==========");
            System.out.println(obtenerPuestosTexto.obtenerPuestosTexto(funcionSeleccionada));

            boolean puestoOcupado = false;
            while (!puestoOcupado) {
                System.out.print("Ingrese número de puesto (1-20): ");
                int numeroPuesto = scanner.nextInt();
                scanner.nextLine();

                if (numeroPuesto < 1 || numeroPuesto > 20) {
                    System.out.println("Número de puesto inválido. Debe estar entre 1 y 20");
                    continue;
                }

                int indice = numeroPuesto - 1;
                try {
                    if (estaDisponible.estaDisponible(funcionSeleccionada, indice)) {
                        ocuparPuesto.ocuparPuesto(funcionSeleccionada, indice);
                        System.out.println("Puesto " + numeroPuesto + " ocupado exitosamente");
                        puestoOcupado = true;
                    } else {
                        System.out.println("El puesto " + numeroPuesto + " ya está ocupado. Seleccione otro puesto");
                    }
                } catch (IndiceInvalidoException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (ListaVaciaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void iniciarLabores() {
        try {
            System.out.println("========== INICIAR LABORES ==========");
            Funcion[] funciones = cine.listarFunciones();

            for (int i = 0; i < funciones.length; i++) {
                Funcion funcion = funciones[i];
                int vendidos = contarVendidos.contarVendidos(funcion);
                int disponibles = 20 - vendidos;

                System.out.println("========== REPRODUCIENDO FUNCIÓN ==========");
                System.out.println("Película: " + funcion.getPelicula());
                System.out.println("Hora: " + funcion.getHoraInicio());
                System.out.println("Puestos vendidos: " + vendidos);
                System.out.println("Puestos disponibles: " + disponibles);

                if (i < funciones.length - 1) {
                    System.out.print("Presione una tecla para continuar con la siguiente función...");
                    scanner.nextLine();
                }
            }

            System.out.println("========== FIN DE LABORES ==========");
            System.out.println("Todas las funciones han sido reproducidas");
        } catch (ListaVaciaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
