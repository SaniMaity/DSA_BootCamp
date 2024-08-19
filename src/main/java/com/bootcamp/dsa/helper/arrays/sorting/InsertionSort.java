package com.bootcamp.dsa.helper.arrays.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] intArry = {6,7,5,2,3,1,0,-9};
        insertionSort(intArry);
        System.out.println(Arrays.toString(intArry));
    }

    private static void insertionSort(int[] intArry) {
        for (int i=0; i<intArry.length-1; i++){
            for (int j = i+1; j>0; j--){
                if (intArry[j]<intArry[j-1]){
                    swapElements(intArry,j,j-1);
                }else {
                    break;
                }
            }
        }
    }

    private static void swapElements(int[] intArry, int first, int second) {
        int temp = intArry[second];
        intArry[second] = intArry[first];
        intArry[first] = temp;
    }


}
