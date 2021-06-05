Check for Anagrams
Write a function to check whether two given strings are anagram of each other or not. 
  An anagram of a string is another string that contains the same characters,
only the order of characters can be different. For example, “abcd” and “dabc” are an anagram of each other.
  
  Method 1 (Use Sorting)  

Sort both strings
Compare the sorted strings
// JAVA program to check whether two strings
// are anagrams of each other
import java.io.*;
import java.util.Arrays;
import java.util.Collections;

class GFG {

	/* function to check whether two strings are
	anagram of each other */
	static boolean areAnagram(char[] str1, char[] str2)
	{
		// Get lenghts of both strings
		int n1 = str1.length;
		int n2 = str2.length;

		// If length of both strings is not same,
		// then they cannot be anagram
		if (n1 != n2)
			return false;

		// Sort both strings
		Arrays.sort(str1);
		Arrays.sort(str2);

		// Compare sorted strings
		for (int i = 0; i < n1; i++)
			if (str1[i] != str2[i])
				return false;

		return true;
	}

	/* Driver Code*/
	public static void main(String args[])
	{
		char str1[] = { 't', 'e', 's', 't' };
		char str2[] = { 't', 't', 'e', 'w' };
	
		// Function Call
		if (areAnagram(str1, str2))
			System.out.println("The two strings are"
							+ " anagram of each other");
		else
			System.out.println("The two strings are not"
							+ " anagram of each other");
	}
}

////////////////////////////////////////////////Method 2 (Count characters) 
This method assumes that the set of possible characters in both strings is small. In the following implementation, it is assumed that the characters are stored using 8 bit and there can be 256 possible characters. 

Create count arrays of size 256 for both strings. Initialize all values in count arrays as 0.
Iterate through every character of both strings and increment the count of character in the corresponding count arrays.
Compare count arrays. If both count arrays are same, then return true.
Below is the implementation of the above idea:


// JAVA program to check if two strings
// are anagrams of each other
import java.io.*;
import java.util.*;
 
class GFG {
 
    static int NO_OF_CHARS = 256;
 
    /* function to check whether two strings
    are anagram of each other */
    static boolean areAnagram(char str1[], char str2[])
    {
        // Create 2 count arrays and initialize
        // all values as 0
        int count1[] = new int[NO_OF_CHARS];
        Arrays.fill(count1, 0);
        int count2[] = new int[NO_OF_CHARS];
        Arrays.fill(count2, 0);
        int i;
 
        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (i = 0; i < str1.length && i < str2.length;
             i++) {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }
 
        // If both strings are of different length.
        // Removing this condition will make the program
        // fail for strings like "aaca" and "aca"
        if (str1.length != str2.length)
            return false;
 
        // Compare count arrays
        for (i = 0; i < NO_OF_CHARS; i++)
            if (count1[i] != count2[i])
                return false;
 
        return true;
    }
 
    /* Driver code*/
    public static void main(String args[])
    {
        char str1[] = ("geeksforgeeks").toCharArray();
        char str2[] = ("forgeeksgeeks").toCharArray();
 
        // Function call
        if (areAnagram(str1, str2))
            System.out.println("The two strings are"
                               + "anagram of each other");
        else
            System.out.println("The two strings are not"
                               + " anagram of each other");
    }
}
