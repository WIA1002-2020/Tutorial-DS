/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial04;

import java.util.Random;

/**
 *
 * @author muham
 */
public class LinkedList<T extends Comparable<T>> {
    public static final int ASCENDING = 1;     //
    public static final int DESCENDING = 2;    //>-- For Tutorial08
    private int orderType;                     //
    private ListNode head;                      

    public LinkedList() {
        head = null;
    }

    public int length() {
        int count = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.getLink();
            count++;
        }
        return count;
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void showList() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
    }

    //insert at the back
    public void addNode(T a) {
        ListNode newNode = new ListNode(a, null);
        ListNode currentNode = head;
        if (head == null) {
            head = newNode;
        } else {
            while (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
            }
            currentNode.setLink(newNode);
        }
    }

    //delete from the back
    public void deleteNode() {
        ListNode currentNode = head;
        ListNode previousNode = head;
        if (head != null) {
            if (currentNode.getLink() == null) {
                head = null;
            } else {
                while (currentNode.getLink() != null) {
                    previousNode = currentNode;
                    currentNode = currentNode.getLink();
                }
                previousNode.setLink(null);
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    public void addFrontNode(T a) {
        head = new ListNode(a, head);
    }

    public void deleteFrontNode() {
        if (head != null) {
            head = head.getLink();
        } else {
            System.out.println("The list is empty");
        }
    }

    public boolean contains(T t) {
        boolean found = false;
        ListNode currentNode = head;
        while (currentNode != null) {
            if (t.compareTo((T) currentNode.getData()) == 0) {
                found = true;
                break;
            }
            currentNode = currentNode.getLink();
        }
        return found;
    }

    public void addNodeByPosition(T a, int index) {
        if (index == 0) {
            addFrontNode(a);
        } else if (index == length()) {
            addNode(a);
        } else if (index > length()) {
            System.out.println("Invalid index. No node inserted");
        } else {
            ListNode newNode = new ListNode(a, null);
            ListNode currentNode = head;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getLink();
            }
            ListNode tempNode = currentNode.getLink();
            currentNode.setLink(newNode);
            newNode.setLink(tempNode);
        }
    }

    public void deleteNodeByPosition(int index) {
        if (index == 0) {
            deleteFrontNode();
        } else if (index == length() - 1) {
            deleteNode();
        } else if (index >= length()) {
            System.out.println("Invalid index. No node deleted.");
        } else {
            ListNode currentNode = head;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getLink();
            }
            ListNode tempNode = currentNode.getLink();
            currentNode.setLink(tempNode.getLink());
            tempNode = null;
        }
    }

    public void setFront(T t) {
        if (head != null) {
            head.setData(t);
        } else {
            System.out.println("Invalid update. List is empty");
        }
    }

    public void setBack(T t) {
        if (head != null) {
            ListNode currentNode = head;
            while (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
            }
            currentNode.setData(t);
        } else {
            System.out.println("Invalid update. List is empty");
        }
    }

    public void set(T t, int index) {
        if (index == 0) {
            setFront(t);
        } else if (index == length() - 1) {
            setBack(t);
        } else if (index >= length() - 1) {
            System.out.println("Invalid index. Update failed");
        } else {
            ListNode currentNode = head;
            for (int i = 1; i <= index; i++) {
                currentNode = currentNode.getLink();
            }
            currentNode.setData(t);
        }
    }

    public T getFront() {
        if (head != null) {
            return (T) head.getData();
        } else {
            return null;
        }
    }

    public T getBack() {
        if (head != null) {
            ListNode currentNode = head;
            while (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
            }
            return (T) currentNode.getData();
        } else {
            return null;
        }
    }

    public T get(int index) {
        if (index == 0) {
            return getFront();
        } else if (index == length() - 1) {
            return getBack();
        } else if (index >= length() - 1) {
            return null;
        } else {
            ListNode currentNode = head;
            for (int i = 1; i <= index; i++) {
                currentNode = currentNode.getLink();
            }
            return (T) currentNode.getData();
        }
    }

    public void plusTenPointFive() {
        ListNode currentNode = head;
        while (currentNode != null) {
            Double value = (Double) currentNode.getData();
            if (value > 20) {
                value += 10.5;
                currentNode.setData((T) value);
            }
            currentNode = currentNode.getLink();
        }
    }

    public int sumAllInteger() {
        int sum = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            Integer num = (Integer) currentNode.getData();
            sum += num;
            currentNode = currentNode.getLink();
        }
        return sum;
    }

    public int sumEvenNumber() {
        int sum = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            Integer num = (Integer) currentNode.getData();
            if (num % 2 == 0) {
                sum += num;

            }
            currentNode = currentNode.getLink();
        }
        return sum;
    }

    public void addRandomNumber() {
        Random rn = new Random();
        Integer n = rn.nextInt(10);
        addNode((T) n);
    }

    public void removeAll(T t) {
        T data = (T) head.getData();
        if (isEmpty()) {
            return;
        }
        if (t.compareTo(data) == 0) {
            while (t.compareTo(data) == 0) { // Consider when two same numbers are beside one another
                head = head.getLink();
                data = (T) head.getData();
            }
        }
        ListNode currentNode = head;
        while (currentNode.getLink() != null) {
            data = (T) currentNode.getLink().getData();
            if (data.compareTo(t) == 0) {
                while (data.compareTo(t) == 0) { // Same case
                    currentNode.setLink(currentNode.getLink().getLink());
                    if (currentNode.getLink() != null) {
                        data = (T) currentNode.getLink().getData();
                    } else {
                        break;
                    }
                }
            } else {
                currentNode = currentNode.getLink();
            }
        }
    }

    public T findMedian() {
        int length = 0;
        ListNode currentNode = head;
        while (currentNode.getLink() != null && length != length() / 2) {
            currentNode = currentNode.getLink();
            length++;
        }
        return (T) currentNode.getData();
    }
    
    //For Tutorial08
    public void selectionSort(int a){
        orderType=a;
        for(int i=0; i<length()-1;i++){
            swap(i,getSelectionIndex(i));
        }
    }
    
    public int getSelectionIndex(int start){
        T temp=null, temp1=null;
        ListNode currentNode = head;
        int index=start;
        for (int i = 0; i <= start; i++) {
            if(i==start){
                temp=(T)currentNode.getData();
                currentNode=currentNode.getLink();
            }
            else{
                currentNode=currentNode.getLink();
            }
        }
        for (int i = start+1; i < length(); i++) {
            temp1=(T)currentNode.getData();
            if(temp.compareTo(temp1)>0 && orderType==ASCENDING){
                index=i;
                temp=temp1;
            }
            else if(temp.compareTo(temp1)<0 && orderType==DESCENDING){
                index=1;
                temp=temp1;
            }
            currentNode=currentNode.getLink();
        }
        return index;
    }
    
    public void swap(int index1, int index2){
        ListNode currentNode = head;
        ListNode swapNode = head;
        T temp=null, temp1=null;
        for (int i = 0; i <= index1; i++) {
            if(i==index1){
                temp=(T)currentNode.getData();
            }
            else{
                currentNode=currentNode.getLink();
            }
        }
        for (int i = 0; i <= index2; i++) {
            if(i==index2){
                temp1=(T)swapNode.getData();
                currentNode.setData(temp1);
                swapNode.setData(temp);
            }
            else{
                swapNode=swapNode.getLink();
            }
        }
    }
    
    public void bubbleSort(int a){
        T temp=null, temp1=null;
        orderType=a;
        for(int iteration=0; iteration<length()-1;iteration++){
            ListNode currentNode = head;
            ListNode nextNode = head.getLink();
            for (int i = 0; i < length()-1-iteration; i++) {
                temp=(T)currentNode.getData();
                temp1=(T)nextNode.getData();
                if(temp.compareTo(temp1)>0 && orderType==ASCENDING)
                    swap(i,i+1);
                else if(temp.compareTo(temp1)<0 && orderType==DESCENDING)
                    swap(i,i+1);
                currentNode=currentNode.getLink();
                nextNode=nextNode.getLink();
            }
        }
    }
}
