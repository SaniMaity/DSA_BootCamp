package com.bootcamp.dsa.helper.arrays.searching.modifieldBinarySearch;
/*
given a sorted array, and target
you need to find the smallest number that is greater or equal to the target element
arr={2,3,5,9,14,16,18}
target=15
Ceiling of the target will be 16
*/

public class CeilingOfNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 4;
        System.out.println("Ceiling of target will be at indexNumber: "+getCeilingOfNumber(arr,target));
    }

    private static int getCeilingOfNumber(int[] arr, int target) {
        int startIndex =0;
        int endIndex = arr.length-1;
        if (arr[startIndex] == arr[endIndex]){  // incase all the element of the array are same
            return arr[startIndex] >= target ? target:-1;
        }
        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if (arr[midIndex] == target){
                return midIndex;
            }
            if (target > arr[midIndex]){
                startIndex = midIndex+1;        //searching in the rightSide of  the array
            }else endIndex = midIndex-1;    //searching in the LeftSide of  the array
        }
        return startIndex;
    }
}
