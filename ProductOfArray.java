/*
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode 238: Product of Array Except Self
 * Given an array of n integers where n > 1, nums, 
 * return an array output such that output[i] is equal to
 *  the product of all the elements of nums except nums[i].
 *  
 *  Solve it without division and in O(n).
 *  For example, given [1,2,3,4], return [24,12,8,6].
 *  
 *  Follow up:
 *  Could you solve it with constant space complexity?
 *   (Note: The output array does not count as extra space
 *   for the purpose of space complexity analysis.)
 * 
 */
public class ProductOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4};
		System.out.println("nums[] = [1,2,3,4]");
		int[] result = productExceptSelf(nums);
		System.out.println("Here's the result. We are expecting [24,12,8,6]");
		System.out.println("Result");
		for (int e: result){
			System.out.print(e + " ");
		}
		int[] result1 = productExceptSelf1(nums);
		System.out.println();
		System.out.println("Result1");
		for (int e: result1){
			System.out.print(e + " ");
		}
		
		int[] nums1 = {0,0};
		System.out.println("nums[] = [0,0]");
		int[] result2 = productExceptSelf(nums1);
		System.out.println("Here's the result. We are expecting [0,0]");
		System.out.println("Result");
		for (int e: result2){
			System.out.print(e + " ");
		}
		int[] result3 = productExceptSelf(nums1);
		System.out.println();
		System.out.println("Result3");
		for (int e: result3){
			System.out.print(e + " ");
		}
	}
	
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int totalProduct = 1;
        
        for (int i=0; i<nums.length;i++){
        	totalProduct = totalProduct*nums[i];
        }
        
        for (int j=0; j<nums.length; j++){
            if (nums[j] == 0){
                result[j] = 0;
            }else{
                result[j] = totalProduct/nums[j];
            }
        }
        return result;
    }
    
    public static int[] productExceptSelf1(int[] nums){
    	/*
    	 * nums = [1,2,3,4]
    	 * res = [1,-,-,-]
    	 * 
    	 * Frist For Loop:
    	 * i=1
    	 * res[1] = res[0]*nums[0] = 1*1 = 1
    	 * res = [1,1,-,-]
    	 * 
    	 * i=2
    	 * res[2] = res[1]*nums[1] = 1*2 = 2
    	 * res = [1,1,2,-]
    	 * 
    	 * i=3
    	 * res[3] = res[2]*nums[2] = 2*3 = 6
    	 * res = [1,1,2,6]
    	 * 
    	 * Second for loop
    	 * j=3
    	 * res[3] = res[3]*res[0] = 6*1 = 6
    	 * res[0] = res[0]*nums[3] = 1*4 = 4
    	 * res = [4,1,2,6]
    	 * 
    	 * j=2
    	 * res[2] = res[2]*res[0] = 2*4 = 8
    	 * res[0] = res[0]*nums[2] = 4*3 = 12
    	 * res = [12,1,8,6]
    	 * 
    	 * j=1
    	 * res[1] = res[1]*res[0] = 1*12 = 12
    	 * res[0] = res[0]*nums[1] = 12*2 = 24
    	 */
    	int[] res = new int[nums.length];
    	
    	res[0] = 1;
    	for (int i=1; i<nums.length; i++){
    		res[i] = res[i-1]*nums[i-1];
    	}
    	
    	for (int j=nums.length-1; j>0; j--){
    		res[j] *= res[0];
    		res[0] *= nums[j];
    	}
    	
    	return res;
    }


}
