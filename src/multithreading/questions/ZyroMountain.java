package multithreading.questions;

public class ZyroMountain {

    public static int lengthOfLongestMountain(int[] arr) {
        int n = arr.length;
        int maxLength = 0;

        for (int i = 1; i < n - 1; i++) {

            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                int left = i - 1;
                int right = i + 1;

                while (left > 0 && arr[left] >  arr[left - 1]) {
                    left --;
                }

                while (right < n -1 && arr[right] > arr[right + 1]) {
                    right ++;
                }

                int length = right - left + 1;
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println(lengthOfLongestMountain(arr));
    }
}
