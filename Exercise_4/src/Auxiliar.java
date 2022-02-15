public class Auxiliar {

    public static int numRandomInt(int min, int max){
        return (int) (Math.random()*(max - min + 1)) + min;
    }

    public static double numRandomDouble(int min, int max){
        return Math.round(Math.floor(Math.random()*(max-min+1)+min) * 100.0 / 100.0);
    }

}
