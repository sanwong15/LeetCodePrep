/*
* San Wong
* hswong1@uci.edu
* LeetCode 202: Happy Number
*
*/

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        while(!set.contains(n)){
            set.add(n);
            
            n = SquareSumOfEachDigit(n);
            
            if (n==1){
                return true;
            }
            
        }
        
        return false;
    }
    
    public int SquareSumOfEachDigit(int n){
        int sum = 0;
        while(n>0){
            sum = sum + (int)Math.pow(n%10,2);
            n = n/10;
        }
        
        return sum;
    }
}