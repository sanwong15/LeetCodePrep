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

    int max_Len; //Max Len of LIS
    
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        
        if(len == 0) return 0;
        
        max_Len = 1; //Base case. coz we will have at least one element in the subsequence.
        recursiveLIS(nums,len);
        return max_Len;
    }
    
    public int recursiveLIS(int[] arr, int len){
        //Base case
        if(len == 1) return 1;
        
        int currLen = 1;
        int max_ending_here = 1; //Length of LIS ending with arr[n-1]
        
        for (int i=1; i<len; i++){
            //Current longest Subsequence up till index i
            currLen = recursiveLIS(arr,i);
            
            //if A[i] > A[j]
            if(arr[i-1]<arr[len-1] && currLen+1>max_ending_here){
                max_ending_here = currLen +1;
            }
        }
        
        if(max_Len < max_ending_here){
            max_Len = max_ending_here;
        }
        
        return max_ending_here;
    }
    
    
    
}