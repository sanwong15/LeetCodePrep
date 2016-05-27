import java.util.HashMap;
import java.util.HashSet;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode 136: Single Number
 * Given an array of integers, every element appears twice except for one
 * Find that single one.
 * 
 * Linear Run Time. Without using memory
 */
public class singleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,10,15,8,15,10,5};
		System.out.println(findSingle(nums));
		System.out.println(findSingleWithSet(nums));
		System.out.println(findSingleXOR(nums));

	}
	
	public static int findSingle(int[] nums){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0; i<nums.length;i++){
			if (!map.containsKey(nums[i])){
				map.put(nums[i], 1);
			}else{
				map.remove(nums[i]);
			}
		}
		
		return map.keySet().iterator().next();
	}
	
	public static int findSingleWithSet(int[] nums){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<nums.length;i++){
			if (!set.contains(nums[i])){
				set.add(nums[i]);
			}else{
				set.remove(nums[i]);
			}
		}
		
		return set.iterator().next();
	}
	
	public static int findSingleXOR(int[] nums){
		int result = 0;
		for (int e: nums){
			System.out.println("e: " + e);
			System.out.println("result before XOR: " + result);
			result ^=e;
			System.out.println("result after XOR: " + result);
		}
		
		return result;
	}

}
