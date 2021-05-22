Given a list of integers nums, sort the array such that:

All even numbers are sorted in increasing order
All odd numbers are sorted in decreasing order
The relative positions of the even and odd numbers remain the same
Constraints

n ≤ 100,000 where n is the length of nums
Example 1
Input
nums = [8, 13, 11, 90, -5, 4]
Output
[4, 13, 11, 8, -5, 90]
Explanation
The even numbers are sorted in increasing order, the odd numbers are sorted in decreasing number, and the relative positions were [even, odd, odd, even, odd, even] and remain the same after sorting.

import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i : nums)
            if (i % 2 == 0)
                even.add(i);
            else
                odd.add(i);

        Collections.sort(even);
        Collections.sort(odd, (a, b) -> b - a);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        for (int i : nums)
            if (i % 2 == 0)
                nums[p++] = even.get(p1++);
            else
                nums[p++] = odd.get(p2++);

        return nums;
    }
}
