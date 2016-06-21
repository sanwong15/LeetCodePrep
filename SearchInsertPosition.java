/*
San Wong
hswong1@uci.edu

35. Search Insert Position
Given a sorted array and a target value, return the index if the target is 
found. If not, return the index where it would be if it were inserted in 
order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/


public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        
        if(len == 0) return 0;
        if(target<=nums[0]) return 0;
        if(target > nums[len-1]) return len;
        
        int low = 0;
        int high = len-1;
        int mid = (low+high)/2;
        
        while(low!=mid){
            if (target == nums[mid]){
                return mid;
            } else if (target < nums[mid]){
                high = mid;
            }else{
                low = mid;
            }
            //Update mid
            mid = (low+high)/2;
        }
        return high;
        
    }
}