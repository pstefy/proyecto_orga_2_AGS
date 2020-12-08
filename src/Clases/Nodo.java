package Clases;

public class Nodo {
  
    private String muerto;
    private String titulo;
    private int codigo;
    private Nodo siguiente;
    private Nodo anterior;
    
    public Nodo(String muerto, String titulo, int codigo){
        this.muerto = muerto;
        this.titulo = titulo;
        this.codigo = codigo;
        this.siguiente = null;
        this.anterior = null;
    }

    public String getMuerto() {
        return muerto;
    }

    public void setMuerto(String muerto) {
        this.muerto = muerto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

}
