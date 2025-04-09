package strings;

public class LongestCommonPrefix {

//    Start with the first string as the prefix.
//    Compare it with each subsequent string and reduce the prefix until it matches the beginning of each string.
//    Stop if the prefix becomes empty.
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }

        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flown", "flowing"};
        System.out.println(longestCommonPrefix(input));
    }
}
