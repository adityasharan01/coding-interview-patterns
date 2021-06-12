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
 

Constraints:

1 <= startTime.length == endTime.length == profit.length <= 5 * 104
1 <= startTime[i] < endTime[i] <= 109
1 <= profit[i] <= 104
    Hints:
  Think on DP.
  Sort the elements by starting time, then define the dp[i] as the maximum profit taking elements from the suffix starting at i.
  Use binarySearch (lower_bound/upper_bound on C++) to get the next index for the DP transition.
 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	  DP

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i<startTime.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
		//sort by end time
        Arrays.sort(jobs, new Comparator<int[]>() {
            public int compare (int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        //define: dp[n] max profix when there are n jobs available
        //substructure: dp[i] = max(profix of current job + dp[prevjob that can fit in current's schedule], dp[i-1])
        int[] dp = new int[jobs.length + 1];
        for (int i = 1; i<dp.length; i++) {
            int prev = find(jobs, i-1);
            int prevPorfix = prev == -1? 0:dp[prev + 1];
            dp[i] = Math.max(prevPorfix + jobs[i-1][2], dp[i-1]);
        }
        return dp[jobs.length];
    }
    
    public int find(int[][] jobs, int index) {
        int start = 0;
        int end = jobs.length - 1;
        while (start + 1 < end) {
            int mid = (start + end)/2;
            if (jobs[mid][1] > jobs[index][0]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (jobs[end][1] <= jobs[index][0]) {
            return end;
        } else if (jobs[start][1] <= jobs[index][0]) {
            return start;
        } else {
            return -1;
        }
    }
}
dfs

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i<startTime.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        
        //sort by start time
        Arrays.sort(jobs, new Comparator<int[]>() {
            public int compare (int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        return dfs(jobs, 0, new HashMap<>());
    }
    
    public int dfs(int[][] jobs, int index, Map<Integer, Integer> map) {
        if (map.containsKey(index)) {
            return map.get(index);
        }
        if (index == jobs.length) {
            return 0;
        }
        
        // choose
        int next = findFirstOne(jobs, index);
        int choose = jobs[index][2] + (next == -1? 0: dfs(jobs, next, map));
        
        // not choose
        int notChoose = dfs(jobs, index + 1, map);
        
        int result = Math.max(choose, notChoose);
        map.put(index, result);
        
        return result;
    }
    
    //find first job that has a start time larger or equal than the end of the current job
    public int findFirstOne(int[][] jobs, int index) {
        int start = index+1;
        int end = jobs.length - 1;
        while (start + 1 < end) {
            int mid = (start + end)/2;
            if (jobs[mid][0] >= jobs[index][1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (start < jobs.length && jobs[start][0] >= jobs[index][1]) {
            return start;
        } else if (end > index && jobs[end][0] >= jobs[index][1]) {
            return end;
        } else {
            return -1;
        }
    }
}
Always worry about that i can't come up with a DP solution. So practice every question with DFS if I can 
      
    ////////////////////////////////////////////////////////////////////////ANOTHER SOLUTION /////////////////////////////////////////////////////
    
    class Job{

int start;
int end;
int profit;
Job(int start,int end,int profit){
    this.start = start;
    this.end = end;
    this.profit = profit;
}
}
class Solution {

public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int n=profit.length;
    List<Job> jobs=new ArrayList<>();
    for(int i=0;i<n;i++)
        jobs.add(new Job(startTime[i],endTime[i],profit[i]));
    jobs.sort(Comparator.comparingInt(o->o.start));
    int[] dp=new int[n];
    Arrays.fill(dp,-1);
    return maxProfit(jobs,dp,0);
}
int maxProfit(List<Job> jobs,int[] dp,int index){
    int n=jobs.size();
    if(index==n || index==-1)
        return 0;
    if(dp[index] != -1)
        return dp[index];
    int maxProfit=0;
    int selectJobProfit = jobs.get(index).profit + maxProfit(jobs,dp,nextIndex(jobs,index+1,jobs.get(index).end));
    int skipJobProfit=maxProfit(jobs,dp,index+1);
    maxProfit=Math.max(selectJobProfit,skipJobProfit);
    dp[index]=maxProfit;
    return maxProfit;
}
int nextIndex(List<Job> jobs,int start,int target){
    int high=jobs.size()-1;
    int result=-1;
    while(start<=high){
        int mid=start+(high-start)/2;
        if(jobs.get(mid).start<target)
            start=mid+1;
        else{
            result=mid;
            high=mid-1;
        }
    }
    return result;
}
}


 
