You are given a lists of non-negative integers nums. Sort the list in ascending order by the number of 1s in binary representation for each number. If there are ties in the number of 1s, then break ties by their value in ascending order.

Constraints

0 ≤ n ≤ 100,000 where n is the length of nums
Example 1
Input
nums = [3, 1, 4, 7]
Output
[1, 4, 3, 7]
Explanation
1 and 4 both have one 1s but 1 comes earlier since it has lower value. 3 has two 1s. And 7 has three 1s.
  
  import java.util.*;

class Solution {
    
    public int[] solve(int[] nums) {
        Pair[] result=new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i]=new Pair(nums[i],Integer.bitCount(nums[i]));
        }
        Sort mysort=new Sort();
        Arrays.sort(result,mysort);
        int[] res1=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res1[i]=result[i].first;
        }
        return res1;
    }
    static class Pair
    {
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    static class Sort implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            if (a.second == b.second)
                return a.first - b.first;
            else
                return a.second - b.second;
        }
    }

}
