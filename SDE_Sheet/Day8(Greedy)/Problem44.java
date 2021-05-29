We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

 

Example 1:



Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
Example 2:



Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.
Example 3:



Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
  
//java dp + binary search runtime O(nlogn)
  class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // dp approach + binary search
        // sort the jobs by endTime
        // for job i, consider two scenarios: 1)  job i is used; 2) job i is not used
        // dp[i] = max(dp[i - 1], dp[j] + profit[i]) where j is the largest index of the job not overlapping with job i
		// to search for j efficiently, use binary search to reduce time complexity 
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, new jobComparator());
        
        int res = 0;
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            int left = 0;
            int right = i - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (jobs[mid][1] > jobs[i][0]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // left is the index of the 1st job that overlaps with current job i, so the actual index we need is (left - 1) 
			// if (left - 1 < 0), it means such a valid job does not exist
            if (left - 1 < 0) {
                dp[i] = Math.max(dp[i - 1], jobs[i][2]);
            } else {
                dp[i] = Math.max(dp[i - 1], jobs[i][2] + dp[left - 1]);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    
    class jobComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
}
  //Java - Recursive with Memoization and Binary Search
class Job {
  int start;
  int end;
  int profit;
  Job(int start, int end, int profit) {
    this.start = start;
    this.end = end;
    this.profit = profit;
  }
}
class Solution {
  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int n = profit.length;
    List<Job> jobs = new ArrayList<>();
    for (int i = 0; i < n; i++) 
      jobs.add(new Job(startTime[i], endTime[i], profit[i]));
    
    Collections.sort(jobs, (a,b) -> Integer.compare(a.start,b.start));
    int[] memo = new int[n];
    Arrays.fill(memo, -1);
    return maxProfit(jobs, memo, 0);
  }
  private int maxProfit(List<Job> jobs, int[] memo, int index) {
    int n = jobs.size();
    if (index == n || index == -1)
      return 0;
    if (memo[index] != -1)
      return memo[index];
    
    int maxProfit = 0;
    int workProfit = jobs.get(index).profit + maxProfit(jobs, memo, findNextJob(jobs, jobs.get(index).end, index + 1));
    int skipProfit = maxProfit(jobs, memo, index + 1);
    maxProfit = Math.max(workProfit, skipProfit);
    memo[index] = maxProfit;
    return maxProfit;
  }
  // Binary Search
  private int findNextJob(List<Job> jobs, int target, int prevIndex) {
    int low = prevIndex;
    int high = jobs.size() - 1;
    int result = -1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (jobs.get(mid).start < target) {
        low = mid + 1;
      } else {
        result = mid;
        high = mid - 1;
      }
    }
    return result;
  } 
}
