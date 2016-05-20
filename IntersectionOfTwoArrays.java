import java.util.ArrayList;
import java.util.HashSet;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode 349. Intersection of Two Arrays
 * Given two arrays, write a function to compute their intersection.
 * Example:Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2]
 * 
 * It returns the element that exists in both interger array
 */


public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1 = {1,2,2,1};
		int[] num2 = {2,2};
		int[] num3 = {1,2};
		
		System.out.println("nums1 = {1,2,2,1}");
		System.out.println("nums2 = {2,2}");
		System.out.println("Element that intercept: ");
		int[] result = intersect(num1,num2);
		
		for (int e: result){
			System.out.println(e);
		}
		
		System.out.println();
		
		System.out.println("nums1 = {1,2,2,1}");
		System.out.println("nums2 = {1,2}");
		System.out.println("Element that intercept: ");
		int[] result1 = intersect(num1,num3);
		
		for (int e: result1){
			System.out.println(e);
		}

	}
	
	public static int[] intersect(int[] nums1, int[] nums2){
		HashSet<Integer> hSet = new HashSet<Integer>();
		
		for (int i=0; i<nums1.length; i++){
			hSet.add(nums1[i]);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int j=0; j<nums2.length;j++){
			if (hSet.contains(nums2[j])){
				list.add(nums2[j]);
				hSet.remove(nums2[j]);
			}
		}
		
		int[] result = new int[list.size()];
		for (int k=0; k<list.size();k++){
			result[k] = list.get(k).intValue();
		}
		
		return result;
		
	}

}
