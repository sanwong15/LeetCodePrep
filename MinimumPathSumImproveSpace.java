/*
San Wong
hswong1@uci.edu

LeetCode 64: Minimum Path Sum

DP: O(n^2) time O(n) space
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        int col = grid[0].length;
        int row = grid.length;
        
        int[] result = new int[col];
        
        //initial and boundary condition.
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        for (int i=0; i<row; i++){
            //result array will be re-use for each row
            result[0] = result[0]+grid[i][0];
            
            for(int j=1; j<col; j++){
                result[j] = Math.min(result[j],result[j-1])+grid[i][j];
                /*
                This result[1] means the minpath to get to result[0][1]
                result[1] = Math.min(result[1],result[0]) + grid[i][1]; //result[1] = Integer.MAX_VALUE; result[0] = grid[i][0]; => result[0]+grid[i][1];
                
                it will be used again when we calculae the min path to get to result[1][1]
                
                */
            }
        }
        
        
        return result[col-1];
        
    }
}