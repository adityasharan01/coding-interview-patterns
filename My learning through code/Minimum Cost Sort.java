Given a list of integers nums, return the minimum cost of sorting the list in ascending or descending order. 
The cost is defined as the sum of absolute differences between any element's old and new value.

Constraints

n ≤ 100,000 where n is the length of nums
Example 1
Input
nums = [1, 4, 3]
Output
2
Explanation
The cost to change the list to ascending order is 2:

Change 4 to 3 for a cost of 1
Change 3 to 4 for a cost of 1
Example 2
Input
nums = [7, 3, 5]
Output
4
Explanation
The cost to change the list to descending order is 4:

Change 3 to 5 for a cost of 2
Change 5 to 3 for a cost of 2

Note -> If you ever need to duplicate an array for any purpose then 
I'll suggest you go for cloning rather than copying. What I mean to say is that try to use .clone() 
method instead of Arrays.copyOf() method, as the former works in better time complexity.

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int costAsc = 0;
        int costDesc = 0;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            costAsc += Math.abs(nums[i] - arr[i]);
            costDesc += Math.abs(nums[i] - arr[j]);
        }
        return Math.min(costAsc, costDesc);
    }
}
