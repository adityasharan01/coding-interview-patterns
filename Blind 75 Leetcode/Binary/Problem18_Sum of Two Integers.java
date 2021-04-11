Given two integers a and b, return the sum of the two integers without using the operators + and -.

 

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5
 

Constraints:

-1000 <= a, b <= 1000
 Approach :

  Given two numbers a and b, a&b returns the number formed by '1' bits on a and b. When it is left shifted by 1 bit, it is the carry.

For example, given a=101 and b=111 (in binary), the a&b=101. a&b << 1 = 1010.

a^b is the number formed by different bits of a and b. a&b=10.
  
  public int getSum(int a, int b) {
 
   while(b!=0){
       int c = a&b;
       a=a^b;
       b=c<<1;
   }
 
   return a;
}
  
