/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial10;

import java.util.ArrayList;

/**
 *
 * @author muham
 */
public class ArrayGraph<V extends Comparable<V>, E> {
    private int index, size;
    private V[] vertex;
    private E[][] weight;
    private boolean[] marked;
    
    public ArrayGraph(int a){
        index=-1;
        size=a;
        vertex=(V[])new Comparable[size];
        weight=(E[][])new Object[size][size];
        marked=new boolean[size];
    }
    
    public boolean isEmpty(){
        return (index==-1);
    }
    
    public boolean isFull(){
        return (index==size);
    }
    
    public int getVerticeSize(){
        return index+1;
    }
    
    public void showGraph(){
        if(isEmpty())
            System.out.println("The array graph is empty");
        else{
            for (int i = 0; i <= index; i++) {
                System.out.println(vertex[i] +" --> ");
                for (int j = 0; j <= index; j++) {
                    if(weight[i][j]!=null)
                        System.out.print(" -> "+ vertex[j] +" : "+ weight[i][j]);
                }
                System.out.println();
            }
        }
    }
    
    public void clear(){
        index=-1;
    }
    
    public void addVertice(V a){
        index++;
        if(isFull()){
            System.out.println("The graph is full");
            index--;
        }
        else{
            vertex[index]=a;
        }
    }
    
    public int hasVertice(V a){
        if(isEmpty()){
            return -1;
        }
        else{
            for (int i = 0; i <= index; i++) {
                if(a.compareTo(vertex[i])==0)
                    return i;
            }
        }
        return -1;
    }
    
    public boolean addEdge(V from, V to, E w){
        int fromIndex=hasVertice(from);
        int toIndex=hasVertice(to);
        if(fromIndex==-1 || toIndex==-1)
            return false;
        else{
            weight[fromIndex][toIndex]=w;
        }
        return true;
    }
    
    public boolean deleteEdge(V from, V to){
        int fromIndex=hasVertice(from);
        int toIndex=hasVertice(to);
        if(fromIndex==-1 || toIndex==-1)
            return false;
        else{
            weight[fromIndex][toIndex]=null;
        }
        return true;
    }
    
    public boolean isEdge(V from, V to){
        int fromIndex=hasVertice(from);
        int toIndex=hasVertice(to);
        if(fromIndex==-1 || toIndex==-1)
            return false;
        else{
            if(weight[fromIndex][toIndex]!=null)
                return true;
        }
        return false;
    }
    
    public E getWeight(V from, V to){
        int fromIndex=hasVertice(from);
        int toIndex=hasVertice(to);
        if(fromIndex==-1 || toIndex==-1)
            return null;
        else{
            return weight[fromIndex][toIndex];
        }
    }
    
    public void markVertice(V a){
        int aIndex=hasVertice(a);
        if(aIndex!=-1)
            marked[aIndex]=true;
    }
    
    public boolean isMarked(V a){
        int aIndex=hasVertice(a);
        if(aIndex!=-1)
            return marked[aIndex];
        return false;
    }
    
    public ArrayList getAdjacent(V a){
        ArrayList<V> array=new ArrayList();
        int aIndex=hasVertice(a);
        if(aIndex!=-1){
            for (int i = 0; i <= index; i++) {
                if(weight[aIndex][i]!=null)
                    array.add(vertex[i]);
            }
        }
        return array;
    }   
}
