package arrays_and_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        // pre-size to fit up to n-1 entries without resizing (load factor: 0.75)
        Map<Integer, Integer> seen = new HashMap<>((int) (nums.length / 0.75f) + 1);

        // Iterate through the array once
        for (int i = 0; i < nums.length; i++) {
            // calculate the complement we need to reach target
            int complement = target - nums[i];
            // if the complement was seen before, return its stored index (j) and current index (i)
            Integer j = seen.get(complement);
            if (j != null) {
                return new int[]{j, i};
            }
            // otherwise remember this value with its index for future lookups
            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3, 4, 5, 6}, 7)));  // Output: [0,1]
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{5, 5}, 10)));       // Output: [0,1]
    }

}
