Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
 

Follow up:

Could you come up with the O(n2) solution?
Could you improve it to O(n log(n)) time complexity?

// TC O(n2)
//SC O(n)


```public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        // Every  single number is a longest increasing subsequence in itself that's why length of lcs in this case is 1
        dp[0] = 1;
        // filling dp array with all ones
        for(int i=1;i<dp.length;i++){
            dp[i]=1;
        }
        
        int maxans = 1;
    // taking two pointer variable i and j

// i points to 1 and j to 0 in arr
        for (int i = 1; i < dp.length; i++) {

            for (int j = 0; j < i; j++) {
 // to form increasing subsequence number at i needs to be greater than number at j in arr 
  // In dp array number at i must be <=number at j because we are forming increasing subsequence in dp array 
  // so basically dp array is storing the indexes of lcs 
  // for ex . if i am taking both 8 and 9 in my lcsso 9 should come after 8 in dp array 
  
       if (nums[i] > nums[j]&& dp[i]<dp[j]+1) // +1 because of 0 indexing 
   
                    
                    
  // if the above condition satisfies putting that value of j just after i in dp array at i position                  
   dp[i] =dp[j] + 1;
    
 // finding maximum length 
 
            maxans = Math.max(maxans, dp[i]);
        }
        }
  // returning lcs
        return maxans;
            
    }
}
    
