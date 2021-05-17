Reverse Pairs 
Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].

 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
 

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1
  
//Approach: Count inversions during Merge Sort. Here the definition of an inversion is slightly changed but core idea remains the same.

class Solution {
    private int merge(int[] A, int l, int m, int r, int[] M) {
        int i = l, t = l, k = 0, res = 0;
        for(int j = m + 1; j <= r; j++) {
            while(t <= m && A[t] <= 2L * A[j]) t++;
            res += m - t + 1;
            while(i <= m && A[i] <= A[j]) M[k++] = A[i++];
            M[k++] = A[j];
        }
        while(i <= m) M[k++] = A[i++];
        for(i = l; i <= r; i++) A[i] = M[i - l];
        return res;
    }
    private int mergeSort(int[] A, int l, int r, int[] M) {
        if(l >= r) return 0;
        int m = l + ((r-l) >> 1);
        return mergeSort(A, l, m, M) + mergeSort(A, m + 1, r, M) + merge(A, l, m, r, M);
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
    }
}
