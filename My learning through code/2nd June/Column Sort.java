Given a two-dimensional integer matrix, sort each of the columns in ascending order.

Constraints

n, m ≤ 250 where n and m are the number of rows and columns in matrix
Example 1
Input
matrix = [
    [10, 20, 30],
    [5, 5, 3],
    [0, 10, 7]
]
Output
[
    [0, 5, 3],
    [5, 10, 7],
    [10, 20, 30]
]

Hint #1
Can you convert this into a problem where you sort the rows ?
First Transpose the matrix and after sort the each row and once again transpose the matrix and return the matrix.

import java.util.*;

class Solution {
    public static int[][] transpose(int[][] a) {      //method 1 to transpose matrix 
        int arr[][] = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                arr[j][i] = a[i][j];
            }
        }
        return arr;
    }
   static void transpose(int A[][])                   //method 2 to transpose matrix inplace 
    {
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
            {
                 int temp = A[i][j];
                 A[i][j] = A[j][i];
                 A[j][i] = temp;
            }
    }
    public int[][] solve(int[][] matrix) {
        matrix = transpose(matrix);
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
        }
        matrix = transpose(matrix);
        return matrix;
    }
}
