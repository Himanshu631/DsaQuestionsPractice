package strings;

import java.util.*;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        // Count of characters needed from string t
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // Variables for sliding window
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int formed = 0; // How many characters have met their required count
        int required = need.size(); // Total unique characters to match

        // Result: {window length, left, right}
        int[] ans = {-1, 0, 0};

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // If the current character count matches what's needed, increment formed
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window from the left
            while (left <= right && formed == required) {
                // Update result if smaller window is found
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                // Remove the leftmost character from the window
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // If removing causes it to no longer meet the requirement, reduce `formed`
                if (need.containsKey(leftChar) && window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    formed--;
                }

                left++; // Shrink the window
            }

            right++; // Expand the window
        }

        // Return the smallest window found or empty string if none
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solver = new MinimumWindowSubstring();
        String s = "ACBANBC";
        String t = "ABC";
        System.out.println(solver.minWindow(s, t)); // Output: "ACB"
    }
}
