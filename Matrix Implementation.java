You are given a two-dimensional integer matrix matrix containing 1s and 0s. For each row in matrix, reverse the row. Then, flip each value in the matrix such that any 1 becomes 0 and any 0 becomes 1.

Constraints

n, m ≤ 250 where n and m are the number of rows and columns in matrix

import java.util.*;



//Declaration of Matrix 
int[][] myarr={{1,2,3},{4,5,6},{7,8,9}}
class Solution {
    public int[][] solve(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int row_length = matrix[0].length; // get the length of each row
        // loop through the entire matrix
        for (int[] row : matrix) {
            // loop through each row, doing the swap and invert the same time
            for (int i = 0; i < (row_length + 1) / 2; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[row_length - 1 - i] ^ 1;
                row[row_length - 1 - i] = temp;
            }
        }
        return matrix;
    }
}
