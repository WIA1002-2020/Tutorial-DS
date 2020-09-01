/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial05;

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
        Stack<Character> q1 = new Stack<>();
        System.out.println("Stack implementation using Linked List");
        System.out.println("Insert three nodes into the stack");
        q1.push('A');
        q1.push('N');
        q1.push('D');
        q1.showStack();
        System.out.println("\nPop one node from the stack");
        q1.pop();
        q1.showStack();
        System.out.println("\nThe element on the top of the stack is "+ q1.peek());
        q1.showStack();
        System.out.println("\nThe number of the elements in the stack is "+ q1.getSize());
        
        //Question 2
        ArrayStack<Character> q2 = new ArrayStack<>();
        System.out.println("Stack implementation using Array");
        System.out.println("\nInsert three nodes into the stack");
        q2.push('A');
        q2.push('N');
        q2.push('D');
        q2.showStack();
        System.out.println("\nPop one node from the stack");
        q2.pop();
        q2.showStack();
        System.out.println("\nThe element on the top of the stack is "+ q2.peek());
        q1.showStack();
        System.out.println("\nThe number of the elements in the stack is "+ q2.getSize());
        
        //Question 3
        Scanner s = new Scanner(System.in);
        String str;
        System.out.print("\nEnter a sentence : ");
        str=s.nextLine();
        System.out.println("Original Sentence : "+ str);
        Stack<Character> qc3 = new Stack<>();
        Stack<String> qs3 = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            qc3.push(str.charAt(i));
        }
        String[] word = str.split(" ");
        for (int i = 0; i < word.length; i++) {
            qs3.push(word[i]);
        }
        System.out.println("The sentence in reverse order : ");
        while(!qc3.isEmpty()){
            System.out.print(qc3.pop());
        }
        System.out.print("\nThe word in reverse order : ");
        while(!qs3.isEmpty()){
            System.out.print(qs3.pop() +" ");
        }
        System.out.println("");
        
        //Question 4
        System.out.println("\nFib(1): "+ Fib(1));
        System.out.println("Fib(5): "+ Fib(5));
        System.out.println("Fib(8): "+ Fib(18));
        System.out.println("Fib(14): "+ Fib(14));
        System.out.println("");
        
        //Question 5
        String[] para = {"(())", ")()(", "((())())()", "(())()))", "())"};
        for (int i = 0; i < para.length; i++) {
            if(isBalanced(para[i]))
                System.out.println(para[i]  +" is balanced");
            else
                System.out.println(para[i] +" is not balanced");
        }
        
        //Question 6
        final int MAX=100, SIZE=10;
        Random r = new Random();
        boolean[] marker = new boolean[SIZE];
        int[] num = new int[SIZE];
        System.out.print("\nThe random numbers are : ");
        for (int i = 0; i < num.length; i++) {
            num[i]=1+r.nextInt(MAX);
            marker[i]=false;
            System.out.print(num[i] +" ");
        }
        boolean check=true;
        int round=1;
        Stack<Integer> q6 = new Stack<>();
        while(check){
            check=false;
            for (int i = 0; i < num.length; i++) {
                if(num[i]%2==round && !marker[i]){
                    marker[i]=true;
                    q6.push(num[i]);
                    round++;
                    round%=2;
                    check=true;
                }
            }
        }
        System.out.print("\nThe numbers in the stack : ");
        if(!q6.isEmpty())
            q6.showStack();
        System.out.print("\nThe numbers remain in the array : ");
        for (int i = 0; i < num.length; i++) {
            if(!marker[i])
                System.out.print(num[i] +" ");
        }
        System.out.println("");
    }  
    
    public static int Fib(int n){
        if(n<3)
            return 1;
        else{
            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            stack.push(1);
            int first, second, ans=0;
            for (int i = 3; i <= n; i++) {
                second=stack.pop();
                first=stack.pop();
                ans=first+second;
                stack.push(second);
                stack.push(first);
            }
            return ans;
        }
    }
    
    public static boolean isBalanced(String a){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)=='(')
                stack.push(a.charAt(i));
            else{
                if(!stack.isEmpty() && stack.peek()=='(')
                    stack.pop();
                else
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
