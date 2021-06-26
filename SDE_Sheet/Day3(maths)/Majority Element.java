Majority Element II
Given an integer array of size n,
find all elements that appear more than ⌊ n/3 ⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109

  There can be at most k - 1 major element in an array if the major element appears more than ⌊n / k⌋ times.

In the begining, we assume there are k - 1 candidates:

These candidates can take any value;
The vote of these candidates must be 0
Then we traverse the array:

If current element equals to the value of any candidate, the candidate get a vote; (one voter can only vote for one candidate)
If the vote of any candidate is 0, then current element is set as a new candidate and he can get a vote immediately; (A voter can also be elected)
Otherwise, current element vote against all candidates and all candidates lose a vote.
Assume you're voting for the president. If you want to select Trump or Biden. Ok, just vote for them (case 1). If Trump is impeached or Biden is dead, now you can run for the president (case 2). If you want to vote for Lebron James, of course both Biden or Trump won't get your vote (case 3).

After election, we need to count the vote of each candidate to see whether they are qualified for the position, i.e., the vote is larger than ⌊n / k⌋.

public List<Integer> majorityElement(int[] nums) {
	List<Integer> result = new ArrayList<Integer>();
	if (nums.length == 0)
		return result;
	// In the begining, both Trump and Biden don't get a vote
	int firstMajor = Integer.MAX_VALUE, firstSum = 0, secondMajor = Integer.MIN_VALUE, secondSum = 0;
	
	for (int i = 0; i < nums.length; i++) {
		// case 1: I want to vote for Biden or Trump
		if (nums[i] == firstMajor)
			firstSum++;
		else if (nums[i] == secondMajor)
			secondSum++;
		// case 2: I want to run for the president
		else if (firstSum == 0) {
			firstMajor = nums[i];
			firstSum = 1;
		}
		else if (secondSum == 0) {
			secondMajor = nums[i];
			secondSum = 1;
		}
		// case 3: fuck sleepy Joe and crazy Trump, let James be the president
		else {
			firstSum--;
			secondSum--;
		}
	}
	// After election, we need to count the vote again.
	firstSum = 0;
	secondSum = 0;
	for (int i = 0; i < nums.length; i++) {
		if (nums[i] == firstMajor)
			firstSum++;    
		else if (nums[i] == secondMajor)
			secondSum++;
	}
	if (firstSum > nums.length / 3)
		result.add(firstMajor);
	if (secondSum > nums.length / 3)
		result.add(secondMajor);
	return result;
}
