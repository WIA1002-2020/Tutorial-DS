/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial05;

/**
 *
 * @author muham
 */
public class ArrayStack<T> {
    private T[] stack;
    private int index;
    private final int MAX = 10;
    
    public ArrayStack(){
        index=-1;
        stack=(T[])new Object[MAX];
    }
    
    public boolean isEmpty(){
        return(index==-1);
    }
    
    public boolean isFull(){
        return(index==MAX);
    }
    
    public int getSize(){
        return index+1;
    }
    
    public T pop(){
        T temp;
        if(!isEmpty()){
            temp=stack[MAX-index-1];
            index--;
            return temp;
        }
        return null;
    }
    
    public T peek(){
        if(!isEmpty()){
            return stack[MAX-index-1];
        }
        return null;
    }
    
    public void push(T a){
        ++index;
        if(!isEmpty()){
            stack[MAX-index-1]=a;
        }
        else{
            System.out.println("Full Stack");
            index--;
        }
    }
    
    public void showStack(){
        if(isEmpty()){
            System.out.println("Empty Stack");
        }
        else{
            for (int i = MAX-index-1; i < MAX; i++) {
                System.out.print(" <-- "+ stack[i]);
            }
        }
    }
}
