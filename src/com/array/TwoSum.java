package com.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String args[]) {

      int[]  nums = {3,4,5,6};
      int target = 7;

        int[] sum = findSumBruteForce(nums , target);
        int[] sum1 = findSumUsingHashMap(nums , target);
        int[] sum2 = findSumbySorting(nums , target);

        System.out.println(Arrays.toString(sum));
        System.out.println(Arrays.toString(sum1));
        System.out.println(Arrays.toString(sum2));
    }

    private static int[] findSumbySorting(int[] nums, int target) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1 ; j > i; j--) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }

        }
        return new int[0];

    }

    private static int[] findSumUsingHashMap(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0 ; i<nums.length; i++ )
        {
            int diff = target-nums[i];

            if(map.containsKey(diff)) {
                return new int[] {map.get(diff),i};
            }
                map.put(nums[i],i);

        }
        return new int[0];
    }

    private static int[] findSumBruteForce(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }

        }
        return new int[0];

    }
}
