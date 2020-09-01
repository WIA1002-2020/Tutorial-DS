/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial06;

import Tutorial05.Stack;
import java.util.Random;
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
        //Question 1
        Queue<Character> a = new Queue<>();
        System.out.println("Queue Implementation using Linked List");
        System.out.println("Enqueue three nodes");
        a.enqueue('B');
        a.enqueue('M');
        a.enqueue('W');
        a.showQueue();
        System.out.println("\nDequeue one node");
        a.dequeue();
        a.showQueue();
        System.out.println("\nThe front node of the queue is " + a.peek());
        System.out.println("The queue size is " + a.getSize());

        //Question 2
        Queue<Character> b = new Queue<>();
        System.out.println("\nQueue Implementation using Array");
        System.out.println("Enqueue three nodes");
        b.enqueue('B');
        b.enqueue('M');
        b.enqueue('W');
        b.showQueue();
        System.out.println("\nDequeue one node");
        b.dequeue();
        b.showQueue();
        System.out.println("\nThe front node of the queue is " + b.peek());
        System.out.println("The queue size is " + b.getSize());
        System.out.println("");

        //Question 3
        Queue<String> c = new Queue<>();
        Random r = new Random();
        String temp;
        int total = 30;
        int i, num;
        for (i = 1; total >= 3; i++) {
            num = 1 + r.nextInt(3);
            temp = "Customer " + i + " : " + num + " set(s)";
            c.enqueue(temp);
            total -= num;
        }
        if (total != 0) {
            temp = "Customer " + i + " : " + total + " set(s)";
            c.enqueue(temp);
        }
        System.out.println("Simulating a Queue to purchase MY phone");
        c.showQueueln();
        System.out.println("Number of Customer : " + c.getSize());
        System.out.println("");

        //Question 4
        String[] str = {"kayak", "Welcome", "Was it a car or a cat I saw?", "race car"};
        for (int j = 0; j < str.length; j++) {
            if (checkSentence(str[j])) {
                System.out.println(str[j] + " is a palindrome");
            } else {
                System.out.println(str[j] + " is not a palindrome");
            }
        }
        System.out.println("");

        //Question 5
        String[] str1 = {"Was it a car or a cat I saw?", "?civic#", "redrawer", "race car", "put it up"};
        for (int j = 0; j < str1.length; j++) {
            if (checkSentence1(str1[j])) {
                System.out.println(str1[j] + " is a palindrome");
            } else {
                System.out.println(str1[j] + " is not a palindrome");
            }
        }

        //Question 6
        Scanner s = new Scanner(System.in);
        String sentence;
        System.out.print("\nEnter a sentence : ");
        sentence = s.nextLine();
        Queue<String> Q = new Queue<>();
        Queue<String> hold = new Queue<>();
        Queue<String> Q1 = new Queue<>();
        String[] word = sentence.split(" ");
        for (int j = 0; j < word.length; j++) {
            Q.enqueue(word[j]);
        }
        System.out.print("The original queue : ");
        Q.showQueue();
        System.out.print("\nReverse all the elements in the queue : ");
        int count = 1;
        while (true) {
            if (count % 2 == 1) {
                while (Q.getSize() != 1) {
                    hold.enqueue(Q.dequeue());
                }
                Q1.enqueue(Q.dequeue());
                count++;
                if (hold.isEmpty()) {
                    break;
                }
            } else {
                while (hold.getSize() != 1) {
                    Q.enqueue(hold.dequeue());
                }
                Q1.enqueue(hold.dequeue());
                count++;
                if (Q.isEmpty()) {
                    break;
                }
            }
        }
        Q1.showQueue();
        System.out.println("");
    }

    public static boolean checkSentence(String a) {
        Queue<Character> Q = new Queue<>();
        Stack<Character> S = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            Q.enqueue(a.charAt(i));
            S.push(a.charAt(i));
        }
        while (!S.isEmpty()) {
            if (Q.dequeue() != S.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkSentence1(String a) {
        Queue<Character> Q = new Queue<>();
        Stack<Character> S = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            if (Character.isLetterOrDigit(a.charAt(i))) {
                Q.enqueue(Character.toLowerCase(a.charAt(i)));
                S.push(Character.toLowerCase(a.charAt(i)));
            }
        }
        while (!S.isEmpty()) {
            if (Q.dequeue() != S.pop()) {
                return false;
            }
        }
        return true;
    }

}
