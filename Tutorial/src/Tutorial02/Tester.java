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
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Question 1
        parameter<String> str1 = new parameter<>("Hello","World");
        System.out.println(str1.toString());
        parameter<Double> dou = new parameter<>(12.4,64.3);
        System.out.println(dou.toString());
        parameter<Integer> num = new parameter<>(20, 35);
        System.out.println(num.toString());
        parameter<String> str2 = new parameter<>("Welcome","Welcome");
        System.out.println(str2.toString());
        System.out.println();
        
        //Question 2
        Integer[] numb = {3, 2, 5, 0, 1};
        Character[] letter = { 'P', 'I', 'V', 'C', 'D' };
        SpecialEncoding<Integer> a = new SpecialEncoding<>(numb);
        SpecialEncoding<Character> b = new SpecialEncoding<>(letter);
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println("");
        
        //Question 3
        Maximum max = new Maximum(42,63,58);
        System.out.println(max.toString());
        Maximum max1 = new Maximum(78.09,41.28,19.82);
        System.out.println(max1.toString());
        System.out.println("");
        
        //Question 4
        ArrayDice<Integer> arrayDice = new ArrayDice<>();
        arrayDice.rollDice(5);
        System.out.println(arrayDice.toString());
        arrayDice.rollDice(4);
        System.out.println(arrayDice.toString());

        LinkedListDice<Integer> linkedListDice = new LinkedListDice<>();
        linkedListDice.rollDice(3);
        System.out.println(linkedListDice.toString());
        linkedListDice.rollDice(4);
        System.out.println(linkedListDice.toString());
    }
    
}
