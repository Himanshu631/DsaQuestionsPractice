package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceSumExists {

    public static boolean checkSubSequenceSumExists(int[] arr, int index, int sum, int k, List<Integer> currentList) {

        if (arr.length == index) {
            if (k==sum) {
                System.out.println(currentList);
                return true;
            }
            return false;
        }

        sum+=arr[index];
        currentList.add(arr[index]);
        if (checkSubSequenceSumExists(arr, index+1, sum, k, currentList)) {
            return true;
        }

        currentList.remove(currentList.size()-1);
        sum-=arr[index];
        return checkSubSequenceSumExists(arr, index + 1, sum, k, currentList);
    }


    public static void main(String[] args) {
        int[] arr = {1,2,1};
        System.out.println(checkSubSequenceSumExists(arr,0, 0, 2, new ArrayList<>()));
    }
}
