/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial01;

/**
 *
 * @author muham
 */
public class SmartPhone implements Comparable <SmartPhone> {
    private String name;
    private int price;

    public SmartPhone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(SmartPhone other) {
        if(this.price < other.price){
            return -1;
        }
        if(this.price == other.price){
            return 0;
        }
        return 1;
    }
    
//    public int compareTo(SmartPhone other) {
//        return Integer.compare(this.price,other.price);
//    }
    public String toString(){
        return name +" (RM"+ price +") ";
    }
}
