Given an unsorted array Arr of size N of positive integers. One number 'A' from set {1, 2, …N} is missing and one number 'B' occurs twice in array. Find these two numbers.

Example 1:

Input:
N = 2
Arr[] = {2, 2}
Output: 2 1
Explanation: Repeating number is 2 and 
smallest positive missing number is 1.
Example 2:

Input:
N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findTwoElement() which takes the array of integers arr and n as parameters and returns an array of integers of size 2 denoting the answer ( The first index contains B and second index contains A.)
  
  
class Solve {
    int[] findTwoElement(int arr[], int n) 
    {
        // code here
        int ans[]=new int[n+1];
        
        Arrays.fill(ans,0);
        ans[0]=1;
        for(int i=0;i<n;i++)
        {
            ans[arr[i]]++;
        }
        
        int final_ans[]=new int[2];
        for(int i=1;i<ans.length;i++)
        {
            if(ans[i]==0)
            final_ans[1]=i;
            if(ans[i]>=2)
            final_ans[0]=i;
        }
        return final_ans;
    }
}

//Approach 2:
//Approach:Let x and y be the desired output elements. Calculate XOR of all the array elements.
xor1 = arr[0]^arr[1]^arr[2]…..arr[n-1]

XOR the result with all numbers from 1 to n
xor1 = xor1^1^2^…..^n

In the result xor1, all elements would nullify each other except x and y. All the bits that are set in xor1 will be set in either x or y. So if we take any set bit (We have chosen the rightmost set bit in code) of xor1 and divide the elements of the array in two sets – one set of elements with same bit set and other set with same bit not set. By doing so, we will get x in one set and y in another set. Now if we do XOR of all the elements in first set, we will get x, and by doing same in other set we will get y. 
class GFG {
    static int x, y;
  
    static void getTwoElements(int arr[], int n)
    {
        /* Will hold xor of all elements
       and numbers from 1 to n  */
        int xor1;
  
        /* Will have only single set bit of xor1 */
        int set_bit_no;
  
        int i;
        x = 0;
        y = 0;
  
        xor1 = arr[0];
  
        /* Get the xor of all array elements  */
        for (i = 1; i < n; i++)
            xor1 = xor1 ^ arr[i];
  
        /* XOR the previous result with numbers from 
       1 to n*/
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;
  
        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = xor1 & ~(xor1 - 1);
  
        /* Now divide elements into two sets by comparing
    rightmost set bit of xor1 with the bit at the same 
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements. The 
    following two for loops serve the purpose */
        for (i = 0; i < n; i++) {
            if ((arr[i] & set_bit_no) != 0)
                /* arr[i] belongs to first set */
                x = x ^ arr[i];
  
            else
                /* arr[i] belongs to second set*/
                y = y ^ arr[i];
        }
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0)
                /* i belongs to first set */
                x = x ^ i;
  
            else
                /* i belongs to second set*/
                y = y ^ i;
        }
  
        /* *x and *y hold the desired output elements */
    }
 
