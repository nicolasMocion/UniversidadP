public class Laberinto{


    public char[][] laberinto={
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
    };

    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args) {
        Laberinto m = new Laberinto(); 												// construimos un objeto de la clase Laberinto por defecto
        m.laberinto[8][1] = 'X'; 													// introducimos en este caso, la salida (X) en las coordenadas (1,1)
        m.resuelve(1, 1);
        int i = 0;
                                                                                        // ahora, introducimos la entrada (S) en las coordenadas (8,1) y llamamos al algoritmo
        imprimirLaberinto(i,0, m.laberinto, "");								    // imprimimos el laberinto ya resuelto (si tiene solución)
    }

    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void resuelve(int x, int y){ 				// permite introducir unas coordenadas (x, y)
        if (paso(x, y)) { 								// intentará resolver el laberinto en estas coordenadas
            laberinto[x][y] = 'S'; 						// introduce en las coordenadas (x, y) la entrada
        }
    }

    private boolean paso(int x, int y)
    {

        if (laberinto[x][y]=='X'){
            return true;
        }


        if (laberinto[x][y]=='#'||laberinto[x][y]=='*' ||laberinto[x][y]=='f') {
            return false;
        }

        laberinto[x][y]='*';

        boolean result;

        result=paso(x+1, y);
        if (result){
            return true;
        }

        result=paso(x-1, y);
        if (result) return true;

        result=paso(x, y+1);
        if (result)return true;


        result=paso(x, y-1);
        if (result) return true;


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