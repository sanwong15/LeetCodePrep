/*
San Wong
hswong1@uci.edu

345. Reverse Vowels of a String

Write a function that takes a string as input 
and reverse only the vowels of a string.
*/

public class Solution {
    public String reverseVowels(String s) {
        char[] sArray = s.toCharArray();
        
        int len = sArray.length;
        
        Set<Character> vowels = new HashSet<Character>();
        
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        
        for (int i=0, j=len-1; i<j;){
            if(!vowels.contains(sArray[i])){
                i++;
                continue;
            }
            if(!vowels.contains(sArray[j])){
                j--;
                continue;
            }
            
            char temp = sArray[i];
            sArray[i] = sArray[j];
            sArray[j] = temp;
            i++;
            j--;
            
        }
        
        return String.valueOf(sArray);
        
    }
}