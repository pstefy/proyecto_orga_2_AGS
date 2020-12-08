package Clases;

public class Palabras {

    private Palabra[] palabras;
    private int eliminados;

    public Palabras() {
        this.palabras = null;
        this.eliminados = 0;
    }

    public void Vaciar() {
        this.palabras = null;
        this.eliminados = 0;
    }

    public void CargarDesdePeliculas(Peliculas peliculas) {
        for (int i = 0; i < peliculas.getPeliculas().length; i++) {
            this.Añadir(peliculas.getPeliculas()[i][0], peliculas.getPeliculas()[i][2], Integer.parseInt(peliculas.getPeliculas()[i][1]));
        }
    }

    public void Añadir(String muerto, String titulo, int codigo) {
        String[] palabras = titulo.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            int posicion = -1;
            if (this.palabras != null) {
                posicion = this.BusquedaBinaria(palabras[i]);
            }
            if (posicion == -1) {
                Palabra[] ArregloAuxiliar = this.InicializarArreglo();
                Palabra datos = new Palabra(muerto, palabras[i], titulo, codigo);
                ArregloAuxiliar = this.TransferirArregloOrdenado(ArregloAuxiliar, datos);
                this.palabras = ArregloAuxiliar;
            } else {
                this.palabras[posicion].getLista().Añadir(muerto, titulo, codigo);
            }
        }
    }

    public Palabra[] InicializarArreglo() {
        if (this.palabras == null) {
            return new Palabra[1];
        } else {
            return new Palabra[this.palabras.length + 1];
        }
    }

    public Palabra[] TransferirArregloOrdenado(Palabra[] ArregloAuxiliar, Palabra datos) {
        if (this.palabras == null) {
            ArregloAuxiliar[0] = datos;
            return ArregloAuxiliar;
        } else {
            int j = 0;
            boolean mayor = true;
            if (this.palabras[palabras.length - 1].getPalabra().length() > datos.getPalabra().length()) {
                for (int i = 0; i < datos.getPalabra().length(); i++) {
                    if ((int) datos.getPalabra().toUpperCase().charAt(i) > (int) this.palabras[palabras.length - 1].getPalabra().toUpperCase().charAt(i)) {
                        mayor = true;
                        break;
                    } else if ((int) datos.getPalabra().toUpperCase().charAt(i) < (int) this.palabras[palabras.length - 1].getPalabra().toUpperCase().charAt(i)) {
                        mayor = false;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < this.palabras[palabras.length - 1].getPalabra().length(); i++) {
                    if ((int) datos.getPalabra().toUpperCase().charAt(i) > (int) this.palabras[palabras.length - 1].getPalabra().toUpperCase().charAt(i)) {
                        mayor = true;
                        break;
                    } else if ((int) datos.getPalabra().toUpperCase().charAt(i) < (int) this.palabras[palabras.length - 1].getPalabra().toUpperCase().charAt(i)) {
                        mayor = false;
                        break;
                    }
                }
            }
            if (mayor) {
                for (int i = 0; i < this.palabras.length; i++) {
                    ArregloAuxiliar[i] = this.palabras[i];
                }
                ArregloAuxiliar[ArregloAuxiliar.length - 1] = datos;
            } else {
                boolean insertado = false;
                for (int i = 0; i < ArregloAuxiliar.length; i++) {
                    boolean menor = false;
                    if (this.palabras[j].getPalabra().length() > datos.getPalabra().length() && !insertado) {
                        for (int k = 0; k < datos.getPalabra().length(); k++) {
                            if ((int) datos.getPalabra().toUpperCase().charAt(k) > (int) this.palabras[j].getPalabra().toUpperCase().charAt(k)) {
                                menor = false;
                                break;
                            } else if ((int) datos.getPalabra().toUpperCase().charAt(k) < (int) this.palabras[j].getPalabra().charAt(k)) {
                                menor = true;
                                break;
                            }
                        }
                    } else if (!insertado) {
                        for (int k = 0; k < this.palabras[palabras.length - 1].getPalabra().length(); k++) {
                            if ((int) datos.getPalabra().toUpperCase().charAt(k) > (int) this.palabras[j].getPalabra().toUpperCase().charAt(k)) {
                                menor = false;
                                break;
                            } else if ((int) datos.getPalabra().toUpperCase().charAt(k) < (int) this.palabras[j].getPalabra().charAt(k)) {
                                menor = true;
                                break;
                            }
                        }
                    }
                    if (menor && !insertado) {
                        ArregloAuxiliar[i] = datos;
                        i++;
                        ArregloAuxiliar[i] = this.palabras[j];
                        j++;
                        insertado = true;
                    } else {
                        ArregloAuxiliar[i] = this.palabras[j];
                        j++;
                    }
                }
            }
            return ArregloAuxiliar;
        }
    }

    public void EliminacionLogica(String titulo) {
        String[] palabras = titulo.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            int posicion = this.BusquedaBinaria(palabras[i]);
            this.palabras[posicion].getLista().EliminacionLogica(titulo);
        }
    }

    public void CompactadorReindexador() {
        for (int i = 0; i < this.palabras.length; i++) {
            this.palabras[i].getLista().CompactadorReindexador();
            if (this.palabras[i].getLista().getFirst() == null) {
                this.palabras[i].setEliminado("*");
                this.eliminados++;
            }
        }
        if (eliminados == 0) {
            System.out.println("No hay elementos para compactar");
        } else if (this.palabras.length == eliminados) {
            this.Vaciar();
        } else {
            Palabra[] ArregloAuxiliar = new Palabra[this.palabras.length - this.eliminados];
            int j = 0;
            for (int i = 0; i < this.palabras.length; i++) {
                if (!this.palabras[i].getEliminado().equals("*")) {
                    ArregloAuxiliar[j] = this.palabras[i];
                    j++;
                }
            }
            this.eliminados = 0;
            this.palabras = ArregloAuxiliar;
        }
    }

    public int BusquedaBinaria(String dato) {
        int buscado = BusquedaBinariaAuxiliar(this.palabras, 0, this.palabras.length - 1, dato);
        return buscado;
    }

    public int BusquedaBinariaAuxiliar(Palabra[] ArregloAuxiliar, int izq, int der, String dato) {
        int cen = (izq + der) / 2;
        if (izq + 1 != der && izq != der) {
            if (ArregloAuxiliar[cen].getPalabra().toUpperCase().equals(dato.toUpperCase())) {
                return cen;
            } else {
                boolean mayor = true;
                if (this.palabras[cen].getPalabra().length() > dato.length()) {
                    for (int i = 0; i < dato.length(); i++) {
                        if ((int) dato.toUpperCase().charAt(i) > (int) this.palabras[cen].getPalabra().toUpperCase().charAt(i)) {
                            mayor = true;
                            break;
                        } else if ((int) dato.toUpperCase().charAt(i) < (int) this.palabras[cen].getPalabra().toUpperCase().charAt(i)) {
                            mayor = false;
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < this.palabras[cen].getPalabra().length(); i++) {
                        if ((int) dato.toUpperCase().charAt(i) > (int) this.palabras[cen].getPalabra().toUpperCase().charAt(i)) {
                            mayor = true;
                            break;
                        } else if ((int) dato.toUpperCase().charAt(i) < (int) this.palabras[cen].getPalabra().toUpperCase().charAt(i)) {
                            mayor = false;
                            break;
                        }
                    }
                }
                if (!mayor) {
                    cen = BusquedaBinariaAuxiliar(ArregloAuxiliar, izq, cen - 1, dato);
                } else {
                    cen = BusquedaBinariaAuxiliar(ArregloAuxiliar, cen + 1, der, dato);
                }
                return cen;
            }
        } else {
            if (ArregloAuxiliar[izq].getPalabra().equals(dato)) {
                return izq;
            } else if (ArregloAuxiliar[der].getPalabra().equals(dato)) {
                return der;
            } else {
                return -1;
            }
        }
    }

    public Palabra[] getPalabras() {
        return palabras;
    }

    public void setPalabras(Palabra[] palabras) {
        this.palabras = palabras;
    }

    public int getEliminados() {
        return eliminados;
    }

    public void setEliminados(int eliminados) {
        this.eliminados = eliminados;
    }
}
