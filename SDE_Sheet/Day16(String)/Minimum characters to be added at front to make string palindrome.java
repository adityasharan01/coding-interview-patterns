Minimum characters to be added at front to make string palindrome
Given a string str we need to tell minimum characters to be added at front of string to make string palindrome.
Examples: 
 

Input  : str = "ABC"
Output : 2
We can make above string palindrome as "CBABC"
by adding 'B' and 'C' at front.

Input  : str = "AACECAAAA";
Output : 2
We can make above string palindrome as AAAACECAAAA
by adding two A's at front of string.
 

Recommended: Please try your approach on {IDE} first, before moving on to the solution.
Naive approach: Start checking the string each time if it is a palindrome and if not, then delete the last character and check again. When the string gets reduced to wither a palindrome or empty then the number of characters deleted from the end till now will be the answer as those characters could have been inserted at the beginning of the original string in the order which will will make the string a palindrome.
Below is the implementation of the above approach:

// Java program for getting minimum character to be
// added at front to make string palindrome

class GFG {

// function for checking string is palindrome or not
	static boolean ispalindrome(String s) {
		int l = s.length();

		for (int i = 0, j = l - 1; i <= j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}

// Driver code
	public static void main(String[] args) {
		String s = "BABABAA";
		int cnt = 0;
		int flag = 0;

		while (s.length() > 0) {
			// if string becomes palindrome then break
			if (ispalindrome(s)) {
				flag = 1;
				break;
			} else {
				cnt++;

				// erase the last element of the string
				s = s.substring(0, s.length() - 1);
				//s.erase(s.begin() + s.length() - 1);
			}
		}

		// print the number of insertion at front
		if (flag == 1) {
			System.out.println(cnt);
		}
	}
}
Efficient approach: We can solve this problem efficiently in O(n) time using lps array of KMP algorithm. 
First we concat string by concatenating given string, a special character and reverse of given string then we will get lps array for this concatenated string, recall that each index of lps array represent longest proper prefix which is also suffix. We can use this lps array for solving the problem. 
 



For string = AACECAAAA
Concatenated String = AACECAAAA$AAAACECAA
LPS array will be {0, 1, 0, 0, 0, 1, 2, 2, 2, 
                   0, 1, 2, 2, 2, 3, 4, 5, 6, 7}
Here we are only interested in the last value of this lps array because 
it shows us the largest suffix of the reversed string that matches the prefix of the original string
i.e these many characters already satisfy the palindrome property. Finally minimum number of character needed to make the string 
a palindrome is length of the input string minus last entry of our lps array. Pease see below code for better understanding


// Java program for getting minimum character to be
// added at front to make string palindrome
import java.util.*;
class GFG
{
 
// returns vector lps for given string str
public static int[] computeLPSArray(String str)
{
    int n = str.length();
    int lps[] = new int[n];
    int i = 1, len = 0;
    lps[0] = 0; // lps[0] is always 0
     
    while (i < n)
    {
        if (str.charAt(i) == str.charAt(len))
        {
            len++;
            lps[i] = len;
            i++;
        }
        else
        {
            // This is tricky. Consider the example.
            // AAACAAAA and i = 7. The idea is similar
            // to search step.
            if (len != 0)
            {
                len = lps[len - 1];
                 
                // Also, note that we do not increment
                // i here
            }
            else
            {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}
 
// Method returns minimum character to be added at
// front to make string palindrome
static int getMinCharToAddedToMakeStringPalin(String str)
{
    StringBuilder s = new StringBuilder();
    s.append(str);
     
    // Get concatenation of string, special character
    // and reverse string
    String rev = s.reverse().toString();
    s.reverse().append("$").append(rev);
     
    // Get LPS array of this concatenated string
    int lps[] = computeLPSArray(s.toString());
    return str.length() - lps[s.length() - 1];
}
 
// Driver Code
public static void main(String args[])
{
    String str = "AACECAAAA";
    System.out.println(getMinCharToAddedToMakeStringPalin(str));
}
}
