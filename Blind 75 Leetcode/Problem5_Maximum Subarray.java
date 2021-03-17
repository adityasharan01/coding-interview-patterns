Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
  
  
//  APPROACH 1:


Thoughts Before Coding
    - For each of the number 'x' inside the input array
        - We have 2 choices
            - Add 'x' to the current running sum
            - Start a new running sum with 'x'
        - When should we start a new running sum with 'x'?
            - When our current running sum is a negative value
                - We should start a new subarray
            - This is because 'x + negative value' will only lower
              the value of 'x'
                - So, we should just start a new subarray of 'x'
    - We will return the contiguous subarray, which contains the highest sum

Answer
    - Create two variables
        - sum, the current running sum, initially 0
        - maxSum, the maximum subarray sum, initially 'Integer.MIN_VALUE'
    - Iterate through the elements of 'nums', denoted as 'num'
        - If 'sum' is less than 0
            - Reset 'sum' to 0 (we are starting a new subarray with 'num')
        - Increment 'sum' by 'num'
        - Update 'maxSum' if 'sum' is greater
    - Return 'maxSum'

What is the Time and Space Complexity?
    - Time Complexity = O(n), where 'n' is the length of the input array
        - O(n), visit each element once
    - Space Complexity = O(1)
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;

        for (int num: nums) {
            sum = Math.max(sum, 0) + num;
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}


//Approach 2:
class Solution {
    public int maxSubArray(int[] nums) {
     
        int finalSum = nums[0];
        int preSum = nums[0];        
        
        for(int i = 1; i<nums.length; i++){
            preSum = Math.max(preSum + nums[i], nums[i]);
            finalSum = Math.max(finalSum, preSum);
        }
          return finalSum;
    }
} 
