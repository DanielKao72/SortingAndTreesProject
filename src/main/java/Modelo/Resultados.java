package Modelo;

public class Resultados {
    private String nombre;
    private long tiempo;
    private boolean encontrado;

    public Resultados(String nombre, long tiempo, boolean encontrado) {
        this.nombre = nombre;
        this.tiempo = tiempo;
        this.encontrado = encontrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public boolean isEncontrado() {
        return encontrado;
    }

    public void setEncontrado(boolean encontrado) {
        this.encontrado = encontrado;
    }
}