import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/*
* San Wong
* hswong1@uci.edu
*
* LeetCode 266: Palindrome Permutation
*
* Given a string, determine if a permutation of the string could form a 
* palindrome.
*
* For example,
* "code" -> False, "aab" -> True, "carerac" -> True.
*
*/

public class StringPermutationPalindromeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "code";
		String test1 = "aab";
		String test2 = "carerac";
		
		System.out.println("For s='code'; " + "Result: " + PalindromeCheck(test));
		System.out.println("For s='aab'; " + "Result: " + PalindromeCheck(test1));
		System.out.println("For s='carerac'; " + "Result: " + PalindromeCheck(test2));

	}
	
	public static boolean PalindromeCheck(String s){
		int len = s.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i=0; i<len; i++){
			if (map.containsKey(s.charAt(i))){
				int currentCount = map.get(s.charAt(i));
				currentCount++;
				map.put(s.charAt(i), currentCount);
			}else{
				map.put(s.charAt(i), 1);
			}
		}
		
		//For even length string. There should have no odd numbers count
		//For odd length string, There should have only 1 odd numbers count
		
		int count = 0;
		for (int v: map.values()){
			if (v%2 ==1){
				count++;
			}
		}
		
		return count==1 || count==0;
	}
	
	

}
