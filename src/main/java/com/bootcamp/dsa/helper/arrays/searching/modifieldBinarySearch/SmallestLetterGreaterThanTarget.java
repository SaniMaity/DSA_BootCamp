package com.bootcamp.dsa.helper.arrays.searching.modifieldBinarySearch;
/*
https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
You are given an array of characters letters that is sorted in non-decreasing order, and a
character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target.
If such a character does not exist, return the first character in letters.

Example 1:
Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.

*/

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'z';
        System.out.println("smallestLetter which is greater than target is at: "+getSmallestLetterGreaterThanTarget(letters,target));

    }
    private static int getSmallestLetterGreaterThanTarget(char[] letters, char target) {
        int startIndex = 0;
        int endIndex = letters.length - 1;
        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if (target < letters[midIndex]) {
                endIndex = midIndex - 1;
            } else startIndex = midIndex + 1;
        }
        return startIndex==letters.length ? 0 : startIndex; //as this it's one of the condition which is if you search entirely and nothing found then return the first index
    }
}
