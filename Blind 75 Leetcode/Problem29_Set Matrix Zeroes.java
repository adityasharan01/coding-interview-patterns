 Set Matrix Zeroes
 Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
  
  
  class Solution {
    
    public void setZeroes(int[][] matrix) {
        
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        int i = 0, j = 0;
        
        /**
        * Mark which row and column you want to make zero
        * Don't try to do it recursively at the same time otherwise you will endup making every thing 0
        * like a ripple effect
        * You can optimize this but i have taken a rather simple to understand approach
        */
        for(i = 0; i < row.length; i++) {
            for(j = 0; j < col.length; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1; //this row you have to make 0
                    col[j] = 1; //this col you have to make 0
                }
            }   
        }
        
        
        for(i = 0; i < row.length; i++) {
            if(row[i] == 1) {
                //make this whole row zero
                for(j = 0; j < col.length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        
        for(j = 0; j < col.length; j++) {
            if(col[j] == 1) {
                //make this whole column zero
                for(i = 0; i < row.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
  
  
  
  
  Logic
Using nested loop find the (row,col) of the array where 0 is present and add them to 2 sets
Now using the values present in row fill the columns of the array and vice-versa.

class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        row = set()
        col = set()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    col.add(j)
                    row.add(i)
        for i in row:
            for j in range(len(matrix[0])):  #fill  columns
                matrix[i][j] = 0
        
        for i in col:
            for j in range(len(matrix)):   #fill rows
                matrix[j][i] = 0
