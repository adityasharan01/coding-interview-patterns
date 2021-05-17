Next Permutation
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100

  // Approach 1:
  //Using a simple example, we can derive the following steps:

public void nextPermutation(int[] A) {
    if(A == null || A.length <= 1) return;
    int i = A.length - 2;
    while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
    if(i >= 0) {                           // If not entirely descending
        int j = A.length - 1;              // Start from the end
        while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
        swap(A, i, j);                     // Switch i and j
    }
    reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
}

public void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
}

public void reverse(int[] A, int i, int j) {
    while(i < j) swap(A, i++, j--);
}
