/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Stefani
 */
public class Titulo {
    private String titulo;
    private int rrn;
    
    public Titulo(String titulo, int rrn){
        this.titulo = titulo;
        this.rrn = rrn;

    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the rrn
     */
    public int getRrn() {
        return rrn;
    }

    /**
     * @param rrn the rrn to set
     */
    public void setRrn(int rrn) {
        this.rrn = rrn;
    }
}
