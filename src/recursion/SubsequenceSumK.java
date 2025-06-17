package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceSumK {

    public static void getSumEqualToK(int[] arr, int index, List<Integer> currentList, int sum, int k){
        if (index == arr.length) {
            if (k == sum) {
                System.out.println(currentList);
            }
            return;
        }

        currentList.add(arr[index]);
        sum += arr[index];
        getSumEqualToK(arr, index+1, currentList, sum, k);
        currentList.remove(currentList.size()-1);
        sum -= arr[index];

        getSumEqualToK(arr, index+1, currentList, sum, k);
    }


    public static void main(String[] args) {
        int[] arr = {1,2,1};
        getSumEqualToK(arr, 0, new ArrayList<>(),0, 2);

    }
}
