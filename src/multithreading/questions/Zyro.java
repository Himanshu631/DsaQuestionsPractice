package multithreading.questions;

public class Zyro {

    public static int count(int[] arr, int n) {
        int firstOcc = getFirstOccurence(arr, n);
        int lastOcc = getLastOccurrence(arr, n);

        return lastOcc - firstOcc + 1;
    }

    private static int getFirstOccurence(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        // {1,2,2,3,3,3,4,4,4};
        while (low <= high) {
            int mid = low + (high-low)/2;

            if (arr[mid] == k) {
                result  = mid;
                high = mid - 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static int getLastOccurrence(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        // {1,2,2,3,3,4,4,4};
        while (low <= high) {
            int mid = low + (high-low)/2;

            if (arr[mid] == k) {
                result  = mid;
                low = mid + 1;
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int [] sortedArray = {1,2,2,3,3,4,4,4,4,4,4};
        int k = 4;

        System.out.println(count(sortedArray,k));

    }
}
