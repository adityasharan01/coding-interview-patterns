Intuition
My intuition was to divide array into two parts with first part having k elements and other part with remaining elements and then reverse them separately and join them and then reverse the whole array to get the result.

Implementation
--> In reverse function, I just reverse the elements from given index to end index passed in the function.
--> In solve function, I took array broke it into two parts and reversed them separately, then I took the whole array and reversed it.

Example #1
Let's take nums = [1, 2, 3, 4, 5, 6] and then k = 2.
Firstly, I took [1, 2] and reversed them and [3, 4, 5, 6] and reversed it.
So now nums = [2, 1, 6, 5, 4, 3] and then I reversed this whole array.
The result --> nums = [3, 4, 5, 6, 1, 2].

Time Complexity
\mathcal{O}(n)O(n) as there is only one loop in reverse function.

Space Complexity
\mathcal{O}(1)O(1) as the reverse function make changes in the given array.

import java.util.*;

class Solution {
    public void reverse(int[] a, int i, int j) {
        int li = i;
        int ri = j;
        while (li < ri) {
            int temp = a[li];
            a[li] = a[ri];
            a[ri] = temp;
            li++;
            ri--;
        }
    }
    public int[] solve(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        return nums;
    }
}

//Approach 2
import java.util.*;

class Solution 
{
    public int[] solve(int[] nums, int k) 
    {
    if (nums == null || nums.length < 2) {
            return new int[] {nums[0]};
        }
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

        return nums;
    }
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
