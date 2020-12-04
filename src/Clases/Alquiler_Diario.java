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
public class Alquiler_Diario {
    private int alquiler_d;
    private int rrn;
    
    public Alquiler_Diario(int alquiler_d, int rrn){
        this.alquiler_d = alquiler_d;
        this.rrn = rrn;

    }

    /**
     * @return the alquiler_d
     */
    public int getAlquiler_d() {
        return alquiler_d;
    }

    /**
     * @param alquiler_d the alquiler_d to set
     */
    public void setAlquiler_d(int alquiler_d) {
        this.alquiler_d = alquiler_d;
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
