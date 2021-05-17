Count Inversions
iven an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 

Example 1:

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 
has three inversions (2, 1), (4, 1), (4, 3).
Example 2:

Input: N = 5
arr[] = {2, 3, 4, 5, 6}
Output: 0
Explanation: As the sequence is already 
sorted so there is no inversion count.
Example 3:

Input: N = 3, arr[] = {10, 10, 10}
Output: 0
Explanation: As all the elements of array 
are same, so there is no inversion count.
Your Task:
You don't need to read input or print anything. Your task is to complete the function inversionCount() which takes the array arr[] and the size of the array as inputs and returns the inversion count of the given array.

Expected Time Complexity: O(NLogN).
Expected Auxiliary Space: O(N).
  
  
class Inversion_of_Array
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    
    static long inversionCount(long arr[], long N)
    {
        long count=0;
       long temp[]=new long[(int)N];
     count=merge(arr,temp,0,N-1);
     return count;
        
    }
            static long merge(long arr[],long temp[], long left, long right)
            {
                long mid,count=0;
               
                if(left<right)
                {
                    mid=(left+right)/2;  
                count=merge(arr,temp,left,mid);
                count=count+merge(arr,temp,mid+1,right);
                count=count+merge_sort(arr,temp,left,mid,right);
                }
                return count;
            }
            static long merge_sort(long arr[],long temp[],long left,long mid,long right)
            {
                long count=0;
                long i=left;
                long j=mid+1;
                long k=left;
                while(i<=mid&&j<=right)
                {
                    if(arr[(int)i]<=arr[(int)j])
                    {
                        temp[(int)k++]=arr[(int)i++];
                    }
                    else
                    {
                        temp[(int)k++]=arr[(int)j++];
                        count=count+(mid+1-i);
                    }
                }
                while(i<=mid)
                {
                    temp[(int)k++]=arr[(int)i++];
                }
                while(j<=right)
                {
                 temp[(int)k++]=arr[(int)j++];   
                }
                for( i=left;i<=right;i++)
                {
                    arr[(int)i]=temp[(int)i];
                }
                return count;
            }
            
    
