package com.bootcamp.dsa.helper.arrays.searching.modifieldBinarySearch;
/*
https://leetcode.com/problems/search-in-rotated-sorted-array/description/
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

//need to find the pivot then BS on the left half if not found search in the right half of the array
// as pivot is the place where left half will be ascending and right hand will be ascending
//pivot will be the largest element in this array
//find pivot:
case 1: if mid element > mid +1 element then pivot is: mid element and  make sure midIndex < endIndex avoiding indexOutOfBound
case 2: if mid  element < mid-1 element then mid-1 is the pivot  and make sure midIndex > startIndex
case 3: if start > mid element then search only in the left side of the array, as all the element from start till mid will be greater than mid
        as we are trying to find the larger element which is pivot so pivot must lie in left hand side
        end = mid -1;
case 4: if start < mid element then largest number will lie in the right side of the array,
    cause if mid will be pivot then it could have caught earlier check 1 and 2
    start = mid +1;
*/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int array[] = {4,5,6,7,8,1,2,3,4,2};
        int target = 3;

        int pivotIndex=getPivotElementIndex(array);
        System.out.println("pivot element is: "+array[pivotIndex]);
        int ansr = -1;
        ansr = searchTargetInSortedArrayBS(array, target, 0, pivotIndex);
        if (ansr == -1){
            ansr = searchTargetInSortedArrayBS(array, target, pivotIndex +1, array.length -1);
        }
        System.out.println("target element found in index no: "+ansr);

    }

    private static int searchTargetInSortedArrayBS(int[] array, int target, int startIndex, int endIndex) {
        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if (array[midIndex] == target){
                return midIndex;
            }
            if (target > array[midIndex]){
                startIndex = midIndex+1;
            }else endIndex = midIndex -1;
        }
        return -1;
    }


    private static int getPivotElementIndex(int[] array) {
        int startIndex = 0;
        int endIndex = array.length -1;

        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if (midIndex < endIndex && array[midIndex] > array[midIndex +1]){ //case 1 : larger element or the pivot is mid Element
                return midIndex;
            } else if (midIndex > startIndex && array[midIndex] < array[midIndex - 1]) { //case 2: pivot will be mid -1 element
                return midIndex -1;
            }
            if (array[midIndex] <= array[startIndex]){   //case 3: all the larger element will be from start till mid hence search from start till mid
                endIndex = midIndex -1;
            }else startIndex = midIndex + 1; //case 4: larger element will lie in the right side of this array so search from mid till end
        }
        return -1;
    }
}
