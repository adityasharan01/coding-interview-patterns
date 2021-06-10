There are n workers.  The i-th worker has a quality[i] and a minimum wage expectation wage[i].

Now we want to hire exactly k workers to form a paid group.  When hiring a group of k workers, we must pay them according to the following rules:

Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group.
Every worker in the paid group must be paid at least their minimum wage expectation.
Return the least amount of money needed to form a paid group satisfying the above conditions.

 

Example 1:

Input: quality = [10,20,5], wage = [70,50,30], k = 2
Output: 105.00000
Explanation: We pay 70 to 0-th worker and 35 to 2-th worker.
Example 2:

Input: quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
Output: 30.66667
Explanation: We pay 4 to 0-th worker, 13.33333 to 2-th and 3-th workers seperately. 
 

Note:

1 <= k <= n <= 10000, where n = quality.length = wage.length
1 <= quality[i] <= 10000
1 <= wage[i] <= 10000
Answers within 10-5 of the correct answer will be considered correct.
Let's read description first and figure out the two rules:

"1. Every worker in the paid group should be paid in the ratio of their quality compared to other workers in the paid group."
So for any two workers in the paid group,
we have wage[i] : wage[j] = quality[i] : quality[j]
So we have wage[i] : quality[i] = wage[j] : quality[j]
We pay wage to every worker in the group with the same ratio compared to his own quality.

"2. Every worker in the paid group must be paid at least their minimum wage expectation."
For every worker, he has an expected ratio of wage compared to his quality.

So to minimize the total wage, we want a small ratio.
So we sort all workers with their expected ratio, and pick up K first worker.
Now we have a minimum possible ratio for K worker and we their total quality.

As we pick up next worker with bigger ratio, we increase the ratio for whole group.
Meanwhile we remove a worker with highest quality so that we keep K workers in the group.
We calculate the current ratio * total quality = total wage for this group.

We redo the process and we can find the minimum total wage.
Because workers are sorted by ratio of wage/quality.
For every ratio, we find the minimum possible total quality of K workers.

Time Complexity
O(NlogN) for sort.
O(NlogK) for priority queue.

 // The key to the solution is that Kth ratio (wage / quality) can only satisfy workers with a smaller ratio. 
    // Otherwise, it will break the minimum expectation constraint, since every worker will be sharing the same ratio. 
    // However, you cannot simply pick the first Kth workers. Since if the sum of the quality is super high, 
    // then we would rather have a higher ratio but smaller sum of quality. 
    // Therefore, we are looking for the minimum sum of quality * ratio. Following is how the algorithm works:
    
    // 1. Create an array that stores the ratio (worker[0]) and quality (worker[1]). 
    //     We don't care about the min wage expectation anymore, 
    //     since we are only looking at the workers with a ratio that is smaller than any current ratio, 
    //     and will always satisfy the minimum constraint.
    // 2. Sort the array and start from Kth smallest ratio. 
    //     Otherwise, there won't be enough workers that satisfy with the current ratio (minimum constraint breaks)
    // 3. Keep increase the current ratio with the next worker and find the smallest sum, since both the sum of quality and ratio impacts the result
    // 4. Keep removing the largest quality, since we want the smallest sum of quality and the smallest ratio possible

    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        // ratio (worker[0]) and quality (worker[1])
        double[][] workers = new double[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = (double) quality[i];
        }
        //smallest ratio first, so we can make sure that we don't violate the minimum expectation rule
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        // use a priority queue to remove the larest quality, sorted with the larest quality ahead
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> (int) (b - a));
        double result = Double.MAX_VALUE, qsum = 0;
        for (double[] w : workers) {
            qsum += w[1];
            pq.add(w[1]);
            // if we have more than k workers, remove the one with the largest quality
            if (pq.size() > K) {
                qsum -= pq.poll();
            }
            if (pq.size() == K) {
                result = Math.min(result, qsum * w[0]);
            }
        }
        return result;
    }
