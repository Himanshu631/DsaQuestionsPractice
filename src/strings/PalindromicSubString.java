package strings;

// Given a string s, return the number of palindromic substrings in it.

// Each substring must be contiguous and you can count the same character multiple times
// if it appears in multiple palindromes.
public class PalindromicSubString {

    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCenter(s, i, i);     // odd length
            count += expandAroundCenter(s, i, i + 1); // even length
        }

        return count;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        PalindromicSubString sol = new PalindromicSubString();
        System.out.println("Total palindromic substrings: " + sol.countSubstrings("aaa"));
    }
}
