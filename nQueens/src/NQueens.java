import java.util.ArrayList;

public class NQueens {

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> soluciones = nReinas(8);
        imprimirSolucion(soluciones);
    }

    public static ArrayList<ArrayList<String>> nReinas(int n){
        ArrayList<ArrayList<String>> resultados = new ArrayList<>();
        resolver(n, 0, 0, new ArrayList<Integer>(), resultados);
        return resultados;
    }

    public static void resolver(int n, int fila, int currentCol, ArrayList<Integer> posicionesColumnas, ArrayList<ArrayList<String>> resultados){
        if (fila == n){
            resultados.add(crearTableroParaPosiciones(posicionesColumnas, n));
            return;
        } else {
            if(currentCol == n){
                return;
            } else {
                posicionesColumnas.add(currentCol);
                if (esValido(posicionesColumnas)){
                    resolver(n, fila + 1, 0,  posicionesColumnas, resultados);
                }
                posicionesColumnas.remove(posicionesColumnas.size() - 1);
                resolver(n, fila, currentCol + 1,  posicionesColumnas, resultados);
            }
        }
    }

    public static boolean esValido(ArrayList<Integer> posicionColumna){
        int rowId = posicionColumna.size() - 1;
        for(int i =0; i < rowId; i++){
            int diff = Math.abs(posicionColumna.get(i) - posicionColumna.get(rowId));
            if(diff ==  0 || diff == rowId - i) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<String> crearTableroParaPosiciones(ArrayList<Integer> posicionColumna, int n) {
        ArrayList<String> tablero = new ArrayList<>();
        int total = posicionColumna.size();

        for (int row = 0; row < total; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                if (col == posicionColumna.get(row)) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }

            tablero.add(sb.toString());
        }


        for (int row = total; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                sb.append('.');
            }
            tablero.add(sb.toString());
        }

        return tablero;
    }

    public static void imprimirSolucion(ArrayList<ArrayList<String>> soluciones) {
        for (ArrayList<String> solution : soluciones) {
            for (String fila : solution) {
                System.out.println(fila);
            }
            System.out.println();
        }
    }
}





