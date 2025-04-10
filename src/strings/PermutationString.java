package strings;

// Given two strings s1 and s2, return true if s2 contains a permutation of s1.
// In other words, one of s1's permutations is a substring of s2.
public class PermutationString {

    // Use an integer array s1Count[26] and s2Count[26] to count frequencies of characters in s1 and the current window of s2.
    //
    // Slide a window of length s1.length() across s2.
    //
    // On each step, compare both frequency arrays.
    //
    // If they match, return true.
    public boolean checkPermutationString(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Count frequency of characters in s1 and in the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1Count, s2Count)) return true;

            // Slide the window: remove s2[i], add s2[i + s1.length()]
            s2Count[s2.charAt(i + s1.length()) - 'a']++;
            s2Count[s2.charAt(i) - 'a']--;
        }

        // Check last window
        return matches(s1Count, s2Count);
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "asd";
        String s2 = "resdat";
        PermutationString permutationString = new PermutationString();
        System.out.println(permutationString.checkPermutationString(s1, s2));
    }
}
