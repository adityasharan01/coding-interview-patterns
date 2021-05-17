Majority Element
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-231 <= nums[i] <= 231 - 1
  Follow-up: Could you solve the problem in linear time and in O(1) space?
    
    public int majorityElement(int[] nums) {
    int candidate = nums[0];
    int count = 1;
    //2 4 4 1 3
    
    //Boyer Moore Vote Algorithm
    for(int i = 1; i < nums.length; i++){
        if(count == 0){
            candidate = nums[i];
            count = 1;
        }
        else{
            if(nums[i] == candidate){
                count++;
            }
            else{
                count--;
            }
        }
    }
    
    //
    count = 0;
    for(int i = 0; i < nums.length; i++){
        if(nums[i] == candidate){
            count++;
        }
    }
    if(count > nums.length/2){
        return candidate;
    }
    else{
        return -1;
    }
}
