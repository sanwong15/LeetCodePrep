import java.util.ArrayList;
import java.util.List;

/*
* San Wong
* hswong1@uci.edu
*
* LeetCode 293 FlipGame
* 
* You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
*  you and your friend take turns to flip two consecutive "++" into "--". 
*  The game ends when a person can no longer make a move and therefore the other person will be the winner.
*  
*  Write a function to compute all possible states of the string after one valid move.
*  For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
 
If there is no valid move, return an empty list [].
*
*/

public class flipGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "++++";
		List<String> resultList = flipResult(test);
		
		for (String e:resultList){
			System.out.println(e);
		}
	}
	
	public static List<String> flipResult(String s){
		int len = s.length();
		List<String> result = new ArrayList<String>();
		
		if(s==null || len<2){
			return result;
		}
		
		for (int i=0; i<len-1; i++){
			if(s.charAt(i) == '+' && s.charAt(i + 1) == '+'){
				String s1 = s.substring(0,i);
				String s2 = "--";
				String s3 = s.substring(i+2);
				String temp = s1+s2+s3;
				result.add(temp);
			}
		}
		
		return result;
	}

}
