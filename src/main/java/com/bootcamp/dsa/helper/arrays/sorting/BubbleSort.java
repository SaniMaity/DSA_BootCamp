package com.bootcamp.dsa.helper.arrays.sorting;

import java.util.Arrays;
//compare adjuscent elements in each iteration and place the max element to the last respective position
public class BubbleSort {
    public static void main(String[] args) {
    int[] intArry = {6,7,5,2,3,1,0};
    bubbleSort(intArry);
        System.out.println(Arrays.toString(intArry));
    }
    public static void bubbleSort(int[] array){
        //step 1: loop through everyElement of the array OR run it n-1 times
        for (int i =0; i< array.length; i++){
            boolean swapped = false;
            //for each iteration max item will be placed at the last respective position
            for (int j =1; j < array.length -i; j++){//run it length -ith times as after one complete iteration the last part of the array will continue to be getting sorted, hence no point checking that
                //swap if item is smaller than previous item
                if (array[j] < array[j-1]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j]=temp;
                    swapped = true;
                }
            }
            if (!swapped){
                //if not swapped for a values of j, that mean  the rest of the array is already sorted hence break out of the loop
                break;
            }
        }
    }

}

