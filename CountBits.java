/*
* San Wong
* hswong1@uci.edu
*
* Given a non negative integer number num. For every numbers i in the
* range 0 ≤ i ≤ num calculate the number of 1's in their binary
* representation and return them as an array.
*/


public class Solution {
    public int[] countBits(int num) {
        if (num<0) return null;
        
        int[] result = new int[num+1];
        result[0] = 0;
        if (num==0) return result;
        result[1] = 1;
        if (num==1) return result;
        result[2] = 1;
        if (num==2) return result;
        
        //For num>=3
        for (int i=3; i<=num; i++){
            result[i] = result[i/2]+result[i%2];
        }
        
        return result;
    }
}