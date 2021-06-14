Unique Fractions
You are given a list of lists fractions where each list contains [numerator, denominator] which represents the number numerator / denominator.

Return a new list of lists such that the numbers in fractions are:

In their most reduced terms. E.g. 8 / 6 becomes 4 / 3.
Any duplicate fractions that represent the same value are removed.
Sorted in ascending order by their value.
If the number is negative, the - sign should go to the numerator (the input also follows this).
Constraints

n ≤ 100,000 where n is the length of fractions
Example 1
Input
fractions = [
    [8, 4],
    [2, 1],
    [7, 3],
    [14, 6],
    [10, 2],
    [-3, 6]
]
Output
[
    [-1, 2],
    [2, 1],
    [7, 3],
    [5, 1]
]
Explanation
Once we reduce the numbers they become [[2, 1], [2, 1], [7, 3], [7, 3], [5, 1], [-1, 2]]. The result then comes from deduping and sorting by value.
  
hint :USE GCD
import java.util.*;

class Solution {
    public int[][] solve(int[][] fractions) {
        for(int i=0;i<fractions.length;i++){
            int hcf=gcd(Math.abs(fractions[i][0]),Math.abs(fractions[i][1]));
            fractions[i][0]/=hcf;
            fractions[i][1]/=hcf;
            if (fractions[i][1] < 0) {
                if (fractions[i][0] >= 0) {
                    fractions[i][1] = fractions[i][1] * -1;
                    fractions[i][0] = fractions[i][0] * -1;
                }
            }
        }
        HashSet<ArrayList<Integer>> hs=new HashSet<>();
        for(int i=0;i<fractions.length;i++)
        {
            ArrayList<Integer> h1=new ArrayList();
            h1.add(fractions[i][0]);
            h1.add(fractions[i][1]);
            hs.add(h1);
        }
        int[][] result=new int[hs.size()][2];
        int i=0;
        for(ArrayList<Integer> arr:hs){
            result[i][0]=arr.get(0);
            result[i][1]=arr.get(1);
            i++;
        }
       Arrays.sort(result, new Comparator<int[]>() {        // can write new Comparator<>() {
        public int compare(int[] o1, int[] o2) {
            if((float)o1[0]/o1[1] < (float)o2[0]/o2[1]){
                return -1;
            }
            return 1;
        }
        });
        return result;
    }
    static int gcd(int a,int b){
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
}
