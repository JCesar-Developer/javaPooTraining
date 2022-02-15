import java.util.Arrays;

public class Pelicula {

    private String[] Titulos = { "El señor de los anillos", "Harry Potter", "Juego de Tronos", "El león la bruja y el ropero" };
    private String[] Directores = { "Guillermo del Toro", "Steaven Spilvergh", "Quentin Tarantino", "Frank for Capola" };

    private String  titulo;
    private double  precioEntrada;
    private int     minutos;
    private int     edadMinima;
    private String  director;

    public Pelicula() {
        this.titulo = Titulos[Auxiliar.numRandomInt(0, 3)];
        this.precioEntrada = Auxiliar.numRandomDouble(14, 21);
        this.minutos = Auxiliar.numRandomInt(180, 240);
        this.edadMinima = Auxiliar.numRandomInt(14,18);
        this.director = Directores[Auxiliar.numRandomInt(0, 3)];
    }

    //GETTERS Y SETTERS
    public String[] getTitulos() {
        return Titulos;
    }

    public void setTitulos(String[] titulos) {
        Titulos = titulos;
    }

    public String[] getDirectores() {
        return Directores;
    }

    public void setDirectores(String[] directores) {
        Directores = directores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Pelicula:" +
                "\n- Titulo = " + titulo + "," +
                "\n- Precio Entrada = " + precioEntrada + " euros,"+
                "\n- Minutos = " + minutos + " minutos," +
                "\n- Edad Minima = " + edadMinima + " años," +
                "\n- Director = " + director + ".";
    }

}
