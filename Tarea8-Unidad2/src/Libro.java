public class Libro {
    private String titulo;
    private boolean rentado;

    public Libro(String titulo) {
        this.titulo = titulo;
        this.rentado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isRentado() {
        return rentado;
    }

    public void setRentado(boolean rentado) {
        this.rentado = rentado;
    }
}
