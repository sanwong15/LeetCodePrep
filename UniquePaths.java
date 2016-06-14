/*
San Wong
hswong1@uci.edu

62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

m is number of row while n is number of col

nCr = n!/(n-r)!r!  choose r out of n (i.e n>r)
We must make m-1 steps to make it to the most right
We must make (m-1)+(n-1) total steps to get to the end point.
take m-1 steps out of (m-1)+(n-1) => (m-1)C((m-1)+(n-1)) paths
*/
public class Solution {
    public int uniquePaths(int m, int n) {
        /*
        n = m-1+n-1 = m+n-2
        r = m-1
        
        n-r = m+n-2-(m-1) = n-2+1 = n-1
        */
        double upperFactorial = factorial(m+n-2);
        double lowerFactorial = factorial(n-1) * factorial(m-1);
        
        return (int)((upperFactorial/lowerFactorial) + 1e-6);
    }
    
    public double factorial(int n){
        if (n==0){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
}