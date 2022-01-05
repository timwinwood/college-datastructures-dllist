package com.website.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * -- Q1.b - Implement a Doubly Linked List that will hold the website records
 * ArrayStack - a class that provides a Array Stack
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public class DLList implements LinkedListInterface {

	// instance variables
	private DLNode head;
	private DLNode curr;
	private int current;
	private DLNode tail;
	private int size;

	/**
	 * DLList constructor
	 */
	public DLList() {

		this.head = null;
		this.curr = null;
		this.tail = null;
		this.size = 0;
	}

	/**
	 * checks if the DLList is empty
	 * 
	 * @return boolean representing if the DLList is empty
	 */
	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}

	/**
	 * returns the size of the DLList
	 * 
	 * @return the size of the DLList
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * adds an element to the end of the Doubly Linked List
	 *
	 * @param element the new element
	 */
	@Override
	public void add(Object element) {

		// declare the new node
		DLNode newNode;

		// if the list is empty, the new node is the head
		if (isEmpty()) {

			newNode = new DLNode(element, null, null);
			this.head = newNode;
			this.tail = newNode;
			this.curr = newNode;

		// else, add the node to the end of the list, newNode.prev is this,next
		} else {

			newNode = new DLNode(element, this.tail, null);
			this.tail.setNext(newNode);
			this.tail = newNode;
		}

		// increment size
		this.size++;

	}

	/**
	 * removes a Node from the Doubly Linked List at the specified index
	 *
	 * @param index the index of the Node to remove
	 */
	@Override
	public void remove(int index) {

		 // if index is out of bounds, throw an IndexOutOfBoundsException
		if ((index <= 0) || (index > this.size())) {
			throw new IndexOutOfBoundsException();
		}

		// if list is empty, throw an RuntimeException()
		if (this.isEmpty()) {
			throw new RuntimeException();

		}
		
		// If the index is the end of the list, handle special case - remove the tail
		if (index == size()) {
	
			this.tail = this.tail.getPrev();
			if (this.tail != null) {
				this.tail.setNext(null);
			}
	
		// If the index is the start of the list, handle special case - remove the head
		} else if (index == 1) {
	
			this.head = this.head.getNext();
			if (this.head != null) {
				this.head.setPrev(null);
			}
	
		// else, remove the Node at the specified index
		} else {
	
			// get a reference for the Node we wish to remove
			setCurrent(index);
			DLNode tempNode = this.curr;
			
			// get the next and prev Nodes of the Node we wish to remove
			DLNode nextNode = tempNode.getNext();
			DLNode prevNode = tempNode.getPrev();
			
			// link the next and prev Nodes together, therefore removing the Node we wish to remove
			nextNode.setPrev(prevNode);
			prevNode.setNext(nextNode);
	
		}
	
		// decrement the size
		this.size--;


	}

	/**
	 * sets the current Node
	 *
	 * @param index the index of the current Node
	 */
	@Override
	public void setCurrent(int index) {

		// start from the head (beginning of the list)
		this.curr = this.head;
		
		// loop through the Nodes until we reach index, setting the current Node
		int i = 1;
		while (i < index) {
			this.curr = this.curr.getNext();
			i++;
		}

	}

	/**
	 * gets the Node at the specified index
	 *
	 * @param index the index of the Node to retrieve
	 */
	@Override
	public Object get(int index) {

		 // if index is out of bounds, throw an IndexOutOfBoundsException
		if ((index <= 0) || (index > size())) {
			throw new IndexOutOfBoundsException();
		}
		
		// set the current Node and return
		setCurrent(index);
		return curr;

	}

	/**
	 * clears the Doubly Linked List
	 */
	@Override
	public void clear() {
		
		// loop through and remove all the Nodes
		while (size() > 0) {
			remove(1);
		}

	}

	/**
	 * -- Q1.b.i - browse browse to a website
	 * 
	 * @param title the website title
	 * @param url   the website url
	 */
	public void browse(String title, String url) {
		
		// while the size is more than the current active website
		// remove the last Node in the list
		while (this.size() > current) {
			this.remove(this.size());

		}

		// get current date and format for date and time
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		DateFormat tf = new SimpleDateFormat("HHmm");
	    int intDate = Integer.parseInt(df.format(date));
	    int intTime = Integer.parseInt(tf.format(date));
		
	    // create a new Website
		Website w = new Website(title, 20210823,1537,url);
		
		// add the Website to the list and go Forward one
		this.add(w);
		goForward();

	}

	/**
	 * -- Q1.b.ii - goBack go back a page
	 */
	public void goBack() {

		// cant go back if we are at the statr of the list
		if (current == 0) {
			throw new IndexOutOfBoundsException();
		}
		
		// decrement the current active website by 1
		// set the current website
		current--;
		setCurrent(current);
		
	}

	/**
	 * -- Q1.b.iii - goForward go forward a page
	 */
	public void goForward() {
		
		// cant go forward if we are at the end of the list
		if (current == this.size()) {
			throw new IndexOutOfBoundsException();
		}
		
		// increment the current active website by 1
		// set the current website
		current++;
		setCurrent(current);
	}

	/**
	 * -- Q1.b.iv - printDS prints the contents of the stack
	 */
	public void printDS() {
		
		// declare nodeTemp as head, to start at the beginning of the list
		DLNode nodeTemp = head;

		// loop through the list and add append each node to the StringBuilder
		StringBuilder sb = new StringBuilder();
		sb.append("=== DLLContents ===" + "\n");
		while (nodeTemp != null) {
			sb.append(nodeTemp.toString() + "\n");
			nodeTemp = nodeTemp.getNext();
		}
		
		// print the contents of the StringBuilder
		System.out.print(sb);

	}

	/**
	 * prints the current website
	 */
	public void printCurrent() {
		System.out.println("=== Current Website ===");
		System.out.println(this.curr.toString());
	}

}
