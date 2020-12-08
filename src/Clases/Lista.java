package Clases;

public class Lista {

    private Nodo first;
    private Nodo last;

    public Lista() {
        this.first = null;
        this.last = null;
    }
    
    public void Vaciar(){
        this.first = null;
        this.last = null;
    }
    
    public void Añadir(String muerto, String titulo, int codigo){
        Nodo nuevo = new Nodo(muerto,titulo,codigo);
        if (first == null) {
            this.first = this.last = nuevo;
        } else{
            this.last.setSiguiente(nuevo);
            nuevo.setAnterior(last);
            this.last = nuevo;
        }
    }
    
    public Nodo Buscar(String dato){
        Nodo aux = this.first;
        while(aux != null){
            if (aux.getTitulo().equals(dato)) {
                break;
            }
            aux = aux.getSiguiente();
        }
        return aux;
    }
    
    public void EliminacionLogica(String titulo){
        Nodo nodo = this.Buscar(titulo);
        nodo.setMuerto("*");
    }
    
    public void CompactadorReindexador(){
        Nodo aux = this.first;
        while(aux != null){
            if (this.first == aux && this.first.getMuerto().equals("*")) {
                this.first = this.first.getSiguiente();
                this.first.setAnterior(null);
            }else if (this.last == aux){
                this.last = this.last.getAnterior();
                this.last.setSiguiente(null);
            }else{
                aux.getAnterior().setSiguiente(aux.getSiguiente());
                aux.getSiguiente().setAnterior(aux.getAnterior());
            }
            aux = aux.getSiguiente();
        }
    }

    public Nodo getFirst() {
        return first;
    }

    public void setFirst(Nodo first) {
        this.first = first;
    }

    public Nodo getLast() {
        return last;
    }

    public void setLast(Nodo last) {
        this.last = last;
    }
    
}
