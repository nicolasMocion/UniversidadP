public class Main {
    public static void main(String[] args) {

        //Matrices deben ser de las mismas dimensiones

        int[][] matrix1 = {{2,2,3}, {4,6,3}};
        int[][] matrix2 = {{2,3,5}, {7,5,8}};
        int[][] matrixResultado = new int[matrix1.length][matrix1[0].length];

        sumarMatrices(matrix1,matrix2,matrixResultado,0,0);


    }


    public static void sumarMatrices(int[][] matrix1, int[][] matrix2, int[][] matrixResult, int i, int j) {

        if (i >= matrixResult.length || j >= matrixResult[i].length) {

            System.out.println("Done");
        } else {

            matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
            System.out.println(" " + matrixResult[i][j]);


            if (j == matrix1[i].length - 1) {

                i++;
                j = 0;
                System.out.println(" ");

                sumarMatrices(matrix1, matrix2, matrixResult, i, j);
            } else {

                j++;
                sumarMatrices(matrix1, matrix2, matrixResult, i, j);

            }

        }
    }

}