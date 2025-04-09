package strings;

// Find the length of the longest substring without repeating characters.
import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {
    public int lengthOfLongestSubstring(String s) {

        // Two pointers (left and right) that define a window in the string:
        // The window expands as we move right to include new characters.
        // If we hit a duplicate, we move left forward to remove characters until the duplicate is gone.

        // We use a Set to keep track of the characters inside our window.
        // This helps us know if we've seen a character before (i.e., a duplicate).
        Set<Character> seen = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Shrink window if duplicate character found
            while (seen.contains(c)) {
                // When we hit a duplicate (a character already in the Set),
                // We start shrinking the window from the left,
                // removing characters from the Set until the duplicate is gone.
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(c);
            // Each time we expand the window and it's valid (i.e., no duplicates), we update the maximum length.
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestUniqueSubstring sol = new LongestUniqueSubstring();
        System.out.println(sol.lengthOfLongestSubstring("abcdeafghijklmnaopqyza")); // Output: 9
    }
}

