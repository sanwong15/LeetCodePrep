import java.util.HashSet;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode 260: 
 */
public class singleNumberThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {-1,0};
		int[] nums2 = {1, 2, 1, 3, 2, 5};
		
		int[] result1 = singleNumber(nums1);
		
		for(int e1: result1){
			System.out.println(e1);
		}

		System.out.println();
		
		int[] result2 = singleNumber(nums2);
		
		for(int e2: result2){
			System.out.println(e2);
		}

	}
	
    public static int[] singleNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0; i<nums.length;i++){
			if (!set.contains(nums[i])){
				set.add(nums[i]);
			}else{
				set.remove(nums[i]);
			}
		}
		int[] result = new int[set.size()];
		int j = 0;
		for (Integer e: set){
			result[j] = e.intValue();
			j++;
		}
		
		return result;
    }

}
