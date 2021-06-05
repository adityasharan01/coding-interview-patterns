Largest rectangle in histogram
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
  
  //Simple Solution
import java.io.*;
import java.util.*;

class GFG {
    
    public static int getMaxArea(int arr[],int n){
         int res=0;
        for(int i=0;i<n;i++){
            int curr=arr[i];
            for(int j=i-1;j>=0;j--){
                if(arr[j]>=arr[i])curr+=arr[i];
                else break;
            }
            for(int j=i+1;j<n;j++){
                if(arr[j]>=arr[i])curr+=arr[i];
                else break;
            }
            res=Math.max(res,curr);
        }
        return res;
    
    }
	public static void main (String[] args) {
	
	    int[] arr=new int[]{6,2,5,4,1,5,6};
        
        System.out.print("Maximum Area: "+getMaxArea(arr,arr.length));   
	  
	}
	
}
//Better SOlution 
  import java.io.*;
import java.util.*;

class GFG {
    
    public static int getMaxArea(int arr[],int n){
         int res=0;
         int[] ps=new int[n];int[] ns=new int[n];
    
        Stack <Integer> s=new Stack<>();
        s.add(0);
        for(int i=0;i<n;i++){
            while(s.isEmpty()==false && arr[s.peek()]>=arr[i])
                s.pop();
            int pse=s.isEmpty()?-1:s.peek();
            ps[i]=pse;
            s.push(i);
        }
        
        while(s.isEmpty()==false){
            s.pop();
        }
        
        s.push(n-1);
        for(int i=n-1;i>0;i--){
            while(s.isEmpty()==false && arr[s.peek()]>=arr[i])
                s.pop();
            int nse=s.isEmpty()?n:s.peek();
            ns[i]=nse;
            s.add(i);
        }
        
        for(int i=0;i<n;i++){
            int curr=arr[i];
            curr+=(i-ps[i]-1)*arr[i];
            curr+=(ns[i]-i-1)*arr[i];
            res=Math.max(res,curr);
        }
        return res;
    
    }
	public static void main (String[] args) {
	
	    int[] arr=new int[]{6,2,5,4,1,5,6};
        
        System.out.print("Maximum Area: "+getMaxArea(arr,arr.length));   
	  
	}
	
}
  //Efficient Solution
import java.io.*;
import java.util.*;

class GFG {
    
    public static int getMaxArea(int arr[],int n){
        Stack <Integer> s=new Stack<>();
        int res=0;
        int tp;
        int curr;
        for(int i=0;i<n;i++){
            while(s.isEmpty()==false && arr[s.peek()]>=arr[i]){
                tp=s.peek();s.pop();
                curr=arr[tp]* (s.isEmpty() ? i : i - s.peek() - 1);
                res=Math.max(res,curr);
            }
            s.add(i);
        }
        while(s.isEmpty()==false){
            tp=s.peek();s.pop();
            curr=arr[tp]* (s.isEmpty() ? n : n - s.peek() - 1);
            res=Math.max(res,curr);
        }
        
        return res;
    
    }
	public static void main (String[] args) {
	
	    int[] arr=new int[]{6,2,5,4,1,5,6};
        
        System.out.print("Maximum Area: "+getMaxArea(arr,arr.length));   
	  
	}
	
}
