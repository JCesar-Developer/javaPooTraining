class Liga {

    public static void main(String[] args) {

        Jornada j1 = new Jornada();
        Amigo a1 = new Amigo(5);
        a1.hacerApuesta(j1);
        j1.jugarPartidos();

    }
}

class Amigo {
    private String nombres[] = {"Amigo1", "Amigo2", "Amigo3", "Amigo4", "Amigo5"};
    private String nombre;
    private int dineroBase;
    private int apuestasGanadas;

    //CONSTRUCTOR
    public Amigo(int dineroBase) {
        this.nombre = nombres[Auxiliar.numRandomInt(0, 4)];
        this.dineroBase = dineroBase;
        this.apuestasGanadas = 0;
    }

    //GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    //CONSTRUCTOR
    public void hacerApuesta(Jornada jornada) {
        int nroPartidos = jornada.getPartidos().length;

        while ( nroPartidos > 0 ) {

            Equipo equipoEscogido = jornada.getPartidos()[nroPartidos - 1].getEquipoAleatorio();
            System.out.println("El amigo: " + this.nombre + ", ha apostado por: " + equipoEscogido.getEquipo());
            nroPartidos--;

        }

    }

}

class Jornada {
    private Partido partidos[] = new Partido[4];

    //CONSTRUCTOR
    public Jornada() {

        for ( int i = 0; i < partidos.length ; i++){
            partidos[i] = new Partido();
            partidos[i].mostrarMatch();
        }

    }

    //GETTERS Y SETTERS
    public Partido[] getPartidos() {
        return partidos;
    }

    //MÉTODOS DE CLASE
    public void jugarPartidos() {
        for (Partido p : partidos){
            System.out.println("");
            p.jugarPartido();
            p.mostrarEquipoGanador();
        }
    }


}

class Partido {
    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo equipoGanador;

    //CONSTRUCTOR
    public Partido() {

        this.equipo1 = new Equipo();
        this.escogerEquipo2(equipo1);

    }

    //GETTERS Y SETTERS
    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public Equipo getEquipoAleatorio() {
        int aux = Auxiliar.numRandomInt(0,1);

        if ( aux == 0 ) return this.getEquipo1();
        if ( aux == 1 ) return this.getEquipo2();
        return null;

    }

    //MÉTODOS DE CLASE
    private void escogerEquipo2(Equipo equipo1) {

        Equipo equipoContrincante = new Equipo();
        if( !equipo1.getEquipo().equals(equipoContrincante.getEquipo()) ){
            this.equipo2 = equipoContrincante;
        } else {
            this.escogerEquipo2(equipo1);
        }

    }

    public void mostrarMatch() {
        System.out.println("Equipo: " + equipo1.getEquipo() + " VS Equipo: " + equipo2.getEquipo());
    }

    public void jugarPartido() {

        int golesEquipo1 = equipo1.marcarGoles();
        int golesEquipo2 = equipo2.marcarGoles();

        System.out.println(equipo1.getEquipo() +", marco: " + golesEquipo1 + " goles.");
        System.out.println(equipo2.getEquipo() +", marco: " + golesEquipo2 + " goles.");

        if ( golesEquipo1 > golesEquipo2 ) this.equipoGanador = equipo1;
        if ( golesEquipo2 > golesEquipo1 ) this.equipoGanador = equipo2;
        if ( golesEquipo1 == golesEquipo2 ) this.equipoGanador = null;

    }

    public void mostrarEquipoGanador() {

        Equipo mostrarGanador = this.equipoGanador;

        if ( mostrarGanador != null ) System.out.println( "El equipo ganador es: " + mostrarGanador.getEquipo() );
        else System.out.println("¡Empate!");

    }

}

class Equipo {

    private String equipos[] = {"Team A","Team B","Team C","Team D", "¡Empate!"};
    private String equipo;
    private int goles;

    //CONSTRUCTOR
    public Equipo() {
        this.equipo = this.equipos[Auxiliar.numRandomInt(0, 3)];
    }

    //GETTER Y SETTER
    public String getEquipo() {
        return equipo;
    }

    public int getGoles() {
        return goles;
    }

    //MÉTODOS DE CLASE
    public int marcarGoles(){
        this.goles = Auxiliar.numRandomInt(0, 10);
        return goles;
    }

}

class Auxiliar {

    public static int numRandomInt(int min, int max){
        return (int) (Math.random()*(max - min + 1)) + min;
    }

}
