package strings;

// Given a string s, find the longest substring that is a palindrome.
public class LongestPalindromicSubString {
    // Think of a palindrome as something that expands from the center.
    // Start from each character and try to expand outward to see if it forms a palindrome.
    //
    // There are two types of centers:
    //
    // Odd length palindrome: center at 1 character (like aba)
    //
    // Even length palindrome: center between 2 characters (like abba)
    //
    // We try to expand around every possible center and track the maximum length palindrome we find.

    public String getLongestPalindromicSubString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = checkPalindrome(s,i,i);  // Consider i to be the middle element Odd case -> "madam"
            int len2 = checkPalindrome(s,i,i+1); // Consider i and i+1 to be the middle element EVEN case -> "maddam"

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start, end+1);
    }

    private int checkPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        String str = "ada";
        LongestPalindromicSubString longestPalindromicSubString = new LongestPalindromicSubString();
        System.out.println(longestPalindromicSubString.getLongestPalindromicSubString(str));
    }
}
