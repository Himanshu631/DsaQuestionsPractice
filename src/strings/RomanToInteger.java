package strings;

import java.util.*;

public class RomanToInteger {

    public int romanToInt(String s) {
        // Step 1: Map each Roman numeral to its integer value
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );

        int total = 0;

        // Step 2: Loop through each character
        for (int i = 0; i < s.length(); i++) {
            int currVal = map.get(s.charAt(i));

            // Step 3: Check if next character exists and is larger
            if (i < s.length() - 1 && currVal < map.get(s.charAt(i + 1))) {
                // Subtraction case
                total -= currVal;
            } else {
                // Normal addition
                total += currVal;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        RomanToInteger converter = new RomanToInteger();

        System.out.println(converter.romanToInt("III"));     // 3
        System.out.println(converter.romanToInt("IV"));      // 4
        System.out.println(converter.romanToInt("IX"));      // 9
        System.out.println(converter.romanToInt("LVIII"));   // 58
        System.out.println(converter.romanToInt("MCMXCIV")); // 1994
    }
}

