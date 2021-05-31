Matrix Prefix Sum
Given a two-dimensional integer matrix, return a new matrix A of the same dimensions where each element is set to A[i][j] = sum(matrix[r][c]) for all r ≤ i, c ≤ j.

Constraints

n, m ≤ 250 where n and m are the number of rows and columns in matrix
matrix[i][j] ≤ 2**12
Example 1
Input
matrix = [
    [2, 3],
    [5, 7]
]
Output
[
    [2, 5],
    [7, 17]
]
Iterate over the input matrix and prefix sum matrix at the same time. Populate values of prefix sum matrix by using previously calculated prefix sum values and the current matrix value.

Example #1
Let's analyze the example input and prefix sum matrix given in the problem description:

input matrix
2 3
5 7

prefix sum matrix
[a b] 2 5
[c p] 7 17

  
  import java.util.*;

class Solution {
    public int[][] solve(int[][] matrix) {
        if(matrix.length==0)
            return matrix;
        int row=matrix.length;
        int col=matrix[0].length;

        for(int i=0;i<row;i++){
            for(int j=1;j<col;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j]+=matrix[i-1][j];
            }
        }
        return matrix;
    }
}

  
  
Let p = 17 be the prefixSum[1][1], it's also equal to 7 + 7 + 5 - 2. i.e. p = inputMatrix[1][1] + b + c - a

To calculate the value of p, we can sum already calculated values of upper and left points in the prefix sum matrix, but we also need to subtract the value of a, because we implicitly used it twice. (as value of a is already part of both b and c) We can generalize this formula and it holds for all prefix sums. For the indexes where b, c or a element doesn't exist, we just replace the non-existing value with zero. That's all.

Time Complexity
\mathcal{O}(n * m)O(n∗m)where n and m are the number of rows and columns in the input matrix

Space Complexity
\mathcal{O}(n * m)O(n∗m)where n and m are the number of rows and columns in the input matrix

import java.util.*;

class Solution {
    public int[][] solve(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return new int[0][];
        }
        int m = matrix[0].length;
        if (m == 0) {
            return new int[n][0];
        }
        int[][] prefixSum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = (i > 0 && j > 0) ? prefixSum[i - 1][j - 1] : 0;
                int b = (i > 0) ? prefixSum[i - 1][j] : 0;
                int c = (j > 0) ? prefixSum[i][j - 1] : 0;
                prefixSum[i][j] = matrix[i][j] + b + c - a;
            }
        }
        return prefixSum;
    }
}
