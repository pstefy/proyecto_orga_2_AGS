package Clases;

public class Palabra {

    private String eliminado;
    private String palabra;
    private Lista lista;

    public Palabra(String muerto, String palabra, String titulo, int codigo) {
        this.eliminado = "";
        this.palabra = palabra;
        this.lista = new Lista();
        lista.Añadir(muerto, titulo, codigo);
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }
    
}
