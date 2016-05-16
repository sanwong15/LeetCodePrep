/*
San Wong
hswong1@uci.edi

LeetCode 344. Reverse String
Given s = "hello", return "olleh".
*/

public class ReverseString{
	public String reverseString(String s){
		int len = s.length();

		Stringbuilder sb = new Stringbuilder();

		for (int i = len-1; i>=0; i--){
			sb.append(s.charAt(i);
		}

		return sb.toString();
	}
}

// Another approach
public class ReverseString1 {
    public String reverseString(String s) {
        Stack st = new Stack();
        
        for (int i=0; i<s.length(); i++){
            st.push(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.toString();
        
    }
}