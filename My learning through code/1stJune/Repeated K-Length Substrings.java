Repeated K-Length Substrings
Given a string s and an integer k, return the number of k-length substrings that occur more than once in s.

Constraints

n ≤ 100,000 where n is the length of s.
k ≤ 10
Example 1
Input
s = "abcdabc"
k = 3
Output
1
Explanation
"abc" occurs twice in the string

Example 2
Input
s = "aaabbb"
k = 2
Output
2
Explanation
Both "aa" and "bb" occurs twice.
  
  import java.util.*;

class Solution 
{
    public int solve(String s, int k)
    {
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<=s.length()-k;i++)
        {
            String res=s.substring(i,i+k);
            if(hm.containsKey(res)){
                int of=hm.get(res);
                int nf=of+1;
                hm.put(res,nf);
            }
            else{
                hm.put(res,1);
            }
        }
        int count=0;
        for(String key:hm.keySet()){
            if(hm.get(key)>1){
                count++;
            }
        }
        return count;
    }

}
/////////////solution 2
// int result = 0;
//         HashMap<String, Integer> map = new HashMap<>();
//         for (int i = 0; i <= s.length() - k; i++) {
//             String curr = s.substring(i, i + k);
//             map.put(curr, map.getOrDefault(curr, 0) + 1);   //OBSERVE THIS
//         }
//         for (Map.Entry<String, Integer> entry : map.entrySet())   //OBSERVE THIS
//             if (entry.getValue() > 1)
//                 result++;
//         return result;
//////////////
