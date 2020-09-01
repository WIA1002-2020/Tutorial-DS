/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial02;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author muham
 */
public class LinkedListDice<T> implements Dice<T> {

    LinkedList<T> linkedList;

    public void rollDice(int times) {
        linkedList = new LinkedList<>();
        System.out.println("Linked List Implementation: Roll " + times + " time(s)");
        Integer value;
        Random random = new Random();
        for (int i = 0; i < times; i++) {
            value = random.nextInt(6) + 1;
            linkedList.add((T) value);
        }
    }

    public T getTotal() {
        Integer total = 0;
        for (int i = 0; i < linkedList.size(); i++) {
            total += (Integer) linkedList.get(i);
        }
        return (T) total;
    }

    public String toString() {
        String str = "";
        for (T t : linkedList) {
            str += t + " ";
        }
        str += "\nTotal is " + getTotal();
        return str;
    }
}
