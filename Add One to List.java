You are given a list of integers nums, representing a decimal number and nums[i] is between [0, 9].

For example, [1, 3, 9] represents the number 139.

Return the same list in the same representation except modified so that 1 is added to the number.
  
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
