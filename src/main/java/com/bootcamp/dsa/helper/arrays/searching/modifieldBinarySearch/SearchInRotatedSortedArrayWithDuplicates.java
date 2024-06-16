package com.bootcamp.dsa.helper.arrays.searching.modifieldBinarySearch;
/*

refer to SearchInRotatedSortedArray first this is slight modification to that


*/
public class SearchInRotatedSortedArrayWithDuplicates {
    public static void main(String[] args) {
        int array[] = {4,5,6,7,8,1,2,3,4,2};
        int target = 3;

        int pivotIndex=getPivotElementIndexInDuplicateArray(array);
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
    private static int getPivotElementIndexInDuplicateArray(int[] array){
        int startIndex = 0;
        int endIndex = array.length -1;

        while (startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;

            if (midIndex < endIndex && array[midIndex] > array[midIndex +1]){ //case 1 : larger element or the pivot is mid Element
                return midIndex;
            } else if (midIndex > startIndex && array[midIndex] < array[midIndex - 1]) { //case 2: pivot will be mid -1 element
                return midIndex -1;
            }
            //check if start mid and end are same then skip the duplicates from both he end, as we are trying to find the pivot/larger no
            if (array[startIndex] == array[midIndex] && array[midIndex] == array[endIndex]){
                //first check if start element is pivot or not before skipping it
                if (array[startIndex] > array[startIndex + 1]){
                    return startIndex;
                }
                startIndex ++;

                //check if end is pivot or not before skipping the end
                if (array[endIndex] < array[endIndex -1]){
                    return endIndex-1;
                }
                endIndex--;
            }
            //left side is sorted so pivot should be in the right side
            else if (array[startIndex] < array[midIndex] || array[startIndex] == array[midIndex] && array[midIndex] < array[endIndex] ) {
                startIndex = midIndex + 1;
            }else endIndex = midIndex -1;
        }
        return -1;
    }
}

