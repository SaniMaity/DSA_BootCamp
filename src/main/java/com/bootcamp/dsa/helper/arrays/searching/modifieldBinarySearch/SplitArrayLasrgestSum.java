package com.bootcamp.dsa.helper.arrays.searching.modifieldBinarySearch;
/*
https://leetcode.com/problems/split-array-largest-sum/description/
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
Return the minimized largest sum of the split.
A subarray is a contiguous part of the array.

Example 1:

Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are below 4 ways to split nums into two subarrays, where subarray is a contiguous part of the array
    [7,2,5,10],[8] : here largest sum among the two subArray is: 24
    [7,2,5],[10,8] : here largest sum among the two subArray is: 18
    [7,2],[5,10,8] : here largest sum among the two subArray is: 23
    [7],[2,5,10,8] : here largest sum among the two subArray is: 25
   : now the question asked to return the smallest of this 4 lasrgeSum which will be 18
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

//lets say, what could be minimum part/pieces of subArray, that's 1: which is the whole array itself
now what could be the maximum parts/pieces of subarray : that is the number of element, here: 5 in the array each considered as subarray

now at any given point what could be the maximum Large sum of a subarray : sum of all the element: here :7+2+5+10+8=32
    [7,2,5,10,18] : here largest sum among the  subArray is: 32
at any given time what could be the minimum Largest sum of an subArray: 10
    [7],[2],[5],[10],[8]: here largest sum among the  subArray is:10

now this 10-32 could be the range where my max sum should be present, while splitting the array into given number of pieces
use BS in this search space to find the actual answer


*/
public class SplitArrayLasrgestSum {
    public static void main(String[] args) {
        int[] array={7,2,5,10,8};
        int allowedPieces=2;
        int maxElement=Integer.MIN_VALUE;//this will be considered as the lowerLimit of my BS
        int sumOfElement=0;//this will be considered as upperLimit of my BS
        for (int element:array){
            sumOfElement =sumOfElement + element;
            if (element > maxElement)
                maxElement=element;
        }
        System.out.println("startElement is: "+maxElement+" and EndElement is: "+sumOfElement);
        int answer = findSplitArrayLasrgestSum(array,allowedPieces,maxElement,sumOfElement);
    }

    private static int findSplitArrayLasrgestSum(int[] array, int allowedPieces, int startElement, int endElement) {
        //using BS
        while (startElement<endElement){
            int maxSum = startElement + (endElement-startElement)/2; //nothing but mid in BS{
            //calculate how many pieces you can divide the arrays into, with the maxSum
            int individualSubArraySum =0;
            int pieces =1;
            for (int element: array){
                if (individualSubArraySum + element > maxSum){
                    //the element can't be added to this subArray make a new one
                    pieces ++;
                    //now your individualSubArraySum = element as you are starting new subArray
                    individualSubArraySum = element;
                }else {
                    //you can continue adding individualSubArraySum into the same subArray
                    individualSubArraySum = individualSubArraySum + element;
                }
            }
            if (pieces > allowedPieces){
                startElement = maxSum +1;//new piece can't be added so search in the right side of the searchSpace
            }else endElement = maxSum;
        }
        return startElement;//can return either start/end here start will be == end

    }


}
