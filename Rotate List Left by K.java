Write a function that rotates a list of numbers to the left by k elements. Numbers should wrap around.

Note: The list is guaranteed to have at least one element, and k is guaranteed to be less than or equal to the length of the list.

Bonus: Do this without creating a copy of the list. How many swap or move operations do you need?

Constraints

n ≤ 100,000 where n is the length of nums


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
