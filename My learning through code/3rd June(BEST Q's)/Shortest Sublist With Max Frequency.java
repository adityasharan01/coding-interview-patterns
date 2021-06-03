Shortest Sublist With Max Frequency
You are given a list of integers nums. Let k be the frequency of a most frequent number in nums.
  Return the length of a shortest sublist such that the frequency of its most frequent number is also k.

Constraints

n ≤ 100,000 where n is the length of nums
Example 1
Input
nums = [1, 2, 3, 4, 3, 1]
Output
3
Explanation
The most frequent numbers are 1 and 3 and each of them occur twice, so k = 2. 
  And the sublist [3, 4, 3] is the shortest sublist such that the frequency of the most frequent number is equal to k.



Intuition
Storing count of a number, its first and last index in pair class.

Implementation
Traverse through the nums array to store its count and first ans last indices so that we can calculate its length.
Then traversing HashMap to find the number with maximum count and it sublist length.
If two numbers has same count then checking which has the minimum length.

Time Complexity
Traversing array once to store in hashmap and then traversing hashmap once \mathcal{O}(n)O(n)

Space Complexity
For every number in array storing it in HashMap \mathcal{O}(n)O(n)

import java.util.*;

class Solution {
    static class Pair {
        int count, start, last;
        Pair(int a, int b, int c) {
            this.count = a;
            this.start = b;
            this.last = c;
        }
    }
    public int solve(int[] nums) {
        HashMap<Integer, Pair> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], new Pair(hm.get(nums[i]).count + 1, hm.get(nums[i]).start, i));
                continue;
            }
            hm.put(nums[i], new Pair(1, i, i));
        }

        int maxCount = Integer.MIN_VALUE, minLen = nums.length + 1;
        for (Pair x : hm.values()) {
            // if two no. has same count, then check shortest sublist b/w them
            if (x.count == maxCount && x.last - x.start + 1 < minLen) {
                minLen = x.last - x.start + 1;
                continue;
            }

            // if curr element has max count then update minLen
            if (x.count > maxCount) {
                maxCount = x.count;
                minLen = x.last - x.start + 1;
            }
        }

        return minLen;
    }
}
