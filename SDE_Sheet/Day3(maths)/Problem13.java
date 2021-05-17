  Search a 2D Matrix
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
  Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
  
  
  
  The basic idea is from right corner, if the current number greater than target col - 1 in same row, else if the current number less than target, row + 1 in same column, finally if they are same, we find it, and return return.

  public boolean searchMatrix(int[][] matrix, int target) {
            int i = 0, j = matrix[0].length - 1;
            while (i < matrix.length && j >= 0) {
                    if (matrix[i][j] == target) {
                        return true;
                    } else if (matrix[i][j] > target) {
                        j--;
                    } else {
                        i++;
                    }
                }
            
            return false;
        }

//Bnary search method 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int m=matrix.length; 
        int n=matrix[0].length;
        for (int i=0; i<m; i++){
            if (target>=matrix[i][0] && target<=matrix[i][n-1]) return binarySearch(matrix[i],target);
        }
        return false;
    }
    
    public boolean binarySearch(int [] arr, int target){
        int low=0;
        int high=arr.length-1;
        int mid=(low+high)/2;
        while (low<=high){
            mid=(low+high)/2;
            if (target==arr[mid]) return true;
            else if (target>arr[mid]) low=mid+1;
            else {high=mid-1;}
        }
        return false;
    }
}
