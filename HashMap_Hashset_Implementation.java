import java.util.*;
//Hashset Implementation
class Solution {
    public boolean solve(String s) {
        HashSet<Character> charsSeen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (charsSeen.contains(c))
                return false;
            charsSeen.add(c);
        }
        return true;
    }
    }

//HashMap Implementation 
HashMap<String,Integer> hm = new HashMap<>();
    for(String s2:s1){
        if(hm.containsKey(s2))
            return false;
        else
            hm.put(s2,1);    
    }
    return true;

//Another hashmap implementation
if (!wordCounts.containsKey(word))
wordCounts.put(word, 1);
else
wordCounts.put(word, wordCounts.get(word) + 1);
