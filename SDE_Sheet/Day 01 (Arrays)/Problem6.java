Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8}}. The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. Similarly, {5, 7} and {6, 8} should be merged and become {5, 8}

Write a function that produces the set of merged intervals for the given set of intervals. 
A simple approach is to start from the first interval and compare it with all other intervals for overlapping, if it overlaps with any other interval, then remove the other interval from the list and merge the other into the first interval. Repeat the same steps for remaining intervals after first. This approach cannot be implemented in better than O(n^2) time.
An efficient approach is to first sort the intervals according to the starting time. Once we have the sorted intervals, we can combine all intervals in a linear traversal. The idea is, in sorted array of intervals, if interval[i] doesn’t overlap with interval[i-1], then interval[i+1] cannot overlap with interval[i-1] because starting time of interval[i+1] must be greater than or equal to interval[i]. Following is the detailed step by step algorithm. 
 

1. Sort the intervals based on increasing order of 
    starting time.
2. Push the first interval on to a stack.
3. For each interval do the following
   a. If the current interval does not overlap with the stack 
       top, push it.
   b. If the current interval overlaps with stack top and ending
       time of current interval is more than that of stack top, 
       update stack top with the ending  time of current interval.
4. At the end stack contains the merged intervals.

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
public class MergeOverlappingIntervals {
 
    // The main function that takes a set of intervals, merges
    // overlapping intervals and prints the result
    public static void mergeIntervals(Interval arr[])
    {
        // Test if the given set has at least one interval
        if (arr.length <= 0)
            return;
   
        // Create an empty stack of intervals
        Stack<Interval> stack=new Stack<>();
   
        // sort the intervals in increasing order of start time
        Arrays.sort(arr,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return i1.start-i2.start;
            }
        });
   
        // push the first interval to stack
        stack.push(arr[0]);
   
        // Start from the next interval and merge if necessary
        for (int i = 1 ; i < arr.length; i++)
        {
            // get interval from stack top
            Interval top = stack.peek();
   
            // if current interval is not overlapping with stack top,
            // push it to the stack
            if (top.end < arr[i].start)
                stack.push(arr[i]);
   
            // Otherwise update the ending time of top if ending of current
            // interval is more
            else if (top.end < arr[i].end)
            {
                top.end = arr[i].end;
                stack.pop();
                stack.push(top);
            }
        }
   
        // Print contents of stack
        System.out.print("The Merged Intervals are: ");
        while (!stack.isEmpty())
        {
            Interval t = stack.pop();
            System.out.print("["+t.start+","+t.end+"] ");
        } 
    } 
 
    public static void main(String args[]) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
    }
}
 
class Interval
{
    int start,end;
    Interval(int start, int end)
    {
        this.start=start;
        this.end=end;
    }
}


A O(n Log n) and O(1) Extra Space Solution 
The above solution requires O(n) extra space for the stack. We can avoid the use of extra space by doing merge operations in-place. Below are detailed steps. 



1) Sort all intervals in increasing order of start time.
2) Traverse sorted intervals starting from first interval, 
   do following for every interval.
      a) If current interval is not first interval and it 
         overlaps with previous interval, then merge it with
         previous interval. Keep doing it while the interval
         overlaps with the previous one.         
      b) Else add current interval to output list of intervals.
      
      
   import java.util.Arrays;
import java.util.Comparator;
 
// An Interval
class Interval
{
    int start,end;
     
    Interval(int start, int end)
    {
        this.start=start;
        this.end=end;
    }
}
 
public class MergeOverlappingIntervals {
     
    // Function that takes a set of intervals, merges
    // overlapping intervals and prints the result
    public static void mergeIntervals(Interval arr[])
    {
        // Sort Intervals in decreasing order of
        // start time
        Arrays.sort(arr,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return i2.start - i1.start;
            }
        });
   
        int index = 0; // Stores index of last element
        // in output array (modified arr[])
   
        // Traverse all input Intervals
        for (int i=1; i<arr.length; i++)
        {
            // If this is not first Interval and overlaps
            // with the previous one
            if (arr[index].end >=  arr[i].start)
            {
                   // Merge previous and current Intervals
                arr[index].end = Math.max(arr[index].end, arr[i].end);
                arr[index].start = Math.min(arr[index].start, arr[i].start);
            }
            else {
                index++;
                arr[index] = arr[i];
            }   
        }
         
        // Now arr[0..index-1] stores the merged Intervals
        System.out.print("The Merged Intervals are: ");
        for (int i = 0; i <= index; i++)
        {
            System.out.print("[" + arr[i].start + ","
                                        + arr[i].end + "]");
        }
    }
 
    // Driver Code
    public static void main(String args[]) {
        Interval arr[]=new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        mergeIntervals(arr);
    }
}
