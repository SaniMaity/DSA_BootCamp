package com.bootcamp.dsa.helper.arrays.searching.modifieldBinarySearch;
/*
https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
Same as https://leetcode.com/problems/find-peak-element/description/
You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
Return the index of the peak element.
Your task is to solve it in O(log(n)) time complexity.

Example 1:

Input: arr = [0,1,0]
Output: 1

//there is two half of the array one is in ascending order and the 2nd half is in descending order
//1. while checking the mid, check if the mid-element is > the mid+1 element that mean you are on the Descending part of the array
    so your mid might be the ans but check the left side in-case larger element might present there
    end = mid
    2. else if mid-element is < mid+1 element then you are in the ascending order part of the array, so definitely larger element will present
    on the right hand side of the array
    start = mid +1
    //loop will be violated if start > end
    //and at the end start and end will point to same, which will be  the largest element
    //because start and end are trying t o find the max element because of the above two cases

*/

public class PeakInMountainArray {
    public static void main(String[] args) {
        int[] array = {0,1,3,7,9,6,4,2,0};
        System.out.println("largestElement is at indexNo: "+getLasrgestElementPosition(array));
    }

    private static int getLasrgestElementPosition(int[] array) {
        int startIndex =0;
        int endIndex=array.length -1;
        while(startIndex < endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if (array[midIndex] > array[midIndex + 1]){//you are in  the descending part of the array
                endIndex = midIndex;
            }else // array[midIndex] < array[midIndex + 1]) ie: you are in the ascending part of the array
                startIndex = midIndex +1;
            }
        return startIndex; //you can return end also, as both of them will be pointing to the same element which is the largest element
        }
}
