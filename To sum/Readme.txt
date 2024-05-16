Two Sum Problem Solution

This repository contains a Java solution for the Two Sum problem, a common algorithmic challenge where the goal is to find two numbers in an array that add up to a specific target value.
Problem Description

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to the target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Solution

The solution is implemented in the `Solution` class, which contains the method `twoSum`.

Method Signature

java
public int[] twoSum(int[] nums, int target)

Parameters

- `int[] nums`: An array of integers.
- `int target`: The target integer to which two numbers in the array should add up.

Returns

- `int[]`: An array containing the indices of the two numbers that add up to the target. If no such pair exists, the method returns `{-1, -1}`.

Implementation Details

The method uses a `HashMap` to store the value of each element in `nums` as a key and its index as the value. It then iterates through the array and for each element, calculates the complement (i.e., `target - nums[i]`). If the complement is found in the `HashMap`, it returns the indices of the current element and the complement. If the loop completes without finding a solution, it returns `{-1, -1}`.

Example

java
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);  // Output: Indices: 0, 1
    }
}


