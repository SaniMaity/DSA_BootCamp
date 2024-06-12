package com.bootcamp.dsa.helper.arrays.binarySearch;

/*
Arrays must be sorted
set startIndex = 0
set endIndex = arrayLength -1
mid = (start + end)/2
    OR start + (end -start) /2 #in-order to avoid stepping out of the integer range in case of start and end values are huge numbers
while(start < end)
{
 check if arr[mid] = target;
    target found return mid
 if(target < arr[mid])
    end = mid - 1     #search left part of the array
 if(target > arr[mid])
    start=mid + 1     #search right part of the array
}
if not found return -1      ##now start becomes > end hence return invalid index '-1' target not found
*/

public class BinarySearch {
    public static void main(String[] args) {
        int[] ascArr = {1,3,5,7,10,21,23};
        int target = 10;
        System.out.println("Asc: TargetElement present in index: "+binarySearchForAscendingArray(ascArr,target));
        int[]  descArr = {40,33,23,17,16,7,6,4,1,0};
        int target2=1;
        System.out.println("Desc: TargetElement present in index: "+binarySearchForDescendingArray(descArr,target2));
    }

    private static int binarySearchForAscendingArray(int[] ascArr, int target) {
        if (ascArr.length == 0) //meaning this is an empty array
            return -1;
        int startIndex =0;
        int endIndex = ascArr.length-1;
        if (ascArr[startIndex] == ascArr[endIndex]){  //incase all the element of the array are same
            return ascArr[startIndex] == target ? target:-1;
        }

        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if (ascArr[midIndex] == target){
                return midIndex;
            }
            if (target > ascArr[midIndex]){
                startIndex = midIndex+1;        //searching in the rightSide of  the array
            }else endIndex = midIndex-1;    //searching in the LeftSide of  the array
        }
        return -1;  //target element doesn't present in the array
    }

    private static int binarySearchForDescendingArray(int[] descArr, int target) {
        if (descArr.length == 0) //meaning this is an empty array
            return -1;
        int startIndex =0;
        int endIndex = descArr.length-1;
        if (descArr[startIndex] == descArr[endIndex]){  //incase all the element of the array are same
            return descArr[startIndex] == target ? target:-1;
        }

        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if (descArr[midIndex] == target){
                return midIndex;
            }
            if (target > descArr[midIndex]){
                endIndex = midIndex-1; //searching in the LeftSide of the array as the array is in Descending order
            }else startIndex = midIndex+1;;    //searching in the RightSide of  the array as the array is in Descending order
        }
        return -1;  //target element doesn't present in the array
    }
}
