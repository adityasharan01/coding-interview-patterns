Given an integer num, return an array of the number of 1's in the binary representation of every number in the range [0, num].

 

Example 1:

Input: num = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: num = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 

Constraints:

0 <= num <= 105
 

Follow up:

It is very easy to come up with a solution with run time O(32n). Can you do it in linear time O(n) and possibly in a single pass?
Could you solve it in O(n) space complexity?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?


1. Naive Solution

We can simply count bits for each number like the following:

public int[] countBits(int num) {
    int[] result = new int[num+1];
 
    for(int i=0; i<=num; i++){
        result[i] = countEach(i);
    }
 
    return result;
}
 
public int countEach(int num){
    int result = 0;
 
    while(num!=0){
        if(num%2==1){
            result++;
        }
        num = num/2;
    }
 
    return result;
}

2. Improved Solution

For number 2(10), 4(100), 8(1000), 16(10000), ..., the number of 1's is 1. Any other number can be converted to be 2^m + x. For example, 9=8+1, 10=8+2. 
  The number of 1's for any other number is 1 + # of 1's in x.
public int[] countBits(int num) {
    int[] result = new int[num+1];
 
    int p = 1; //p tracks the index for number x
    int pow = 1;
    for(int i=1; i<=num; i++){
        if(i==pow){
            result[i] = 1;
            pow <<= 1;
            p = 1;
        }else{
            result[i] = result[p]+1;
            p++;
        }
 
    }
 
    return result;
}
