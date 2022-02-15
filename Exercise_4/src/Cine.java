public class Cine {

    private int nroSalas;

    public static void main(String[] args) {

        //CREAMOS SALA
        System.out.println("\nSALA 1: ----------------------------------------");
        Sala sala1 = new Sala(8, 9);
        sala1.mostrarSala();

        //CREAMOS Y MOSTRAMOS LOS ESPECTADORES
        System.out.println("");
        int nroEspectadores = 100;
        Espectador[] espectadores = new Espectador[nroEspectadores];

        int i = 0;
        while (i < nroEspectadores){
            Espectador espectador = new Espectador();
            espectadores[i] = espectador;
            i++;
        }

        sala1.mostrarEspectadores(espectadores);

        //OCUPAMOS LOS ASIENTOS SI SE PUEDE
        sala1.ocuparAsientos(espectadores);
        System.out.println("");
        sala1.mostrarEstadoAsientos();
        System.out.println("");
        sala1.mostrarAsientosOcupados();


    }
}


