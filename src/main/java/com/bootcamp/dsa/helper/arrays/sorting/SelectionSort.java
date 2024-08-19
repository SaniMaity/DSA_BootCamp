package com.bootcamp.dsa.helper.arrays.sorting;

import java.util.Arrays;
//pick  the max element from the array and place it to it's correct index

public class SelectionSort {
    public static void main(String[] args) {
        int[] intArry = {6,7,5,2,3,1,0};
        selectionSort(intArry);
        System.out.println(Arrays.toString(intArry));
    }
    public static void selectionSort(int[] intArray){
        for (int i=0; i < intArray.length; i++){
            //find the max element of the remaining array and swap with correct index
            int lastIndex = intArray.length -i -1;//running it till the remaining part of the array which is not sorted
            int maxIndex = getMaxindex(intArray, 0,lastIndex);
            swapElements(intArray,maxIndex,lastIndex);
        }
    }

    private static void swapElements(int[] intArray, int first, int second) {
        int temp = intArray[second];
        intArray[second]=intArray[first];
        intArray[first]=temp;
    }

    private static int getMaxindex(int[] intArray, int start, int end) {
        int maxIndex = start;
        for (int i = start; i<= end; i++){
            if (intArray[i]>intArray[maxIndex]){
                maxIndex=i;
            }
        }
        return maxIndex;
    }
}
