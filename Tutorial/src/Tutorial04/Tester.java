/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial04;

import java.util.Scanner;

/**
 *
 * @author muham
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Question 1
        LinkedList<Double> q1 = new LinkedList<>();
        q1.addNode(23.1);
        q1.addNode(36.5);
        q1.addNode(12.8);
        q1.addNode(42.6);
        q1.addNode(32.8);
        System.out.println("The number in the linked list");
        q1.showList();
        System.out.println("");
        
        //Question 2
        System.out.println("\nThe number in the linked list after updated");
        q1.plusTenPointFive();
        q1.showList();
        System.out.println("");
        
        //Question 3
        int n = 5904;
        System.out.print("\nEnter the total amount : " + n);
        System.out.println("\nTotal amount: "+ n);
        convertAmount(n);
        System.out.println();
        
        //Question 4
        LinkedList<Integer> a = new LinkedList<>();
        a.addNode(23);
        a.addNode(15);
        a.addNode(17);
        a.addNode(28);
        a.addNode(12);
        a.addNode(40);
        a.showList();
        System.out.println("\nLinked List has "+ a.length() +" node(s)");
        System.out.println("Total is "+ a.sumAllInteger());
        System.out.println("Total even number is "+ a.sumEvenNumber());
        System.out.println("");
        
        //Question 5
        LinkedList<Integer> b = new LinkedList<>();
        for (int i = 0; i < 15; i++) {
            b.addRandomNumber();
        }
        System.out.println("Linked List has "+ b.length() +" node(s)");
        b.showList();
        int removeNo = 4;
        System.out.println("\nDelete the number " + removeNo +" from the list");
        b.removeAll(removeNo);
        System.out.println("Linked List has "+ b.length() +" node(s)");
        b.showList();
        System.out.println("\n");
        
        //Question 6
        LinkedList<Integer> c = new LinkedList<>();
        c.addFrontNode(78);
        c.addFrontNode(45);
        c.addFrontNode(34);
        c.addFrontNode(23);
        c.addFrontNode(17);
        c.addFrontNode(10);
        c.addFrontNode(8);
        c.showList();
        System.out.println("\nThe median is "+ c.findMedian());
    }

    public static void convertAmount(int amount) {
        LinkedList<Integer> currencyNotes = new LinkedList<>();
        LinkedList<Integer> noOfNotes = new LinkedList<>();
        currencyNotes.addNode(100);
        currencyNotes.addNode(50);
        currencyNotes.addNode(20);
        currencyNotes.addNode(10);
        currencyNotes.addNode(5);
        currencyNotes.addNode(1);
        for (int i = 0; i < currencyNotes.length(); i++) {
            noOfNotes.addNode(0);
        }
        // count notes using Greedy approach 
        for (int i = 0; i < currencyNotes.length(); i++) {
            if (amount >= currencyNotes.get(i)) {
                noOfNotes.set(amount / currencyNotes.get(i), i);
                amount -= noOfNotes.get(i) * currencyNotes.get(i);
            }
        }
        for (int i = 0; i < currencyNotes.length(); i++) {
            System.out.println("MYR " + currencyNotes.get(i) + " : " + noOfNotes.get(i));
        }
    }
}
