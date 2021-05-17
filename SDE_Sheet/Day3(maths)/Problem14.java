Pow(x, n)
  
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104
  
  //Approach1:
public class Solution {
    public double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }
}
//////////////
public double myPow(double x, int n) {
    // special case
    if (x == 0 || x == 1 || n == 1) {return x;}
    else if (n == 0) {return 1;}
    // negative result
    if (x < 0 && n % 2 != 0) {return -myPow(-x, n);}
    else if (x < 0 && n % 2 == 0) {return myPow(-x, n);}
    // fractor result
    if (n < 0) {return 1/myPow(x, -n);}
    // main calculation
    return helper(x, n);
}
private double helper(double x, int n) {
    // precondition: x > 0 && n > 0
    if (n == 1) {return x;}
    return (((n % 2) == 0)? helper(x*x, n/2): (helper(x*x, n/2)*x));
}
my idea is:

firstly, consider all special case and try to make the input x and n as positive number
use the idea of binary search. it will decrease the n. Even though the x will increase, the total amount of calculation still decreases.
