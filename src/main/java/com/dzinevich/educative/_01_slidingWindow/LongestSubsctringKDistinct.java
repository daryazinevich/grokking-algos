package com.dzinevich.educative._01_slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubsctringKDistinct {

    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k) {
            throw new IllegalArgumentException();
        }

        int windowStart = 0;
        int maxLength = 0;

        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        // in the loop we will try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // ! the same chars go to the same key as keys are distinct
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window
            // until we are left with k distinct characters in the frequency map
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring " + LongestSubsctringKDistinct.findLength("araaci", 2)
                + ". Should be 4");
        System.out.println("Length of the longest substring " + LongestSubsctringKDistinct.findLength("araaci", 1)
                + ". Should be 2");
        System.out.println("Length of the longest substring " + LongestSubsctringKDistinct.findLength("cbbebi", 3)
                + ". Should be 5");
    }
}
