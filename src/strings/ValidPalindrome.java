package strings;

// Check palindrome, considering only alphanumeric characters and ignoring cases
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // Step 1: Convert to lowercase and use two pointers
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Step 2: Skip non-alphanumeric characters
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Step 3: Compare characters (case insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Step 4: Move pointers inward
            left++;
            right--;
        }

        // Step 5: If all characters match, it's a valid palindrome
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome checker = new ValidPalindrome();

        System.out.println(checker.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(checker.isPalindrome("race a car"));                     // false
        System.out.println(checker.isPalindrome(" "));                              // true
    }
}

