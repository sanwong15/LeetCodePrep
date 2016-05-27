/*
 * San Wong
 * hswong1@uci.edu
 * 
 * LeetCode 242: Valid Anagram
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 */


import java.util.HashMap;

public class validAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "anagram";
		String t1 = "nagaram";
		
		System.out.println(isAnagram(s1,t1));
		
		String s2 = "rat";
		String t2 = "car";
		
		System.out.println(isAnagram(s2,t2));

	}
	
	public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if (!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }
        
        for (int j = 0; j<t.length(); j++){
            char c = t.charAt(j);
            if (!map.containsKey(c)){
                return false;
            }else{
                map.put(c,map.get(c)-1);
                if(map.get(c) == 0){
                    map.remove(c);
                }
            }
            
            
        }
        
        return (map.isEmpty());
        
        
    }

}
