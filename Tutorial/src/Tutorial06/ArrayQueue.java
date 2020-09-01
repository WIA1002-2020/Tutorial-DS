/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial06;

/**
 *
 * @author muham
 */
public class ArrayQueue<T> {
    private T[] queue;
    private final int MAX=10;
    private int front, rear, size;
    
    public ArrayQueue(){
        front=0;
        rear=0;
        size=0;
        queue=(T[])new Object[MAX];
    }
    
    public boolean isEmpty(){
        return(size==0);
    }
    
    public boolean isFull(){
        return(size==MAX);
    }
    
    public int getSize(){
        return size;
    }
    
    public void enqueue(T a){
        if(isFull()){
            System.out.println("Queue is full");
        }
        else{
            queue[rear]=a;
            rear++;
            size++;
        }
    }
    
    public T dequeue(){
        if(!isEmpty()){
            T a = queue[front];
            front=++front%MAX;
            size--;
            return a;
        }
        return null;
    }
    
    public T peek(){
        if(!isEmpty()){
            return queue[front];
        }
        return null;
    }
    
    public void showQueue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        else{
            for (int i = 0; i < size; i++) {
                System.out.print(queue[(front+i)%MAX] +" ");
            }
        }
    }
}
