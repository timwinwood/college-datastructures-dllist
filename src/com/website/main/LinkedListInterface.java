package com.website.main;


/**
 * LinkedListInterface - an interface to define the methods for a Linked List
 *
 * @author Tim Winwood - x20213638
 * @version 1.0
 */
public interface LinkedListInterface {

    public boolean isEmpty();
    public int size();
    public void add(Object element);
    public void remove(int index);
    public void setCurrent(int index);
    public Object get(int index);
    public void clear();

}
