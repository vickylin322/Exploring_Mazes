package project3;

import java.util.Iterator;
import java.util.Objects;

/**
 * DoublyLinkedList class is used to created a genetic class of DoublyLinkedList
 * This class is a genetic class that does not permit null elements. The
 * DoublyLinkedList class stored the internal Node class with Parameter E data,
 * and the DoublyLinkedList class has private member of head, tail and size of
 * the DoublyLinkedList object.
 * 
 * @author Vicky Lin
 */

public class DoublyLinkedList<E> implements Iterable<E> {
	/**
	 * Node class is used to created the node and keep track of the structure in
	 * DoublyLinkedList This class is the internal class of the DoublyLinkedList,
	 * with the public members of E data, Node<E> next, Node<E> previous
	 * 
	 */
	// Node class
	private class Node<E> {
		public E data;
		public Node<E> next;
		public Node<E> previous;

		/**
		 * Constructs a new Node object
		 * 
		 * @param E data
		 * @throws NullPointerException when the parameter is invalid(set to be null)
		 */

		// create a node with a given data element
		// new node points to null
		public Node(E data) {
			if (data == null)
				throw new NullPointerException("List does not permit null elements");
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}

	// initiate the private members of the DoublyLinkedList class
	// head, tail to null
	private Node<E> head;
	private Node<E> tail;
	private int size;

	/**
	 * Constructs a new DoublyLinkedLikst object
	 */
	// Constructor
	// create an empty DoublyLinkedList object
	DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * add element into the DoublyLinkedList
	 * 
	 * @param E e the element will be added to the list
	 * @throws ClassCastException if the class of specified element prevents it from
	 *                            being added to the list
	 * @return true if this list changed as a result of the call; false if the
	 *         specified element is null
	 */
	// boolean add(E e)method
	public boolean add(E e) throws ClassCastException {
		// return false if e is null
		if (e == null) {
			return false;
		}
		// e is valid then create node object
		Node<E> node = new Node<E>(e);
		// if the list is empty
		if (head == null) {
			head = tail = node;
			tail.next = null;
			head.previous = null;
		}
		// if the list is not empty, add to the last position
		else {
			tail.next = node;
			node.previous = tail;
			tail = node;
			tail.next = null;
		}
		// keep track of the size of the list
		size++;
		return true;
	}

	/**
	 * Add the specified element at the specified position in the list.
	 * 
	 * @param E   e, the element will be added to the list.
	 * @param int pos, the position the element should be inserts in the list a
	 *            valid pos should be in the range of (0-size()-1)
	 * @throws ClassCastException        if the class of specified element prevents
	 *                                   it from being added to the list
	 * @throws IndexOutOfBoundsException if pos parameter is invalid(out of range)
	 * @return true if this list changed as a result of the call; false if the
	 *         specified element is null
	 */
	// boolean add​(E e, int pos)
	public boolean add(E e, int pos) throws ClassCastException, IndexOutOfBoundsException {
		// if the position is larger or not in the list
		if (pos < 0 || pos > size()) {
			throw new IndexOutOfBoundsException("Out of Bound position given");
		}
		// the element is null
		if (e == null) {
			return false;
		}

		// create a counter
		int counter = 0;
		Node<E> node = new Node<E>(e);
		// add to the empty list
		if (size() == 0) {
			head = node;
			tail = node;
		}
		// add the new element to the head
		else if (pos == 0) {
			node.next = head;
			head.previous = node;
			head = node;
		}
		// add the new element to the tail
		else if (pos == size()) {
			node.previous = tail;
			tail.next = node;
			tail = node;
		}
		// add to the position(in the middle)
		else {
			Node<E> current = head;
			while (counter < pos - 1) {
				current = current.next;
				counter++;
			}
			node.next = current.next;
			current.next = node;
			node.previous = current;
			node.next.previous = node;
		}
		size++;
		return true;
	}

	/**
	 * Removes all the elements from the list This list will be empty after this
	 * called being made
	 */
	// clear
	public void clear() {
		this.head = null;
		this.tail = null;
		size = 0;
	}

	/**
	 * Indicates whether the list contains the specified object
	 * 
	 * @param Object o, the specified element to find in the list Use the
	 *               Objects.equals method to ensure this list contains at least one
	 *               element e such that Objects.equals(o(parameter),e)
	 * @return true if this list contains the specified element, false other wise.
	 */
	// boolean contains(Object o)
	public boolean contains(Object o) {
		// use iterator to iterate each element of the list
		Iterator<E> thisItr = this.iterator();
		// list contains at least one element e such that Objects.equals(o, e)
		while (thisItr.hasNext()) {
			if (Objects.equals(o, thisItr.next())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Indicates whether some object o is "equal to" this list.
	 * 
	 * @param Object o, the object that compared equality to this list/ To
	 *               DoublyLinkedList objects are considered equal if the specified
	 *               object is also an instance of DoublyLinkedList, both lists have
	 *               the same size and all the corresponding pairs of elements in
	 *               the two lists are equal
	 * @return true if this object is the same as the obj argument, false otherwise.
	 */

	// boolean equals(Object o)
	// Partial cite the iterator example in class slide
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof DoublyLinkedList<?>))
			return false;
		DoublyLinkedList<?> otherObj = (DoublyLinkedList<?>) o;
		if (this.size != otherObj.size)
			return false;

		// use iterator to iterate through both list
		Iterator<E> thisItr = this.iterator();
		Iterator<?> otherItr = otherObj.iterator();
		while (thisItr.hasNext() && otherItr.hasNext()) {
			if (!(thisItr.next().equals(otherItr.next()))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the element at the specified position.
	 * 
	 * @param int pos, the position in the list.
	 * @return the element at the pos parameter position; null if such position does
	 *         not exist.
	 */
	// get the element in the position
	public E get(int pos) {
		// return null if the position is out of bound
		if (pos < 0 || pos >= size())
			return null;
		// return the element at the position through iterate the list
		else {
			Node<E> current = head;
			for (int i = 0; i < pos; i++) {
				current = current.next;
			}
			return current.data;
		}
	}

	/**
	 * Indicates whether the list is empty
	 * 
	 * @return true if the list is empty; false otherwise.
	 */
	// isEmpty method
	public boolean isEmpty() {
		if (head == null && tail == null)
			return true;
		if (size() == 0)
			return true;
		return false;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in the
	 * list.
	 * 
	 * @param Object o, element to search for.
	 * @return the lowest index of the o parameter in the list; -1 of there is not
	 *         such index.
	 */
	// indexOf method
	public int indexOf(Object o) {
		if (this.contains(o)) {
			for (int i = 0; i < size(); i++) {
				E o1 = this.get(i);
				if (o == null ? o1 == null : o.equals(o1)) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Remove the first occurrence of the specified element from this list if it is
	 * present. if the list does not contain the element,remains unchanged
	 * 
	 * @param Object o, element to remove from this list, if present
	 * @throws ClassCastException   if the class of specified element prevents it
	 *                              from being added to the list
	 * @throws NullPointerEXception if the parameter o is null
	 * @return true if this list changed as a result of the call; false, otherwise
	 */
	// boolean remove(Object o)
	public boolean remove(Object o) throws ClassCastException, NullPointerException {
		if (o == null)
			throw new NullPointerException("Invalid input value!");
		if (isEmpty())
			return false;

		else {
			// check ClassCastException
			if (!(o.getClass().equals(head.data.getClass())))
				throw new ClassCastException("Invalid type!");
			// get index of the object
			int index = indexOf(o);
			// this object is not in the list
			if (index == -1)
				return false;
			remove(index);
		}
		return true;
	}

	/**
	 * Remove the element at the specified position in this list
	 * 
	 * @param int pos, the index of the element to be removed, a valid pos should be
	 *            in range (0-size()-1)
	 * @throws IndexOutOfBoundsException if pos is out of range (pos < 0 || pos >=
	 *                                   size())
	 * @return the element that was removed from the list
	 */
	// remove (int pos) method
	public E remove(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= size)
			throw new IndexOutOfBoundsException("the position is out of bound");
		E remove = null;
		// remove the first node of the list
		if (pos == 0) {
			remove = get(0);
			if (size() == 1) {
				head = null;
				tail = null;
			} else {
				head = head.next;
				head.previous = null;
			}
		}
		// remove the last element
		else if (pos == size() - 1) {
			remove = get(size() - 1);
			if (size() == 1) {
				head = null;
				tail = null;
			} else {
				tail = tail.previous;
				tail.next = null;
			}
		}
		// remove from the middle
		else {
			Node<E> current = head;
			// set the current to the node before removal position
			for (int i = 0; i < pos - 1; i++)
				current = current.next;
			remove = current.next.data;
			current.next = current.next.next;
			current.next.previous = current;
		}
		size--;
		return remove;
	}

	/**
	 * Indicates the size of the list
	 * 
	 * @return the number of elements in this list
	 */
	// size
	public int size() {
		return size;
	}

	/**
	 * Returns the string representation of this list The string representation
	 * consists of a list of the collection's elements in the order. And they are
	 * returned by its iterator enclosed in square brackets ("[]"). Adjacent
	 * elements are separated by the characters ", " (comma and space).
	 * 
	 * @returns the string representation of this list
	 */
	// toString method
	public String toString() {
		Iterator<E> itr = iterator();
		StringBuilder result = new StringBuilder();
		String comma = "";
		result.append("[");
		while (itr.hasNext()) {
			result.append(comma);
			result.append(String.valueOf(itr.next()));
			comma = ", ";
		}
		result.append("]");
		return result.toString();
	}

	/**
	 * This class represents a iterator. It implements the Iterator<E> .
	 */
	// create iterator for the equals method to compare each element in the list
	// partial cite the iterator example in class slide
	private class Itr implements Iterator<E> {
		private Node<E> current = head;

		public boolean hasNext() {
			return current != null;
		}

		public E next() {
			E tmp = current.data;
			current = current.next;
			return tmp;
		}
	}

	/**
	 * To return every elements in the list from the first element to the last it
	 * implements the Iterable<E> interface
	 * 
	 * @return an iterator over elements of this list
	 */
	public Iterator<E> iterator() {
		return new Itr();
	}
}
