/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.logic;

/**
 *
 * @author pc
 */
public class TranslateToPostfix {
    
    public String input;
    public InfixStack stack;
    public StringBuilder output = new StringBuilder();
    
    //Constructor
    public TranslateToPostfix(String input){
        this.input = input;
        
        stack = new InfixStack(input.length()); 
    }
    
    /**
     * 
     * @return 
     */
    public String doTrans(){
        
          for(int i =0; i < input.length();i++){
            char op = input.charAt(i); // look at all character individually
            
            switch(op){
                case '+':
                case '-':
                    output.append(" ");
                    getOperand(op, 1);
                    break;
                case '/':
                case '*':
                    output.append(" ");
                    getOperand(op, 2);
                    break;
                default:
                    output.append(op);
                    break;
            }
        }
            while(!stack.isEmpty()){
                //get the rest charcahters from stack and append them on output
                output.append(" ");
                output.append(stack.pop());
                
            }
          return output.toString() ;
    }
    
    /**
     * Get the operand from input and compare precedence of operations. If operation + precedence2 is one
     * otherwise it two. If precedence2 is smaller than current precedence(operations)on stack than push and 
     * break from while loop on stack, else write operation on output. At the and push opThis(operations that
     * you looking) on stack
     * @param opThis operations of operand
     * @param prec1 precedence of operations
     */
    private void getOperand(char opThis, int prec1){
        
        
        while(!stack.isEmpty()){  //while stack is not empty
            char opTop = stack.pop(); //pop pperand from stack
            int prec2; //get second precedance 
            if(opTop == '+' || opTop == '-'){
                prec2 = 1; 
            }
            else{
                prec2 = 2;
            }
            if(prec2 < prec1){ //if prec2 is greater from the prec1 ( * < +) than push on stack
                stack.push(opTop);
                break;
            }
            else{  //otherwise print opTop on output
                output.append(opTop).append(" ");
            }
        }
        stack.push(opThis);
    }
    
}
