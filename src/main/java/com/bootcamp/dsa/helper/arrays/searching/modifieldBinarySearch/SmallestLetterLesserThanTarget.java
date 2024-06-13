package com.bootcamp.dsa.helper.arrays.searching.modifieldBinarySearch;
/*

You are given an array of characters letters that is sorted in non-decreasing order, and a
character target. There are at least two different characters in letters.

Return the Largest character in letters that is lexicographically lesser than target.
If such a character does not exist, return the first character in letters.

Example 1:
Input: letters = ["c","f","j"], target = "f"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.

*/
public class SmallestLetterLesserThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'j';
        System.out.println("Largest Letter which is lesser than target is at: "+getLargestLetterLesserThanTarget(letters,target));

    }
    private static int getLargestLetterLesserThanTarget(char[] letters, char target) {
        int startIndex = 0;
        int endIndex = letters.length - 1;
        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if (target > letters[midIndex]){
                startIndex = midIndex + 1;
            }else endIndex = midIndex - 1;
        }
        return startIndex==letters.length ? 0 : endIndex; //as this it's one of the condition which is if you search entirely and nothing found then return the first index
    }
}
