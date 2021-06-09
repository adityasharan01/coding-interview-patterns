Given an n by n matrix of letters matrix, return whether there are exactly n different letters that appear in the matrix and each letter appears exactly once in each row and exactly once in each column.

Constraints

1 ≤ n ≤ 250 where n is the number of rows and columns in matrix
Example 1
Input
matrix = [
    ["a", "b", "c"],
    ["c", "a", "b"],
    ["b", "c", "a"]
]
Output
true
Explanation
There are 3 different letters and each letter appears exactly once in each row and column.

Example 2
Input
matrix = [
    ["a", "b", "c"],
    ["d", "a", "a"],
    ["b", "b", "a"]
]
Output
false
Explanation
There are 4 different letters, and also "a" and "b" appear twice in the same row.
  
  //Use hashset ..insert and validate if each element present in every column and row or not.
  import java.util.*;

class Solution {
    public boolean solve(String[][] matrix) {
        int N =matrix.length;
        for(int i=0;i<matrix.length;i++)
        {
            HashSet<String> row=new HashSet<>();
            HashSet<String> col=new HashSet<>();
            for(int j=0;j<matrix[i].length;j++){
                row.add(matrix[i][j]);
                col.add(matrix[j][i]);
            }
            if(!row.equals(col) || row.size()!= N || col.size()!=N){
                return false;
            }
        }
        return true;
    }
}
