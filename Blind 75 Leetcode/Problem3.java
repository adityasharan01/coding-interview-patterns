Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
  
  public boolean containsDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
        for (int j = 0; j < i; ++j) {
            if (nums[j] == nums[i]) return true;  
        }
    }
    return false;
}
// Time Limit Exceeded


Intuition

Utilize a dynamic data structure that supports fast search and insert operations.

Algorithm

From Approach #1 we know that search operations is O(n)O(n) in an unsorted array and we did so repeatedly. Utilizing a data structure with faster search time will speed up the entire algorithm.

There are many data structures commonly used as dynamic sets such as Binary Search Tree and Hash Table. The operations we need to support here are search() and insert(). For a self-balancing Binary Search Tree (TreeSet or TreeMap in Java), search() and insert() are both O(\log n)O(logn) time. For a Hash Table (HashSet or HashMap in Java), search() and insert() are both O(1)O(1) on average. Therefore, by using hash table, we can achieve linear time complexity for finding the duplicate in an unsorted array.

Java

public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>(nums.length);
    for (int x: nums) {
        if (set.contains(x)) return true;
        set.add(x);
    }
    return false;
}
Complexity Analysis

Time complexity : O(n)O(n). We do search() and insert() for nn times and each operation takes constant time.

Space complexity : O(n)O(n). The space used by a hash table is linear with the number of elements in it.
