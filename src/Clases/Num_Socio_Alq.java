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
public class Num_Socio_Alq {
    private int num_socio_alq;
    private int rrn;
    
    public Num_Socio_Alq(int num_socio_alq, int rrn){
        this.num_socio_alq = num_socio_alq;
        this.rrn = rrn;

    }

    /**
     * @return the num_socio_alq
     */
    public int getNum_socio_alq() {
        return num_socio_alq;
    }

    /**
     * @param num_socio_alq the num_socio_alq to set
     */
    public void setNum_socio_alq(int num_socio_alq) {
        this.num_socio_alq = num_socio_alq;
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
