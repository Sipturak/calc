/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.logic;

import java.util.StringTokenizer;

/**
 *
 * @author pc
 */
public class PostfixEvalute {
    
    private String input;
    private PostfixStack stack;
    
    public PostfixEvalute(String input){
        this.input = input;
        stack = new PostfixStack(20);
    }
    
    /**
     * Break string into tokens ,push on the stack and when you find a operator 
     * pop two last element from stack and do operations on them. Fill res and again
     * push on stack. Repeat that process while reach to last token
     * @return 
     */
    public double doRes(){
        
        int j;
        double num1,num2, res;
       
        char ch;
        
        StringTokenizer tz = new StringTokenizer(input);
        
        while(tz.hasMoreTokens()){
            
            String token = tz.nextToken();
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                num2 = stack.pop();
                num1 = stack.pop();
                
                switch(token){

                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                            res = num1 / num2;
                            break;
                    default:
                        res = 0;
                        break;
                }
                stack.push(res);
            }
            else{
               try{
                    stack.push(Double.parseDouble(token));
               }
               catch(NumberFormatException ex){
                   break;
               }
            }
        }
        res = stack.pop();
        return res;
        
    }
}
