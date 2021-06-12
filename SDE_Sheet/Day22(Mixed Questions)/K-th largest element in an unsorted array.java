K-th largest element in an unsorted array.
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104
  
Personally, the most straightforward way is to use quick select. There is a simple conversion: Find kith largest element is equivalent to find (n - k)th smallest element in array. It is worth mentioning that (n - k) is the real index (start from 0) of an element.

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partion(nums, start, end);
            if (pivot < index) start = pivot + 1; 
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }
    
    private int partion(int[] nums, int start, int end) {
        int pivot = start, temp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }
}
  //Tree Set Implementations
  public int findKthLargest(int[] nums, int k) {
	Set<Integer> set = new TreeSet<>((a, b) -> a.equals(b) ? 1 : b - a);
	for(int i = 0; i < nums.length; i++) set.add(nums[i]);
    return set.toArray(new Integer[0])[k - 1];
}
class Solution {
public int findKthLargest(int[] nums, int k) {
  PriorityQueue pq=new PriorityQueue();
    int l=nums.length;
    for(int i=0;i<l;i++)
    {
        if(i<k)
          pq.add(nums[i]);
        else
        {
          if(nums[i]>pq.peek())
            {
              pq.poll();
              pq.add(nums[i]);
             }
        }
      }
    return pq.peek();
    }
}
//Max Min Heap Implementation
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k>nums.length){
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            for(int i=0;i<nums.length;i++) maxHeap.add(nums[i]);
            for(int i=0;i<k-1;i++) maxHeap.poll();
            return maxHeap.poll();
        }else{
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(int i=0;i<nums.length;i++) minHeap.add(nums[i]);
            for(int i=0;i<nums.length-k;i++) minHeap.poll();
            return minHeap.poll();
        }
    }
}
