import java.util.*;

class Solution {
    public int solve(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
   
}
We can use xor operation. If there bit is same, xor operations results 0, otherwise, it results 1

Implementation
Xor 2 numbers
Use the bit count built in function in Java

Best way is to XOR the two numbers this gives us a number and then count the number of 1's in the number.

Implementation
import java.util.*;

class Solution {
    public int solve(int x, int y) {
        int k = x ^ y;
        int cnt = 0;
        while (k > 0) {
            cnt += (k % 2);
            k /= 2;
        }
        return cnt;
    }
}
