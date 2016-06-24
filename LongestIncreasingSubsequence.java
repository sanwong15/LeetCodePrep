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
    /*
    Three Cases:
    1. if A[i] is smallest among all end candidates of active lists. We will start new active list of length 1
    2. if A[i] is largest among all end candidates of active lists, we will clone the largest active list and extend it by A[i]
    3. if A[i] is in between the smallest and the largest end candidates of active lists. we will find a list with largest end candidates but still smaller than A[i]. Then we will clone and extend this list by A[i]. Last, we discard all other lists of same length as that of this modified list.
    */
    
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        
        if(nums == null || size == 0) {
            return 0;
        }
        
        int[] tailTable = new int[size];
        tailTable[0] = nums[0];
        int len = 1;
        
        for(int i=1; i<size; i++){
            if (nums[i] < tailTable[0]){
                //new smallest value
                tailTable[0] = nums[i];
            }else if(nums[i] > tailTable[len-1]){
                //largest element: extend the list
                tailTable[len++] = nums[i];
            }else{
                tailTable[CeilIndex(tailTable,-1,len-1,nums[i])] = nums[i];
            }
        }
        
        for (int e: tailTable){
            System.out.print(e + " ");
        }
        
        return len;
        
    }
    
    //Binary Search
    public int CeilIndex(int[] A, int l, int r, int key){
        while(r-l>1){
            int m = l+(r-l)/2;
            if(A[m] >= key){
                r = m;
            }else{
                l = m;
            }
        }
        return r;
    }
    
    
}