Longest Consecutive Sequence
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 104
-109 <= nums[i] <= 109
 

Follow up: Could you implement the O(n) solution?
  
  
  Using a set to collect all elements that hasn't been visited. search element will be O(1) and eliminates visiting element again.

public class Solution {
public int longestConsecutive(int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    
    Set<Integer> set = new HashSet<Integer>();
    
    for(int num: nums) set.add(num);
    int max = 1;
    for(int num: nums) {
        if(set.remove(num)) {//num hasn't been visited
            int val = num;
            int sum = 1;
            while(set.remove(val-1)) val--;
            sum += num - val;
            
            val = num;
            while(set.remove(val+1)) val++;
            sum += val - num;
            
            max = Math.max(max, sum);
        }
    }
    return max;
}
}
