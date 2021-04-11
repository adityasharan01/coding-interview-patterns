Leetcode: Encode and Decode Strings
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
Machine 1 (sender) has the function:
string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:
string encoded_string = encode(strs);
and Machine 2 does:
vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.
Implement the encode and decode methods.
Note:
The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
Understand the problem:
This is just an implementation problem. The key is how to separate the list of strings during the serialization process 
so we can decode the string in the de-serialization process.

One way we can think of is to use the number at front. e.g. abcdef, we can store 6abcdef. 
However, what if the string also starts from numbers, e.g. 123abc. In this case, 
what we stored is 6123abc, which is wrong. Therefore, we need to use another divider to divide the length of the string with the string itself. In this solution, we just use '#'. 
  
 One thing needs to be careful in this such kind problem is the length of the string, 
which is in the form of string, is not a single character. Therefore, we need to parse the string until we see the divider. 
  
  public class Codec {
 
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
         
        for (String str : strs) {
            if (str == null || str.length() == 0) {
                sb.append("0#");
            } else {
                sb.append(str.length() + "#" + str);
            }
        }
         
        return sb.toString();
    }
 
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
         
        if (s == null || s.length() == 0) {
            return strs;
        }
         
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
                j++;
            }
             
            int num = Integer.parseInt(s.substring(i, j));
            i = j;
            i++; // skip '#'
            if (num == 0) {
                strs.add("");
            } else {
                strs.add(s.substring(i, i + num));
            }
             
            i += num;
        }
         
        return strs;
    }
}
 
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));


APPROACH 2:
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return ret;
    }
}
