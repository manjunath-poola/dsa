package com.manju.interview.questions.leetcode;

/*

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.
        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]
        Constraints:

        2 <= nums.length <= 104
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        Only one valid answer exists.

        Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?*/

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSum {
    public static void main(String[] args) {
//        twoSum(new int[]{2, 7, 11, 15}, 9);   //o/p [0,1]
//        twoSum(new int[]{3, 2, 4}, 6); //o/p [1,2]
        twoSum(new int[]{3, 3, 4}, 6); //[0,1]
    }

    private static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2 || nums.length > Math.pow(10, 4)) {
            return nums;
        }
        int n = nums.length;
        Map<Integer, List<Integer>> mapOfNums = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if ((target > 0 && target < nums[i]) || (target < 0 && target > nums[i])) {
                continue;
            }
            if (mapOfNums.containsKey(nums[i])) {
                List<Integer> list = mapOfNums.get(nums[i]);
                list.add(i);
                mapOfNums.put(nums[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                mapOfNums.put(nums[i], list);
            }
        } // 3,4,1,4,1  target= 5,  3,{0},4-{1,3},1-{2,4}
        for (int i = 0; i < nums.length; i++) {
            int anotherNum = target - nums[i];
            if (mapOfNums.containsKey(anotherNum)) {
                List<Integer> sIndexList = new ArrayList<>(mapOfNums.get(anotherNum));
                if (nums[i] == anotherNum) {
                    if (sIndexList.size() == 1) {
                        continue;
                    }
                    System.out.println("[" + sIndexList.get(0) + "," + sIndexList.get(1) + "]");
                    return new int[]{sIndexList.get(0), sIndexList.get(1)};
                } else {
                    System.out.println("[" + i + "," + sIndexList.get(0) + "]");
                    return new int[]{i, sIndexList.get(0)};
                }
            }
        }

        return nums;
    }
}


