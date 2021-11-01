package project3;

/**
 * This class represents a reference based stack that using the doubly linked
 * list as the internal storage for the location. This class implements the
 * PossibleLocations interface with methods of add(Location s), remove() and
 * isEmpty
 * 
 * @author Vicky Lin
 */

public class StackOfSpaces implements PossibleLocations {
	// Initialized the head and the tail
	private DoublyLinkedList<Location> list = new DoublyLinkedList<>();
	
	/**
	 * Add a Location object to this collection.(push in stack)
	 * making the top of the stack as the front of the list
	 * @param Location s, the location to be added
	 * @throws NullPointerException if the given location is null
	 */
	@Override
	public void add(Location s) {
		if (s == null)
			throw new NullPointerException("The given location is invalid");
		list.add(s,0);
	}

	/**
	 * Remove the next object from this collection.(pop in stack) The specific item
	 * returned is determined by the underlying structure by which this collection
	 * is represented. As for stack, remove from the top of the list(the front of list
	 * in this case).
	 * 
	 * @return the next object, or null if set is empty
	 */
	@Override
	public Location remove() {
		if (isEmpty())
			return null;
		// remove from the end of the stack
		else {
			Location remove = list.remove(0);
			return remove;
		}
	}

	/**
	 * Determines if this collection is empty or not.
	 * 
	 * @return true, if set is empty, false, otherwise.
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
     * Returns a string representation of this stack.
     * The string representation consists of a list of the collection's
     * elements in the FILO order they would be removed and returned by future
     * calls to remove(). The elements should be enclosed in square brackets (`"[]"`).
     * Adjacent elements are separated by the characters `", "` (comma and space).
     * Elements are converted to strings as by `String.valueOf(Object)`.
     * @return string representation of this collection
     */
	
	public String toString() {
		return list.toString();
	}
}
