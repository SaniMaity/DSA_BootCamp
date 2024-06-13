package com.bootcamp.dsa.helper.arrays.searching.binarySearch;

/*
You don't know whether the array is sorted in AscendingOr Descending order
firstly check if the Array is in AscendingOrder / Descending Order
best way to check that if first element of the Array is > last element in the array
if yes then it's in Ascending Order or else It's  in Descending order
    Logical part is exactly same as Binary search
Based on that you decided whether to search in Left part or in the Right part of the array
*/

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int randomSortedArray[] = {1,3,5,7,10,21,23};
        int target = 1;
        System.out.println("OrderAgnosticBS: TargetElement present in index: "+orderAgnnosticBinarySearch(randomSortedArray,target));
        int randomSortedArray2[] = {40,33,23,17,16,7,6,4,1,0};
        int target2 = 0;
        System.out.println("OrderAgnosticBS: TargetElement present in index: "+orderAgnnosticBinarySearch(randomSortedArray2,target2));
    }

    private static int orderAgnnosticBinarySearch(int[] randomSortedArray, int target) {
        if (randomSortedArray.length == 0)
            return -1;
        int startIndex=0;
        int endIndex=randomSortedArray.length-1;
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
}
