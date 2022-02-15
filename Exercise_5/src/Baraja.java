import java.util.ArrayList;
import java.util.Scanner;

public class Baraja {

    //ATRIBUTOS
    private int NROCARTAS;
    private ArrayList<Carta> cartasBaraja;
    private ArrayList<Carta> cartasMonton;
    private int totalCartasEnBaraja = 0;

    //CONSTRUCTOR
    public Baraja(int NROCARTAS) {
        this.NROCARTAS = NROCARTAS;
        this.cartasBaraja = new ArrayList<>();
        this.cartasMonton = new ArrayList<>();

        //SE CREAN LAS CARTAS DENTRO DE LA BARAJA
        while (totalCartasEnBaraja < NROCARTAS){
            Carta nuevaCarta = new Carta();
            this.agregarNuevaCartaBaraja(nuevaCarta);
        }
    }

    //GETTERS Y SETTERS
    public int getNROCARTAS() {
        return NROCARTAS;
    }

    public ArrayList<Carta> getCartasBaraja() {
        return cartasBaraja;
    }

    public int getTotalCartasEnBaraja() {
        return totalCartasEnBaraja;
    }

    //MÉTODOS DE CLASE
    private void agregarNuevaCartaBaraja(Carta nuevaCarta){
        if ( comprobarCarta(nuevaCarta) ) {
            return;
        }
        if ( comprobarSiExiste(nuevaCarta) ) {
            return;
        }
        else {
            this.cartasBaraja.add( nuevaCarta );
            this.totalCartasEnBaraja++;
        }
    }

    private boolean comprobarCarta(Carta c){
        if (c.getNumero() == 8 || c.getNumero() == 9){
            return true;
        }
        return false;
    }

    private boolean comprobarSiExiste(Carta c){
        for (int i = 0; i < totalCartasEnBaraja; i++) {
            if ( cartasBaraja.get(i).getCodigo().equals(c.getCodigo()) ) {
                return true;
            }
        }
        return false;
    }

    public void barajar(){
        ArrayList<Carta> nuevaBaraja = new ArrayList<>();
        int index;

        try {
            while ( cartasBaraja.size() > 0 ) {

                index = Auxiliar.numRandomInt(0, cartasBaraja.size() - 1 );

                nuevaBaraja.add(this.cartasBaraja.get(index));
                this.cartasBaraja.remove(index);

            }

        } finally {

            this.cartasBaraja = nuevaBaraja;

        }

    }

    public void entregarUnaCarta() {
        if ( totalCartasEnBaraja > 0 ) {

            System.out.print("Se ha entregado la carta: ");
            System.out.println( cartasBaraja.get(0).getCodigo() );
            cartasMonton.add(cartasBaraja.get(0));
            cartasBaraja.remove(0);
            totalCartasEnBaraja--;

        } else {

            System.out.println("No quedan más cartas en la baraja");

        }
    }

    public void entregarCartas(Baraja baraja){
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuantas cartas deseas pedir? ");
        int cartasPedidas = sc.nextInt();

        if ( totalCartasEnBaraja - cartasPedidas >= 0 ) {

            while (cartasPedidas > 0) {
                baraja.entregarUnaCarta();
                cartasPedidas--;
            }

        } else {

            System.out.println("No existe está cantidad de cartas en la Baraja");

        }

    }

    public void mostrarCartasMonton(){
        for (Carta c: cartasMonton) System.out.println(c.getCodigo());
    }

    public void mostrarCartasBaraja(){
        for (Carta c: cartasBaraja) System.out.println(c.getCodigo());
    }

}