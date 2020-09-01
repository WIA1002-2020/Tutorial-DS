/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial07;

/**
 *
 * @author muham
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Question 2
        BST<Character> a = new BST<>();
        String str = "FACULTY";
        for (int i = 0; i < str.length(); i++) {
            a.addNode(str.charAt(i));
        }
        display(a);
        System.out.println("\nRemove 1 Character L");
        a.remove('L');
        display(a);
        System.out.println("\n");
        
        //Question 3
        ArrayBST<Character> b = new ArrayBST<>();
        String str1 = "FACULTY";
        for (int i = 0; i < str1.length(); i++) {
            b.addNode(str.charAt(i));
        }
        display1(b);
        System.out.println("\nRemove 1 Character L");
        b.removeNode('Y');
        display1(b);
        System.out.println("");
    }
    
    public static void display(BST<Character> tree){
        System.out.println("The number of elements in the tree : "+ tree.getSize());
        System.out.print("The tree elements - PREORDER : ");
        tree.setOrder(BST.PREORDER);
        tree.showTree();
        System.out.print("\nThe tree elements - INORDER : ");
        tree.setOrder(BST.INORDER);
        tree.showTree();
        System.out.print("\nThe tree elements - POSTORDER : ");
        tree.setOrder(BST.POSTORDER);
        tree.showTree();
    }
    
    public static void display1(ArrayBST<Character> tree){
        System.out.println("The number of elements in the tree : "+ tree.getSize());
        System.out.print("The tree elements - PREORDER : ");
        tree.setOrder(ArrayBST.PREORDER);
        tree.showTree();
        System.out.print("\nThe tree elements - INORDER : ");
        tree.setOrder(ArrayBST.INORDER);
        tree.showTree();
        System.out.print("\nThe tree elements - POSTORDER : ");
        tree.setOrder(ArrayBST.POSTORDER);
        tree.showTree();
    }    
}
