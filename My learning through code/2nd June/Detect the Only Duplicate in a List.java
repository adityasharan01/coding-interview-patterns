You are given a list nums of length n + 1 picked from the range 1, 2, ..., n.
  By the pigeonhole principle, there must be a duplicate. Find and return it. There is guaranteed to be exactly one duplicate.

Bonus: Can you do this in \mathcal{O}(n)O(n) time and \mathcal{O}(1)O(1) space?

Constraints

n ≤ 10,000
Example 1
Input
nums = [1, 2, 3, 1]
Output
1
Example 2
Input
nums = [4, 2, 1, 3, 2]
Output
2

Intuition
Since there is only one duplicate and that duplicate replaces a value in an array that's
  suppose to have values that are one more or less than each other, you can do some math to find the duplicate.

Implementation
The indexTotal is the total of the array if there is no 
duplicate(example: {1,2,3,4}, indexTotal = 10)
The total is the total of the input array.
Loop to find the indexTotal and total.
Find the difference between indexTotal and total. That value subtracted from the length of the input array should give you the value of the duplicate.
Example #1
int[] nums = {1, 2, 3, 1}
indexTotal = 1+2+3+4 = 10
total = 1+2+3+1 = 7

nums.length = 4
10-7 = 3
4-3 = 1

1 is the duplicate value.

Time Complexity
\mathcal{O}(n)O(n) One for loop, no nested loops.

Space Complexity
\mathcal{O}(1)O(1) Two integer variables but no arrays.

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int indexTotal = 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            indexTotal += i + 1;
            total += nums[i];
        }
        return nums.length - (indexTotal - total);
    }
}
