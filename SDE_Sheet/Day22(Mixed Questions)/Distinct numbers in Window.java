Distinct numbers in Window.
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.



Input Format
First argument is an integer array A
Second argument is an integer B.



Output Format
Return an integer array.

Example Input
Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3
Input 2:

 A = [1, 1, 2, 2]
 B = 1


Example Output
Output 1:

 [2, 3, 3, 2]
Output 2:

 [1, 1, 1, 1]


Example Explanation
Explanation 1:

 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].
Explanation 2:

 Window size is 1, so the output array is [1, 1, 1, 1].
Hint1:If you have solution for window [i, i+k-1], can you quickly build solution for window [i+1, i+k], using some data structure?
What could be this data structure? A data structure which can store distinct elements(and their count?)?
Hint2:If you have solution for window [i, i+k-1], can you quickly build solution for window [i+1, i+k]?
If we have a data structure where we can maintain count of all keys and number of distinct keys,
then we just have to reduce count of key A[i] and increasing count of A[i+k]. If count of some key has been reduced to zero, we need to remove that key.
This structure is a hashmap. All operations that we have said a constant time in it.

public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) 
    {
        ArrayList<Integer> arr=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        
        for(int i=0;i<B;i++)
        {
             hm.put(A.get(i), hm.getOrDefault(A.get(i), 0) + 1);  
        }
        
          arr.add(hm.size());
          
          for(int i=B;i<A.size();i++)
    {
        if(hm.get(A.get(i-B))==1)
        {
            hm.remove(A.get(i-B));
        }
        else
        {
            hm.put(A.get(i-B),hm.get(A.get(i-B))-1);
        }
        
        hm.put(A.get(i), hm.getOrDefault(A.get(i), 0) + 1);
        
        arr.add(hm.size());
    }
        
      return arr;  
    }
}
