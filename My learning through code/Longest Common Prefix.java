Longest Common Prefix
Given a list of lowercase alphabet strings words, return the longest common prefix.

Example 1
Input
words = ["anthony", "ant", "antigravity"]
Output
"ant"

public String solve(String[] words) {
    Arrays.sort(words);
    int max=0,flag=0;
    for(int i = 0 ; i < words[0].length();i++){
        for(int j = 0 ; j < words.length-1;j++){
            if(words[j].charAt(0)!=words[j+1].charAt(0))
            return "";
        if(words[j].charAt(i)!=words[j+1].charAt(i))
         break;
        else 
            flag++;
    }
      if(flag==words.length-1){
            max = i;          
        }
        flag=0;
    }
    return words[0].substring(0,max+1);
}
