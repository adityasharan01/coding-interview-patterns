Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".



public String minWindow(String s, String t) {
    HashMap<Character, Integer> goal = new HashMap<>();
    int goalSize = t.length();
    int minLen = Integer.MAX_VALUE;
    String result = "";
 
    //target dictionary
    for(int k=0; k<t.length(); k++){
        goal.put(t.charAt(k), goal.getOrDefault(t.charAt(k), 0)+1);
    }
 
    int i=0;
    int total=0;
    HashMap<Character, Integer> map = new HashMap<>();
    for(int j=0; j<s.length(); j++){
        char c = s.charAt(j);
        if(!goal.containsKey(c)){
            continue;
        }
 
        //if c is a target character in the goal, and count is < goal, increase the total
        int count = map.getOrDefault(c, 0);
        if(count<goal.get(c)){
            total++;
        }
 
        map.put(c, count+1);
 
        //when total reaches the goal, trim from left until no more chars can be trimmed.
        if(total==goalSize){
            while(!goal.containsKey(s.charAt(i)) || map.get(s.charAt(i))>goal.get(s.charAt(i))){
                char pc = s.charAt(i);
                if(goal.containsKey(pc) && map.get(pc)>goal.get(pc)){
                    map.put(pc, map.get(pc)-1);
                }
 
                i++;
            }
 
            if(minLen>j-i+1){
                    minLen = j-i+1;
                    result = s.substring(i, j+1);
            }
        }            
    }
 
    return result;
}
