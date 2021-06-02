Given a number, find the greatest number less 
than the given a number which is the power of two or find the most significant bit number .

Examples: 

Input : 10
Output : 8
Greatest number which is a Power of 2 less than 10 is 8
Binary representation of 10 is 1010
The most significant bit corresponds
to decimal number 8.

Input : 18
Output : 16 
  
  import java.io.*;
 
class GFG {
    static int setBitNumber(int n)
    {
        if (n == 0)
            return 0;
 
        int msb = 0;
        n = n / 2;
 
        while (n != 0) {
            n = n / 2;
            msb++;
        }
 
        return (1 << msb);
    }
 
    // Driver code
    public static void main(String[] args)
    {
        int n = 0;
        System.out.println(setBitNumber(n));
    }
}
 
