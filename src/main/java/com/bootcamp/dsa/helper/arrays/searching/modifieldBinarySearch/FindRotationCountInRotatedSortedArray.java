package com.bootcamp.dsa.helper.arrays.searching.modifieldBinarySearch;
/*
https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
Given an array arr[] of size N having distinct numbers sorted in increasing order and the array has been right rotated (i.e,
the last element will be cyclically shifted to the starting position of the array) k number of times, the task is to find the value of k.

Input: arr[] = {15, 18, 2, 3, 6, 12}
Output: 2
Explanation: Initial array must be {2, 3, 6, 12, 15, 18}.
We get the given array after rotating the initial array twice.

Input: arr[] = {7, 9, 11, 12, 5}
Output: 4

//find the pivot element in the array, number of rotation will be the index+1 of that pivot element
*/
public class FindRotationCountInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = {7, 9, 11, 12, 5};
        int pivotIndex = -1;
        pivotIndex = getPivot(array);
        System.out.println("pivot element is: "+array[pivotIndex]);
        System.out.println("number of rotation is "+(pivotIndex+1));
    }

    private static int getPivot(int[] array) {
        int startIndex = 0;
        int endIndex = array.length -1;
        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            //case 1: if mid element > mid +1 element then pivot is: mid element and  make sure midIndex < endIndex avoiding indexOutOfBound
            if (array[midIndex] > array[midIndex +1] && midIndex < endIndex){
                return midIndex;
            } else if (array[midIndex] < array[midIndex -1] && midIndex > startIndex) {   //case 2: if mid  element < mid-1 element then mid-1 is the pivot  and make sure midIndex > startIndex
                return midIndex-1;
            }
            if (array[midIndex] <= array[startIndex]){   //case 3: all the larger element will be from start till mid hence search from start till mid
                endIndex = midIndex -1;
            }else startIndex = midIndex + 1; //case 4: larger element will lie in the right side of this array so search from mid till end
        }
        return -1;
    }


}
