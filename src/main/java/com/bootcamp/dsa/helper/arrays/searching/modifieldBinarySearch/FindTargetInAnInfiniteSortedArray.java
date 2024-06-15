package com.bootcamp.dsa.helper.arrays.searching.modifieldBinarySearch;
/*
you have given an sorted array and a target, need to find the index of the target element.Condition is, consider
the given array is an infinite array.
Basically you can't use the arr.length for the end index.
//same as BS, just try to do BS in batches/chunk of the given array,
//and then grow the chunk size double everytime till you don't find the element

*/

public class FindTargetInAnInfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,3,6,7,9,12,16,18,20,80,100,104,130,175,315,678,984,1000};
        int target = 80;
        int startPos=0;
        int endPos=1;//start the range of two
        while ( target > arr[endPos]){   //trying to find the range where I should use BS
            // size of previous range = (endPos - (startPos -1) = endPos - startPos +1
            int tmpstart = endPos +1;
            endPos = endPos + (endPos - startPos +1) *2;    //doubling the size of the range
            startPos = tmpstart;
        }
        System.out.println("Target element found in indexNumber: "+findTargetInArray(arr,target,startPos,endPos));
    }

    private static int findTargetInArray(int[] arr, int target, int startIndex, int endIndex) {
        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if (arr[midIndex] == target)
                return midIndex;
            if (target > arr[midIndex])
                startIndex = midIndex + 1;
            else endIndex = midIndex -1;
        }
        return -1;
    }
}
