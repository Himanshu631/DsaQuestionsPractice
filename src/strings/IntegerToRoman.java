package strings;

public class IntegerToRoman {

    // Roman numerals are built using symbol-value pairs, starting from largest to smallest.

    // We use greedy approach:

    // Match the largest symbol possible.

    // Subtract its value and append symbol.
    // Repeat until number becomes zero.
    public String intToRoman(int num) {
        // Step 1: Arrays of values and their corresponding Roman symbols
        int[] values =    {1000, 900, 500, 400, 100, 90,  50, 40, 10,  9, 5, 4, 1};
        String[] symbols = {"M", "CM","D", "CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        // Step 2: Greedily subtract largest possible value
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];             // Subtract the value
                sb.append(symbols[i]);        // Append corresponding symbol
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman converter = new IntegerToRoman();

        System.out.println(converter.intToRoman(1994));  // "MCMXCIV"
    }
}

