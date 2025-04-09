package strings;

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An anagram is a word or phrase formed by rearranging the letters of another,
// using all original letters exactly once.
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        // Step 1: If the lengths are different, they can't be anagrams
        if (s.length() != t.length()) return false;

        // Step 2: Create an array to count the frequency of characters
        // Assuming input consists of only lowercase English letters
        int[] count = new int[26];

        // Step 3: Count each character in 's' and subtract the count for 't'
        for (int i = 0; i < s.length(); i++) {
            // Increment count for character in s
            count[s.charAt(i) - 'a']++;

            // Decrement count for character in t
            count[t.charAt(i) - 'a']--;
        }

        // Step 4: After processing both strings, all counts should be 0
        for (int freq : count) {
            if (freq != 0) {
                return false; // Found mismatch in frequency
            }
        }

        // Step 5: If all counts are zero, it's a valid anagram
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validator = new ValidAnagram();

        // Test cases
        System.out.println(validator.isAnagram("anagram", "nagaram")); // true
        System.out.println(validator.isAnagram("rat", "car"));         // false
    }
}

