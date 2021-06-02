Divide two integers without using multiplication, division and mod operator

Given a two integers say a and b. Find the quotient after dividing a by b without using multiplication, division and mod operator.

Example: 

Input : a = 10, b = 3
Output : 3

Input : a = 43, b = -8
Output :  -5 

What if we have to solve this problem for longs, not for ints, in a language that doesn't support anything larger than long, say, Java or C#? Then we no longer have an option to use longs to avoid overflow, no pun intended. I was fiddling around with corner cases until I came up with a pretty ugly solution that worked, but then I found this one. The idea of using negative integers had crossed my mind, but I didn't think it could lead to less ugly code until I saw that solution. So I took up the idea, and did this:

public int divide(int dividend, int divisor) {
    if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
        return Integer.MAX_VALUE;
    if (dividend == 0 || divisor == 1) // necessary for MIN_VALUE / 1
        return dividend;
    // use negative numbers to avoid overflow, original idea by @brubru777
    if (dividend > 0)
        return -divide(-dividend, divisor);
    if (divisor > 0)
        return -divide(dividend, -divisor);
    int shiftedDivisor = divisor;
    int shift = 0;
    while ((shiftedDivisor << 1) < 0) {
        ++shift;
        shiftedDivisor <<= 1;
    }
    int quotient = 0;
    int remainder = dividend;
    while (shift >= 0) {
        if (remainder <= shiftedDivisor) {
            quotient |= 1 << shift;
            remainder -= shiftedDivisor;
        }
        shiftedDivisor >>= 1;
        --shift;
    }
    return quotient;
}
