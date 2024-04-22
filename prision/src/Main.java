public class Main {
    public char[][] laberinto = {
            {' ', 'P', 'X', ' ', 'P', 'P', ' ', 'P'},
            {' ', 'P', 'P', ' ', 'P', 'P', ' ', 'P'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'P', ' ', 'P', 'P', ' ', 'P', 'P', ' '},
            {'P', ' ', 'X', 'P', ' ', 'P', 'P', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'P', 'X', 'P', ' ', 'P', 'P', ' ', 'P'},

    };




    public static void main(String[] args) {
        Main m = new Main(); 												// construimos un objeto de la clase Laberinto por defecto
        												                // introducimos en este caso, la salida (X) en las coordenadas (1,1)
        m.resolver(0, 0, 5,7, 0 ,0);
        int i = 0;
        // ahora, introducimos la entrada (S) en las coordenadas (8,1) y llamamos al algoritmo
        imprimirLaberinto(i,0, m.laberinto, "");
    }


    public void resolver(int x, int y, int xf, int yf, int counterPrisionero, int prisioneroFalstante) {

        if (paso(x, y, xf,yf, counterPrisionero, prisioneroFalstante)) {

                return;
        }

    }


    public boolean paso(int x, int y, int xf, int yf, int counterPrisionero, int prisioneroFaltante){


        // Basicamente no permite estar en una posicion ilegal. por lo que no deberia estar al inicio

        if (x >= laberinto.length  || y >= laberinto[0].length || x < 0 || y < 0 ) {
            return false;
        }

        if (laberinto[x][y]=='f' || laberinto[x][y]=='*'){
            return false;
        }

        if(laberinto[x][y]=='X'){
            prisioneroFaltante = prisioneroFaltante + 1;
        }

        if(laberinto[x][y]=='P'){
            counterPrisionero= counterPrisionero + 1;
        }

        laberinto[x][y]='*';

        boolean result;
        result=paso(x+1, y, xf, yf, counterPrisionero, prisioneroFaltante);
        if (result) return true;

        result=paso(x-1, y, xf, yf,counterPrisionero, prisioneroFaltante);
        if (result) return true;

        result=paso(x, y+1, xf, yf, counterPrisionero,  prisioneroFaltante);
        if (result)return true;


        result=paso(x, y-1, xf, yf,counterPrisionero,  prisioneroFaltante);
        if (result) return true;

        if(x == xf && y == yf){

            System.out.println("La cantidad de prisioneros es "  + counterPrisionero + " y faltan " + prisioneroFaltante);
            return true;
        }

        laberinto[x][y]='f';
        return false;



    }

    public static void imprimirLaberinto(int i, int j, char[][] matriz, String initial) {

        if(i >= matriz.length  || j >= matriz[i].length){
            System.out.println("Finalizacion!");
        }

        else{
            initial = initial +  " " + matriz[i][j];

            if(j == matriz[i].length - 1){

                i++;
                j = 0;
                System.out.println(initial);
                initial = "";
                imprimirLaberinto(i, j, matriz, initial);

            }
            else {
                j++;
                imprimirLaberinto(i, j, matriz, initial);
            }

        }


    }


}







