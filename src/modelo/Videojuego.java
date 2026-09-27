package modelo;

public class Videojuego {
    private String titulo;
    private String genero;
    private double precio;

    public Videojuego(String titulo, String genero, double precio) {
        this.titulo = titulo;
        this.genero = genero;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public double getPrecio() {
        return precio;
    }
}
