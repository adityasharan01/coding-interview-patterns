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
  
  
  public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        
        
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}

/////////////////////////////////////////////////////Second Solution
 this problem in top-down manner using recursion + memoization

/**
 * Initial recursion + memoization solution in Java.
 *
 * @author Haoyang Fan
 * @version 1.0
 * @since 02-01-2019
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // create the memoization array to save results and avoid repeat computations
        Boolean[] canBreak = new Boolean[s.length()];

        // convert the list into set for faster lookup
        Set<String> wordSet = new HashSet<>(wordDict);

        // recursion with memoization
        return helper(s, 0, wordSet, canBreak);
    }

    private boolean helper(String s, int startIdx, Set<String> wordSet, Boolean[] canBreak) {
        // in case we've reached the end of string, return true
        if (startIdx == s.length()) return true;
        // else if we've already computed on current substring before
        if (canBreak[startIdx] != null) return canBreak[startIdx]; // auto-unboxing

        boolean res = false;
        // iterate through all indices after startIdx, explore every possible word
        for (int i = startIdx + 1; i <= s.length(); i++) {
            String currWord = s.substring(startIdx, i);
            // skip if this is not a word in the input dictionary
            if (!wordSet.contains(currWord)) continue;
            // recursively call upon the rest of string
            if (helper(s, i, wordSet, canBreak)) {
                res = true;
                break;
            }
        }
        // add result to memo and return the result
        canBreak[startIdx] = res;
        return res;
    }
}
