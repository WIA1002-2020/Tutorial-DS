/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial02;

import java.util.Random;

/**
 *
 * @author muham
 */
public class ArrayDice<T> implements Dice<T> {

    private T[] arr;

    public void rollDice(int times) {
        arr = (T[]) new Object[times];
        System.out.println("Array Implementation: Roll " + times + " time(s)");
        Integer value;
        Random random = new Random();
        for (int i = 0; i < times; i++) {
            value = random.nextInt(6) + 1;
            arr[i] = (T) value;
        }
    }

    public T getTotal() {
        Integer total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += (Integer) arr[i];
        }
        return (T) total;
    }

    public String toString() {
        String str = "";
        for (T t : arr) {
            str += t + " ";
        }
        str += "\nTotal is " + getTotal();
        return str;
    }
}
