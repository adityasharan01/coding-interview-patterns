You are given a list of integers nums, representing a decimal number and nums[i] is between [0, 9].

For example, [1, 3, 9] represents the number 139.

Return the same list in the same representation except modified so that 1 is added to the number.

Constraints

1 ≤ n ≤ 100,000 where n is the length of nums.
Example 1
Input
nums = [1, 9, 1]
Output
[1, 9, 2]
Example 2
Input
nums = [9]
Output
[1, 0]


Intuition
1 -> if the last number in the array is less than 9 just add one and return the array
2 -> iterate the array in reverse if any number is less than 9 just add one and return
3 -> if every element in the array is 9 just create a new array with one extra space and set the first index to 1 and return

Implementation
In java by default int value is 0 hence the last case works

Time Complexity
\mathcal{O}(n)O(n) cause the programs iterate the array once

Space Complexity
\mathcal{O}(n)O(n)+1 in worst case we need to create and array of length n+1 size

import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        if (nums[nums.length - 1] < 9) {
            nums[nums.length - 1] += 1;
            return nums;
        }
        int[] rtn = new int[nums.length + 1];
        int carry = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < 9) {
                nums[i] += carry;
                return nums;
            } else
                nums[i] = 0;
        }
        rtn[0] = 1;
        return rtn;
    }
}
