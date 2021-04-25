Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Constraints:

1 <= intervals.length <= 2 * 104
intervals[i].length == 2
-2 * 104 <= starti < endi <= 2 * 104
  
  
  
  Approach 1:
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int end = intervals[0][1];
        int count = 0;
        
        for(int i = 1; i<intervals.length; i++) {
            if(end > intervals[i][0]) {
                end = Math.min(end, intervals[i][1]);
                count++;
            }
            else end = intervals[i][1];
        }
        return count;
    }
}
//////////
Approach2:
  
  Thought process:

The idea is to sort the array based on the intervals start points and use a greedy approach.

After the array is sorted, iterate through the array and use a local variable "end" to keep track of the smallest end point of current overlapping intervals. The reason is that we want to delete all overlapping intervals except the one that has the smallest end point, so that the next interval won't overlap with it.

Once we iterate through a group of overlapping intervals, we update "end" to be the end point of the next interval.
  
  /**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length < 2) {
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        int end = intervals[0].end;
        int min = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < end) {
                end = Math.min(end, intervals[i].end);
                min++;
            } else {
                end = intervals[i].end;
            }
        }
        
        return min;
    }
}
 
