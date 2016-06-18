/*
San Wong
hswong1@uci.edu

191. Number of 1 Bits
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        
        for (int i=0; i<32; i++){
            if ((n&1) == 1){
                count++;
            }
            n>>=1;
        }
        
        return count;
    }
}