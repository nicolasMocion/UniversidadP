public class Main {
    public static void main(String[] args) {

        int[][] matrix = {{5,2},{1,1}, {3,4}};
        int i = matrix.length;
        int j = matrix[0].length;

        int[][] transpose = new int[j][i];

        traverseMatrix(matrix, transpose, 0, 0);


    }


    public static void traverseMatrix(int[][] originalMatrix,int[][] transpose ,int i, int j){

        if(i >= originalMatrix.length || j >= originalMatrix[i].length){

            System.out.println("Done");
        }

        else{

            transpose[j][i] = originalMatrix[i][j];
            System.out.println(" " + transpose[j][i]);


            if( j == originalMatrix[i].length -1){

                i++;
                j = 0;
                System.out.println(" ");

                traverseMatrix(originalMatrix,transpose,i, j);
            }

            else {

                j++;
                traverseMatrix(originalMatrix,transpose,i, j);

            }

        }








    }



}