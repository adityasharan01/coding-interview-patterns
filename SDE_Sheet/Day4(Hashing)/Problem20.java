4Sum
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
  
  Thoughts Before Coding
    - The brute force approach will be to perform 4 nested 'for' loops
      to find all of the possible quadruplets
        - This approach will cost us O(n^4) time complexity because
          of the nested 'for' loops
    - We can implement an optimized approach by sorting the input
      array in ascending order
        - We can use a nested 'for' loop to find the first 2 elements
          inside our quadruplet
            - Then can implement a two pointer approach for the
              last 2 elements inside our quadruplet
      - This will allow us to reduce the time complexity to O(n^3)
   - The side case we have to handle is to prevent duplicate
     quadruplets
        - When we sort the input array in ascending order
            - All of the duplicates elements are grouped together
        - If our quadruplet consists of [a, b, c, d]
            - After we have accounted for a number 'x' at
              position 'i' inside our quadruplet
                - We will want to skip all future occurrences of 'x'
                  for the position 'i'

Answer
    - Sort the input array in ascending order
    - Create a list 'quadruplets' to keep track of all quadruplets
    - Iterate through the indices from '0 -> nums.length - 4', denoted as 'i'
        - If 'i' is not equal to 0 AND 'nums[i - 1]' is equal to 'nums[i]'
            - continue to next iteration
        - Iterate through the indices from 'i + 1 -> nums.length - 3', denoted as 'j'
            - If 'j' is not equal to 'i + 1' AND 'nums[j - 1]' is equal to 'nums[j]'
                - continue to next iteration
            - Create two variables
                - k, initially at 'j + 1'
                - m, initially at 'nums.length - 1'
            - While 'k' is less than 'm'
                - If 'k' is not equal to 'j + 1' AND 'nums[k - 1]' is equal to 'nums[k]'
                    - Increment 'k'
                    - continue to next iteration
                - If 'm' is not equal to 'nums.length - 1' AND 'nums[m]' is equal to 'nums[m + 1]'
                    - Decrement 'm'
                    - Continue to next iteration
                - Find the 'sum' of the four elements location at 'i, j, k, m'
                - If 'sum' is equal to 'target'
                    - Add the 4 numbers to 'quadruplets'
                    - Increment 'k'
                - Else if 'sum' is less than 'target'
                    - Increment 'k'
                - Else
                    - Decrement 'm'
    - Return 'quadruplets'
 public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1, m = nums.length - 1;

                while (k < m) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) {
                        k++;
                        continue;
                    }

                    if (m != nums.length - 1 && nums[m] == nums[m + 1]) {
                        m--;
                        continue;
                    }

                    int sum = nums[i] + nums[j] + nums[k] + nums[m];

                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[k++], nums[m]));
                    } else if (sum < target) {
                        k++;
                    } else {
                        m--;
                    }
                }
            }
        }

        return quadruplets;
    }
}
