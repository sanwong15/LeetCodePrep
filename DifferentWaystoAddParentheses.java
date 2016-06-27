/*
San Wong
hswong1@uci.edu

241. Different Ways to Add Parentheses
Given a string of numbers and operators, return all possible results from 
computing all the different possible ways to group numbers and operators. 
The valid operators are +, - and *.
*/

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        int length = input.length();
        
        for (int i=0; i<length; i++){
            char c = input.charAt(i);
            
            if(!isOperator(c)){
                continue;
            }
            
            List<Integer> left = diffWaysToCompute(input.substring(0,i));
            List<Integer> right = diffWaysToCompute(input.substring(i+1));
            
            //Handle when c is an operator
            for (int l:left){
                for(int r:right){
                    int tempResult = 0;
                    if(c=='+'){
                        tempResult = l+r;
                    }else if(c=='-'){
                        tempResult = l-r;
                    }else{
                        tempResult = l*r;
                    }
                    
                    result.add(tempResult);
                }
            }
            
            
        }
        
        //For input that only contain 1 number
        if(result.isEmpty()){
            result.add(Integer.parseInt(input));
        }
        
        return result;
       
        
    }
    
    public boolean isOperator(char c){
        return (c=='+' )||(c=='-')||(c=='*');
    }
}