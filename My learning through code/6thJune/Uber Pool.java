You are given a two-dimensional integer list requested_trips containing [start_x, end_x, num_passengers], and an integer capacity. Each requested trip asks to pick up num_passengers passenger at start_x and drop them off at end_x. You also have a car with the given capacity, and start at x = 0.

Given that you'd like to pick up every passenger and can only move right, return whether you can pick up and drop off everyone.

Constraints

n ≤ 100,000 where n is the length of requested_trips
Example 1
Input
trips = [
    [1, 30, 2],
    [3, 5, 3],
    [5, 9, 3]
]
capacity = 6
Output
true
Hint 1:Think of intervals and sorting
Hint 2:Priority queue
Hint 3:sweep line

Intuition
Sort our array base on start time
Drop people base on the end time

Implementation
Sort the array base on start time
Traverse our array and pick the people. We can drop those people whose end time is less than the current start time, which we store them in a heap
Update the current capacity to see if it is exceed the limit
Time Complexity
\mathcal{O}(nlogn)O(nlogn) For either the sorting or the query by heap, it is O(nlogn) in total

Space Complexity
\mathcal{O}(n)O(n). We use a heap to store people's end time
  
Solution:
import java.util.*;

class Solution {
    public boolean solve(int[][] A, int cap) {
        Arrays.sort(A, (a, b) -> { return a[0] - b[0]; });

        int cur = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> { return a[0] - b[0]; });
        for (int i = 0; i < A.length; i++) {
            while (pq.size() > 0 && pq.peek()[0] <= A[i][0]) {
                int top[] = pq.poll();
                cur -= top[1];
            }

            pq.add(new int[] {A[i][1], A[i][2]});
            cur += A[i][2];
            if (cur > cap)
                return false;
        }
        return true;
    }
}

//Method 2:
Intuition
For every trip maintain the number of passengers onboard and also maintain the drop off points in sorted order. At every starting point drop off the passengers who's end point is less than or equal to current starting point. After processing all drop offs, Check if the number of onboard count including new passengers at current point exceeds the capacity, if exceeds return false otherwise proceed next.

Implementation
Maintain current onboard count in an integer variable and all drop offs in a min heap. For every starting point, process all the drop offs whos end point is less than current starting point in a while loop. Check if the current pool including new passengers at current location exceeds capacity, if yes, return false otherwise proceed next;

Time Complexity
\mathcal{O}(n\log n )O(nlogn) where n is the number of trips

Space Complexity
\mathcal{O}(n)O(n) where n is the number of drop offs

import java.util.*;

class Solution {
    public boolean solve(int[][] trips, int capacity) {
        PriorityQueue<DropPoint> dropQueue =
            new PriorityQueue<DropPoint>((a, b) -> a.point - b.point);

        int currentPool = 0;
        for (int[] trip : trips) {
            int startPoint = trip[0];
            while (!dropQueue.isEmpty() && dropQueue.peek().point <= startPoint) {
                DropPoint nextDrop = dropQueue.poll();
                currentPool -= nextDrop.numberOfPassengers;
            }

            if (currentPool + trip[2] > capacity)
                return false;
            currentPool += trip[2];
            dropQueue.offer(new DropPoint(trip[1], trip[2]));
        }

        return true;
    }
}

class DropPoint {
    int point;
    int numberOfPassengers;

    public DropPoint(int point, int numberOfPassengers) {
        this.point = point;
        this.numberOfPassengers = numberOfPassengers;
    }
}
