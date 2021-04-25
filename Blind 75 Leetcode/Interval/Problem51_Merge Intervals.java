Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
  
  
 
Approach:-
 The key to solve this problem is defining a Comparator first to sort the arraylist of Intevals.
Java Solution:-
 public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                if (i1.start != i2.start) {
                    return i1.start - i2.start;
                }
                else {
                    return i1.end - i2.end;
                }
            }
        });
        List<Interval> result = new LinkedList<Interval>();
        Interval curr = null;
        for (Interval inter:intervals) {
            if (curr == null) {
                curr = inter;
                continue;
            }
            if (inter.start > curr.end) {
                result.add(curr);
                curr = inter;
            }
            else {
                curr.end = Math.max(curr.end, inter.end);
            }
        }
        if (curr != null) {
            result.add(curr);
        }
        return result;
    }
}
 
 
 ///////////////////////////////
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        int size = 0;
        int point1 = intervals[0][0];
        int point2 = intervals[0][1];
        for(int i = 1; i<intervals.length; i++) {
            if(point2>=intervals[i][0]) {
                if(point2<=intervals[i][1]) {
                    point2 = intervals[i][1];
                }
            } else {
                intervals[size][0] = point1;
                intervals[size][1] = point2;
                size++;
                point1 = intervals[i][0];
                point2 = intervals[i][1];
            }
        }
        intervals[size][0] = point1;
        intervals[size][1] = point2;
        return Arrays.copyOf(intervals, size+1);
    }
}


Python Aprroach :-
      class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        
        i = intervals
        
        i.sort(key=lambda x:x[0])
        
        res = [intervals[0]]
        
        for pos in range(1, len(i)):
            
            # no overlap:
            if res[-1][1] < i[pos][0]:
                res.append(i[pos])
            
            # partial overlap
            elif res[-1][1] >= i[pos][0] and res[-1][1] <= i[pos][1]:
                merged = [res[-1][0], i[pos][1]]
                res.pop(-1)
                res.append(merged)
            
        return res
