package com.dzinevich.leetcode.backtracking;

import java.util.Arrays;

/**
 * Given an integer array nums,
 * return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array
 * by deleting some or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class LongestSubsequence {

    public int longestIncreasingSubseq(int[] nums) {

        int[] cache = new int[nums.length];
        for(int i = 0; i < nums.length; i++) { //O(n)
            cache[i] = 1;
        }

        for(int i = nums.length - 1; i >= 0; i--) { // O(n^2)

            for (int j = i+1; j < nums.length; j++) {

                if (nums[i] < nums[j]) {

                    cache[i] = Math.max(cache[i], 1 + cache[j]);

                }
            }
        }

        Arrays.sort(cache); // O(n*logn)

        return cache[cache.length-1];
        // O(n) + O(n^2) + O(nlogn) == O(n^2)
    }


    public static void main(String[] args) {
        LongestSubsequence L = new LongestSubsequence();
        System.out.println(L.longestIncreasingSubseq(new int[]{10, 9, 2, 5, 3, 7, 101, 18}) + " : ex 4");
        System.out.println(L.longestIncreasingSubseq(new int[]{0,1,0,3,2,3}) + " : ex 4");
        System.out.println(L.longestIncreasingSubseq(new int[]{7,7,7,7,7,7,7}) + " :ex 1");
    }
}
