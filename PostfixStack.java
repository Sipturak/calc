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
public class PostfixStack {
    
    //instance variables
    private double [] arr;
    private int maxSize;
    private int top;
    
    //Constructor
    public PostfixStack(int s){
        maxSize = s;
        arr = new double[maxSize];
        top = -1;
    }
    /**
     * Add element on stack if is not full otherwise throws exception
     * @param number
     */
    public void push(double number){
       try{
           if(!isFull()){
               arr[++top] = number;
           }
       }
       catch(ArrayIndexOutOfBoundsException ex){
           System.out.println(ex.getMessage());
       }
        
    }
    /**
     * Get removed element from stack
     * @return top element on stack
     */
    public double pop(){
        if(isEmpty()){
            return 0;
        }
        else{
            return arr[top--];
        }
    }
    /**
     * Check if this stack is empty
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return (top == - 1);
    }
    /**
     * Check if this stack is empty
     * @return true if stack is full 
     */
    public boolean isFull(){
        return(top == maxSize - 1);
    }
    
   
    
    
    
}
