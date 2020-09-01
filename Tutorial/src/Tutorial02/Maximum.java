/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial02;

/**
 *
 * @author muham
 */
public class Maximum<T extends Comparable<T>>{
    private T a,b,c;

    public Maximum(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public T max() {
        T max = null;
        if(a instanceof Integer){
            if(a.compareTo(b) > 0 && a.compareTo(c) > 0){
                max = a;
            }
            else if(b.compareTo(a) > 0 && b.compareTo(c) > 0){
                max = b;
            }
            else{
                max = c;
            }                   
        }
        else if(a instanceof Double){
            if(a.compareTo(b) > 0 && a.compareTo(c) > 0){
                max = a;
            }
            else if(b.compareTo(a) > 0 && b.compareTo(c) > 0){
                max = b;
            }
            else{
                max = c;
            }
        }
        return max;
    }
    
    public String toString(){
        return "The maximum value of "+ a +" "+ b +" "+ c +" is "+ max();
    }
}
