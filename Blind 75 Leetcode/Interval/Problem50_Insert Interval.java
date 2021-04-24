Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
Example 3:

Input: intervals = [], newInterval = [5,7]
Output: [[5,7]]
Example 4:

Input: intervals = [[1,5]], newInterval = [2,3]
Output: [[1,5]]
Example 5:

Input: intervals = [[1,5]], newInterval = [2,7]
Output: [[1,7]]
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= intervals[i][0] <= intervals[i][1] <= 105
intervals is sorted by intervals[i][0] in ascending order.
newInterval.length == 2
0 <= newInterval[0] <= newInterval[1] <= 105
  
  
  class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    LinkedList<int[]> merged = new LinkedList<>();
    boolean inserted = false;
    
    for(int i = 0; i < intervals.length; i++){
      if(!inserted){
        //new is after current
        if(newInterval[0] > intervals[i][1]){
          merged.add(intervals[i]);
        }
        //new is before current
        else if(newInterval[1] < intervals[i][0]){
          merged.add(newInterval);
          merged.add(intervals[i]);
          inserted = true;
        }
        //there is overlap between the newInterval and the current interval
        else{
          int lo = Math.min(newInterval[0], intervals[i][0]);
          int hi = Math.max(newInterval[1], intervals[i][1]);
          merged.add(new int[]{lo,hi});
          inserted = true;
        }
      }
      else{
        //there is overlap between the last inserted interval and the current interval
        if(merged.getLast()[1] >= intervals[i][0]){
          merged.getLast()[1] = Math.max(merged.getLast()[1], intervals[i][1]);
        }
        //No overlap, we just add the current interval
        else{
          merged.add(intervals[i]);
        }
      }
    }
    
    if(!inserted){
      merged.add(newInterval);
    }
    
    return merged.toArray(new int[merged.size()][]);
  }
}



Java Solution 2 - Binary Search

If the intervals list is an ArrayList, we can use binary search to make the best search time complexity O(log(n)). However, the worst time is bounded by shifting the array list if a new range needs to be inserted. So time complexity is still O(n).

public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> result = new ArrayList<>();
 
    if (intervals.size() == 0) {
        result.add(newInterval);
        return result;
    }
 
    int p = helper(intervals, newInterval);
    result.addAll(intervals.subList(0, p));
 
    for (int i = p; i < intervals.size(); i++) {
        Interval interval = intervals.get(i);
        if (interval.end < newInterval.start) {
            result.add(interval);
        } else if (interval.start > newInterval.end) {
            result.add(newInterval);
            newInterval = interval;
        } else if (interval.end >= newInterval.start || interval.start <= newInterval.end) {
            newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
        }
    }
 
    result.add(newInterval);
 
    return result;
}
 
public int helper(List<Interval> intervals, Interval newInterval) {
    int low = 0;
    int high = intervals.size() - 1;
 
    while (low < high) {
        int mid = low + (high - low) / 2;
 
        if (newInterval.start <= intervals.get(mid).start) {
            high = mid;
        } else {
            low = mid + 1;
        }
    }
 
    return high == 0 ? 0 : high - 1;
}
The best time is O(log(n)) and worst case time is O(n)
