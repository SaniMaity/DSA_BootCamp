package com.bootcamp.dsa.helper.arrays.searching.modifieldBinarySearch;
/*
given a sorted array, and target
you need to find the greatest number that is less than or equal to the target element
arr={2,3,5,9,14,16,18}
target=15
Ceiling of the target will be 14
*/
public class FloorOfNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 17;
        System.out.println("Floor of target will be at indexNumber: "+getFloorOfNumber(arr,target));
    }

    private static int getFloorOfNumber(int[] arr, int target) {
        int startIndex =0;
        int endIndex = arr.length-1;
        if (arr[startIndex] == arr[endIndex]){  // incase all the element of the array are same
            return arr[startIndex] <= target ? target:-1;
        }
        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex-startIndex)/2;
            if (arr[midIndex] == target)
                return midIndex;
            if (target > arr[midIndex]){
                startIndex = midIndex + 1;
            }else endIndex = midIndex - 1;
        }
        return endIndex;
    }


}
