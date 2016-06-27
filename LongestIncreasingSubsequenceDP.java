/*
San Wong
hswong1@uci.edu

300. Longest Increasing Subsequence
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it 
is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        
        int[] LIS = new int[len];
        int i,j,max = 0;
        
        //Initialize
        for (i=0; i<len; i++){
            LIS[i] = 1;
        }
        
        //Bottom Up
        for (i = 1; i<len; i++){
            for ( j = 0; j<i; j++){
                if(nums[i] > nums[j] && 1+LIS[j] >LIS[i]){
                    LIS[i] = 1+LIS[j];
                }
            }
        }
        
        for (i=0; i<len; i++){
            if(max<LIS[i]){
                max = LIS[i];
            }
        }
        
        return max;

    }
    
}