package com.bootcamp.dsa.helper.arrays.searching.modifieldBinarySearch;

import java.util.Arrays;

/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

//run BS twice one for finding 1st occurrence of the element
//another for the last occurrence of the element

*/
public class firstAndLastOccuranceOfElement {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        int[] ansr = {-1,-1};   //initialising the answer as default values
        int startOccurrence = getFisrOrLastOccuranceOfTarget(nums,target,true);
        int lastOccurrence = getFisrOrLastOccuranceOfTarget(nums,target,false);
        ansr[0]=startOccurrence;
        ansr[1]=lastOccurrence;
        System.out.println("startAndLast occurrence of target is: "+ Arrays.toString(ansr));
    }

    private static int getFisrOrLastOccuranceOfTarget(int[] nums, int target, boolean ifSearchingForFirstOccurrence) {
        int ansr=-1;
        int startIndex = 0;
        int endIndex = nums.length -1;
        if (startIndex == endIndex){
            return nums[startIndex] == target ? startIndex : ansr ;
        }

        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if (nums[midIndex] == target){
                ansr = midIndex;    //possible answer is found
                if(ifSearchingForFirstOccurrence){  //if searching for firstOccurrence then possible that there is more target element present in the left part
                    endIndex = midIndex - 1;
                }else startIndex = midIndex + 1;    //if searching for lastOccurrence  then possible of more tarhet element present in the right hand part
            }
            if (target > nums[midIndex]){
                startIndex = midIndex + 1;
            } else endIndex = midIndex -1;

        }
        return ansr;
    }
}
