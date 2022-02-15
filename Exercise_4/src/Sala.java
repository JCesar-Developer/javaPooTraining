public class Sala {

    //ATRIBUTOS
    private int filas;      //NÚMERO
    private int columnas;   //LETRA
    private String[][] nroAsiento;
    private String[][] espectador;
    private boolean[][] asientoOcupado;
    private Pelicula pelicula;
    private int aforo = 0;

    //CONSTRUCTOR
    public Sala (int filas, int columnas) {

        this.filas = filas;
        this.columnas = columnas;
        this.pelicula = new Pelicula();

        this.nroAsiento     = new String[filas][columnas];
        this.espectador     = new String[filas][columnas];
        this.asientoOcupado = new boolean[filas][columnas];

        for (int i = 0 ; i < filas ; i++){
            for (int j = 0 ; j < columnas ; j++){
                this.nroAsiento[i][j] = String.valueOf(filas-i) + Character.toString (65 + j);
                this.espectador[i][j] = "vacio";
                this.asientoOcupado[i][j] = false;
            }
        }
    }

    //GETTERS Y SETTERS
    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public String[][] getNroAsiento() {
        return nroAsiento;
    }

    public void setNroAsiento(String[][] nroAsiento) {
        this.nroAsiento = nroAsiento;
    }

    public boolean[][] getAsientoOcupado() {
        return asientoOcupado;
    }

    public void setAsientoOcupado(boolean[][] asientoOcupado) {
        this.asientoOcupado = asientoOcupado;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    //MÉTODOS DE CLASE
    public void mostrarSala(){
        System.out.println(this.pelicula);
        System.out.println("");
        this.mostrarAsientos();
    }

    private void mostrarAsientos() {
        for (int i = 0 ; i < filas ; i++){
            for (int j = 0 ; j < columnas ; j++){
                System.out.print(nroAsiento[i][j] + " | ");
            }
            System.out.println("");
        }
    }

    public void mostrarEstadoAsientos() {
        System.out.println("Total asientos: " + this.filas*this.columnas);
        System.out.println("Total espectadores: " + this.aforo);

        for (int i = 0 ; i < filas ; i++){
            for (int j = 0 ; j < columnas ; j++){
                System.out.print(nroAsiento[i][j] + ": " + asientoOcupado[i][j] + " | ");
            }
            System.out.println("");
        }
    }

    public void mostrarAsientosOcupados() {
        for (int i = 0 ; i < filas ; i++){
            for (int j = 0 ; j < columnas ; j++){
                System.out.print(nroAsiento[i][j] + ": " + espectador[i][j] + " | ");
            }
            System.out.println("");
        }
    }

    public void mostrarEspectadores(Espectador[] espectadores){
        int i = 0;
        while (i < espectadores.length){
            System.out.println(espectadores[i]);
            i++;
        }
    }

    public void ocuparAsientos(Espectador[] espectadores){
        int i = 0;
        while (i < espectadores.length && this.aforo < this.filas * this.columnas){

            if(espectadores[i].getEdad() >= pelicula.getEdadMinima() && espectadores[i].getDinero() >= pelicula.getPrecioEntrada()){
                this.ocuparAsiento(espectadores[i]);
                this.aforo++;
            }

            i++;

        }
    }

    private int filaEscogida;
    private int columnaEscogida;

    private void ocuparAsiento(Espectador espectador) {
        this.filaEscogida = Auxiliar.numRandomInt(1, this.filas);
        this.columnaEscogida = Auxiliar.numRandomInt(1, this.columnas);

        if(this.asientoOcupado[filaEscogida - 1][columnaEscogida - 1] == true){
            System.out.println("Este asiento ya está ocupado");
            this.ocuparAsiento(espectador);
        } else {
            this.asientoOcupado[filaEscogida - 1][columnaEscogida - 1] = true;
            this.espectador[filaEscogida - 1][columnaEscogida - 1] = espectador.getNombre();
            System.out.println(nroAsiento[filaEscogida - 1][columnaEscogida - 1]+ ": " + espectador.getNombre());
        }
    }

}
