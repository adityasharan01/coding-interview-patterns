


Approach 1:
Java Solution 1 - Math

public int missingNumber(int[] nums) {
    int sum=0;
    for(int i=0; i<nums.length; i++){
        sum+=nums[i];
    }
 
    int n=nums.length;
    return n*(n+1)/2-sum;
}

Approach 2:
Java Solution 2 - Binary Search

public int missingNumber(int[] nums) {
   Arrays.sort(nums);
   int l=0, r=nums.length;
   while(l<r){
       int m = (l+r)/2;
       if(nums[m]>m){
           r=m;
       }else{
           l=m+1;
       }
   }
 
   return r;
}
Approach 3:
class Solution {
public int missingNumber(int[] nums) {

    int n = nums.length;
    int actualSum = 0;
    
    int expectedSum = n * (n + 1) / 2;
           
    
    for(int i : nums)
        actualSum = actualSum + i;
    
    return expectedSum - actualSum;
}
}
