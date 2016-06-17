/*
San Wong
hswong1@uci.edu

350. Intersection of Two Arrays II
Given two arrays, write a function to compute their intersection.
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
*/

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        HashMap<Integer, Integer> count = new HashMap<Integer,Integer>();
        for (int e: nums1){
            if (!count.containsKey(e)){
                count.put(e,1);
            }else{
                int currentCount = count.get(e);
                count.put(e,currentCount+1);
            }
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int e: nums2){
            if(count.containsKey(e) && count.get(e)>0){
                result.add(e);
                int freq = count.get(e);
                count.put(e, freq-1);
            }
        }
        
        int size = result.size();
        int[] array = new int[size];
        
        for(int i=0; i<size; i++){
            array[i] = result.get(i);
        }
        
        return array;
    }
}