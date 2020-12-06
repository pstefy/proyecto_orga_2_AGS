package Clases;

public class Peliculas {

    private String[][] peliculas;
    private int eliminados;

    public Peliculas() {
        this.peliculas = null;
        this.eliminados = 0;
    }

    public void Vaciar() {
        this.peliculas = null;
        this.eliminados = 0;
    }

    public void Añadir(String muerto, String codigo, String titulo, String alquiler) {
        String[][] ArregloAuxiliar = this.InicializarArreglo();
        ArregloAuxiliar = this.TransferirArreglo(ArregloAuxiliar);
        String[] data = {muerto, codigo, titulo, alquiler, "0", "Disponible"};
        ArregloAuxiliar[ArregloAuxiliar.length - 1] = data;
        this.peliculas = ArregloAuxiliar;
    }
    
    public void Añadir_2(String muerto, String codigo, String titulo, String alquiler, String dias, String disponibilidad) {
        String[][] ArregloAuxiliar = this.InicializarArreglo();
        ArregloAuxiliar = this.TransferirArreglo(ArregloAuxiliar);
        String[] data = {muerto, codigo, titulo, alquiler, dias, disponibilidad};
        ArregloAuxiliar[ArregloAuxiliar.length - 1] = data;
        this.peliculas = ArregloAuxiliar;
    }

    public String[][] InicializarArreglo() {
        if (this.peliculas == null) {
            return new String[1][6];
        } else {
            return new String[this.peliculas.length + 1][6];
        }
    }

    public String[][] TransferirArreglo(String[][] ArregloAuxiliar) {
        if (this.peliculas == null) {
            return ArregloAuxiliar;
        } else {
            for (int i = 0; i < this.peliculas.length; i++) {
                ArregloAuxiliar[i] = this.peliculas[i];
            }
            return ArregloAuxiliar;
        }
    }

    public String Alquilar(int index, int dias, int socio) {
        String alquilar;
        if (this.peliculas[index][5].equals("Disponible")) {
            this.peliculas[index][4] = Integer.toString(dias);
            this.peliculas[index][5] = Integer.toString(socio);
            int precio = dias*Integer.parseInt(this.peliculas[index][3]);
            alquilar = "Película alquilada correctamente.\nPrecio total: " + precio + "$";
        } else{
            alquilar = "La película ya fue alquilada por otro socio";
        }
        return alquilar;
    }

    public String Devolver(int index, int retraso) {
        String devolver = "";
        if (this.peliculas[index][5].equals("Disponible")) {
            devolver = "La película no ha sido alquilada";
        }else{
            int costo = Integer.parseInt(this.peliculas[index][3]) * Integer.parseInt(this.peliculas[index][4]);
            retraso = 2 * Integer.parseInt(this.peliculas[index][3]) * retraso;
            devolver = "El costo de alquiler de la película es " + costo + "$\n"
                    + "El extra por retraso es " + retraso + "$";
            this.peliculas[index][5] = "Disponible";
            this.peliculas[index][4] = "0";
        }
        return devolver;
    }

    public void EliminacionLogica(int index) {
        this.peliculas[index][0] = "*";
        this.eliminados++;
    }

    public void CompactadorReindexador() {
        if (eliminados == 0) {
            System.out.println("No hay elementos para compactar");
        } else if (this.peliculas.length == eliminados) {
            this.Vaciar();
        } else {
            String[][] ArregloAuxiliar = new String[this.peliculas.length - this.eliminados][5];
            int j = 0;
            for (int i = 0; i < this.peliculas.length; i++) {
                if (!this.peliculas[i][0].equals("*")) {
                    ArregloAuxiliar[j] = this.peliculas[i];
                    j++;
                }
            }
            this.eliminados = 0;
            this.peliculas = ArregloAuxiliar;
        }
    }

    public String DatoPelicula(int index) {
        String data;
        if (this.peliculas[index][0].equals("*")) {
            data = "Búsqueda fallida";
        } else {
            data = "Código: " + this.peliculas[index][1] + "\n"
                    + "Título: " + this.peliculas[index][2] + "\n"
                    + "Alquiler diario: " + this.peliculas[index][3] + "\n"
                    + "Días de alquiler: " + this.peliculas[index][4] + "\n"
                    + "Número de socio: " + this.peliculas[index][5] + "\n";
        }
        return data;
    }

    public String DatosPeliculas() {
        String data = "";
        int j = 1;
        for (int i = 0; i < this.peliculas.length; i++) {
            if (!this.peliculas[i][0].equals("*")) {
                if (data.equals("")) {
                    data = "-> Película " + j + " <-\n"
                            + "Código: " + this.peliculas[i][1] + "\n"
                            + "Título: " + this.peliculas[i][2] + "\n"
                            + "Alquiler diario: " + this.peliculas[i][3] + "\n"
                            + "Días de alquiler: " + this.peliculas[i][4] + "\n"
                            + "Número de socio: " + this.peliculas[i][5] + "\n";
                    j++;
                } else {
                    data += "\n-> Película " + j + " <-\n"
                            + "Código: " + this.peliculas[i][1] + "\n"
                            + "Título: " + this.peliculas[i][2] + "\n"
                            + "Alquiler diario: " + this.peliculas[i][3] + "\n"
                            + "Días de alquiler: " + this.peliculas[i][4] + "\n"
                            + "Número de socio: " + this.peliculas[i][5] + "\n";
                    j++;
                }
            }
        }
        return data;
    }

    public String[][] getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(String[][] peliculas) {
        this.peliculas = peliculas;
    }

    public int getEliminados() {
        return eliminados;
    }

    public void setEliminados(int eliminados) {
        this.eliminados = eliminados;
    }

}
