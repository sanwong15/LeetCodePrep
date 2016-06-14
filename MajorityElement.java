/*
San Wong
hswong1@uci.edu

169. Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        
        if (nums.length <=2) return nums[0];
        //Cal cutoff
        int cutOff = 0;
        if (nums.length % 2 == 0){
            cutOff = nums.length/2;
        }else{
            cutOff = (nums.length/2) + 1;
        }
        
        for (int i=0; i<nums.length; i++){
            if(!countMap.containsKey(nums[i])){
                countMap.put(nums[i],1);
            }else{
                int count = countMap.get(nums[i]);
                count++;
                if(count>= cutOff){
                    return nums[i];
                }else{
                    countMap.put(nums[i],count);
                }
                
            }
        }

        
        return -1;
    }
}