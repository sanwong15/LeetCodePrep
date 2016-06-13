/*
San Wong
hswong1@uci.edu

LeetCode 64: Minimum Path Sum

DP: runTime O(n^2). Space: O(n^2)
*/

public class Solution {
    public int minPathSum(int[][] grid) {
        int col = grid[0].length;
        int row = grid.length;
        
        int[][] result = new int[row][col];
        
        //initial and boundary condition.
        result[0][0] = grid[0][0];
        
        for (int j=1; j<col; j++){
            result[0][j] = result[0][j-1]+grid[0][j]; 
        }
        
        for(int i=1; i<row; i++){
            result[i][0] = result[i-1][0]+grid[i][0];
        }
        
        for (int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                result[i][j] = Math.min(result[i-1][j],result[i][j-1])+grid[i][j];
            }
        }
        
        
        return result[row-1][col-1];
        
    }
}