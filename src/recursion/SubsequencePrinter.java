package recursion;

public class SubsequencePrinter {

    public static void printSubsequences(String input, String output) {
        // Base Case: if input is empty, print the current output (subsequence)
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }

        // Take the first character
        char ch = input.charAt(0);

        // Remaining string
        String rest = input.substring(1);

        // Recursive call: include the character
        printSubsequences(rest, output + ch);

        // Recursive call: exclude the character
        printSubsequences(rest, output);
    }

    public static void main(String[] args) {
        String str = "abc";
        printSubsequences(str, "");
    }
}

