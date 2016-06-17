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
        
        if (nums1 == null || nums2 == null || len1 == 0 || len2 == 0){
            return new int[0];
        }
        

        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i=0;
        int j=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(i<len1 && j<len2){
            if (nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        
        int size = list.size();
        int[] result = new int[size];
        
        for(i=0; i<size; i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}