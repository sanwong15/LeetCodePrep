/*
* San Wong
* hswong1@uci.edu
*
* Check Palindrome Permutation

*/

public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "code";
		String test1 = "aab";
		String test2 = "carerac";
		
		System.out.println("For s='code'; " + "Result: " + checkPalindrome(test));
		System.out.println("For s='aab'; " + "Result: " + checkPalindrome(test1));
		System.out.println("For s='carerac'; " + "Result: " + checkPalindrome(test2));
	}
	
	public static boolean checkPalindrome(String s){
		StringBuilder sb = new StringBuilder();
		//Stack<Character> st = new Stack<Character>();

		for (int i=s.length()-1; i>=0; i--){
			sb.append(s.charAt(i));
		}

		String flipped = sb.toString();

		if (s.equals(flipped)){
			return true;
		}else{
			return false;
		}
	}

}
