
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/
import java.util.*;

class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 5, 11 };
        int target = 10;
        int[] res = twoSum(nums, target);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int testKey = target - nums[i];
            if (map.containsKey(testKey)) {
                return new int[] { map.get(testKey), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}