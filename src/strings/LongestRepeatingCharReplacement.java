package strings;

// Replace at most k characters in a string to make all characters in a window the same.
// Return the length of the longest such substring.

public class LongestRepeatingCharReplacement {

    public static int charReplacements(String s, int k) {
        int[] freq = new int[26];

        // left is the start of the sliding window.
        // maxFreq tracks the max frequency of any character in the current window.
        // maxLength keeps track of the maximum valid window size found so far.
        int left = 0, maxFreq = 0, maxLength = 0;

        // Expands the window to the right, one character at a time.
        for (int right = 0; right < s.length(); right++) {

            // Increments the count of the current character in the freq array.
            // s.charAt(right) - 'A' maps 'A' to 0, 'B' to 1, etc.
            freq[s.charAt(right) - 'A']++;

            // Updates maxFreq to reflect the most frequent character in the window.
            // This helps determine how many non-majority characters we’d need to replace
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // Core condition: Checks if number of characters to replace is more than k
            // Characters to replace = window size - maxFreq
            // If more than k, the window is invalid, so we need to shrink it.
            if ((right - left + 1) - maxFreq > k) {

                // Shrinks the window from the left by removing the leftmost character's frequency.
                freq[s.charAt(left) - 'A']--;
                // Moves the window start forward by one character.
                left++;
            }

            // Updates the answer with the current valid window size.
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
        }

    public static void main(String[] args) {
        String string = "AABBBAAAAA";
        int k = 2;

        System.out.println("Answer "+ charReplacements(string, k));
    }
}
