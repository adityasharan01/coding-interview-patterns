Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The answer is guaranteed to fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000
 

Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?
  
  Approach 1:
this is like coin change with permutation. we have to consider all unique ways with their permutations

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] strg = new int[target+1];
        Arrays.fill(strg,-1);
        return answer(nums,target,strg);
    }
    public static int answer(int[] arr,int target,int[] strg){
        if(target==0){
            return 1;
        }
        if(target<0) return 0;
        
        if(strg[target]!=-1) return strg[target]; //memoization
        
        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans+=answer(arr,target-arr[i],strg);  // taking all elements of array into account
        }
        return strg[target]=ans;
    }
}
Approach 2:
  class Solution {

    
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        

        int[] cache = new int[target + 1];
        cache[0] = 1;

        //bottom up approach
        
        //solve for each sum
        //start with 1 to target
        for(int currTargetSum = 1; currTargetSum <= target; currTargetSum++){
            
            //append all the permuataion count for this current target sum
            for(int num : nums){
                
                int remainingSum  = currTargetSum - num;
                
                //as nums in sorted in increasing order,
                //remainging sum will be more -ve
                if(remainingSum < 0) break;
                
                cache[currTargetSum] += cache[remainingSum];
            }
            
        }
        
        return cache[target];
    }
    
    
}
  
  
