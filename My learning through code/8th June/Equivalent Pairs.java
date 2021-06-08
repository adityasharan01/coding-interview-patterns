You are given a list of integers nums. Return the number of pairs i < j such that nums[i] = nums[j].

Constraints

0 ≤ n ≤ 100,000 where n is the length of nums
Example 1
Input
nums = [3, 2, 3, 2, 2]
Output
4
Explanation
We have index pairs (0, 2), (1, 3), (1, 4), (3, 4).
  Use. HashMap to store the indices in a list.

Once you have indices, since these are stored in increasing order only, each one will have pairs with all the ones to the right.

Implementation
once the map is formed just use the formula (n*n-1)/2 as there will be these many combinations
  import java.util.*;

class Solution {
    public int solve(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i])){
                int of=hm.get(nums[i]);
                int nf=of+1;
                hm.put(nums[i],nf);
            }
            else{
                hm.put(nums[i],1);
            }
        }
        for(Integer key :hm.keySet()){
            int res=hm.get(key);
            result+=((res*(res-1))/2);
        }
        return result;
    }
}
