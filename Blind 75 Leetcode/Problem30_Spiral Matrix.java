Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
  
  class Main
{
    private static void printSpiral(int mat[][], int top, int bottom,
                                    int left, int right)
    {
        if (left > right) {
            return;
        }
        // print top row
        for (int i = left; i <= right; i++) {
            System.out.print(mat[top][i] + " ");
        }
        top++;
 
        if (top > bottom) {
            return;
        }
        // print right column
        for (int i = top; i <= bottom; i++) {
            System.out.print(mat[i][right] + " ");
        }
        right--;
 
        if (left > right) {
            return;
        }
        // print bottom row
        for (int i = right; i >= left; i--) {
            System.out.print(mat[bottom][i] + " ");
        }
        bottom--;
 
        if (top > bottom) {
            return;
        }
        // print left column
        for (int i = bottom; i >= top; i--) {
            System.out.print(mat[i][left] + " ");
        }
        left++;
 
        printSpiral(mat, top, bottom, left, right);
    }
 
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 1, 2, 3, 4, 5},
            {16, 17, 18, 19, 6},
            {15, 24, 25, 20, 7},
            {14, 23, 22, 21, 8},
            {13, 12, 11, 10, 9}
        };
 
        int top = 0, bottom = mat.length - 1;
        int left = 0, right = mat[0].length - 1;
 
        printSpiral(mat, top, bottom, left, right);
    }
}


Python Approach :
def printSpiral(mat, top, bottom, left, right):
 
    if left > right:
        return
 
    # print top row
    for i in range(left, right + 1):
        print(mat[top][i], end=' ')
 
    top = top + 1
 
    if top > bottom:
        return
 
    # print right column
    for i in range(top, bottom + 1):
        print(mat[i][right], end=' ')
 
    right = right - 1
 
    if left > right:
        return
 
    # print bottom row
    for i in range(right, left - 1, -1):
        print(mat[bottom][i], end=' ')
 
    bottom = bottom - 1
 
    if top > bottom:
        return
 
    # print left column
    for i in range(bottom, top - 1, -1):
        print(mat[i][left], end=' ')
 
    left = left + 1
 
    printSpiral(mat, top, bottom, left, right)
 
 
if __name__ == '__main__':
 
    mat = [
        [1, 2, 3, 4, 5],
        [16, 17, 18, 19, 6],
        [15, 24, 25, 20, 7],
        [14, 23, 22, 21, 8],
        [13, 12, 11, 10, 9]
    ]
 
    top = 0
    bottom = len(mat) - 1
    left = 0
    right = len(mat[0]) - 1
 
    printSpiral(mat, top, bottom, left, right)
