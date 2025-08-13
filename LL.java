import java.util.*;

public class LL {   
    public static void main(String[] args) {
       
    }

    public static void setmatrix(int[][] matrix){
        int n = matrix.length; // row 
        int m = matrix[0].length; // col

        List<int[]> zeroes = new ArrayList<>();

        // adding in zeroes
        for (int i = 0 ;i<n ;i++){
            for (int j=0; j<m ; j++){
                if (matrix[i][j] ==0){
                    zeroes.add(new int[] {i,j});
                }
            }
        }

        // setting to 0
        for (int[] zero :zeroes){
            int row= zero[0];
            int col = zero[1];

            // make row 0 col 0
            
            for (int i= 0 ; i<n; i++){
                matrix[row][i]=0;
            }
            for (int j= 0 ; j<m; j++){
                matrix[j][col]=0;
            }
        }

    }
}

