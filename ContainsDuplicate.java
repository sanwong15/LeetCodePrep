/*
San Wong
hswong1@uci.edu

217. Contains Duplicate
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*/

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0){
            return false;
        }
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i=0; i<nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                return true;
            }
        }
        
        return false;
    }
}