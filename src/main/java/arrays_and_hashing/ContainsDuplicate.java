package arrays_and_hashing;

import java.util.HashSet;
import java.util.Set;


class ContainsDuplicate {

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) { // 'add' returns true if added successfully, false if it was already present
                return true; // duplicate found
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solution = new ContainsDuplicate();

        int[] nums1 = {1, 2, 3, 3};
        System.out.println(solution.hasDuplicate(nums1)); // Output: true

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solution.hasDuplicate(nums2)); // Output: false
    }

}
