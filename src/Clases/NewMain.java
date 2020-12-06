
package Clases;

import static Ventanas.Principal.peliculas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class NewMain {

    public static void main(String[] args) {
        
        Peliculas pelicula = new Peliculas();
        pelicula.Añadir("","11", "Titanic", "5");
        pelicula.Añadir("","2", "KKK", "3");
        pelicula.Añadir("","40", "Origen", "7");
        pelicula.Añadir("","886", "End Game", "20");
        pelicula.Añadir("","709", "Aquaman", "10");
        Codigos codigo = new Codigos();
        codigo.CargarDesdePeliculas(pelicula);
        System.out.println(pelicula.Alquilar(0, 3, 334));
        System.out.println(pelicula.Alquilar(2, 3, 8));
        System.out.println(pelicula.Alquilar(0, 3, 34));
        System.out.println(pelicula.Devolver(0, 5));
        System.out.println(pelicula.DatoPelicula(3));
        System.out.println(pelicula.DatosPeliculas());
        
        
    }
    
}
