Intuition
Here we are asked to print the sum of the elements in an array a nums from index i to j (exclusive).

So, we see here that instead of calculating the sum from index i to j every time which takes \mathcal{O}(n)O(n) we create another array call prefix which stores the sum from index 0 to index i (exclusive) every time.

From this prefix array we can just return answer for the function total as prefix[j] - prefix[i];

Implementation
I have implemented Prefix Sums concept inorder to reduce the time complexity from \mathcal{O}(nq)O(nq) to \mathcal{O}(q)O(q).

Example #1
For example, let's consider nums = [ 1, 4, 9, 3, 2 ]
and we need to calculate the total from 1 to 3.

Our prefix sum array will be prefix = [ 0, 1, 5, 14, 17, 19 ].
Note: prefix array's length is 1 more than actual length of nums i.e n+1.

Code:

public int total(int i, int j) {
        return prefix[j] - prefix[i];
}
now for total(1,3) we return prefix[3] - prefix[1]
ie.  14 - 1 = 13.

even by summing up elements from index 1 to 3 (exclusive) we get 13 i.e a[1] + a[2] = 4 + 9.

Time Complexity
As total() function is \mathcal{O}(1)O(1).

for q queries, the Time Complexity is \mathcal{O}(q)O(q).

Space Complexity
As we have used an additional array which is of length n+1, The Space Complexity of code is \mathcal{O}(n)O(n) .

import java.util.*;

class RangeSum {
    int prefix[];
    public RangeSum(int[] nums) {
        int n = nums.length, sum = 0;
        prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = (sum += nums[i]);
        }
    }

    public int total(int i, int j) {
        return prefix[j] - prefix[i];
    }
}
