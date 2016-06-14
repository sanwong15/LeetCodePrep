/*
San Wong
hswong1@uci.edu

169. Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Method that don't use a HashMap but it assume majority elementa always exist.
*/

public class Solution {
    public int majorityElement(int[] nums) {
         if (nums == null || nums.length ==0){
            return 0;
        }
        
        int major = nums[0];
        int count = 1;
        
        for (int i=1; i<nums.length; i++){
            if (nums[i] != major){
                count--;
            }else{
                count++;
            }
            
            if (count == 0){
                major = nums[i];
                count = 1;
            }
        }
        
        return major;
        

    }
}