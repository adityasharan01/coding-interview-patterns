Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
  
  
  Approach :
We are supposed to solve the problem in Time Complexity better than O(nlgn).
If that constraint were not present, here is what can be done.
Use Map (Dictionary) and store the frequency of the number.
Sort the map by values.
Pick only first k objects.
But since, the constraint is present, we can use the following algorithm:
Sample input: [1,1,1,2,2,3] and k = 2
Use map/dictionary and store the frequency of the number and maximum frequency of all the numbers.
So at the end of this operation, for the sample problem, map would look like this: 1 → 3, 2 → 2, 3 →1. Also, maximum frequency will be 3.
Now, since, we cannot use regular sorting approach, another thing that comes to mind is, bucket sort.
Create a multi-storage bucket with (maximum frequency + 1)as its size. Now, based on frequency of the word, put it in the appropriate bucket level. In our example, Put 1 at level 3, put 2 at level 2 and put 3 at level 1.
There might be more than one numbers with the same frequency. So, we can use linked list to store more than one elements at the same level.
Now, iterate over the bucket elements and keep a counter to match with the input value k.
  
  
  public List<Integer> topKFrequent(int[] nums, int k) {
        
        int len = nums.length;
        int maxFreq = 0;
        
        // Algo - step 1:     
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            
            maxFreq = Math.max(maxFreq, map.get(nums[i]));
        }
        
        // Algo - step 3 and 4: Create bucket of size of max Freq. 
        
        List<Integer> [] bucketList = new LinkedList[maxFreq+1];
        
        for(int i=0; i<= maxFreq; i++) {
            bucketList[i] = new LinkedList<>();
        }
        
        // Put elements in the bucket by iterating over the map.
        for(Integer key : map.keySet()) {
            
            int freq = map.get(key);
            
            bucketList[freq].add(key);
            
        }
  
        // Algo step 5:       
        int ct = 0;
        List<Integer> ans = new LinkedList<>();
        
        for(int i=maxFreq; i>=0; i--) {
                
            List<Integer> currentList = bucketList[i];
            
            for(Integer j: currentList) {
                if(ct < k) {
                    ans.add(j);   
                    ct++;
                } else {
                    return ans;
                }
            }    
            
        }
        
        return ans;
        
        
    }
