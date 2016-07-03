/*
San Wong
hswong1@uci.edu

357. Count Numbers with Unique Digits
Given a non-negative integer n, count all numbers with unique digits, x, 
where 0 ≤ x < 10n.
*/

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n==0) return 1;
        if (n==1) return 10;
        if (n==2) return 91;
        
        int[] f = new int[n+1];
        f[0] = 1;
        f[1] = 9;
        f[2] = 91;
        
        for (int i=3; i<=n; i++){
            
            int loopCount = i-2;
            
            int coeff = calTheCoeff(loopCount);
            
            f[i] = f[1]*coeff + f[i-1];
        }
        
        return f[n];
    }
    
    public int calTheCoeff(int loopCount){
        int coeff = 9;
        int num = 8;
        for(int i=0; i<loopCount ; i++){
            coeff *=num;
            num--;
        }
        
        return coeff;
    }
}