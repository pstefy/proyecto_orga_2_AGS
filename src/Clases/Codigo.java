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
public class Codigo {
    private int codigo;
    private int rrn;
    
    public Codigo(int codigo, int rrn){
        this.codigo = codigo;
        this.rrn = rrn;

    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
