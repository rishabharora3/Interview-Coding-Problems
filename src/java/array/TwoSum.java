package java.array;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hashmap.containsKey(diff) && hashmap.get(diff) != i) {
                return new int[]{i, hashmap.get(diff)};
            }
            hashmap.put(nums[i], i);
        }
        return null;
    }

}
