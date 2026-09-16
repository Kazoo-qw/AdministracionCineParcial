package Funcion;

public class Funcion {
    private String codigo;
    private String pelicula;
    private String horaInicio;
    boolean  [] puestos = new boolean[20];

    public Funcion(String codigo, String pelicula, String horaInicio) {
        setCodigo(codigo);
        setPelicula(pelicula);
        setHoraInicio(horaInicio);
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getPelicula() {
        return pelicula;
    }
    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }
    public String getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    public boolean [] getPuestos() {
        return puestos;
    }
    public void setPuestos(boolean [] puestos) {
        this.puestos = puestos;
    }

}

