package com.bootcamp.dsa.helper.arrays.searching.modifieldBinarySearch;
/*
https://leetcode.com/problems/find-in-mountain-array/description/
You may recall that an array arr is a mountain array if and only if:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

Example 1:
Input: array = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.

//first search the peak of this Array, as that you can have two different searchSpace to apply BS on in-order to search the targett
you then use orderAgnostic BS in the leftHand side ie: start till the peakElementIndex
if not found then try right hand side of the array accordingly ie: peakElementIndex till arrayLength-1
//using order-agnostic BS cause left side of the array will be in AscendingOrder and right part of the array will be Descending order

*/
public class FindInMountainArray {
    public static void main(String[] args) {
        int array[] = {1,2,3,4,10,8,7,6};
        int target = 13;
        int ansr = -1;
        int peakElementIndex=getPeakInMountainArray(array);
        System.out.println("peakElement is: "+array[peakElementIndex]);

        ansr = orderAgnnosticBinarySearch(array,target,0,peakElementIndex);//first try in the left part of the array
        if (ansr == -1){//if not found in the lleft part then try right part of the array
            ansr = orderAgnnosticBinarySearch(array,target,peakElementIndex,array.length-1);
        }
        System.out.println("targetElement found in index number: "+ansr);

    }
    private static int orderAgnnosticBinarySearch(int[] randomSortedArray, int target,int startIndex,int endIndex) {
        if (randomSortedArray[startIndex] == randomSortedArray[endIndex]){  //incase all the element of the array are same
            return randomSortedArray[startIndex] == target ? target:-1;
        }
        boolean isAscending=randomSortedArray[endIndex] > randomSortedArray[startIndex];
        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex-startIndex)/2;
            if (randomSortedArray[midIndex] == target)
                return midIndex;
            if (isAscending){       //When the array is in ascending order
                if (randomSortedArray[midIndex] > target)
                    endIndex = midIndex - 1;    //searching on the left side of the Array as mid-element  larger than target
                else startIndex = midIndex + 1; //Searching on the Right side of the Array as mid-element smaller than target
            }else {                         //When the array is in Descending order
                if (randomSortedArray[midIndex] > target)
                    startIndex = midIndex +1;   //Searching on the Right side of the Array as mid-element larger than target
                else endIndex = midIndex -1;    //searching on the left side of the Array as mid-element  smaller than target
            }
        }
        return -1;
    }

    private static int getPeakInMountainArray(int[] array) {
        int startIndex = 0;
        int endIndex = array.length -1;
        while (startIndex < endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if (array[midIndex] > array[midIndex + 1]){
                endIndex = midIndex;
            }else startIndex = midIndex +1;
        }
        return startIndex;
    }
}
