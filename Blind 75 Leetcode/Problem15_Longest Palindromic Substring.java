Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),


1. Dynamic Programming

Let s be the input string, i and j are two indices of the string. Define a 2-dimension array "table" and let table[i][j] denote whether a substring from i to j is palindrome.

Changing condition:
table[i+1][j-1] == 1 && s.charAt(i) == s.charAt(j)
=>
table[i][j] == 1
Time O(n^2) Space O(n^2)
  
  public String longestPalindrome(String s) {
    if(s==null || s.length()<=1)
        return s;
 
    int len = s.length();
    int maxLen = 1;
    boolean [][] dp = new boolean[len][len];
 
    String longest = null;
    for(int l=0; l<s.length(); l++){
        for(int i=0; i<len-l; i++){
            int j = i+l;
            if(s.charAt(i)==s.charAt(j) && (j-i<=2||dp[i+1][j-1])){
                dp[i][j]=true;
 
                if(j-i+1>maxLen){
                   maxLen = j-i+1; 
                   longest = s.substring(i, j+1);
                }
            }
        }
    }
 
    return longest;
}
For example, if the input string is "dabcba", the final matrix would be the following:

1 0 0 0 0 0 
0 1 0 0 0 1 
0 0 1 0 1 0 
0 0 0 1 0 0 
0 0 0 0 1 0 
0 0 0 0 0 1 
From the table, we can clearly see that the longest string is in cell table[1][5].

2. A Simple Algorithm

We can scan to both sides for each character. Time O(n^2), Space O(1)

public String longestPalindrome(String s) {
	if (s.isEmpty()) {
		return null;
	}
 
	if (s.length() == 1) {
		return s;
	}
 
	String longest = s.substring(0, 1);
	for (int i = 0; i < s.length(); i++) {
		// get longest palindrome with center of i
		String tmp = helper(s, i, i);
		if (tmp.length() > longest.length()) {
			longest = tmp;
		}
 
		// get longest palindrome with center of i, i+1
		tmp = helper(s, i, i + 1);
		if (tmp.length() > longest.length()) {
			longest = tmp;
		}
	}
 
	return longest;
}
 
// Given a center, either one letter or two letter, 
// Find longest palindrome
public String helper(String s, int begin, int end) {
	while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
		begin--;
		end++;
	}
	return s.substring(begin + 1, end);
}
