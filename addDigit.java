/*
* San Wong
* hswong1@uci.edu
*
* LeetCode 258 Add Digit
* 
* Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
* For example:
* Given num = 38, the process is like: 3 + 8 = 11 => 1 + 1 = 2. Since 2 has only one digit, return it.
* Follow up:
* Could you do it without any loop/recursion in O(1) runtime?
* 
* n			result
* 0			0
* 1			1
* 2			2
* 3			3
* 4			4
* 5			5
* 6			6
* 7			7
* 8			8
* 9			9
* 10		1
* 11		2
* 12		3
* 13		4
* 14		5
* 15		6
* 16		7
* 17		8
* 18		9
* 19=>10=>	1
* 20		2
* 
* This is a cycle of 1 to 9
* 
* So if I want the following
* 1 - 1
* 2 - 2
* 3 - 3
* 4 - 1
* 5 - 2
* 6 - 3
* 7 - 1
* 8 - 2
* 9 - 3
* 10 - 1
*/
public class addDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test case: 38     Result: " + addDigit(38));
		System.out.println("Test case: 19     Result: " + addDigit(19));
		System.out.println("Test case: 18     Result: " + addDigit(18));
		System.out.println(19%9);
		System.out.println(20%9);
		System.out.println(38%9);
		System.out.println(18%9);
		System.out.println(17%9);
		
		System.out.println("With O(1) approach");
		System.out.println("Test case: 38     Result: " + addDigitFollowUp(38));
		System.out.println("Test case: 19     Result: " + addDigitFollowUp(19));
		System.out.println("Test case: 18     Result: " + addDigitFollowUp(18));
		
		System.out.println("Experiement on cycle of 3");
		System.out.println("Test case: 1     Result: " + cycleOf3(1));
		System.out.println("Test case: 2     Result: " + cycleOf3(2));
		System.out.println("Test case: 3     Result: " + cycleOf3(3));
		System.out.println("Test case: 4     Result: " + cycleOf3(4));
		System.out.println("Test case: 5     Result: " + cycleOf3(5));
		System.out.println("Test case: 6     Result: " + cycleOf3(6));

	}
	
	public static int addDigit(int n){
		
		while(n/10 > 0){
			int sum = 0;
			while (n>0){
				sum += n%10;
				n = n/10;
			}
			n = sum;
		}

		return n;
	}
	
	
	public static int addDigitFollowUp(int n){
		return 1+(n-1)%9;
	}
	
	public static int cycleOf3(int n){
		return 1+(n-1)%3;
	}
	
	
	

}
