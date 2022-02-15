import java.util.Arrays;

public class Espectador {

    private String nombres[] = {"Julio", "Cesar", "Gabriela", "Guadalupe", "Marco", "Alicia", "Ahinoam", "Beker"};
    private String apellidos[] = {"Asto", "Ortiz", "Moz", "Machuca", "Huaman", "Cruz"};

    private String  nombre;
    private int     edad;
    private double  dinero;

    public Espectador() {
        this.nombre = nombres[Auxiliar.numRandomInt(0, 7)] + " " + apellidos[Auxiliar.numRandomInt(0, 5)];
        this.edad = Auxiliar.numRandomInt(14, 45);
        this.dinero = Auxiliar.numRandomDouble(12, 25);
    }

    //GETTERS Y SETTERS
    public String[] getNombres() {
        return nombres;
    }

    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    public String[] getApellidos() {
        return apellidos;
    }

    public void setApellidos(String[] apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return  "Espectador: " + nombre +
                ", edad: " + edad +
                ", dinero: " + dinero;
    }
}
