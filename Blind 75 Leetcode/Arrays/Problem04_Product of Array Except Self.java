Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]






In space complexity we dont have to consider the array which we are returning.
Time : O(N) and Space :O(1)

If this question was asked by you in interview please ask interviewer what to return if array length is 1.(dont assume by yourself that you have to return a null array or 1 size array with 0 value.
)ask clarification question that
1.can the product of number can exceed integer max limit?
2. is the number given are in integer or long
3. can the array length be zero or one (if yes what we have to written than)

here array length is >1 given.

NOTE : 
Follow up: Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.) in followup they have clearly mention that array we are writting is not counted in space complexity.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] pp=new int[nums.length];  //prefix product
        pp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pp[i]=pp[i-1]*nums[i];
        }
        int sp=1;   //suffix profuct
        for(int i=pp.length-1;i>0;i--){
            pp[i]=pp[i-1]*sp;
            sp=sp*nums[i];
        }
        pp[0]=sp;
        return pp;
    }
}













