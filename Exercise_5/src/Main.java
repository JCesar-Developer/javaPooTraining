import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int op;
        Scanner sc = new Scanner(System.in);

        Baraja baraja = new Baraja(40);
        System.out.println("\nSe ha creado una nueva Baraja de " + baraja.getNROCARTAS() + " cartas.");

        do {

            System.out.println("Escoge una opción:");
            System.out.println("");
            System.out.println("1. Barajar cartas.");
            System.out.println("2. Pedir una carta.");
            System.out.println("3. ¿Cuantas cartas quedan en la baraja?");
            System.out.println("4. Pedir varias cartas.");
            System.out.println("5. ¿Cuales han sido las cartas entregadas?");
            System.out.println("6. ¿Cuales son las cartas de la baraja?");
            System.out.println("7. Terminar juego de Cartas.");
            System.out.println("");
            System.out.print("ESCRIBE AQUÍ EL NÚMERO DE TU ELECCIÓN: ");
            op = sc.nextInt();

            switch (op) {
                //-----------------------------------------------------------------//
                case 1: //1. BARAJAR
                    baraja.barajar();
                    break;
                //-----------------------------------------------------------------//
                case 2: //2. ENTREGAR UNA CARTA
                    baraja.entregarUnaCarta();
                    break;
                //-----------------------------------------------------------------//
                case 3: //3. INDICAR CARTAS DISPONIBLES
                    System.out.println("Quedan: " + baraja.getTotalCartasEnBaraja()
                            + ", cartas en la baraja");
                    break;
                //-----------------------------------------------------------------//
                case 4: //4. ENTREGAR CARTAS
                    baraja.entregarCartas(baraja);
                    break;
                //-----------------------------------------------------------------//
                case 5: //5. MOSTRAR CARTAS DEL MONTÓN
                    System.out.println("");
                    System.out.println("Las cartas que han sido entregadas son: ");
                    baraja.mostrarCartasMonton();
                    break;
                //-----------------------------------------------------------------//
                case 6: //6. MOSTRAR CARTAS DE LA BARAJA
                    System.out.println("");
                    System.out.println("Las cartas aún disponibles en la baraja son: ");
                    baraja.mostrarCartasBaraja();
                    break;
                //-----------------------------------------------------------------//
                case 7:
                    break;
                //-----------------------------------------------------------------//
                default:
                    System.out.println("ERROR: Escribe una opción válida para proceder.");
                    break;
                //-----------------------------------------------------------------//
            }

            //PAUSA A ESPERA DE UN BOTÓN.
            System.out.println("\nPress Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();

        } while (baraja.getTotalCartasEnBaraja() > 0 && op != 7) ;

        if (baraja.getTotalCartasEnBaraja() == 0) System.out.println("¡TE HAS QUEDADO SIN CARTAS!");
        System.out.println("Gracias por jugar al juego de cartas de JULITO.");
        sc.close();

    }

}
