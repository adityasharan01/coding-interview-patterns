class Solution {
    public String balancedBrackets(String st) {
      int n = st.length();
      Stack<Character> s = new Stack<>();
      for(int i =0; i <n; i++){
          char ch = st.charAt(i);
          if(ch == '(' ||ch == '['  || ch == '{'  ){
             s.push(ch);
          }else{
              if(s.isEmpty()){
                  return "NO";
              }
              
              else if(    (ch == ']' && s.peek() == '[') ||
                          (ch == ')' && s.peek() == '(') ||
                          (ch == '}' && s.peek() == '{')
                     ){
                     s.pop();
                  continue;
              }
              
                return "NO";
              }
      }
        
        if(s.isEmpty() ==  false) return "NO";
        return "YES";
    }
}