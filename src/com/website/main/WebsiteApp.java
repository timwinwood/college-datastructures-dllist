package com.website.main;

public class WebsiteApp {

	public static void main(String[] args) {

		// -- Q1.c.i - The user goes to ncirl.ie
		DLList websites = new DLList();
		websites.browse("National College of Ireland | Award-Winning Dublin College", "https://www.ncirl.ie/");

		// -- Q1.c.ii - Browses to 5 Links
		websites.browse("About Us | National College of Ireland", "https://www.ncirl.ie/about");
		websites.browse("Departments | National College of Ireland", "https://www.ncirl.ie/About/Departments");
		websites.browse("Faculties | National College of Ireland", "https://www.ncirl.ie/About/Faculties");
		websites.browse("School of Computing | National College of Ireland", "https://www.ncirl.ie/About/Faculties/School-of-Computing");
		websites.browse("Contact Us | National College of Ireland", "https://www.ncirl.ie/About/Contact");
		System.out.println("=== Q1.c.ii - Browses to 5 Links ===");
		websites.printDS();
		websites.printCurrent();

		// -- Q1.c.iii - Goes back twice
		System.out.println("=== Q1.c.iii - Goes back twice ===");
		websites.goBack();
		websites.goBack();
		websites.printDS();
		websites.printCurrent();

		// -- Q1.c.iv - Goes forward once
		System.out.println("=== Q1.c.iv - Goes forward once ===");
		websites.goForward();
		websites.printDS();
		websites.printCurrent();

		// -- Q1.c.v - Clicks new link
		System.out.println("=== Q1.c.v - Clicks new link ===");
		websites.browse("Search all NCI Courses | National College of Ireland", "https://www.ncirl.ie/Courses/search?coursetypes=Postgraduate&subjects=Computing");
		websites.printDS();
		websites.printCurrent();

		/*
		 * -- Q1.d - Stack Implementation vs Doubly Linked List Implementation
		 * 
		 * Note: Due to misreading question 1 I wrote two solutions for the Website App
		 * WebsiteAppDLL - Using a DoublyLinkedList
		 * WebsiteApp - Using a Stack
		 * I have included the solutions for both, to demonstrate my understanding of the difference between the two
		 * 
		 * A Stack is typically built on top of an existing data structure such as an Array or ArrayList. An Element in the Stack is simply an Element in that Array or ArrayList.
		 * A Doubly Linked List is typically built using a Node class, in which each Node is connected to the next and previous using pointers. This Node, then contains a reference to the Element.
		 * 
		 * Arrays are an immutable data type, which means it cannot be changed once it�s created. Therefore, if the Stack was built on top of an Array, each time we push() or pop() the Stack, a new Array would need to be created, which is a slow and costly operation.
		 * When we add() or remove() an element from a Doubly Linked List, we simply need to update the next and previous pointers, which is faster and more efficient.
		 * 
		 * To keep track of the current element in a Stack we simply store the current index. To retrieve the element, we simply use Array[index] or ArrayList.get(index).
		 * To keep track of the current element in a Doubly Linked List we store the current Node as well as the current index. To retrieve the element, we create a method DLL.getCurrent() which would return the element stored within the current Node.
		 * 
		 * To print the contents of a Stack, we can simply iterate over the Array or ArrayList using a loop.
		 * To print the contents of a Doubly Linked List, we must iterate through the Nodes by following the next or previous pointers (depending on the order we wish to print).
		 * 
		 */

	}

}
