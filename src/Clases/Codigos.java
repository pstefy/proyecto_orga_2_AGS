package Clases;

public class Codigos {

    private String[][] codigos;
    private int eliminados;

    public Codigos() {
        this.codigos = null;
        this.eliminados = 0;
    }

    public void Vaciar() {
        this.codigos = null;
        this.eliminados = 0;
    }

    public void CargarDesdePeliculas(Peliculas peliculas) {
        for (int i = 0; i < peliculas.getPeliculas().length; i++) {
            this.Añadir(peliculas.getPeliculas()[i][0], peliculas.getPeliculas()[i][1], Integer.toString(i));
        }
        this.eliminados = peliculas.getEliminados();
    }

    public void Añadir(String muerto, String codigo, String index) {
        String[][] ArregloAuxiliar = this.InicializarArreglo();
        String[] datos = {muerto, codigo, index};
        ArregloAuxiliar = this.TransferirArregloOrdenado(ArregloAuxiliar, datos);
        this.codigos = ArregloAuxiliar;
    }

    public String[][] InicializarArreglo() {
        if (this.codigos == null) {
            return new String[1][3];
        } else {
            return new String[this.codigos.length + 1][3];
        }
    }

    public String[][] TransferirArregloOrdenado(String[][] ArregloAuxiliar, String[] datos) {
        if (this.codigos == null) {
            ArregloAuxiliar[0] = datos;
            return ArregloAuxiliar;
        } else {
            int j = 0;
            if (Integer.parseInt(this.codigos[codigos.length - 1][1]) < Integer.parseInt(datos[1])) {
                for (int i = 0; i < this.codigos.length; i++) {
                    ArregloAuxiliar[i] = this.codigos[i];
                }
                ArregloAuxiliar[ArregloAuxiliar.length - 1] = datos;
            } else {
                boolean insertado = false;
                for (int i = 0; i < ArregloAuxiliar.length; i++) {
                    if (Integer.parseInt(datos[1]) < Integer.parseInt(this.codigos[j][1]) && !insertado) {
                        ArregloAuxiliar[i] = datos;
                        i++;
                        ArregloAuxiliar[i] = this.codigos[j];
                        j++;
                        insertado = true;
                    } else {
                        ArregloAuxiliar[i] = this.codigos[j];
                        j++;
                    }
                }
            }
            return ArregloAuxiliar;
        }
    }

    public void EliminacionLogica(int index) {
        this.codigos[index][0] = "*";
        this.eliminados++;
    }

    public void CompactadorReindexador() {
        if (eliminados == 0) {
            System.out.println("No hay elementos para compactar");
        } else if (this.codigos.length == eliminados) {
            this.Vaciar();
        } else {
            String[][] ArregloAuxiliar = new String[this.codigos.length - this.eliminados][5];
            int j = 0;
            for (int i = 0; i < this.codigos.length; i++) {
                if (!this.codigos[i][0].equals("*")) {
                    ArregloAuxiliar[j] = this.codigos[i];
                    j++;
                }
            }
            this.eliminados = 0;
            this.codigos = ArregloAuxiliar;
        }
    }

    public int BusquedaBinaria   (int dato) {
        int buscado = BusquedaBinariaAuxiliar(this.codigos, 0, this.codigos.length - 1, dato);
        return buscado;
    }

    public int BusquedaBinariaAuxiliar(String[][] ArregloAuxiliar, int izq, int der, int dato) {
        int cen = (izq + der) / 2;
        if (izq + 1 != der) {
            if (Integer.parseInt(ArregloAuxiliar[cen][1]) == dato) {
                return cen;
            } else {
                if (Integer.parseInt(ArregloAuxiliar[cen][1]) > dato) {
                    cen = BusquedaBinariaAuxiliar(ArregloAuxiliar, izq, cen-1, dato);
                } else {
                    cen = BusquedaBinariaAuxiliar(ArregloAuxiliar, cen+1, der, dato);
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

    public String[][] getCodigos() {
        return codigos;
    }

    public void setCodigos(String[][] codigos) {
        this.codigos = codigos;
    }

    public int getEliminados() {
        return eliminados;
    }

    public void setEliminados(int eliminados) {
        this.eliminados = eliminados;
    }
    
}
