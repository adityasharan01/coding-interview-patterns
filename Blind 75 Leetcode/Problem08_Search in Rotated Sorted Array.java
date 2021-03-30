There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
  
  
  
  //Approach 1:
  class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[l] <= nums[mid]){ //checking if first half array is sorted if so
                if(nums[l] <= target && target < nums[mid]){ //check if target lies in the range if so
                    r = mid - 1;                              // search in first half only
                }else                                         //else search in second half
                    l = mid + 1;
            }else{  //if first half isn't sorted go and check for second
                if(nums[mid] < target && target <= nums[r]){ //check if target lies in second half
                    l = mid + 1;                             //if so search in second half
                }else{
                    r = mid - 1;
                }
            }
        }
        return nums[l] == target ? l : -1;
    }
}

//Approach 2:
class Main
{
    // Function to find an element in a circularly sorted array
    public static int searchCircularArray(int[] A, int x)
    {
        // search space is `A[left…right]`
        int left = 0;
        int right = A.length - 1;
 
        // loop till the search space is exhausted
        while (left <= right)
        {
            // find the mid-value in the search space and
            // compares it with the target
            int mid = (left + right) / 2;
 
            // if the key is found, return its index
            if (x == A[mid]) {
                return mid;
            }
 
            // if right half `A[mid…right]` is sorted and `mid` is not
            // the key element
            if (A[mid] <= A[right])
            {
                // compare key with `A[mid]` and `A[right]` to know
                // if it lies in `A[mid…right]` or not
                if (x > A[mid] && x <= A[right])
                {
                    // go searching in the right sorted half
                    left = mid + 1;
                }
                else {
                    right = mid - 1;        // go searching left
                }
            }
 
            // if left half `A[left…mid]` is sorted, and `mid` is not
            // the key element
            else {
                // compare key with `A[left]` and `A[mid]` to know
                // if it lies in `A[left…mid]` or not
                if (x >= A[left] && x < A[mid])
                {
                    // go searching in the left sorted half
                    right = mid - 1;
                }
                else {
                    left = mid + 1;         // go searching right
                }
            }
        }
 
        // key not found or invalid input
        return -1;
    }


