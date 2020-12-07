package Clases;

public class Titulos {

    private String[][] titulos;
    private int eliminados;

    public Titulos() {
        this.titulos = null;
    }

    public void Vaciar() {
        this.titulos = null;
    }

    public void CargarDesdePeliculas(Peliculas peliculas) {
        for (int i = 0; i < peliculas.getPeliculas().length; i++) {
            this.Añadir(peliculas.getPeliculas()[i][0], peliculas.getPeliculas()[i][2]);
        }
        this.eliminados = peliculas.getEliminados();
    }
    
    public void Añadir(String muerto, String nombre) {
        String[][] ArregloAuxiliar = this.InicializarArreglo();
        String[] datos = {muerto, nombre};
        ArregloAuxiliar = this.TransferirArregloOrdenado(ArregloAuxiliar, datos);
        this.titulos = ArregloAuxiliar;
    }

    public String[][] InicializarArreglo() {
        if (this.titulos == null) {
            return new String[1][2];
        } else {
            return new String[this.titulos.length + 1][2];
        }
    }

    public String[][] TransferirArregloOrdenado(String[][] ArregloAuxiliar, String[] datos) {
        if (this.titulos == null) {
            ArregloAuxiliar[0] = datos;
            return ArregloAuxiliar;
        } else {
            int j = 0;
            if (this.titulos[titulos.length - 1][1].compareTo(datos[1]) < 0) {
                for (int i = 0; i < this.titulos.length; i++) {
                    ArregloAuxiliar[i] = this.titulos[i];
                }
                ArregloAuxiliar[ArregloAuxiliar.length - 1] = datos;
            } else {
                boolean insertado = false;
                for (int i = 0; i < ArregloAuxiliar.length; i++) {
                    if (datos[1].compareTo(this.titulos[titulos.length - 1][1]) < 0 && !insertado) {
                        ArregloAuxiliar[i] = datos;
                        i++;
                        ArregloAuxiliar[i] = this.titulos[j];
                        j++;
                        insertado = true;
                    } else {
                        ArregloAuxiliar[i] = this.titulos[j];
                        j++;
                    }
                }
            }
            return ArregloAuxiliar;
        }
    }

    public void EliminacionLogica(int index) {
        this.titulos[index][0] = "*";
        this.eliminados++;
    }

    public void CompactadorReindexador() {
        if (eliminados == 0) {
            System.out.println("No hay elementos para compactar");
        } else if (this.titulos.length == eliminados) {
            this.Vaciar();
        } else {
            String[][] ArregloAuxiliar = new String[this.titulos.length - this.eliminados][5];
            int j = 0;
            for (int i = 0; i < this.titulos.length; i++) {
                if (!this.titulos[i][0].equals("*")) {
                    ArregloAuxiliar[j] = this.titulos[i];
                    j++;
                }
            }
            this.eliminados = 0;
            this.titulos = ArregloAuxiliar;
        }
    }

    public int BusquedaBinaria(String dato) {
        int buscado = BusquedaBinariaAuxiliar(this.titulos, 0, this.titulos.length - 1, dato);
        return buscado;
    }

    public int BusquedaBinariaAuxiliar(String[][] ArregloAuxiliar, int izq, int der, String dato) {
        int cen = (izq + der) / 2;
        if (izq + 1 != der) {
            if (ArregloAuxiliar[cen][1].equals(dato)) {
                return cen;
            } else {
                if (dato.compareTo(ArregloAuxiliar[cen][1]) < 0) {
                    cen = BusquedaBinariaAuxiliar(ArregloAuxiliar, izq, cen - 1, dato);
                } else {
                    cen = BusquedaBinariaAuxiliar(ArregloAuxiliar, cen + 1, der, dato);
                }
                return cen;
            }
        } else {
            if (ArregloAuxiliar[izq][1].equals(dato)) {
                return izq;
            } else if (ArregloAuxiliar[der][1].equals(dato)) {
                return der;
            } else {
                return -1;
            }
        }
    }

    public String[][] getTitulos() {
        return titulos;
    }

    public void setTitulos(String[][] titulos) {
        this.titulos = titulos;
    }

    public int getEliminados() {
        return eliminados;
    }

    public void setEliminados(int eliminados) {
        this.eliminados = eliminados;
    }

}
