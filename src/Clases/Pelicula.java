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
public class Pelicula {
    private Codigo codigo;
    private Titulo titulo;
    private Num_Socio_Alq num_socio_alq;
    private Alquiler_Diario alquiler_d;
    private Eliminada eliminada;
    
    public Pelicula(Codigo codigo, Titulo titulo, Num_Socio_Alq num_socio_alq, Alquiler_Diario alquiler_d, Eliminada eliminada){
        this.codigo = codigo;
        this.titulo = titulo;
        this.num_socio_alq = num_socio_alq;
        this.alquiler_d = alquiler_d;
        this.eliminada = eliminada;

    }

    /**
     * @return the codigo
     */
    public Codigo getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Codigo codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the titulo
     */
    public Titulo getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the num_socio_alq
     */
    public Num_Socio_Alq getNum_socio_alq() {
        return num_socio_alq;
    }

    /**
     * @param num_socio_alq the num_socio_alq to set
     */
    public void setNum_socio_alq(Num_Socio_Alq num_socio_alq) {
        this.num_socio_alq = num_socio_alq;
    }

    /**
     * @return the alquiler_d
     */
    public Alquiler_Diario getAlquiler_d() {
        return alquiler_d;
    }

    /**
     * @param alquiler_d the alquiler_d to set
     */
    public void setAlquiler_d(Alquiler_Diario alquiler_d) {
        this.alquiler_d = alquiler_d;
    }

    /**
     * @return the eliminada
     */
    public Eliminada getEliminada() {
        return eliminada;
    }

    /**
     * @param eliminada the eliminada to set
     */
    public void setEliminada(Eliminada eliminada) {
        this.eliminada = eliminada;
    }
    
}
