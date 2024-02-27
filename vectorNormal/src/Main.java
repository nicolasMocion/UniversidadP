import java.lang.Math.*;


public class Main {
    public static void main(String[] args) {
        int[] vectorA = {1,1,3,3,5,6,7,76};
        int cantidadDimensiones =  vectorA.length;

        System.out.println(calcularMagnitudVector(vectorA,cantidadDimensiones,0, 0));
    }

    public static float calcularMagnitudVector(int [] vector, int cantidadDimensiones, int i, float currentSum){

        if (i >= cantidadDimensiones){

            return (float) Math.sqrt(currentSum);
        }

        int aSquared = vector[i] * vector[i];

        currentSum = aSquared + currentSum;


        i++;

        return calcularMagnitudVector(vector, cantidadDimensiones, i, currentSum);

    }




}