package strings;

import java.util.Map;
import java.util.Stack;

// Given a string s containing just the characters ()[]{}, determine if the input string is valid.
public class ValidParentheses {

    // Intuition
    // Use a stack to track opening brackets.

    // When you see an opening bracket, push it onto the stack.

    // When you see a closing bracket:

    // If the stack is empty → invalid.
    // Pop the top of the stack, and check if it matches the current closing bracket.
    // If the stack is empty at the end → valid.

    public boolean isValid(String s) {

        if (s.length() <= 1) return false;

        Stack<Character> stack = new Stack<>();

        // Step 2: Map of closing to opening brackets
        Map<Character, Character> bracketMap = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );

        for (char c : s.toCharArray()) {
            if (bracketMap.containsValue(c)) {
                stack.push(c);
            }
            else if (bracketMap.containsKey(c)){
                if (stack.isEmpty() || stack.pop() != bracketMap.get(c)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

public static void main(String[] args) {
        ValidParentheses checker = new ValidParentheses();

        System.out.println(checker.isValid("()"));       // true
        System.out.println(checker.isValid("()[]{}"));   // true
        System.out.println(checker.isValid("(]"));       // false
        System.out.println(checker.isValid("([)]"));     // false
        System.out.println(checker.isValid("{[]}"));     // true
    }
}
