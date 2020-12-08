package Clases;

public class Socios {

    private String[][] socios;
    private int eliminados;

    public Socios() {
        this.socios = null;
    }

    public void Vaciar() {
        this.socios = null;
    }

    public void Añadir(String numero, String nombre) {
        String[][] ArregloAuxiliar = this.InicializarArreglo();
        String[] datos = {"",numero, nombre};
        ArregloAuxiliar = this.TransferirArregloOrdenado(ArregloAuxiliar, datos);
        this.socios = ArregloAuxiliar;
    }

    public String[][] InicializarArreglo() {
        if (this.socios == null) {
            return new String[1][3];
        } else {
            return new String[this.socios.length + 1][3];
        }
    }

    public String[][] TransferirArregloOrdenado(String[][] ArregloAuxiliar, String[] datos) {
        if (this.socios == null) {
            ArregloAuxiliar[0] = datos;
            return ArregloAuxiliar;
        } else {
            int j = 0;
            if (Integer.parseInt(this.socios[socios.length - 1][1]) < Integer.parseInt(datos[1])) {
                for (int i = 0; i < this.socios.length; i++) {
                    ArregloAuxiliar[i] = this.socios[i];
                }
                ArregloAuxiliar[ArregloAuxiliar.length - 1] = datos;
            } else {
                boolean insertado = false;
                for (int i = 0; i < ArregloAuxiliar.length; i++) {
                    if (Integer.parseInt(datos[1]) < Integer.parseInt(this.socios[j][1]) && !insertado) {
                        ArregloAuxiliar[i] = datos;
                        i++;
                        ArregloAuxiliar[i] = this.socios[j];
                        j++;
                        insertado = true;
                    } else {
                        ArregloAuxiliar[i] = this.socios[j];
                        j++;
                    }
                }
            }
            return ArregloAuxiliar;
        }
    }

    public void EliminacionLogica(int index) {
        this.socios[index][0] = "*";
        this.eliminados++;
    }

    public void CompactadorReindexador() {
        if (eliminados == 0) {
            System.out.println("No hay elementos para compactar");
        } else if (this.socios.length == eliminados) {
            this.Vaciar();
        } else {
            String[][] ArregloAuxiliar = new String[this.socios.length - this.eliminados][5];
            int j = 0;
            for (int i = 0; i < this.socios.length; i++) {
                if (!this.socios[i][0].equals("*")) {
                    ArregloAuxiliar[j] = this.socios[i];
                    j++;
                }
            }
            this.eliminados = 0;
            this.socios = ArregloAuxiliar;
        }
    }

    public int BusquedaBinaria(int dato) {
        int buscado = BusquedaBinariaAuxiliar(this.socios, 0, this.socios.length - 1, dato);
        return buscado;
    }

    public int BusquedaBinariaAuxiliar(String[][] ArregloAuxiliar, int izq, int der, int dato) {
        int cen = (izq + der) / 2;
        if (izq + 1 != der) {
            if (Integer.parseInt(ArregloAuxiliar[cen][1]) == dato) {
                return cen;
            } else {
                if (Integer.parseInt(ArregloAuxiliar[cen][1]) > dato) {
                    cen = BusquedaBinariaAuxiliar(ArregloAuxiliar, izq, cen - 1, dato);
                } else {
                    cen = BusquedaBinariaAuxiliar(ArregloAuxiliar, cen + 1, der, dato);
                }
                return cen;
            }
        } else {
            if (Integer.parseInt(ArregloAuxiliar[izq][1]) == dato) {
                return izq;
            } else if (Integer.parseInt(ArregloAuxiliar[der][1]) == dato) {
                return der;
            } else {
                return -1;
            }
        }
    }

    public String[][] getSocios() {
        return socios;
    }

    public void setSocios(String[][] socios) {
        this.socios = socios;
    }

    public int getEliminados() {
        return eliminados;
    }

    public void setEliminados(int eliminados) {
        this.eliminados = eliminados;
    }
    
}
