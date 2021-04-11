Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Note:

Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 

Example 1:

Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
Example 2:

Input: n = 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
Example 3:

Input: n = 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 

Constraints:

The input must be a binary string of length 32.

 Follow up: If this function is called many times, how would you optimize it?
  ///////////////////////////////////////////
   public class Solution {
    public int hammingWeight(int n) {
        int ans=0;
        while(n!=0)
        {
            ans++;
            n=n&(n-1);
        }
        return ans;
    }
}
   
 /////////////////////////////////////////////    
 Introduction
I will list some of the interesting usage of bitwise operators, which looks complex on first look. But, if you understand them. They are so magically wonderful that they appears to be the most optimized solution of problem.

Some Basics for Bitwise operators
Basic operators are:

& for AND
| for OR
^ for XOR
>> for right shift
<< for left shift
~ for Negate
Left or right shift does not change the signed-bit of a number
Right shift a number is equivalent to divide a number by 2
Left shift a number is equivalent to multiply a number by 2
Solutions
1. Get LSB (Least Significant Digit)
Simply do an & operation with 1 and number.

num & 1
# it will simply return either 0 or 1
2. Counting the number of 1s in a number (Binary)
You need to get the LSB (least significant bit), and check of it is equal to 1.

Code to count number of 1s

public int count1s(int num) {
    int count = 0;
    while (num > 0) {
        //or, you can do if (num & 1 != 0)
        count += num & 1;
        num = num >> 1;
    }
    return count;
}
3. Counting number of 1s in optimized way
Above method will run as many times as number of bits in the number. We could simply jump to 1s in the number. How?

Lets see power of masking. We have to target just the 1-bit. We can reset the 1s on LSB side one by one.

# example: binary representation: 1010
# we want to reset it to 1000

num & (num - 1)
# i.e. 1010 & 1000 = 1000
So, how do we count number of 1s

public int count1s(int num) {
    int count = 0;
    while (num > 0) {
        //or, you can do if (num & 1 != 0)
        count += num & 1;
        num = num & (num - 1);
    }
    return count;
}
4. Swap Bits
Given a number, swap ith and jth bit

0 1 1 0 0 1 1 0

# swap 2nd and 5th bits (from right)
Note: If the bits are different, only then we have to swap them. Else, no need. So, we need to first get those bits. And check for equality. If they are not same, only then swap them. And, what do we mean by swap. We just need to flip their value. To swap, we need to create a mask.

# num
i = 2;
j = 5;

if ((num >> i & 1) != (num >> j & 1)) {
    # mask for ith, and jth bit
    # (1 << i) | (1 << j)

    # XOR it with num
    num = num ^ ((1 << i) | (1 << j))
}
# else, no need to swap.
We optimized above code not to unnecessary swap bits when they are same. We just set ith and jth bit on our mask as 1. And, we will need to XOR it with the number.

0 1 1 0 0 1 1 0
    -     -   
# - denote positions we want to swap
# mask: 
0 0 1 0 0 1 0 0

# final XOR operation
0 1 1 0 0 1 1 0
0 0 1 0 0 1 0 0

=>
0 1 0 0 0 0 1 0
