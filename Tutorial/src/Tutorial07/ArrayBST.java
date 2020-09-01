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
public class ArrayBST<T extends Comparable<T>> {

    public static final int INORDER = 1;
    public static final int PREORDER = 2;
    public static final int POSTORDER = 3;
    private final int MAX = 20;
    private T[] BST;
    private int index, height, traverse, arrayIndex;
    private T[] treeArray;

    public ArrayBST() {
        index = 1;
        height = 0;
        BST = (T[]) new Comparable[MAX];
    }

    public boolean isEmpty() {
        return (index == 1);
    }

    public int getSize() {
        int count = 0;
        for (int i = 0; i < MAX; i++) {
            if (BST[i] != null) {
                count++;
            }
        }
        return count;
    }

    public int getHeight() {
        for (int i = 0; i < MAX; i++) {
            if (BST[i] != null) {
                index = i;
            }
        }
        height = (int) (Math.log(index + 1) / Math.log(2)) + 1;
        return height;
    }

    public void addNode(T t) {
        boolean add = false;
        int i = 0, height = 0;
        if (isEmpty()) {
            index = 0;
            BST[index] = t;
        } else {
            while (i < MAX) {
                if (BST[i] == null) {
                    BST[i] = t;
                    add = true;
                    break;
                } else if (t.compareTo(BST[i]) <= 0) {
                    i = 2 * i + 1;
                } else {
                    i = 2 * i + 2;
                }
            }
        }
    }

    public void setOrder(int a) {
        traverse = a;
        treeArray = (T[]) new Comparable[MAX];
        arrayIndex = 0;
        if (traverse == INORDER) {
            inOrder(0);
        } else if (traverse == PREORDER) {
            preOrder(0);
        } else {
            postOrder(0);
        }
    }

    public void inOrder(int a) {
        if (a >= MAX) {
            return;
        }
        if (BST[a] != null) {
            inOrder(a * 2 + 1);
            treeArray[arrayIndex++] = BST[a];
            inOrder(a * 2 + 2);
        }
    }

    public void preOrder(int a) {
        if (a >= MAX) {
            return;
        }
        if (BST[a] != null) {
            treeArray[arrayIndex++] = BST[a];
            preOrder(a * 2 + 1);
            preOrder(a * 2 + 2);
        }
    }

    public void postOrder(int a) {
        if (a >= MAX) {
            return;
        }
        if (BST[a] != null) {
            postOrder(a * 2 + 1);
            postOrder(a * 2 + 2);
            treeArray[arrayIndex++] = BST[a];
        }
    }

    public void removeNode(T t) {
        remove(0, t);
    }

    private void remove(int a, T t) {
        if (BST[a] == null) {
            return;
        } else if (t.compareTo(BST[a]) < 0) {
            remove(a * 2 + 1, t);
        } else if (t.compareTo(BST[a]) > 0) {
            remove(a * 2 + 2, t);
        } else {
            removeIndex(a);
        }
    }

    // WIP - This method only works for leaf node
    private void removeIndex(int a) {
        if (BST[a * 2 + 1] == null) {
            replace(a * 2 + 2, a);
        } else if (BST[a * 2 + 2] == null) {
            replace(a * 2 + 1, a);
        }
    }

    private void replace(int oldIndex, int newIndex) {
        T temp = BST[oldIndex];
        BST[newIndex] = temp;
        BST[oldIndex] = null;
    }

    public void showTree() {
        for (int i = 0; i < arrayIndex; i++) {
            System.out.print(treeArray[i] + " ");
        }
    }
}
