import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        System.out.println("Hello world!");

        String[][] palabras = {

                {"vacio", "carro", "baul", "perro"},
                {"colombia", "casa", "moto", "caza"},
                {"llanta", "reir", "archivo", "silla"},
                {"cocina", "ola", "ave", "freir"},


        };

        ArrayList<String> listaPalabras = new ArrayList<>();

        recorrerMatriz(palabras,0,0,listaPalabras);

    }


    public static void recorrerMatriz(String[][] palabras, int i, int j, ArrayList<String> listaPalabras){

        if(i >= palabras.length || j >= palabras[0].length){

            System.out.println(listaPalabras);
        }

        else{

            if(verificarVocalesSeguidas(palabras[i][j], 0)){
                listaPalabras.add(palabras[i][j]);
            }


            if(j ==  palabras[0].length - 1){

                j = 0;
                i = i +1;

                recorrerMatriz(palabras, i, j, listaPalabras);

            }

            else{
                j++;
                recorrerMatriz(palabras, i, j, listaPalabras);
            }

        }

    }


    public static boolean verificarVocalesSeguidas(String palabra, int indexS){

        if(indexS == palabra.length() - 1){
            return false;
        }
        else{

            if(  (isVocal(palabra.charAt(indexS)))  &&  (isVocal(palabra.charAt(indexS + 1)))  ) {
                return true;
            }

            return verificarVocalesSeguidas(palabra, indexS + 1);

        }

    }


    public static  boolean isVocal(char current){

        if(current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u'){

            return true;
        }

        else{
            return false;
        }
    }

}