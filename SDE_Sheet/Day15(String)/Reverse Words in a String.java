Reverse words in a given string
Example: Let the input string be “i like this program very much”. The function should change the string to “much very program this like i”

reverse-words

Examples: 

Input: s = “geeks quiz practice code” 
Output: s = “code practice quiz geeks”

Input: s = “getting good at coding needs a lot of practice” 
Output: s = “practice of lot a needs coding at good getting” 

import java.util.*;
import java.io.*;
import java.lang.*;
  
class GFG { 
       
    static void reverse(char str[],int low, int high){
    while(low<=high){
        //swap
        char temp=str[low];
        str[low]=str[high];
        str[high]=temp;
        //
        low++;
        high--;
    }
    }

    static void reverseWords(char str[],int n){
    int start=0;
    for(int end=0;end<n;end++){
        if(str[end]==' '){
            reverse(str,start,end-1);
            start=end+1;
        }
    }
    reverse(str,start,n-1);
    reverse(str,0,n-1);
    }
  
    public static void main(String args[]) 
    {   String s = "Welcome to Gfg";int n=s.length();
        char[] str = s.toCharArray();
        System.out.println("After reversing words in the string:");
        reverseWords(str,n);
        System.out.println(str);  
    } 
} 
