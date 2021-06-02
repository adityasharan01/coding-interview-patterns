Subsets II

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
  //BEST EXPLAINATION FOR THIS PROBLEM : https://leetcode.com/problems/subsets-ii/discuss/388566/Subsets-I-and-II-Java-Solution-with-Detailed-Explanation-and-Comments-(Recursion-and-Iteration)
  //Another solution in recursion 
  The idea is naive, there are total 2^n different situation if we don't count the duplicates. Build the recursive tree for adding the current number of not. If there is duplicates, count the number of duplicates, and then based on the the number of duplicates, iteratively call the recurse function with different length of duplicates.

public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums){
	    Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        recurse(res, nums, 0, new LinkedList<>());
        return res;
	}
    private void recurse(List<List<Integer>> res, int[] nums, int i, List<Integer> temp){
        if(i==nums.length){
            res.add(temp);
            return;
        }
        if(i<nums.length-1 && nums[i]==nums[i+1]){
            int count = 1;
             /*count how many duplicates for a specific number*/
            while(i<nums.length-1 && nums[i]==nums[i+1]){
                count++;
                i++;
            }
           /*based on the number of duplicates, call recursive with increasing numbers */
            recurse(res, nums, i+1, new LinkedList<>(temp));
            for(int j=0; j<count; j++){
                List<Integer> newtemp = new LinkedList<>(temp);
                for(int k=0; k<j+1; k++){
                    newtemp.add(nums[i]);
                }
                recurse(res, nums, i+1, newtemp);
            }
            return;
        }
        else{
            /*if there is no duplicates, then we just split the work into two:
            add teh current one or not add the current one.*/
            recurse(res, nums, i+1, new LinkedList<>(temp));
            List<Integer> newtemp = new LinkedList<>(temp);
            newtemp.add(nums[i]);
            recurse(res, nums, i+1, newtemp);
        }
    }
}
  
  // BACKTRACKING SOLTION 
  class Solution {
	public List<List> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List> ans = new ArrayList<>();
		List cur = new ArrayList<>();
		backTrack(nums, ans, cur, 0);
		return ans;
	}

	public void backTrack (int[] nums, List<List<Integer>> ans, List<Integer> cur, int start) {
		ans.add(new ArrayList<>(cur));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) continue;
			cur.add(nums[i]);
			backTrack(nums, ans, cur, i + 1);
			cur.remove(cur.size() - 1);
		}
	}
	
}
