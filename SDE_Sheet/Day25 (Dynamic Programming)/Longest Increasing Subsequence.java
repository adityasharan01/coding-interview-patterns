Longest Increasing Subsequence
Given an unsorted list of integers nums,
return the longest strictly increasing subsequence of the array.

Bonus: Can you solve it in \mathcal{O}(n \log n)O(nlogn) time?

Constraints

n ≤ 1,000 where n is the length of nums
Example 1
Input
nums = [6, 1, 7, 2, 8, 3, 4, 5]
Output
5
Explanation
Longest increasing subsequence would be [1, 2, 3, 4, 5]

Example 2
Input
nums = [12, 5, 6, 25, 8, 11, 10]
Output
4
Explanation
One longest increasing subsequence would be [5, 6, 8, 11]

Intuition
A Dynamic Approach

To solve this problem,
-> consider every element i and compare it with every other element before it j.
-> If element at i is greater than element at j , it means that we have an increasing sub sequence whose length -

                  dp[i] = 1 + dp[j] 
->In the end, we return the maximum number in the dp array..

Check this https://www.youtube.com/watch?v=CE2b_-XfVDk

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
            result = Math.max(dp[i], result);
        }
        return result + 1;
    }
}
//////////////////////////////BINARY SEARCH
Intuition
If we iterate through the entire array left to right and make the most compact increasing array, then we can get the longest increasing subsequence. Compactness can be described by the following example:

[1,2,3,4,5] is more compact than [1,10,15,20,30]

The idea is that we want to fill our subsequence with smallest numbers possible so that when comes the next number, we can simply append it to the end of the subsequence.

Implementation
Initially we make a new array, let the name be I[], initially all the values of the array are
infinite, only the 0th element contains negative infinite. The size of I[] will be total
elements in the sequence + 1.
We iterate from left and we pick the numbers from Sequence one by one and insert them
into I[]. When inserting a number, we find the position where all the numbers in left are
strictly smaller than the number.
If we insert the numbers in this fashion, if you think a while, you will find that the
numbers in I[] will always be in ascending order.
And another important thing is that, if a number is inserted into the ith place, and all the
numbers from 1st place to (i-1)th place are smaller than that, so, the L[] value of that
number should be i. It can be proved inductively. However, the next example will show
the procedure fully.
Taken from the paper that poggers linked.

Time Complexity
\mathcal{O}(n\log n )O(nlogn) We use binary search for n numbers.

Space Complexity
\mathcal{O}(n)O(n) We use an array to store the LIS

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[] seq = new int[n + 1];
        Arrays.fill(seq, Integer.MAX_VALUE);
        seq[0] = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int cur = nums[i];

            int insert_index = find_insertion_index(seq, cur);
            res = Math.max(res, insert_index);

            if (seq[insert_index] >= cur) {
                seq[insert_index] = cur;
            }
        }
        return res;
    }

    public int find_insertion_index(int[] nums, int val) {
        // find the greatest index < nums.
        int l = 0;
        int r = nums.length - 1;
        int res = nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < val) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res + 1;
    }
} 
