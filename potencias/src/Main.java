public class Main {
    public static void main(String[] args) {

        int base = 4;
        int exponent = 3;

        System.out.println(potenciar(base,exponent));

    }

    
    public static int potenciar(int base, int exponent){

        if(exponent == 1){

            return base;
        }
        exponent--;

        return potenciar(base, exponent) * base;


    }
}