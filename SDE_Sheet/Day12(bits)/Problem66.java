Program to find whether a no is power of two
Difficulty Level : Easy
Last Updated : 05 Apr, 2021
Given a positive integer, write a function to find if it is a power of two or not.
Examples : 

Input : n = 4
Output : Yes
22 = 4

Input : n = 7
Output : No

Input : n = 32
Output : Yes
25 = 32
  
  //count of set bit should be one 
  import java.io.*;
 
class countSetBits {
    /* Function to get no of set
    bits in binary representation
    of positive integer n */
    static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
 
    // driver program
    public static void main(String args[])
    {
        int i = 9;
        System.out.println(countSetBits(i));
    }
}

//////////////////////
class GFG
{
/* Function to check if x is power of 2*/
static boolean isPowerOfTwo(int n)
{
    if(n==0)
    return false;
 
return (int)(Math.ceil((Math.log(n) / Math.log(2)))) ==
       (int)(Math.floor(((Math.log(n) / Math.log(2)))));
}
 
// Driver Code
public static void main(String[] args)
{
    if(isPowerOfTwo(31))
    System.out.println("Yes");
    else
    System.out.println("No");
     
    if(isPowerOfTwo(64))
    System.out.println("Yes");
    else
    System.out.println("No");
}
}


Another solution is to keep dividing the number by two, i.e, do n = n/2 
 iteratively. In any iteration, if n%2 becomes non-zero and n is not 1
 then n is not a power of 2. If n becomes 1 then it is a power of 2. 
   
 import java.io.*;
 
class GFG {
 
    // Function to check if
    // x is power of 2
    static boolean isPowerOfTwo(int n)
    {
        if (n == 0)
            return false;
         
        while (n != 1)
        {
            if (n % 2 != 0)
                return false;
            n = n / 2;
        }
        return true;
    }
 
    // Driver program
    public static void main(String args[])
    {
        if (isPowerOfTwo(31))
            System.out.println("Yes");
        else
            System.out.println("No");
 
        if (isPowerOfTwo(64))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
