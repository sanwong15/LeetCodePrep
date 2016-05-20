/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Given an array nums, write a function to move all 0's to the end of it
 *  while maintaining the relative order of the non-zero elements.
 *  
 *  For example, given nums = [0, 1, 0, 3, 12], after calling your function, 
 *  nums should be [1, 3, 12, 0, 0].
 *  
 *  Note:
 *  You must do this in-place without making a copy of the array.
 *  Minimize the total number of operations.
 */


public class moveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0, 1, 0, 3, 12};
		
		int result[] = move(nums);
		
		for(int e: result){
			System.out.println(e);
		}

	}
	
	public static int[] move(int[] n){
		int zeroCount = 0;
		for (int i=0; i<n.length; i++){
			if(n[i] == 0){
				zeroCount++;
			}else if(zeroCount>0){
				n[i-zeroCount] = n[i];
				n[i] = 0;
			}
		}
		
		return n;
	}

}
