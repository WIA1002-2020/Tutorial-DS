/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial09;

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
        Q1();
        Q2();
        Q3();
    }

    public static void Q1() {
        int[] location, location1;
        int count;
        char key, key1, key2;
        SearchTest<Character> a = new SearchTest<>('A', 10);
        System.out.print("The Character data set are : ");
        a.showValue();
        Scanner s = new Scanner(System.in);
        System.out.println("Linear Search");
        System.out.print("Enter a letter to search: ");
        key = s.nextLine().charAt(0);
        if (a.linearSearch(key)) {
            count = a.linearSearchCount(key);
            System.out.println(key + " is found");
            System.out.println("The number of " + key + " in the data set is " + count);
            System.out.print("The location of the " + key + " are: ");
            location = a.linearSearchList(key, count);
            for (int i = 0; i < count; i++) {
                System.out.print(location[i] + " ");
            }
            System.out.println("");
        } else {
            System.out.println(key + " is not found");
        }
        System.out.print("Enter two letters to search(begin end) : ");
        key1 = s.next().charAt(0);
        key2 = s.next().charAt(0);
        if (a.linearSearch(key1, key2)) {
            count = a.linearSearchCount(key1, key2);
            System.out.println("The character can be found in between " + key1 + " and " + key2);
            System.out.println("The number of the elements in between " + key1 + " and " + key2 + " in the data set is " + count);
            System.out.println("The location of the elements in between " + key1 + " and " + key2 + " are : ");
            location1 = a.linearSearchList(key1, key2, count);
            for (int i = 0; i < count; i++) {
                System.out.print(location1[i] + " ");
            }
            System.out.println("");
        } else {
            System.out.println("No character can be found in between " + key1 + " and " + key2);
        }
    }
    
    public static void Q2(){
        int[] location, location1;
        int key, key1, key2, count;
        SearchTest<Integer> a = new SearchTest<>(1, 10);
        System.out.print("\nThe Integer data set are : ");
        a.selectionSort(a.ASCENDING);
        a.showValue();
        Scanner s = new Scanner(System.in);
        System.out.println("Binary Search");
        System.out.print("Enter a number to search: ");
        key = s.nextInt();
        if (a.binarySearch(key)) {
            count = a.binarySearchCount(key);
            System.out.println(key + " is found");
            System.out.println("The number of " + key + " in the data set is " + count);
            System.out.print("The location of the " + key + " are: ");
            location = a.binarySearchList(key);
            for (int i = 0; i < count; i++) {
                System.out.print(location[i] + " ");
            }
            System.out.println("");
        } else {
            System.out.println(key + " is not found");
        }
        System.out.print("Enter two numbers to search(begin end) : ");
        key1 = s.nextInt();
        key2 = s.nextInt();
        if (a.binarySearch(key1, key2)) {
            count = a.binarySearchCount(key1, key2);
            System.out.println("The character can be found in between " + key1 + " and " + key2);
            System.out.println("The number of the elements in between " + key1 + " and " + key2 + " in the data set is " + count);
            System.out.println("The location of the elements in between " + key1 + " and " + key2 + " are : ");
            location1 = a.binarySearchList(key1, key2);
            for (int i = 0; i < count; i++) {
                System.out.print(location1[i] + " ");
            }
            System.out.println("");
        } else {
            System.out.println("No integer can be found in between " + key1 + " and " + key2);
        }
    }
    
    public static void Q3(){
        String[] code = {"100-101","200-101","200-120","210-260"};
        String[] name = {"ICND 1","ICND 2","CCNA Routing and Switching","CCNA Security"};
        Scanner s = new Scanner(System.in);
        HashTable<String,String> HT = new HashTable<>();
        System.out.println("Hash Table");
        for (int i = 0; i < code.length; i++) {
            HT.put(code[i], name[i]);
        }
        System.out.print("The number of elements in Hash Table "+ HT.getSize());
        HT.showHashTable();
        System.out.print("\nEnter code to search : ");
        String input = s.nextLine();
        String value;
        if((value=HT.get(input))!=null){
            System.out.println("Course "+ input +" : "+ value);
        }
        else{
            System.out.println("The course "+ input +" cannot be found");
        }
    }
}
