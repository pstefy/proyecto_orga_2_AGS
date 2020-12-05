package Clases;

public class Peliculas {

    private String[][] peliculas;
    private int eliminados;
    
    public Peliculas() {
        this.peliculas = null;
        this.eliminados = 0;
    }

    public void Vaciar(){
        this.peliculas = null;
        this.eliminados = 0;
    }
    
    public void Añadir(String muerto, String codigo, String titulo, String alquiler, String socio) {
        String[][] ArregloAuxiliar = this.InicializarArreglo();
        ArregloAuxiliar = this.TransferirArreglo(ArregloAuxiliar);
        String[] data = {muerto, codigo, titulo, alquiler, socio};
        ArregloAuxiliar[ArregloAuxiliar.length - 1] = data;
        this.peliculas = ArregloAuxiliar;
    }

    public String[][] InicializarArreglo() {
        if (this.peliculas == null) {
            return new String[1][5];
        } else {
            return new String[this.peliculas.length + 1][5];
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

    public String Datos(int index) {
        String data = "Código: " + this.peliculas[index][1] + "\n"
                    + "Título: " + this.peliculas[index][2] + "\n"
                    + "Alquiler diario: " + this.peliculas[index][3] + "\n"
                    + "Número de socio: " + this.peliculas[index][4] + "\n";
        return data;
    }

    public void EliminacionLogica(int index){
        this.peliculas[index][0] = "*";
        this.eliminados++;
    }

    public void CompactadorReindexador(){
        if (eliminados == 0) {
            System.out.println("No hay elementos para compactar");
        }else if(this.peliculas.length == eliminados){
            this.Vaciar();
        }else{
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
