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
public class Eliminada {
    private boolean eliminada;
    private int rrn;
    
    public Eliminada(boolean eliminada, int rrn){
        this.eliminada = eliminada;
        this.rrn = rrn;

    }

    /**
     * @return the eliminada
     */
    public boolean isEliminada() {
        return eliminada;
    }

    /**
     * @param eliminada the eliminada to set
     */
    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
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
