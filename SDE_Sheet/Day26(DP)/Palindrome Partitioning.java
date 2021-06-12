Palindrome Partitioning
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.

he normal dfs backtracking will need to check each substring for palindrome, but a dp array can be used to record the possible break for palindrome before we start recursion.

Edit:
Sharing my thought process:
first, I ask myself that how to check if a string is palindrome or not, usually a two point solution scanning from front and back. Here if you want to get all the possible palindrome partition, first a nested for loop to get every possible partitions for a string, then a scanning for all the partitions. That's a O(n^2) for partition and O(n^2) for the scanning of string, totaling at O(n^4) just for the partition. However, if we use a 2d array to keep track of any string we have scanned so far, with an addition pair, we can determine whether it's palindrome or not by justing looking at that pair, which is this line if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])). This way, the 2d array dp contains the possible palindrome partition among all.

second, based on the prescanned palindrome partitions saved in dp array, a simple backtrack does the job.

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        helper(res, new ArrayList<>(), dp, s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> path, boolean[][] dp, String s, int pos) {
        if(pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pos; i < s.length(); i++) {
            if(dp[pos][i]) {
                path.add(s.substring(pos,i+1));
                helper(res, path, dp, s, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
  
  //Backtracking Solution 
  if the input is "aab", check if [0,0] "a" is palindrome. then check [0,1] "aa", then [0,2] "aab".
While checking [0,0], the rest of string is "ab", use ab as input to make a recursive call.
if the input is "aab", check if [0,0] "a" is palindrome. then check [0,1] "aa", then [0,2] "aab". While checking [0,0], the rest of string is "ab", use ab as input to make a recursive call. ![enter image description here][1]

in this example, in the loop of i=l+1, a recursive call will be made with input = "ab".
Every time a recursive call is made, the position of l move right.

How to define a correct answer?
Think about DFS, if the current string to be checked (Palindrome) contains the last position, in this case "c", this path is a correct answer, otherwise, it's a false answer.

![enter image description here][2]

line 13: is the boundary to check if the current string contains the last element.
l>=s.length()

public class Solution {
        List<List<String>> resultLst;
	    ArrayList<String> currLst;
	    public List<List<String>> partition(String s) {
	        resultLst = new ArrayList<List<String>>();
	        currLst = new ArrayList<String>();
	        backTrack(s,0);
	        return resultLst;
	    }
	    public void backTrack(String s, int l){
	        if(currLst.size()>0 //the initial str could be palindrome
	            && l>=s.length()){
	                List<String> r = (ArrayList<String>) currLst.clone();
	                resultLst.add(r);
	        }
	        for(int i=l;i<s.length();i++){
	            if(isPalindrome(s,l,i)){
	                if(l==i)
	                    currLst.add(Character.toString(s.charAt(i)));
	                else
	                    currLst.add(s.substring(l,i+1));
	                backTrack(s,i+1);
	                currLst.remove(currLst.size()-1);
	            }
	        }
	    }
	    public boolean isPalindrome(String str, int l, int r){
	        if(l==r) return true;
	        while(l<r){
	            if(str.charAt(l)!=str.charAt(r)) return false;
	            l++;r--;
	        }
	        return true;
	    }
}
