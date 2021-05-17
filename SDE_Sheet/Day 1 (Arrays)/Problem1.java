Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1
  
  
  //Basically transfer the problem to finding the beginning of cycle in linked list.  
  public int findDuplicate(int[] nums) {
            if(nums.length ==0 )
                return 0;
            int slow=0, fast=0;
            slow = nums[slow];
            fast = nums[nums[fast]];
            while(slow != fast){
                if(slow == nums[slow])
                    return slow;
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while(slow != fast){
                if(slow == nums[slow])
                    return slow;
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }

////////////
Approach 2:-
class Solution {
    public int findDuplicate(int[] nums) {
        for (int n : nums) {
            if (nums[Math.abs(n)] < 0) {
                return Math.abs(n);
            } else {
                nums[Math.abs(n)] *= -1;
            }
        }
        return -1;
    }
}
Since array length is n+1, the values in nums are essentially valid indices of itself.
for each value n of nums, go to nums[n] to make that value negative.
if the value at nums[n] is already negative, it means that n has already existed.
