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
public class BSTNode<T extends Comparable<T>> {
    private T data;
    private BSTNode leftLink;
    private BSTNode rightLink;
    
    public BSTNode(){
        data = null;
        leftLink = null;
        rightLink = null;
    }

    public BSTNode(T data, BSTNode leftLink, BSTNode rightLink) {
        this.data = data;
        this.leftLink = leftLink;
        this.rightLink = rightLink;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeftLink(BSTNode leftLink) {
        this.leftLink = leftLink;
    }

    public void setRightLink(BSTNode rightLink) {
        this.rightLink = rightLink;
    }

    public T getData() {
        return data;
    }

    public BSTNode getLeftLink() {
        return leftLink;
    }

    public BSTNode getRightLink() {
        return rightLink;
    }
    
    
    
}
