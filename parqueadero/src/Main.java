public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Main m = new Main();
        m.parquear(11,0);
        m.parquear(11,0);
        m.borrarMas(m.parqueadero.length -1 , m.parqueadero[0].length - 1, m.parqueadero);
        m.imprimirParqueadero(0,0, m.parqueadero, "");

    }


    public char[][] parqueadero = {

            {'L',' ','L','D','S','L',' '},
            {'L',' ','L','C',' ','L',' '},
            {' ',' ',' ','C',' ',' ',' '},
            {'C',' ',' ','C','P','P',' '},
            {'C',' ',' ',' ',' ','L',' '},
            {'C',' ','C',' ',' ','L',' '},
            {'C',' ','C',' ','C','C',' '},
            {' ',' ','C',' ',' ',' ',' '},
            {'C',' ','C',' ','C',' ','C'},
            {'C',' ','R',' ','C',' ','R'},
            {' ',' ','R',' ','C','C','R'},
            {' ',' ','R',' ',' ',' ','2'}

    };


    public boolean parquear(int xi, int yi){

        if(avanzar(xi,yi)){

            return true;
        }

        return false;

    }


    public boolean avanzar(int x, int y) {

        if( x >= parqueadero.length || x < 0 || y >= parqueadero[0].length || y < 0){
            return false;
        }

        if (parqueadero[x][y] == '1' || parqueadero[x][y] == '2') {
            parqueadero[x][y] = 'S';
            borrarMas(parqueadero.length -1 , parqueadero[0].length - 1, parqueadero);
            return true;
        }

        if (parqueadero[x][y] == 'L' || parqueadero[x][y] == 'C' || parqueadero[x][y] == 'S' || parqueadero[x][y] == 'f' || parqueadero[x][y] == 'R' || parqueadero[x][y] == 'P'|| parqueadero[x][y] == '+') {

            return false;

        }

        parqueadero[x][y] = '+';


        if (avanzar(x, y + 1)) {
            return true;
        }
        if (avanzar(x + 1, y)) {
            return true;
        }
        if (avanzar(x - 1, y)) {
            return true;
        }
        if (avanzar(x, y - 1)) {
            return true;
        }

        parqueadero[x][y] = 'f';

        return false;

    }


    public static void imprimirParqueadero(int i, int j, char[][] matriz, String initial) {

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
                imprimirParqueadero(i, j, matriz, initial);

            }
            else {
                j++;
                imprimirParqueadero(i, j, matriz, initial);
            }

        }


    }


    public void borrarMas(int i, int j, char[][] matriz){

        if(i < 0 || j < 0){
            System.out.println(" ");
        }

        else{

            if(isPlus(matriz[i][j])){
                matriz[i][j] =' ';
            }


            if(j == 0){

                i--;

                if ( i >= 0){
                    j = matriz[i].length - 1;

                }

                borrarMas(i,j,matriz);

            }

            else{
                j--;
                borrarMas(i, j, matriz);
            }
        }










    }


    public static boolean isPlus(char current){

        if(current == '+' || current == 'f'){
            return true;
        }
        else{
            return false;
        }
    }


}

