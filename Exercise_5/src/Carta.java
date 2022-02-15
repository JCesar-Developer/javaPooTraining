public class Carta {

    //ATRIBUTOS
    private String[] PALO = {"Espadas", "Bastos", "Oros", "Copas"};
    private String codigo;
    private String palo;
    private int numero;

    //CONSTRUCTOR
    public Carta() {
        this.palo = PALO[Auxiliar.numRandomInt(0,3)];
        this.numero = Auxiliar.numRandomInt(1,12);
        this.codigo = numero + " de " + palo;
    }

    //GETTERS Y SETTERS
    public int getNumero() {
        return numero;
    }

    public String getCodigo() {
        return codigo;
    }
}
