package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    // Intuition
    // Two strings are anagrams if their sorted versions are the same.
    //
    // Use a HashMap where:
    // Key = sorted version of the string
    // Value = list of strings that match this sorted key
    // Iterate through the array, sort each string, group it using the map

    public List<List<String>> groupAnagrams(String[] strs) {
        // Step 1: Map to hold sorted string as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();

        // Step 2: Iterate through each string
        for (String str : strs) {
            // Step 3: Convert string to char array, sort it, then turn it back to string
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); // sorted version of the string

            // Step 4: Add the original string to the map under the sorted key
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // Step 5: Return all grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solver = new GroupAnagrams();
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = solver.groupAnagrams(input);
        System.out.println(result);
    }
}

