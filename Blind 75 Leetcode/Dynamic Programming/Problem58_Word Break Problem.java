Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
  
  
  This problem can be solve by using a naive approach, which is trivial. A discussion can always start from that though.
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
             return wordBreakHelper(s, dict, 0);
    }
 
    public boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length()) 
            return true;
 
        for(String a: dict){
            int len = a.length();
            int end = start+len;
 
            //end index should be <= string length
            if(end > s.length()) 
                continue;
 
            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s, dict, start+len))
                    return true;
        }
 
        return false;
    }
}
Time is O(n^2) and exceeds the time limit.

2. Dynamic Programming

The key to solve this problem by using dynamic programming approach:

Define an array t[] such that t[i]==true => 0-(i-1) can be segmented using dictionary
Initial state t[0] == true
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
 
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        return t[s.length()];
    }
}
Time: O(string length * dict size).

3. Java Solution 3 - Simple and Efficient

In Solution 2, if the size of the dictionary is very large, the time is bad. Instead we can solve the problem in O(n^2) time (n is the length of the string).

public boolean wordBreak(String s, Set<String> wordDict) {
    int[] pos = new int[s.length()+1];
 
    Arrays.fill(pos, -1);
 
    pos[0]=0;
 
    for(int i=0; i<s.length(); i++){
        if(pos[i]!=-1){
            for(int j=i+1; j<=s.length(); j++){
                String sub = s.substring(i, j);
                if(wordDict.contains(sub)){
                    pos[j]=i;
                }
            } 
        }
    }
 
    return pos[s.length()]!=-1;
}
