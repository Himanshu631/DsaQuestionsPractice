package recursion;

import java.util.ArrayList;
import java.util.List;

public class ArraySubsequences {

    public static void findSubsequences(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
        // Base case
        if (index == arr.length) {
            result.add(new ArrayList<>(current)); // store a copy
            return;
        }

        // Include current element
        current.add(arr[index]);
        findSubsequences(arr, index + 1, current, result);

        // Backtrack and exclude the element
        current.remove(current.size() - 1);
        findSubsequences(arr, index + 1, current, result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        findSubsequences(arr, 0, new ArrayList<>(), result);

        // Print all subsequences
        for (List<Integer> seq : result) {
            System.out.println(seq);
        }
    }
}

