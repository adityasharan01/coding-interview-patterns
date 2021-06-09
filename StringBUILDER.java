The StringBuilder in Java represents a mutable sequence of characters. 
Since the String Class in Java creates an immutable sequence of characters, 
the StringBuilder class provides an alternative to String Class, as it creates a mutable sequence of characters. 
The function of StringBuilder is very much similar to the StringBuffer class, as both of them provide an alternative to String
Class by making a mutable sequence of characters. However the StringBuilder class differs from the StringBuffer class on the basis of synchronization. 
   
Constructors in Java StringBuilder: 
 

StringBuilder(): Constructs a string builder with no characters in it and an initial capacity of 16 characters.
 
StringBuilder(int capacity): Constructs a string builder with no characters in it and an initial capacity specified by the capacity argument.

StringBuilder(String str): Constructs a string builder initialized to the contents of the specified string.   
  
StringBuilder append(X x): This method appends the string representation of the X type argument to the sequence.
 
  int capacity(): This method returns the current capacity.

char charAt(int index): This method returns the char value in this sequence at the specified index.
  
  StringBuilder delete(int start, int end): This method removes the characters in a substring of this sequence.
 
StringBuilder deleteCharAt(int index): This method removes the char at the specified position in this sequence.
    
int indexOf(): This method returns the index within this string of the first occurrence of the specified substring.
   
String substring(): This method returns a new String that contains a subsequence of characters currently contained in this character sequence.
 
String toString(): This method returns a string representing the data in this sequence.
 
void trimToSize(): This method attempts to reduce storage used for the character sequence. 
  
void setCharAt(int index, char ch): In this method, the character at the specified index is set to ch.
  
StringBuilder reverse(): This method causes this character sequence to be replaced by the reverse of the sequence.
   // usind StringBuilder() constructor
        StringBuilder str
            = new StringBuilder();
 
        str.append("GFG");
 
        // print string
        System.out.println("String = "
                           + str.toString());
 
        // create a StringBuilder object
        // usind StringBuilder(CharSequence) constructor
        StringBuilder str1
            = new StringBuilder("AAAABBBCCCC");
 
        // print string
        System.out.println("String1 = "
                           + str1.toString());
 
        // create a StringBuilder object
        // usind StringBuilder(capacity) constructor
        StringBuilder str2
            = new StringBuilder(10);
 
        // print string
        System.out.println("String2 capacity = "
                           + str2.capacity());
 
        // create a StringBuilder object
        // usind StringBuilder(String) constructor
        StringBuilder str3
            = new StringBuilder(str1.toString());
 
