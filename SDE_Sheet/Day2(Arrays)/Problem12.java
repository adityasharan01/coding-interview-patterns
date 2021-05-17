Rotate Matrix
Let's play a game!! Given a matrix mat[][] with n x m elements. Your task is to check that matrix is Super Similar or not. To perform this task you have to follow these Rules: Firstly all even index rows to be Rotated left and odd index rows to right, And Rotation is done X times(Index starting from zero). Secondly, After all the Rotations check if the initial and the final Matrix are same Return 1 else 0.


Example 1:

Input: n = 2, m = 2
mat = {{1, 2}, 
       {5, 6}}
x = 1
Output: 0
Explanation: After one rotation mat is 
not same as the previous one.
 

Example 2:

Input: n = 2, m = 4
mat = {{1, 2, 1, 2}, 
       {2, 1, 2, 1}}
x = 2
Output: 1
Explanation: After two rotation mat is 
same as the previous one.

Your Task:
You do not need to read input or print anything. Your task is to complete the function isSuperSimilar() which takes n, m, x and the matrix as input parameter and returns 1 if the initial and the final Matrix are same else returns 0.


Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)


Constraints:
1 ≤ n, m ≤ 30
1 ≤ mat[i][j] ≤ 100 
1 ≤ x ≤ 20

The idea is to use loops similar to the program for printing a matrix in spiral form. One by one rotate all rings of elements, starting from the outermost. To rotate a ring, we need to do following. 
    1) Move elements of top row. 
    2) Move elements of last column. 
    3) Move elements of bottom row. 
    4) Move elements of first column. 
Repeat above steps for inner ring while there is an inner ring.
  
  
  import java.lang.*;
import java.util.*;
 
class GFG
{
    static int R = 4;
    static int C = 4;
 
    // A function to rotate a matrix
    // mat[][] of size R x C.
    // Initially, m = R and n = C
    static void rotatematrix(int m,
                    int n, int mat[][])
    {
        int row = 0, col = 0;
        int prev, curr;
 
        /*
        row - Staring row index
        m - ending row index
        col - starting column index
        n - ending column index
        i - iterator
        */
        while (row < m && col < n)
        {
     
            if (row + 1 == m || col + 1 == n)
                break;
     
            // Store the first element of next
            // row, this element will replace
            // first element of current row
            prev = mat[row + 1][col];
     
            // Move elements of first row
            // from the remaining rows
            for (int i = col; i < n; i++)
            {
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;
     
            // Move elements of last column
            // from the remaining columns
            for (int i = row; i < m; i++)
            {
                curr = mat[i][n-1];
                mat[i][n-1] = prev;
                prev = curr;
            }
            n--;
     
            // Move elements of last row
            // from the remaining rows
            if (row < m)
            {
                for (int i = n-1; i >= col; i--)
                {
                    curr = mat[m-1][i];
                    mat[m-1][i] = prev;
                    prev = curr;
                }
            }
            m--;
     
            // Move elements of first column
            // from the remaining rows
            if (col < n)
            {
                for (int i = m-1; i >= row; i--)
                {
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;
        }
 
            // Print rotated matrix
            for (int i = 0; i < R; i++)
            {
                for (int j = 0; j < C; j++)
                System.out.print( mat[i][j] + " ");
                System.out.print("\n");
            }
    }
 
/* Driver program to test above functions */
    public static void main(String[] args)
    {
    // Test Case 1
    int a[][] = { {1, 2, 3, 4},
                  {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16} };
 
    // Tese Case 2
    /* int a[][] = new int {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };*/
    rotatematrix(R, C, a);
     
    }
}
