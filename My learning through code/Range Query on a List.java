Range Query on a List
Implement a data structure with the following methods:

RangeSum(int[] nums) constructs a new instance with the given nums.
total(int i, int j) returns the sum of integers from nums between [i, j). That is, nums[i] + nums[i + 1] + ... + nums[j - 1].
Constraints

n ≤ 100,000 where n is the length of nums
k ≤ 100,000 where k is the number of calls to total
Example 1
Input
methods = ["constructor", "total", "total"]
arguments = [[[1, 2, 5, 0, 3, 7]], [0, 3], [1, 5]]`
Output
[null, 8, 10]
Explanation
r = RangeSum([1,2,5,0,3,7])
r.total(0, 3) == 8 # sum([1, 2, 5])
r.total(1, 5) == 10 # sum([2, 5, 0, 3])
                                             
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
                                                                   
                                                                   
