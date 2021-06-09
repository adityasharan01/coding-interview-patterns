Max Product of Three Numbers
Easy

Given a list of integers nums, find the largest product of three distinct elements.

Constraints

3 ≤ n ≤ 100,000 where n is the length of nums
Example 1
Input
nums = [5, 4, 1, 3, -2, -2]
Output
60
Explanation
We can multiply 5 * 4 * 3

Example 2
Input
nums = [-3, 1, 1, 0]
Output
0
Explanation
We can multiply 1 * 1 * 0

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        if(nums.length==3){
            return nums[0]*nums[1]*nums[2];
        }
        int p1=1,p2=1,res=1;
        p1=((nums[nums.length-1]*nums[nums.length-2])*nums[nums.length-3]);
        p2=((nums[0]*nums[1])*nums[nums.length-1]);
        res=Math.max(p1,p2);
        return res;
    }
}
