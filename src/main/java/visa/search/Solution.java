package visa.search;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int search(int[] nums, int target) {
        try {
            if(nums.length == 0) return -1;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            int position = 0;
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }

            return map.get(target);

        } catch (NullPointerException e){
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr0 = {1};
//        int[] arr1 = {0,1,2,4,5,6,7};
//        int[] arr2 = {2,4,5,6,7,0,1};
        int target = 0;

        Solution sol = new Solution();

        System.out.println(sol.search(arr0, 0));


    }
}
