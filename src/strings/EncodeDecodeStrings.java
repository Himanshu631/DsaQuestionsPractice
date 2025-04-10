package strings;

import java.util.*;

// You are given an array of strings.
// You need to design an algorithm to encode these strings into a single string
// and decode it back to the original array of strings.
public class EncodeDecodeStrings {

    // Intuiton:
    // ["hello","lc","hkr"]
    // encoded as -> 5hello2lc3hkr
    // decoded as ["hello","lc","hkr"]

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(s.substring(i, j));
            result.add(s.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }

        return result;
    }

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("hello");
        strings.add("lc");
        strings.add("hkr");

        EncodeDecodeStrings encodeDecodeStrings = new EncodeDecodeStrings();
        String encodeStr = encodeDecodeStrings.encode(strings);
        System.out.println(encodeStr);
        List<String> decodedStrings = encodeDecodeStrings.decode(encodeStr);
        System.out.println(decodedStrings);
    }
}
