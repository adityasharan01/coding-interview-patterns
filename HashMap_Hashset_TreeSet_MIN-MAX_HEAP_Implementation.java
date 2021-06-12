import java.util.*;
//Hashset Implementation
class Solution {
    public boolean solve(String s) {
        HashSet<Character> charsSeen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (charsSeen.contains(c))
                return false;
            charsSeen.add(c);
        }
        return true;
    }
    }

//HashMap Implementation 
public int solve(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (hm.containsKey(num)) {
                int curr = hm.get(num) + 1;
                hm.put(num, curr);
                max = Math.max(max, curr);
            } else {
                hm.put(num, 1);
                max = Math.max(max, 1);
            }
        }
        return max;

HashMap<String,Integer> hm = new HashMap<>();
    for(String s2:s1){
        if(hm.containsKey(s2))
            return false;
        else
            hm.put(s2,1);    
    }
    return true;

//Another hashmap implementation
if (!wordCounts.containsKey(word))
wordCounts.put(word, 1);
else
wordCounts.put(word, wordCounts.get(word) + 1);
    
 //Looping in Hashmap
    for(Character key:hm.keySet()){
        if(hm.get(key)> mf){
            mf=key;
        }
    }
    //////////////////////////////////////////////////////////
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

