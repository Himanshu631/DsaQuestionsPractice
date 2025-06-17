package recursion;

public class CountSubSequences {

    public static int countSubsequences(int[] arr, int index, int sum, int k) {

        if (arr.length == index) {
            if (k==sum) {
                return 1;
            }
            return 0;
        }

        sum+=arr[index];
        int l = countSubsequences(arr, index + 1, sum, k);

        sum-=arr[index];
        int r = countSubsequences(arr, index + 1, sum, k);

        return l + r;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,1,1,1};
        System.out.println(countSubsequences(arr,0, 0, 5));
    }
}
