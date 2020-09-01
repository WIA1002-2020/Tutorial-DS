/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial08;

import Tutorial04.LinkedList;
import java.util.Random;

/**
 *
 * @author muham
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Question 1
        SortTest<Character> a = new SortTest<>(SortTest.DESCENDING,'A',10);
        System.out.print("The random character are : ");
        a.showValue();
        System.out.println("Selection sort - Descending Order");
        a.selectionSort();
        a.showValue();
        
        a = new SortTest<>(SortTest.DESCENDING,'A',10);
        System.out.print("The random character are : ");
        a.showValue();
        System.out.println("Bubble sort - Descending Order");
        a.bubbleSort();
        a.showValue();
        
        a = new SortTest<>(SortTest.DESCENDING,'A',10);
        System.out.print("The random character are : ");
        a.showValue();
        System.out.println("Insertion sort - Descending Order");
        a.insertionSort();
        a.showValue();
        
        a = new SortTest<>(SortTest.DESCENDING,'A',10);
        System.out.print("The random character are : ");
        a.showValue();
        System.out.println("Merge sort - Descending Order");
        a.mergeSort();
        a.showValue();
        
        a = new SortTest<>(SortTest.DESCENDING,'A',10);
        System.out.print("The random character are : ");
        a.showValue();
        System.out.println("Quick Sort - Descending Order");
        a.quickSort();
        a.showValue();
        System.out.println("");
        
        //Question 2
        SortTest<String> b = new SortTest<>(SortTest.ASCENDING,"A",10,8);
        System.out.print("The random String are : ");
        b.showValue();
        System.out.println("Merge Sort - Ascending Order");
        b.mergeSort();
        b.showValue();
        
        b = new SortTest<>(SortTest.ASCENDING,"A",10,8);
        System.out.print("The random String are : ");
        b.showValue();
        System.out.println("Quick Sort - Ascending Order");
        b.quickSort();
        b.showValue();
        System.out.println("");
        
        //Question 3
        final int MAX=100;
        final int SIZE=10;
        Random r =new Random();
        LinkedList<Integer> list = new LinkedList<>();
        System.out.print("The Random integers are : ");
        for (int i = 0; i < SIZE; i++) {
            list.addNode(r.nextInt(MAX));
        }
        list.showList();
        System.out.println("\nSelection Sort - Ascending Order");
        list.selectionSort(LinkedList.ASCENDING);
        list.showList();
        System.out.println("\n");
        
        //Question 4
        LinkedList<Integer> list1 = new LinkedList<>();
        System.out.print("The Random integers are : ");
        for (int i = 0; i < SIZE; i++) {
            list1.addNode(r.nextInt(MAX));
        }
        list1.showList();
        System.out.println("\nBubble Sort - Descending Order");
        list1.bubbleSort(LinkedList.DESCENDING);
        list1.showList();
        System.out.println("");       
    }
    
}
