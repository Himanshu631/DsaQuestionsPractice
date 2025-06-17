package recursion;

import java.util.ArrayList;
import java.util.List;

public class MergeSortAlgo {

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> resList = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                resList.add(arr[left++]);
            } else {
                resList.add(arr[right++]);
            }
        }

        while (left <= mid) {
            resList.add(arr[left++]);
        }

        while (right <= high) {
            resList.add(arr[right++]);
        }

        // Copy back to original array
        for (int i = 0; i < resList.size(); i++) {
            arr[low + i] = resList.get(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 1, 6, 5, 4, 7, 8, 9};
        mergeSort(arr, 0, arr.length - 1);

        // Print the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }
}
