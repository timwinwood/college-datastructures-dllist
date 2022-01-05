package com.website.main;

/**
 * DLNode - a class to represent a Node in a Doubly Linked List
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class DLNode {
    
	// instance variables
    private Object element;
    private DLNode next;
    private DLNode prev;

	/**
	 * DLNode constructor
	 */
    public DLNode(Object element, DLNode prev, DLNode next){
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

	/**
	 * get the next DLNode
	 * 
	 * @return the next DLNode
	 */
    public DLNode getNext() {
	return next;
    }

	/**
	 * set the next DLNode
	 * 
	 * @param next the next DLNode
	 */
    public void setNext(DLNode next) {
        this.next = next;
    }
    
	/**
	 * get the prev DLNode
	 * 
	 * @return the prev DLNode
	 */
    public DLNode getPrev() {
	return prev;
    }

	/**
	 * set the prev DLNode
	 * 
	 * @param prev the prev DLNode
	 */
    public void setPrev(DLNode prev) {
        this.prev = prev;
    }
     
	/**
	 * get the element
	 * 
	 * @return the element
	 */
    public Object getElement() {
        return element;
    }

	/**
	 * set the element
	 * 
	 * @param element the element
	 */
    public void setElement(Object element) {
        this.element = element;
    }

	/**
	 * returns the string representation of the DLNode object
	 *
	 * @return the string representation of the DLNode object
	 */
    @Override
    public String toString() {
        return element.toString();
    }
    
}