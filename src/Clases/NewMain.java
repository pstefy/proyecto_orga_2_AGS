
package Clases;

public class NewMain {

    public static void main(String[] args) {
        
        Peliculas pelicula = new Peliculas();
        pelicula.Añadir("","11", "Titanic", "5", "506");
        pelicula.Añadir("","40", "Origen", "7", "69");
        pelicula.Añadir("","709", "Aquaman", "10", "99");
        pelicula.Añadir("","886", "End Game", "20", "69");
        pelicula.Añadir("","1", "KKK", "3", "107");
        pelicula.EliminacionLogica(0);
        pelicula.EliminacionLogica(2);
        Codigos codigo = new Codigos();
        codigo.CargarDesdePeliculas(pelicula);
        System.out.println("funciona");
    }
    
}
