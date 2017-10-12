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
public class InfixStack {
    
    //instance variables
    public char [] ch;
    public int maxSize;
    public int top;
    
    //Constructor
    public InfixStack(int size){
        maxSize = size;
        ch = new char[maxSize];
        top = -1;
    }
    /**
     * Add element on stack if is not full otherwise throws exception
     * @param c char of input
     * @throws ArrayIndexOutOfBoundsException 
     */
    public void push(char c) throws ArrayIndexOutOfBoundsException{
        try{
            if(!isFull())
                ch[++top] = c;
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
        }
    }
    /**
     * Get removed element from stack
     * @return top element on stack
     */
    public char pop(){
        if(isEmpty()){
            return 0;
        }
        else{
            return ch[top--]; //get element and decrement top
        }
    }
    /**
     * Check if this stack is empty
     * @return true if stack is empty
     */
    public boolean isEmpty(){
        return (top == -1);
    }
    /**
     * Check if this stack is empty
     * @return true if stack is full 
     */
    public boolean isFull(){
        return (top == maxSize - 1);
    }
    
    
}
