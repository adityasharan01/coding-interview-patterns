City Blocks
You are given a two-dimensional matrix of unique strings representing city blocks, and a list of strings blocks to visit. Given that you are sitting at block matrix[0][0], return the total Manhattan distance required to visit every block in order.

Constraints

0 ≤ n * m ≤ 100,000 where n and m are the number of rows and columns in matrix
Example 1
Input
matrix = [
    ["a", "b", "c"],
    ["d", "e", "f"],
    ["g", "h", "i"]
]
blocks = ["h", "b", "c"]
Output
6
Explanation
"h" is 2 blocks south and 1 block east.
"b" is 2 blocks north.
"c" is 1 block east.
Which adds up to 6.
  
Hint:Try to add distance to strings from where your current position is. And update your current position.
    
Manhattan distance is = |x0-x1|+|y0-y1|;

//My method 
  
import java.util.*;

class Solution {
    public int solve(String[][] matrix, String[] blocks) {
        int result=0;
        int presentx=0,presenty=0;
        for(int i=0;i<blocks.length;i++){
            int[] cord=new int[2];
            cord=coord(matrix,blocks[i]);
            result+=Math.abs(cord[0]-presentx)+Math.abs(cord[1]-presenty);
            presentx=cord[0];
            presenty=cord[1];
        }
        return result;
        
    }
    public int[] coord(String[][] matrix,String s){
        int[] cord=new int[2];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j].equals(s)){
                    cord[0]=i;
                    cord[1]=j;
                }
            }
        }
        return cord;
    }
}
//Efficient method 
import java.util.*;

class Solution {
    public int solve(String[][] matrix, String[] blocks) {
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                map.put(matrix[i][j], new int[] {i, j});
            }
        }
        int sum = 0;
        int i = 0, j = 0, x, y;
        for (String b : blocks) {
            x = map.get(b)[0];
            y = map.get(b)[1];
            sum += Math.abs(x - i) + Math.abs(y - j);
            i = x;
            j = y;
        }
        return sum;
    }
}
