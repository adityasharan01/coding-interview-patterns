You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
  
Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
Example 3:

Input: matrix = [[1]]
Output: [[1]]
Example 4:

Input: matrix = [[1,2],[3,4]]
Output: [[3,1],[4,2]]
 

Constraints:

matrix.length == n
matrix[i].length == n
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
  
  
  public void rotate(int[][] matrix) {
    for(int i=0;i<matrix.length-1;i++){           // |       |
        for(int j=i+1;j<matrix.length;j++){       // | 1 4 7 |
            int temp=matrix[i][j];                // | 2 5 8 |    Calculating the Transpose.
            matrix[i][j]=matrix[j][i];            // | 3 6 9 |
            matrix[j][i]=temp;                    // |       |
        }
    }
    
    for(int i=0;i<matrix.length;i++){                   // |       |
        for(int j=0;j<matrix.length/2;j++){             // | 7 4 1 |    
            int temp=matrix[i][j];                      // | 8 5 2 |    Reversing every Row.
            matrix[i][j]=matrix[i][matrix.length-j-1];  // | 9 6 3 |
            matrix[i][matrix.length-j-1]=temp;          // |       |
        }
    }
}

Solution in python :
class Solution:
    def rotate(self, mat: List[List[int]]) -> None:

        if mat is None:
            return None
        
        n = len(mat)
        
        if n == 1:
            return mat
        
        for i in range(n):
            if len(mat[i]) != n:
                raise Exception("Matrix must be square")

        # Transpose the matrix
        for i in range(n):
            for j in range(i):
                mat[i][j], mat[j][i] = mat[j][i], mat[i][j]

        # Swap columns
        for i in range(n):
            for j in range(n // 2):
                mat[i][j], mat[i][n - j - 1] = mat[i][n - j - 1], mat[i][j]
