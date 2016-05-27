/*
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode 171: Excel Sheet Column Number
 *  A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28 
 * 
 */
public class excelColumn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("A converts to: " + titleToNumber("A"));
		System.out.println("B converts to: " + titleToNumber("B"));
		System.out.println("C converts to: " + titleToNumber("C"));
		System.out.println("Z converts to: " + titleToNumber("Z"));
		System.out.println("AA converts to: " + titleToNumber("AA"));
		System.out.println("AB converts to: " + titleToNumber("AB"));

	}
	
	public static int titleToNumber(String s){
		/*
		 * ASCII TABLE
		 * 
		 * A = 65 --- Z = 90
		 */
		
        int powerTo = 0;
        int val = 0;
        
        for (int i=s.length()-1; i>=0; i--){
        	int charVal = s.charAt(i)-64;
            val += charVal*Math.pow(26,powerTo);
            powerTo++;
        }
        
        return val;
		
	}

}
